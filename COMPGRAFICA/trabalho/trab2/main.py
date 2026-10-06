# Trabalho Bimestral - Manipulador e Visualizador de um Objeto 3D (OpenGL moderno + Python)

import ctypes
import math
import glfw
import numpy as np
from OpenGL.GL import *

vertex_shader_source = """
#version 330 core
layout(location = 0) in vec3 aPos;
layout(location = 1) in vec3 aColor;

uniform mat4 uModel;
uniform mat4 uView;
uniform mat4 uProjection;

out vec3 vColor;

void main()
{
    vColor = aColor;
    gl_Position = uProjection * uView * uModel * vec4(aPos, 1.0);
}
"""

fragment_shader_source = """
#version 330 core
in vec3 vColor;
out vec4 FragColor;

void main()
{
    FragColor = vec4(vColor, 1.0);
}
"""

ALTURA_MAPA = 200           # altura (e largura) do minimapa em pixels
ALCANCE_MAPA = 4.0          # o minimapa mostra x e z em [-4, 4]
DIST_REF = 3.0              # distância observador-origem, usada para igualar a escala das duas projeções
PIVO = np.array([1.0, 0.0, 0.0])

PASSO_T = 0.012
PASSO_R = math.radians(0.6)
PASSO_S = 0.004
PASSO_FOV = 0.2
PASSO_OBS = 0.012
VEL_ORBITA = math.radians(0.4)

# tudo que o usuário pode alterar fica aqui
estado = {}
teclas_anteriores = set()

def resetar():
    estado.update({
        "t": np.array([0.0, 0.0, 0.0]),
        "rot": np.array([0.0, 0.0, 0.0]),   # rotações em X, Y, Z (radianos)
        "escala": 1.0,
        "ordem": 0,                         # 0: T·R·S   1: R·T·S
        "pivo_externo": False,
        "orbita": False,
        "theta": 0.0,                       # ângulo da órbita
        "perspectiva": True,
        "fov": 60.0,
        "centro_projecao": np.array([0.0, 0.0, DIST_REF]),
    })

def modo_comparacao():
    estado["t"] = np.array([0.0, 0.0, -2.0])
    estado["rot"] = np.array([0.0, math.radians(30), 0.0])
    estado["escala"] = 1.0
    estado["pivo_externo"] = False
    estado["orbita"] = False
    estado["theta"] = 0.0
    estado["ordem"] = 0
    estado["centro_projecao"][0] = 0.0

# ---------- matrizes 4x4 (convenção de coluna: v' = M @ v) ----------

def matriz_translacao(tx, ty, tz):
    m = np.identity(4)
    m[:3, 3] = (tx, ty, tz)
    return m

def matriz_escala(s):
    return np.diag([s, s, s, 1.0])

def matriz_rotacao_x(a):
    c, s = math.cos(a), math.sin(a)
    return np.array([[1, 0, 0, 0], [0, c, -s, 0], [0, s, c, 0], [0, 0, 0, 1.0]])

def matriz_rotacao_y(a):
    c, s = math.cos(a), math.sin(a)
    return np.array([[c, 0, s, 0], [0, 1, 0, 0], [-s, 0, c, 0], [0, 0, 0, 1.0]])

def matriz_rotacao_z(a):
    c, s = math.cos(a), math.sin(a)
    return np.array([[c, -s, 0, 0], [s, c, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1.0]])

def matriz_paralela(l, r, b, t, n, f):
    return np.array([
        [2 / (r - l), 0, 0, -(r + l) / (r - l)],
        [0, 2 / (t - b), 0, -(t + b) / (t - b)],
        [0, 0, -2 / (f - n), -(f + n) / (f - n)],
        [0, 0, 0, 1.0],
    ])

def matriz_perspectiva(fov_graus, aspecto, n, f):
    k = 1.0 / math.tan(math.radians(fov_graus) / 2)
    return np.array([
        [k / aspecto, 0, 0, 0],
        [0, k, 0, 0],
        [0, 0, (f + n) / (n - f), 2 * f * n / (n - f)],
        [0, 0, -1, 0],
    ])

# ---------- composição Model / View / Projection ----------

def matriz_model():
    e = estado
    R = matriz_rotacao_z(e["rot"][2]) @ matriz_rotacao_y(e["rot"][1]) @ matriz_rotacao_x(e["rot"][0])
    if e["pivo_externo"]:
        # gira em torno de C: M = T(C) · R · T(-C)
        R = matriz_translacao(*PIVO) @ R @ matriz_translacao(*-PIVO)
    T = matriz_translacao(*e["t"])
    S = matriz_escala(e["escala"])

    # a mesma T, R e S em duas ordens diferentes: A·B != B·A
    model = T @ R @ S if e["ordem"] == 0 else R @ T @ S

    if e["orbita"]:
        # órbita: M = T(C) · Ry(θ) · T(-C), aplicada por último ao objeto já posicionado
        orb = matriz_translacao(*PIVO) @ matriz_rotacao_y(e["theta"]) @ matriz_translacao(*-PIVO)
        model = orb @ model
    return model

def matriz_view():
    c = estado["centro_projecao"]
    return matriz_translacao(-c[0], -c[1], -c[2])

def matriz_projecao(aspecto):
    if estado["perspectiva"]:
        return matriz_perspectiva(estado["fov"], aspecto, 0.1, 50.0)
    # mesma "janela" da perspectiva no plano z = 0 (a DIST_REF do observador), para comparar justo
    h = DIST_REF * math.tan(math.radians(estado["fov"]) / 2)
    return matriz_paralela(-h * aspecto, h * aspecto, -h, h, 0.1, 50.0)

# ---------- minimapa: transformações 2D (matrizes 3x3 em coordenadas (x, z)) ----------

def t2d(x, y):
    return np.array([[1, 0, x], [0, 1, y], [0, 0, 1.0]])

def r2d(a):
    c, s = math.cos(a), math.sin(a)
    return np.array([[c, -s, 0], [s, c, 0], [0, 0, 1.0]])

def s2d(s):
    return np.diag([s, s, 1.0])

def matriz_minimapa(model):
    # posição (x, z) do objeto no mundo, já considerando pivô, ordem e órbita
    cx, _, cz, _ = model @ np.array([0, 0, 0, 1.0])
    # Ry(θ) vista de cima (eixos x, z) equivale a uma rotação 2D de -θ
    ang_y = estado["rot"][1] + (estado["theta"] if estado["orbita"] else 0.0)
    m2 = t2d(cx, cz) @ r2d(-ang_y) @ s2d(estado["escala"])   # M2D = T · R · S
    # embute a 3x3 numa 4x4: (x, z) -> (x, y), z = 0
    m = np.identity(4)
    m[0, 0], m[0, 1], m[0, 3] = m2[0, 0], m2[0, 1], m2[0, 2]
    m[1, 0], m[1, 1], m[1, 3] = m2[1, 0], m2[1, 1], m2[1, 2]
    return m

# ---------- geometria ----------

def criar_cubo():
    v = np.array([
        # x     y     z      r    g    b
        -0.5, -0.5, -0.5,  1.0, 0.0, 0.0,
         0.5, -0.5, -0.5,  0.0, 1.0, 0.0,
         0.5,  0.5, -0.5,  0.0, 0.0, 1.0,
        -0.5,  0.5, -0.5,  1.0, 1.0, 0.0,
        -0.5, -0.5,  0.5,  1.0, 0.0, 1.0,
         0.5, -0.5,  0.5,  0.0, 1.0, 1.0,
         0.5,  0.5,  0.5,  1.0, 1.0, 1.0,
        -0.5,  0.5,  0.5,  0.3, 0.3, 0.3,
    ], dtype=np.float32)
    idx = np.array([
        0, 1, 2, 2, 3, 0,  4, 5, 6, 6, 7, 4,  # trás, frente
        0, 4, 7, 7, 3, 0,  1, 5, 6, 6, 2, 1,  # esquerda, direita
        3, 2, 6, 6, 7, 3,  0, 1, 5, 5, 4, 0,  # topo, base
    ], dtype=np.uint32)
    return v, idx

def criar_marcadores():
    # vértices (x, z, 0) + cor, no espaço local do objeto / do mundo, desenhados com GL_LINES
    br, am, ci = (1, 1, 1), (1, 0.9, 0.2), (0.4, 0.4, 0.4)
    linhas = [
        # quadrado (0..7): contorno do cubo visto de cima
        (-.5, -.5), (.5, -.5), (.5, -.5), (.5, .5), (.5, .5), (-.5, .5), (-.5, .5), (-.5, -.5),
        # seta (8..13): corpo e cabeça apontando para -z local (frente do objeto)
        (0, 0), (0, -.9), (0, -.9), (-.2, -.6), (0, -.9), (.2, -.6),
        # cruz da origem do mundo (14..17)
        (-.3, 0), (.3, 0), (0, -.3), (0, .3),
    ]
    cores = [br] * 8 + [am] * 6 + [ci] * 4
    v = []
    for (x, z), c in zip(linhas, cores):
        v += [x, z, 0.0, *c]
    # marcador do pivô (18..21), em coordenadas de mundo
    px, pz = PIVO[0], PIVO[2]
    for dx, dz in ((-.2, 0), (.2, 0), (0, -.2), (0, .2)):
        v += [px + dx, pz + dz, 0.0, 1.0, 0.3, 0.3]
    return np.array(v, dtype=np.float32)

def criar_vao(vertices, indices=None):
    VAO = glGenVertexArrays(1)
    VBO = glGenBuffers(1)
    glBindVertexArray(VAO)
    glBindBuffer(GL_ARRAY_BUFFER, VBO)
    glBufferData(GL_ARRAY_BUFFER, vertices.nbytes, vertices, GL_STATIC_DRAW)
    if indices is not None:
        EBO = glGenBuffers(1)  # fica guardado dentro do VAO
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO)
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indices.nbytes, indices, GL_STATIC_DRAW)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(0))
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(3 * 4))
    glEnableVertexAttribArray(1)
    glBindVertexArray(0)
    return VAO

# ---------- shaders ----------

def compile_shader(source, shader_type):
    shader = glCreateShader(shader_type)
    glShaderSource(shader, source)
    glCompileShader(shader)
    if not glGetShaderiv(shader, GL_COMPILE_STATUS):
        raise Exception(f"Erro de compilação do shader:\n{glGetShaderInfoLog(shader).decode()}")
    return shader

def create_shader_program(vs_source, fs_source):
    vs = compile_shader(vs_source, GL_VERTEX_SHADER)
    fs = compile_shader(fs_source, GL_FRAGMENT_SHADER)
    program = glCreateProgram()
    glAttachShader(program, vs)
    glAttachShader(program, fs)
    glLinkProgram(program)
    if not glGetProgramiv(program, GL_LINK_STATUS):
        raise Exception(f"Erro de linkar o programa:\n{glGetProgramInfoLog(program).decode()}")
    glDeleteShader(vs)
    glDeleteShader(fs)
    return program

def enviar_mat(program, nome, m):
    # nossas matrizes são "linha por linha"; GL_TRUE pede ao OpenGL para transpor
    glUniformMatrix4fv(glGetUniformLocation(program, nome), 1, GL_TRUE, m.astype(np.float32))

# ---------- entrada ----------

def apertou(window, tecla):
    # True só no frame em que a tecla foi pressionada (toque único)
    p = glfw.get_key(window, tecla) == glfw.PRESS
    antes = tecla in teclas_anteriores
    (teclas_anteriores.add if p else teclas_anteriores.discard)(tecla)
    return p and not antes

def segurando(window, tecla):
    return glfw.get_key(window, tecla) == glfw.PRESS

def process_input(window):
    e = estado
    K = glfw
    eixo = lambda mais, menos: segurando(window, mais) - segurando(window, menos)

    e["t"][0] += PASSO_T * eixo(K.KEY_RIGHT, K.KEY_LEFT)
    e["t"][1] += PASSO_T * eixo(K.KEY_UP, K.KEY_DOWN)
    e["t"][2] = min(2.5, max(-15.0, e["t"][2] + PASSO_T * eixo(K.KEY_W, K.KEY_S)))  # W aproxima, S afasta

    e["rot"][0] += PASSO_R * eixo(K.KEY_I, K.KEY_K)
    e["rot"][1] += PASSO_R * eixo(K.KEY_L, K.KEY_J)
    e["rot"][2] += PASSO_R * eixo(K.KEY_U, K.KEY_N)

    e["escala"] = min(3.0, max(0.2, e["escala"] + PASSO_S * (eixo(K.KEY_EQUAL, K.KEY_MINUS) + eixo(K.KEY_KP_ADD, K.KEY_KP_SUBTRACT))))

    e["fov"] = min(120.0, max(20.0, e["fov"] + PASSO_FOV * eixo(K.KEY_E, K.KEY_Q)))
    e["centro_projecao"][0] += PASSO_OBS * eixo(K.KEY_D, K.KEY_A)

    if apertou(window, K.KEY_1): e["perspectiva"] = False
    if apertou(window, K.KEY_2): e["perspectiva"] = True
    if apertou(window, K.KEY_O): e["ordem"] = 1 - e["ordem"]
    if apertou(window, K.KEY_P): e["pivo_externo"] = not e["pivo_externo"]
    if apertou(window, K.KEY_T): e["orbita"] = not e["orbita"]
    if apertou(window, K.KEY_C): modo_comparacao()
    if apertou(window, K.KEY_R): resetar()

    if e["orbita"]:
        e["theta"] += VEL_ORBITA

def atualizar_titulo(window):
    e = estado
    ordem = "T x R x S" if e["ordem"] == 0 else "R x T x S"
    glfw.set_window_title(window,
        f"{'Perspectiva' if e['perspectiva'] else 'Paralela'} | FOV {e['fov']:.0f} | "
        f"Pivo: {'externo (1,0,0)' if e['pivo_externo'] else 'origem'} | Orbita: {'ON' if e['orbita'] else 'off'} | "
        f"Ordem: {ordem} | Obs X: {e['centro_projecao'][0]:.2f} | Z obj: {e['t'][2]:.2f}")

# ---------- render ----------

def render(window, program, cubo_vao, n_idx, marc_vao):
    w, h = glfw.get_framebuffer_size(window)
    mapa = min(ALTURA_MAPA, h // 2, w // 2)
    model = matriz_model()

    glEnable(GL_SCISSOR_TEST)
    glViewport(0, 0, w, h)
    glScissor(0, 0, w, h)
    glClearColor(0.1, 0.1, 0.15, 1.0)
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    glUseProgram(program)

    # --- visualização principal 3D (acima do minimapa) ---
    glViewport(0, mapa, w, h - mapa)
    glScissor(0, mapa, w, h - mapa)
    glEnable(GL_DEPTH_TEST)
    enviar_mat(program, "uModel", model)
    enviar_mat(program, "uView", matriz_view())
    enviar_mat(program, "uProjection", matriz_projecao(w / max(1, h - mapa)))
    glBindVertexArray(cubo_vao)
    glDrawElements(GL_TRIANGLES, n_idx, GL_UNSIGNED_INT, None)

    # --- minimapa 2D, canto inferior esquerdo ---
    glViewport(0, 0, mapa, mapa)
    glScissor(0, 0, mapa, mapa)
    glClearColor(0.05, 0.05, 0.08, 1.0)
    glClear(GL_COLOR_BUFFER_BIT)
    glDisable(GL_DEPTH_TEST)
    # x do mundo -> x do mapa; z do mundo -> y do mapa (z maior = mais perto do observador = embaixo)
    enviar_mat(program, "uProjection", matriz_paralela(-ALCANCE_MAPA, ALCANCE_MAPA, ALCANCE_MAPA, -ALCANCE_MAPA, -1, 1))
    enviar_mat(program, "uView", np.identity(4))
    glBindVertexArray(marc_vao)
    enviar_mat(program, "uModel", np.identity(4))
    glDrawArrays(GL_LINES, 14, 4)   # origem do mundo
    glDrawArrays(GL_LINES, 18, 4)   # pivô
    enviar_mat(program, "uModel", matriz_minimapa(model))
    glDrawArrays(GL_LINES, 0, 14)   # quadrado + seta, com M2D = T · R · S

    glBindVertexArray(0)
    glfw.swap_buffers(window)
    glfw.poll_events()

def main():
    if not glfw.init():
        raise Exception("Falha ao inicializar o GLFW")
    glfw.window_hint(glfw.CONTEXT_VERSION_MAJOR, 3)
    glfw.window_hint(glfw.CONTEXT_VERSION_MINOR, 3)
    glfw.window_hint(glfw.OPENGL_PROFILE, glfw.OPENGL_CORE_PROFILE)
    window = glfw.create_window(900, 800, "Manipulador 3D", None, None)
    if not window:
        glfw.terminate()
        raise Exception("Falha ao criar a janela")
    glfw.make_context_current(window)

    resetar()
    program = create_shader_program(vertex_shader_source, fragment_shader_source)
    v, idx = criar_cubo()
    cubo_vao = criar_vao(v, idx)
    marc_vao = criar_vao(criar_marcadores())

    while not glfw.window_should_close(window):
        process_input(window)
        atualizar_titulo(window)
        render(window, program, cubo_vao, len(idx), marc_vao)

    glfw.terminate()

if __name__ == "__main__":
    main()
