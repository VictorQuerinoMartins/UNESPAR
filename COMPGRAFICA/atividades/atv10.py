import ctypes
import glfw
import numpy as np
from OpenGL.GL import *

# Shaders
vertex_shader_source = """
#version 330 core
layout(location = 0) in vec3 aPos;
layout(location = 1) in vec3 aColor;
out vec3 vColor;
uniform float time;

void main() {
    vec3 pos = aPos;
    // Deformação no eixo Y baseada na posição X e no tempo
    pos.y += sin(pos.x * 5.0 + time) * 0.2;
    gl_Position = vec4(pos, 1.0);
    vColor = aColor;
}
"""

fragment_shader_source = """
#version 330 core
in vec3 vColor;
out vec4 FragColor;
void main() {
    FragColor = vec4(vColor, 1.0);
}
"""

def compile_shader(source, shader_type):
    shader = glCreateShader(shader_type)
    glShaderSource(shader, source)
    glCompileShader(shader)
    if not glGetShaderiv(shader, GL_COMPILE_STATUS):
        raise Exception(glGetShaderInfoLog(shader).decode())
    return shader

def create_program(v_src, f_src):
    vertex_shader = compile_shader(v_src, GL_VERTEX_SHADER)
    fragment_shader = compile_shader(f_src, GL_FRAGMENT_SHADER)

    program = glCreateProgram()
    glAttachShader(program, vertex_shader)
    glAttachShader(program, fragment_shader)
    glLinkProgram(program)
    if not glGetProgramiv(program, GL_LINK_STATUS):
        raise Exception(glGetProgramInfoLog(program).decode())

    glDeleteShader(vertex_shader)
    glDeleteShader(fragment_shader)
    return program

def framebuffer_size_callback(window, width, height):
    glViewport(0, 0, width, height)

def setup_vao(data):
    vao = glGenVertexArrays(1)
    vbo = glGenBuffers(1)
    glBindVertexArray(vao)
    glBindBuffer(GL_ARRAY_BUFFER, vbo)
    glBufferData(GL_ARRAY_BUFFER, data.nbytes, data, GL_STATIC_DRAW)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(0))
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(3 * 4))
    glEnableVertexAttribArray(1)
    glBindBuffer(GL_ARRAY_BUFFER, 0)
    glBindVertexArray(0)
    return vao, vbo

def init():
    if not glfw.init():
        raise Exception("Falha ao inicializar o GLFW")

    glfw.window_hint(glfw.CONTEXT_VERSION_MAJOR, 3)
    glfw.window_hint(glfw.CONTEXT_VERSION_MINOR, 3)
    glfw.window_hint(glfw.OPENGL_PROFILE, glfw.OPENGL_CORE_PROFILE)

    window = glfw.create_window(800, 600, "Dois Triangulos Deformados", None, None)
    if not window:
        glfw.terminate()
        raise Exception("Falha ao criar a janela")

    glfw.make_context_current(window)
    glfw.set_framebuffer_size_callback(window, framebuffer_size_callback)

    # Triângulo 1 (Vermelho, posicionado à esquerda)
    verts1 = np.array([-0.7, 0.0, 0.0, 1.0, 0.0, 0.0,
                        -0.3, 0.0, 0.0, 1.0, 0.0, 0.0,
                        -0.5, 0.5, 0.0, 1.0, 0.0, 0.0], dtype=np.float32)

    # Triângulo 2 (Azul, posicionado à direita)
    verts2 = np.array([0.3, 0.0, 0.0, 0.0, 0.0, 1.0,
                        0.7, 0.0, 0.0, 0.0, 0.0, 1.0,
                        0.5, 0.5, 0.0, 0.0, 0.0, 1.0], dtype=np.float32)

    vao1, vbo1 = setup_vao(verts1)
    vao2, vbo2 = setup_vao(verts2)

    program = create_program(vertex_shader_source, fragment_shader_source)
    time_loc = glGetUniformLocation(program, "time")

    glClearColor(0.1, 0.1, 0.1, 1.0)

    return window, vao1, vao2, vbo1, vbo2, program, time_loc

def render(window, vao1, vao2, program, time_loc):
    glClear(GL_COLOR_BUFFER_BIT)
    glUseProgram(program)

    # Envia o tempo para a animação da deformação
    glUniform1f(time_loc, glfw.get_time())

    glBindVertexArray(vao1)
    glDrawArrays(GL_TRIANGLES, 0, 3)

    glBindVertexArray(vao2)
    glDrawArrays(GL_TRIANGLES, 0, 3)

    glBindVertexArray(0)
    glfw.swap_buffers(window)
    glfw.poll_events()

def main():
    window, vao1, vao2, vbo1, vbo2, program, time_loc = init()

    while not glfw.window_should_close(window):
        render(window, vao1, vao2, program, time_loc)

    glDeleteVertexArrays(2, [vao1, vao2])
    glDeleteBuffers(2, [vbo1, vbo2])
    glDeleteProgram(program)
    glfw.terminate()

if __name__ == "__main__":
    main()
