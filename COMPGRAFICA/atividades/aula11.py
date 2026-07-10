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

uniform vec3 color;

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
        info = glGetShaderInfoLog(shader).decode()                      #decode() para converter bytes em string
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

def interpolar(a, b, t):
    p = (1-t) * a + t * b
    
    return p

def calcular_ponto_na_curva(t, p0, p1, p2, p3):
    a = interpolar(p0, p1, t)
    b = interpolar(p1, p2, t)
    c = interpolar(p2, p3, t)
    
    d = interpolar(a, b, t)
    e = interpolar(b, c, t)

    p = interpolar(d, e, t)
    return p

def gerar_curva_bezier(p0, p1, p2, p3, n = 100):
    p0, p1, p2, p3 = (np.array(p, dtype=np.float64) for p in (p0, p1, p2, p3))
    
    ts = np.linspace(0.0, 1.0, num=n)
    pontos = [calcular_ponto_na_curva(t, p0, p1, p2, p3) for t in ts]
    return np.array(pontos, dtype=np.float32)                                 # define float32 para rodar no OpenGL

def init():
    if not glfw.init():
        raise Exception("Falha ao inicializar o GLFW")

    window = glfw.create_window(800, 600, "Parabola com Bezier", None, None)
    if not window:
        glfw.terminate()
        raise Exception("Falha ao criar a janela")

    glfw.make_context_current(window)
    glfw.set_framebuffer_size_callback(window, framebuffer_size_callback)

    p0 = (-0.8, -0.5)
    p1 = (-0.4,  0.8)
    p2 = ( 0.4,  0.8)
    p3 = ( 0.8, -0.5)

    pontos = gerar_curva_bezier(p0, p1, p2, p3, n = 100)

    vertices = np.array([[x, y] for x, y in pontos], dtype=np.float32).flatten()

    VAO = glGenVertexArrays(1)
    VBO = glGenBuffers(1)

    glBindVertexArray(VAO)

    glBindBuffer(GL_ARRAY_BUFFER, VBO)
    glBufferData(GL_ARRAY_BUFFER, vertices.nbytes, vertices, GL_STATIC_DRAW)

    glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 2 * 4, ctypes.c_void_p(0))  # 2 * 4 porque cada ponto tem 2 coordenadas (x, y) e cada coordenada é um float (4 bytes)
    glEnableVertexAttribArray(0)

    glBindBuffer(GL_ARRAY_BUFFER, 0)
    glBindVertexArray(0)

    shader_program = create_shader_program(vertex_shader_source, fragment_shader_source)

    color_location = glGetUniformLocation(shader_program, "color")

    return window, VAO, VBO, shader_program, color_location, len(pontos)

def render(window, VAO, shader_program, color_location, color, num_pontos):
    glClearColor(0.1, 0.1, 0.15, 1.0)
    glClear(GL_COLOR_BUFFER_BIT)

    glUseProgram(shader_program)
    glUniform3f(color_location, color[0], color[1], color[2])
    glBindVertexArray(VAO)
    glDrawArrays(GL_LINE_STRIP, 0, num_pontos)
    glBindVertexArray(0)

    glfw.swap_buffers(window)   # troca de buffers (double buffering)
    glfw.poll_events()   # events do teclado e mouse

def main():
    window, VAO, VBO, shader_program, color_location, num_pontos = init()

    while not glfw.window_should_close(window):
        t = (np.sin(glfw.get_time()) + 1.0) / 2.0
        color = (t, t, t)
        render(window, VAO, shader_program, color_location, color, num_pontos)

    glDeleteVertexArrays(1, [VAO])
    glDeleteBuffers(1, [VBO])
    glDeleteProgram(shader_program)
    glfw.terminate()

if __name__ == "__main__":
    main()