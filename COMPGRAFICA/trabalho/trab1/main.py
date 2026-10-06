#Desenvolver uma aplicação gráfica utilizando OpenGL Moderno que permita ao usuário interagir com uma curva de Bézier cúbica por meio do teclado. O projeto deve integrar os conceitos estudados em sala: shaders, uniforms, VAO/VBO e curvas de Bézier.

import ctypes
import glfw
import numpy as np
from OpenGL.GL import *

vertex_shader_source = """
#version 330 core
layout(location = 0) in vec2 aPos;

void main()
{
    gl_Position = vec4(aPos, 0.0, 1.0);
}
"""

fragment_shader_source = """
#version 330 core
out vec4 FragColor;

uniform vec3 color;  // enviado pela CPU a cada draw call, permite trocar a cor sem recompilar o shader

void main()
{
    FragColor = vec4(color, 1.0);
}
"""

def compile_shader(source, shader_type):
    shader = glCreateShader(shader_type)
    glShaderSource(shader, source)
    glCompileShader(shader)

    success = glGetShaderiv(shader, GL_COMPILE_STATUS)
    if not success:
        info = glGetShaderInfoLog(shader).decode()
        raise Exception(f"Erro de compilação do shader:\n{info}")

    return shader

def create_shader_program(vertex_shader_source, fragment_shader_source):
    vertex_shader = compile_shader(vertex_shader_source, GL_VERTEX_SHADER)
    fragment_shader = compile_shader(fragment_shader_source, GL_FRAGMENT_SHADER)

    shader_program = glCreateProgram()
    glAttachShader(shader_program, vertex_shader)
    glAttachShader(shader_program, fragment_shader)
    glLinkProgram(shader_program)

    success = glGetProgramiv(shader_program, GL_LINK_STATUS)
    if not success:
        info = glGetProgramInfoLog(shader_program).decode()
        raise Exception(f"Erro de linkar o programa:\n{info}")

    glDeleteShader(vertex_shader)
    glDeleteShader(fragment_shader)

    return shader_program

def framebuffer_size_callback(window, width, height):
    glViewport(0, 0, width, height)

PASSO_MOVIMENTO = 0.03      # deslocamento 
PASSO_AMOSTRAS = 100        # variação na resolução "+" e "-"
MIN_AMOSTRAS = 100
MAX_AMOSTRAS = 2000
PASSO_ESPESSURA = 1.0       # variação na espessura "[" e "]"
MIN_ESPESSURA = 1.0
MAX_ESPESSURA = 10.0

# uniformes e variáveis, que podem ser alteradas pelo usuário
estado = {
    "cor_curva": (1.0, 1.0, 1.0),
    "pontos_controle": [
        [-0.8, -0.5],
        [-0.3,  0.8],
        [ 0.3, -0.8],
        [ 0.8,  0.5],
    ],
    "indice_selecionado": 0,   
    "num_amostras": 100,      
    "num_curva": 0,           
    "dirty": False,            # True quando pontos/resolução mudaram e o VBO precisa ser reenviado
    "espessura_curva": 2.0,   
    "mostrar_poligono": True,  
    "teclas_anteriores": set(),  # usado por tecla_pressionada_agora() para detectar toque único
}

def tecla_pressionada_agora(window, tecla):
    
    # esta função só retorna True no frame em que a tecla passou de solta para pressionada
    pressionada = glfw.get_key(window, tecla) == glfw.PRESS
    estava_pressionada = tecla in estado["teclas_anteriores"]

    if pressionada:
        estado["teclas_anteriores"].add(tecla)
    else:
        estado["teclas_anteriores"].discard(tecla)

    return pressionada and not estava_pressionada

def mover_ponto_selecionado(dx, dy):
    i = estado["indice_selecionado"]
    x, y = estado["pontos_controle"][i]
    estado["pontos_controle"][i] = [x + dx, y + dy]
    estado["dirty"] = True

def alterar_num_amostras(delta):
    estado["num_amostras"] = min(MAX_AMOSTRAS, max(MIN_AMOSTRAS, estado["num_amostras"] + delta))
    estado["dirty"] = True

def alterar_espessura(delta):
    estado["espessura_curva"] = min(MAX_ESPESSURA, max(MIN_ESPESSURA, estado["espessura_curva"] + delta))

def process_input(window):
    if tecla_pressionada_agora(window, glfw.KEY_R):
        estado["cor_curva"] = (1.0, 0.0, 0.0)
    if tecla_pressionada_agora(window, glfw.KEY_G):
        estado["cor_curva"] = (0.0, 1.0, 0.0)
    if tecla_pressionada_agora(window, glfw.KEY_B):
        estado["cor_curva"] = (0.0, 0.0, 1.0)
    if tecla_pressionada_agora(window, glfw.KEY_W):
        estado["cor_curva"] = (1.0, 1.0, 1.0)

    for i, tecla in enumerate((glfw.KEY_1, glfw.KEY_2, glfw.KEY_3, glfw.KEY_4)):
        if tecla_pressionada_agora(window, tecla):
            estado["indice_selecionado"] = i

    # soma os deltas de todas as setas pressionadas para permitir movimento diagonal
    dx = dy = 0.0
    if glfw.get_key(window, glfw.KEY_UP) == glfw.PRESS:
        dy += PASSO_MOVIMENTO
    if glfw.get_key(window, glfw.KEY_DOWN) == glfw.PRESS:
        dy -= PASSO_MOVIMENTO
    if glfw.get_key(window, glfw.KEY_LEFT) == glfw.PRESS:
        dx -= PASSO_MOVIMENTO
    if glfw.get_key(window, glfw.KEY_RIGHT) == glfw.PRESS:
        dx += PASSO_MOVIMENTO
    if dx != 0.0 or dy != 0.0:
        mover_ponto_selecionado(dx, dy)

    if tecla_pressionada_agora(window, glfw.KEY_EQUAL):
        alterar_num_amostras(PASSO_AMOSTRAS)
    if tecla_pressionada_agora(window, glfw.KEY_KP_ADD):
        alterar_num_amostras(PASSO_AMOSTRAS)
    if tecla_pressionada_agora(window, glfw.KEY_MINUS):
        alterar_num_amostras(-PASSO_AMOSTRAS)
    if tecla_pressionada_agora(window, glfw.KEY_KP_SUBTRACT):
        alterar_num_amostras(-PASSO_AMOSTRAS)

    if tecla_pressionada_agora(window, glfw.KEY_P):
        estado["mostrar_poligono"] = not estado["mostrar_poligono"]

    if tecla_pressionada_agora(window, glfw.KEY_RIGHT_BRACKET):
        alterar_espessura(PASSO_ESPESSURA)
    if tecla_pressionada_agora(window, glfw.KEY_LEFT_BRACKET):
        alterar_espessura(-PASSO_ESPESSURA)

def interpolar(a, b, t):
    return (1 - t) * a + t * b

#  4 pontos de controle a 1 ponto da curva
def calcular_ponto_na_curva(t, p0, p1, p2, p3):
    a = interpolar(p0, p1, t)
    b = interpolar(p1, p2, t)
    c = interpolar(p2, p3, t)

    d = interpolar(a, b, t)
    e = interpolar(b, c, t)

    return interpolar(d, e, t)

def gerar_curva_bezier(p0, p1, p2, p3, n=100):
    p0, p1, p2, p3 = (np.array(p, dtype=np.float64) for p in (p0, p1, p2, p3))

    ts = np.linspace(0.0, 1.0, num=n)
    pontos = [calcular_ponto_na_curva(t, p0, p1, p2, p3) for t in ts]
    return np.array(pontos, dtype=np.float32)  

def criar_vao(vertices):
    VAO = glGenVertexArrays(1)  # guarda os atributos
    VBO = glGenBuffers(1)       # guarda os dados dos vértices na GPU

    glBindVertexArray(VAO)

    glBindBuffer(GL_ARRAY_BUFFER, VBO)
    glBufferData(GL_ARRAY_BUFFER, vertices.nbytes, vertices, GL_DYNAMIC_DRAW)

    # a cada 8 bytes, pega 2 floats a partir do começo, e isso é a posição do vértice
    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 2 * 4, ctypes.c_void_p(0))
    glEnableVertexAttribArray(0)

    glBindBuffer(GL_ARRAY_BUFFER, 0)
    glBindVertexArray(0)

    return VAO, VBO

def atualizar_vbo(curva_VBO, poligono_VBO):
    pontos_controle = estado["pontos_controle"]

    curva = gerar_curva_bezier(*pontos_controle, n=estado["num_amostras"])
    glBindBuffer(GL_ARRAY_BUFFER, curva_VBO)
    # o número de amostras pode mudar (+/-), então o buffer é realocado com glBufferData, não glBufferSubData
    glBufferData(GL_ARRAY_BUFFER, curva.nbytes, curva, GL_DYNAMIC_DRAW)

    poligono = np.array(pontos_controle, dtype=np.float32)
    glBindBuffer(GL_ARRAY_BUFFER, poligono_VBO)
    glBufferData(GL_ARRAY_BUFFER, poligono.nbytes, poligono, GL_DYNAMIC_DRAW)

    glBindBuffer(GL_ARRAY_BUFFER, 0)

    estado["num_curva"] = len(curva)
    estado["dirty"] = False

def init():
    if not glfw.init():
        raise Exception("Falha ao inicializar o GLFW")

    glfw.window_hint(glfw.CONTEXT_VERSION_MAJOR, 3)
    glfw.window_hint(glfw.CONTEXT_VERSION_MINOR, 3)
    glfw.window_hint(glfw.OPENGL_PROFILE, glfw.OPENGL_CORE_PROFILE)

    window = glfw.create_window(800, 600, "Curva de Bezier Cubica", None, None)
    if not window:
        glfw.terminate()
        raise Exception("Falha ao criar a janela")

    glfw.make_context_current(window)
    glfw.set_framebuffer_size_callback(window, framebuffer_size_callback)

    curva = gerar_curva_bezier(*estado["pontos_controle"], n=estado["num_amostras"])
    curva_VAO, curva_VBO = criar_vao(curva)
    estado["num_curva"] = len(curva)

    poligono = np.array(estado["pontos_controle"], dtype=np.float32)
    poligono_VAO, poligono_VBO = criar_vao(poligono)  # mesmo buffer serve para GL_LINE_STRIP e GL_POINTS

    shader_program = create_shader_program(vertex_shader_source, fragment_shader_source)
    color_location = glGetUniformLocation(shader_program, "color")

    glClearColor(0.1, 0.1, 0.15, 1.0)

    return window, curva_VAO, curva_VBO, poligono_VAO, poligono_VBO, shader_program, color_location

def desenhar_curva(curva_VAO, color_location):
    r, g, b = estado["cor_curva"]
    glUniform3f(color_location, r, g, b)
    glLineWidth(estado["espessura_curva"])
    glBindVertexArray(curva_VAO)
    glDrawArrays(GL_LINE_STRIP, 0, estado["num_curva"])

def desenhar_poligono(poligono_VAO, color_location):
    if not estado["mostrar_poligono"]:  # tecla P 
        return

    num_controle = len(estado["pontos_controle"])

    glLineWidth(1.0)
    glUniform3f(color_location, 0.4, 0.4, 0.4)
    glBindVertexArray(poligono_VAO)
    glDrawArrays(GL_LINE_STRIP, 0, num_controle)

def desenhar_pontos(poligono_VAO, color_location):
    if not estado["mostrar_poligono"]:
        return

    num_controle = len(estado["pontos_controle"])
    glBindVertexArray(poligono_VAO)

    glPointSize(8.0)
    glUniform3f(color_location, 1.0, 0.2, 0.2)
    glDrawArrays(GL_POINTS, 0, num_controle)

    glPointSize(14.0)  # ponto selecionado
    glUniform3f(color_location, 1.0, 1.0, 0.0)
    glDrawArrays(GL_POINTS, estado["indice_selecionado"], 1)

def render(window, curva_VAO, poligono_VAO, shader_program, color_location):
    glClear(GL_COLOR_BUFFER_BIT)
    glUseProgram(shader_program)

    desenhar_curva(curva_VAO, color_location)
    desenhar_poligono(poligono_VAO, color_location)
    desenhar_pontos(poligono_VAO, color_location)

    glBindVertexArray(0)

    glfw.swap_buffers(window)
    glfw.poll_events()

def main():
    window, curva_VAO, curva_VBO, poligono_VAO, poligono_VBO, shader_program, color_location = init()

    while not glfw.window_should_close(window):
        process_input(window)

        if estado["dirty"]:
            atualizar_vbo(curva_VBO, poligono_VBO)  # recalcula a curva e reenvia os VBOs

        render(window, curva_VAO, poligono_VAO, shader_program, color_location)

    glDeleteVertexArrays(2, [curva_VAO, poligono_VAO])
    glDeleteBuffers(2, [curva_VBO, poligono_VBO])
    glDeleteProgram(shader_program)
    glfw.terminate()

if __name__ == "__main__":
    main()
