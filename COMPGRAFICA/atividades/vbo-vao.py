import ctypes
import glfw
import numpy as np
from OpenGL.GL import *

vertex_shader_source = """
#version 330 core
layout(location = 0) in vec3 aPos;
layout(location = 1) in vec3 aColor;

out vec3 vColor;

void main()
{
    gl_Position = vec4(aPos, 1.0);
    vColor = aColor;
}
"""

fragment_shader_source = """
#version 330 core
in vec3 vColor;
out vec4 FragColor;

uniform float brightness;

void main()
{
    FragColor = vec4(vColor * brightness, 1.0);
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

def init():
    if not glfw.init():
        raise Exception("Falha ao inicializar o GLFW")

    window = glfw.create_window(800, 600, "Triangulo VBO e VAO", None, None)
    if not window:
        glfw.terminate()
        raise Exception("Falha ao criar a janela")

    glfw.make_context_current(window)
    glfw.set_framebuffer_size_callback(window, framebuffer_size_callback)

    vertices = np.array([
         0.0,  0.5, 0.0,   1.0, 0.0, 0.0,
        -0.5, -0.5, 0.0,   0.0, 1.0, 0.0,
         0.5, -0.5, 0.0,   0.0, 0.0, 1.0,
    ], dtype=np.float32)

    VAO = glGenVertexArrays(1)
    VBO = glGenBuffers(1)

    glBindVertexArray(VAO)

    glBindBuffer(GL_ARRAY_BUFFER, VBO)
    glBufferData(GL_ARRAY_BUFFER, vertices.nbytes, vertices, GL_STATIC_DRAW)

    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(0))
    glEnableVertexAttribArray(0)

    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(3 * 4))
    glEnableVertexAttribArray(1)

    glBindBuffer(GL_ARRAY_BUFFER, 0)
    glBindVertexArray(0)

    shader_program = create_shader_program(vertex_shader_source, fragment_shader_source)

    brightness_location = glGetUniformLocation(shader_program, "brightness")

    return window, VAO, VBO, shader_program, brightness_location

def render(window, VAO, shader_program, brightness_location, brightness):
    glClearColor(0.1, 0.1, 0.15, 1.0)
    glClear(GL_COLOR_BUFFER_BIT)

    glUseProgram(shader_program)
    glUniform1f(brightness_location, brightness)
    glBindVertexArray(VAO)
    glDrawArrays(GL_TRIANGLES, 0, 3)
    glBindVertexArray(0)

    glfw.swap_buffers(window)   # troca de buffers (double buffering)
    glfw.poll_events()   # events do teclado e mouse

def main():
    window, VAO, VBO, shader_program, brightness_location = init()

    while not glfw.window_should_close(window):
        brightness = (np.sin(glfw.get_time()) + 1.0) / 2.0
        render(window, VAO, shader_program, brightness_location, brightness)

    glDeleteVertexArrays(1, [VAO])
    glDeleteBuffers(1, [VBO])
    glDeleteProgram(shader_program)
    glfw.terminate()

if __name__ == "__main__":
    main()