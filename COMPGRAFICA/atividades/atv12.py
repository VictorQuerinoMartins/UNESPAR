import ctypes
import glfw
import numpy as np
from OpenGL.GL import *

WINDOW_WIDTH = 800
WINDOW_HEIGHT = 600

VERTEX_SHADER_SOURCE = """
#version 330 core
layout(location = 0) in vec2 aPos;

uniform mat3 uTransform;    // Matriz de transformação (translação + rotação + escala)

void main(){
    vec3 p = vec3(aPos, 1.0);
    vec3 transformed = uTransform * p;
    gl_Position = vec4(transformed.xy, 0.0, 1.0);
}
"""

FRAGMENT_SHADER_SOURCE = """
#version 330 core
out vec4 FragColor;

uniform vec3 uColor;

void main(){
    FragColor = vec4(uColor, 1.0);
}
"""

def matriz_translacao(delta_x, delta_y):
    """Cálculo da translação: desloca os vértices em (delta_x, delta_y)."""
    return np.array([
        [1.0, 0.0, delta_x],
        [0.0, 1.0, delta_y],
        [0.0, 0.0, 1.0],
    ], dtype=np.float32)


def matriz_escala(fator_x, fator_y):
    """Cálculo da escala: multiplica os vértices por (fator_x, fator_y)."""
    return np.array([
        [fator_x, 0.0, 0.0],
        [0.0, fator_y, 0.0],
        [0.0, 0.0, 1.0],
    ], dtype=np.float32)


def matriz_rotacao(angulo_graus):
    """Cálculo da rotação: gira os vértices em torno da origem."""
    angulo_rad = np.radians(angulo_graus)
    cos = np.cos(angulo_rad)
    sin = np.sin(angulo_rad)
    return np.array([
        [cos, -sin, 0.0],
        [sin, cos, 0.0],
        [0.0, 0.0, 1.0],
    ], dtype=np.float32)


class EstadoTransformacao:
    """Guarda o estado atual (translação, rotação, escala) e monta a matriz final."""

    TRANSLATE_STEP = 0.05
    ROTATE_STEP_GRAUS = 5.0
    SCALE_STEP = 0.05
    SCALE_MIN = 0.2
    SCALE_MAX = 3.0

    def __init__(self):
        self.tx = 0.0
        self.ty = 0.0
        self.angulo = 0.0
        self.escala = 1.0

    def transladar(self, dx, dy):
        self.tx += dx
        self.ty += dy

    def rotacionar(self, sentido):
        # sentido = +1 (anti-horário) ou -1 (horário)
        self.angulo += sentido * self.ROTATE_STEP_GRAUS

    def redimensionar(self, sentido):
        # sentido = +1 (aumenta) ou -1 (diminui)
        self.escala += sentido * self.SCALE_STEP
        self.escala = float(np.clip(self.escala, self.SCALE_MIN, self.SCALE_MAX))

    def matriz_final(self):
        # Composição: escala -> rotação -> translação (aplicadas da direita p/ esquerda)
        T = matriz_translacao(self.tx, self.ty)
        R = matriz_rotacao(self.angulo)
        S = matriz_escala(self.escala, self.escala)
        return T @ R @ S


estado = EstadoTransformacao()


def compile_shader(source, shader_type):
    shader = glCreateShader(shader_type)
    glShaderSource(shader, source)
    glCompileShader(shader)

    success = glGetShaderiv(shader, GL_COMPILE_STATUS)
    if not success:
        info = glGetShaderInfoLog(shader).decode()
        raise RuntimeError(f"Erro de compilação do shader:\n{info}")

    return shader


def create_shader_program(vertex_source, fragment_source):
    vertex_shader = compile_shader(vertex_source, GL_VERTEX_SHADER)
    fragment_shader = compile_shader(fragment_source, GL_FRAGMENT_SHADER)

    program = glCreateProgram()
    glAttachShader(program, vertex_shader)
    glAttachShader(program, fragment_shader)
    glLinkProgram(program)

    success = glGetProgramiv(program, GL_LINK_STATUS)
    if not success:
        info = glGetProgramInfoLog(program).decode()
        raise RuntimeError(f"Erro ao linkar o programa:\n{info}")

    glDeleteShader(vertex_shader)
    glDeleteShader(fragment_shader)

    return program


def framebuffer_size_callback(window, width, height):
    glViewport(0, 0, width, height)


def key_callback(window, key, scancode, action, mods):
    if action not in (glfw.PRESS, glfw.REPEAT):
        return

    if key == glfw.KEY_ESCAPE:
        glfw.set_window_should_close(window, True)

    elif key == glfw.KEY_LEFT:
        estado.transladar(-EstadoTransformacao.TRANSLATE_STEP, 0.0)
    elif key == glfw.KEY_RIGHT:
        estado.transladar(EstadoTransformacao.TRANSLATE_STEP, 0.0)
    elif key == glfw.KEY_UP:
        estado.transladar(0.0, EstadoTransformacao.TRANSLATE_STEP)
    elif key == glfw.KEY_DOWN:
        estado.transladar(0.0, -EstadoTransformacao.TRANSLATE_STEP)

    elif key == glfw.KEY_R:
        if mods & glfw.MOD_SHIFT:
            estado.rotacionar(-1)
        else:
            estado.rotacionar(1)

    elif key == glfw.KEY_E:
        if mods & glfw.MOD_SHIFT:
            estado.redimensionar(1)
        else:
            estado.redimensionar(-1)


def criar_figura():
    vertices = np.array([
        -0.15, -0.15,
         0.15, -0.15,
         0.15,  0.15,

        -0.15, -0.15,
         0.15,  0.15,
        -0.15,  0.15,
    ], dtype=np.float32)

    VAO = glGenVertexArrays(1)
    VBO = glGenBuffers(1)

    glBindVertexArray(VAO)

    glBindBuffer(GL_ARRAY_BUFFER, VBO)
    glBufferData(GL_ARRAY_BUFFER, vertices.nbytes, vertices, GL_STATIC_DRAW)

    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 2 * 4, ctypes.c_void_p(0))
    glEnableVertexAttribArray(0)

    glBindBuffer(GL_ARRAY_BUFFER, 0)
    glBindVertexArray(0)

    return VAO, VBO, len(vertices) // 2


def init():
    if not glfw.init():
        raise RuntimeError("Falha ao inicializar o GLFW")

    window = glfw.create_window(
        WINDOW_WIDTH, WINDOW_HEIGHT,
        "Atividade 12 - Translação, Rotação e Escala via teclado",
        None, None,
    )
    if not window:
        glfw.terminate()
        raise RuntimeError("Falha ao criar a janela")

    glfw.make_context_current(window)
    glfw.set_framebuffer_size_callback(window, framebuffer_size_callback)
    glfw.set_key_callback(window, key_callback)

    VAO, VBO, num_vertices = criar_figura()
    shader_program = create_shader_program(VERTEX_SHADER_SOURCE, FRAGMENT_SHADER_SOURCE)

    transform_loc = glGetUniformLocation(shader_program, "uTransform")
    color_loc = glGetUniformLocation(shader_program, "uColor")

    return window, VAO, VBO, num_vertices, shader_program, transform_loc, color_loc


def render(window, VAO, num_vertices, shader_program, transform_loc, color_loc):
    glClearColor(0.1, 0.1, 0.15, 1.0)
    glClear(GL_COLOR_BUFFER_BIT)

    glUseProgram(shader_program)

    # Matriz final é recalculada a cada quadro a partir do estado atual
    matriz_final = estado.matriz_final()
    glUniformMatrix3fv(transform_loc, 1, GL_TRUE, matriz_final)
    glUniform3f(color_loc, 0.95, 0.55, 0.2)

    glBindVertexArray(VAO)
    glDrawArrays(GL_TRIANGLES, 0, num_vertices)
    glBindVertexArray(0)

    glfw.swap_buffers(window)
    glfw.poll_events()


def main():
    window, VAO, VBO, num_vertices, shader_program, transform_loc, color_loc = init()

    while not glfw.window_should_close(window):
        render(window, VAO, num_vertices, shader_program, transform_loc, color_loc)

    glDeleteVertexArrays(1, [VAO])
    glDeleteBuffers(1, [VBO])
    glDeleteProgram(shader_program)
    glfw.terminate()


if __name__ == "__main__":
    main()
