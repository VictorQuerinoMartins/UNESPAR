import ctypes
import sys

import glfw
import numpy as np
from OpenGL.GL import *


WIDTH = 1000
HEIGHT = 700

mode = 1
factor = 2


VERTEX_SHADER = """
#version 330 core

layout(location = 0) in vec2 aPos;
layout(location = 1) in vec3 aColor;

out vec3 vertexColor;

void main()
{
    gl_Position =
        vec4(
            aPos,
            0.0,
            1.0
        );

    vertexColor = aColor;
}
"""


FRAGMENT_SHADER = """
#version 330 core

in vec3 vertexColor;

out vec4 FragColor;

void main()
{
    FragColor =
        vec4(
            vertexColor,
            1.0
        );
}
"""


def create_demo_image():
    R = [1.0, 0.0, 0.0]
    G = [0.0, 0.7, 0.0]
    B = [0.0, 0.0, 1.0]
    Y = [1.0, 1.0, 0.0]
    W = [1.0, 1.0, 1.0]
    K = [0.0, 0.0, 0.0]
    O = [1.0, 0.5, 0.0]
    M = [1.0, 0.0, 1.0]
    C = [0.0, 1.0, 1.0]

    # bandeira/simbolo 6x6 com 9 cores
    return np.array([
        [R, R, Y, Y, G, G],
        [R, W, Y, Y, W, G],
        [B, B, W, W, O, O],
        [B, B, W, W, O, O],
        [K, M, C, C, M, K],
        [K, K, C, C, K, K],
    ], dtype=np.float32)


def create_border_image():
    # desafio: fronteira forte vermelho | azul
    image = np.zeros((6, 6, 3), dtype=np.float32)
    image[:, :3] = [1.0, 0.0, 0.0]
    image[:, 3:] = [0.0, 0.0, 1.0]
    return image


def only_channel(image, channel_index):
    result = np.zeros_like(
        image
    )

    result[:, :, channel_index] = image[:, :, channel_index]

    return result


def zoom_in_quadrado(image, factor):
    zoomed = np.repeat(
        image,
        factor,
        axis=0
    )

    zoomed = np.repeat(
        zoomed,
        factor,
        axis=1
    )

    return zoomed


def zoom_in_linear(image, factor):
    height, width, channels = image.shape

    new_height = height * factor
    new_width = width * factor

    result = np.zeros(
        (new_height, new_width, channels),
        dtype=np.float32
    )

    for new_row in range(new_height):
        source_y = new_row / factor

        y0 = int(
            np.floor(source_y)
        )

        y1 = min(
            y0 + 1,
            height - 1
        )

        ty = source_y - y0

        for new_col in range(new_width):
            source_x = new_col / factor

            x0 = int(
                np.floor(source_x)
            )

            x1 = min(
                x0 + 1,
                width - 1
            )

            tx = source_x - x0

            top = (
                (1.0 - tx) * image[y0, x0] +
                tx * image[y0, x1]
            )

            bottom = (
                (1.0 - tx) * image[y1, x0] +
                tx * image[y1, x1]
            )

            result[new_row, new_col] = (
                (1.0 - ty) * top +
                ty * bottom
            )

    return result


def zoom_out_quadrado(image, factor):
    return image[::factor, ::factor]


def zoom_out_media(image, factor):
    height, width, channels = image.shape

    new_height = max(
        1,
        height // factor
    )

    new_width = max(
        1,
        width // factor
    )

    result = np.zeros(
        (new_height, new_width, channels),
        dtype=np.float32
    )

    for row in range(new_height):
        for col in range(new_width):
            block = image[
                row * factor:(row + 1) * factor,
                col * factor:(col + 1) * factor
            ]

            result[row, col] = block.mean(
                axis=(0, 1)
            )

    return result


def create_window():
    if not glfw.init():
        raise RuntimeError(
            "Nao foi possivel inicializar o GLFW."
        )

    glfw.window_hint(
        glfw.CONTEXT_VERSION_MAJOR,
        3
    )

    glfw.window_hint(
        glfw.CONTEXT_VERSION_MINOR,
        3
    )

    glfw.window_hint(
        glfw.OPENGL_PROFILE,
        glfw.OPENGL_CORE_PROFILE
    )

    glfw.window_hint(
        glfw.RESIZABLE,
        glfw.FALSE
    )

    if sys.platform == "darwin":
        glfw.window_hint(
            glfw.OPENGL_FORWARD_COMPAT,
            GL_TRUE
        )

    window = glfw.create_window(
        WIDTH,
        HEIGHT,
        "Imagem como Matriz e Zoom",
        None,
        None
    )

    if not window:
        glfw.terminate()

        raise RuntimeError(
            "Nao foi possivel criar a janela."
        )

    glfw.make_context_current(window)

    return window


def compile_shader(source, shader_type):
    shader = glCreateShader(shader_type)

    glShaderSource(
        shader,
        source
    )

    glCompileShader(shader)

    success = glGetShaderiv(
        shader,
        GL_COMPILE_STATUS
    )

    if not success:
        error = glGetShaderInfoLog(
            shader
        ).decode()

        glDeleteShader(shader)

        raise RuntimeError(
            f"Erro ao compilar shader:\n{error}"
        )

    return shader


def create_shader_program():
    vertex_shader = compile_shader(
        VERTEX_SHADER,
        GL_VERTEX_SHADER
    )

    fragment_shader = compile_shader(
        FRAGMENT_SHADER,
        GL_FRAGMENT_SHADER
    )

    program = glCreateProgram()

    glAttachShader(
        program,
        vertex_shader
    )

    glAttachShader(
        program,
        fragment_shader
    )

    glLinkProgram(program)

    success = glGetProgramiv(
        program,
        GL_LINK_STATUS
    )

    if not success:
        error = glGetProgramInfoLog(
            program
        ).decode()

        glDeleteShader(vertex_shader)
        glDeleteShader(fragment_shader)
        glDeleteProgram(program)

        raise RuntimeError(
            f"Erro ao linkar programa:\n{error}"
        )

    glDeleteShader(vertex_shader)
    glDeleteShader(fragment_shader)

    return program


def add_cell(vertices, x0, y0, x1, y1, color):
    r, g, b = color

    vertices.extend([
        x0, y0, r, g, b,
        x1, y0, r, g, b,
        x1, y1, r, g, b,

        x0, y0, r, g, b,
        x1, y1, r, g, b,
        x0, y1, r, g, b,
    ])


def build_grid_vertices(
    image,
    center_x,
    center_y,
    cell_size,
    gap
):
    vertices = []

    height, width, _ = image.shape

    total_width = width * cell_size + (width - 1) * gap
    total_height = height * cell_size + (height - 1) * gap

    start_x = center_x - total_width / 2.0
    start_y = center_y + total_height / 2.0

    for row in range(height):
        for col in range(width):
            x0 = start_x + col * (cell_size + gap)
            y1 = start_y - row * (cell_size + gap)

            x1 = x0 + cell_size
            y0 = y1 - cell_size

            color = image[row, col]

            add_cell(
                vertices,
                x0,
                y0,
                x1,
                y1,
                color
            )

    return np.array(
        vertices,
        dtype=np.float32
    )


def build_panels(images):
    centers = [-0.62, 0.0, 0.62] if len(images) == 3 else [0.0]
    vertices = []

    for image, cx in zip(images, centers):
        cell_size = min(0.12, 0.5 / max(image.shape[:2]))

        vertices.append(
            build_grid_vertices(
                image,
                center_x=cx,
                center_y=0.0,
                cell_size=cell_size,
                gap=0.004
            )
        )

    return np.concatenate(vertices)


def get_images(original_image):
    # lista de imagens exibidas no modo atual
    if mode == 1:
        return [original_image]

    if mode == 2:
        return [only_channel(original_image, c) for c in range(3)]

    if mode == 3:
        return [zoom_in_quadrado(original_image, factor)]

    if mode == 4:
        return [zoom_in_linear(original_image, factor)]

    if mode == 5:
        return [zoom_out_quadrado(original_image, factor)]

    if mode == 6:
        return [zoom_out_media(original_image, factor)]

    if mode == 7:
        return [
            original_image,
            zoom_in_quadrado(original_image, factor),
            zoom_in_linear(original_image, factor),
        ]

    if mode == 8:
        return [
            original_image,
            zoom_out_quadrado(original_image, factor),
            zoom_out_media(original_image, factor),
        ]

    # mode 9: desafio da fronteira
    border = create_border_image()

    return [
        border,
        zoom_in_quadrado(border, factor),
        zoom_in_linear(border, factor),
    ]


def build_scene_vertices(original_image):
    return build_panels(get_images(original_image))


def print_inspection(original_image):
    print("original.shape =", original_image.shape)

    for linha, coluna in [(0, 0), (2, 2), (3, 4)]:
        print(f"image[{linha}, {coluna}] =", original_image[linha, coluna])

    zq = zoom_in_quadrado(original_image, 2)
    zl = zoom_in_linear(original_image, 2)

    print("zoom_linear[1, 3] =", zl[1, 3])
    print(
        "  vem de original[0,1], [0,2], [1,1], [1,2] =",
        original_image[0, 1],
        original_image[0, 2],
        original_image[1, 1],
        original_image[1, 2]
    )

    # fronteira: linha 0, colunas 2..3 do zoom 2 (origem coluna 2 e 3 no zoom=1)
    border = create_border_image()
    bq = zoom_in_quadrado(border, 2)[0]
    bl = zoom_in_linear(border, 2)[0]
    print("fronteira quadrado (cols 4..7):", bq[4:8].tolist())
    print("fronteira linear   (cols 4..7):", bl[4:8].tolist())


def print_shapes(original_image):
    print(f"\n[modo {mode} | factor {factor}]")

    for img in get_images(original_image):
        print("  shape:", img.shape)


def create_geometry(vertices):
    vao = glGenVertexArrays(1)
    vbo = glGenBuffers(1)

    glBindVertexArray(vao)

    glBindBuffer(
        GL_ARRAY_BUFFER,
        vbo
    )

    glBufferData(
        GL_ARRAY_BUFFER,
        vertices.nbytes,
        vertices,
        GL_DYNAMIC_DRAW
    )

    float_size = np.dtype(
        np.float32
    ).itemsize

    stride = 5 * float_size

    glVertexAttribPointer(
        0,
        2,
        GL_FLOAT,
        GL_FALSE,
        stride,
        ctypes.c_void_p(0)
    )

    glEnableVertexAttribArray(0)

    glVertexAttribPointer(
        1,
        3,
        GL_FLOAT,
        GL_FALSE,
        stride,
        ctypes.c_void_p(
            2 * float_size
        )
    )

    glEnableVertexAttribArray(1)

    glBindBuffer(
        GL_ARRAY_BUFFER,
        0
    )

    glBindVertexArray(0)

    return vao, vbo


def update_vbo(vbo, vertices):
    glBindBuffer(
        GL_ARRAY_BUFFER,
        vbo
    )

    glBufferData(
        GL_ARRAY_BUFFER,
        vertices.nbytes,
        vertices,
        GL_DYNAMIC_DRAW
    )

    glBindBuffer(
        GL_ARRAY_BUFFER,
        0
    )


def print_help():
    print()
    print("==============================================")
    print("Imagem como Matriz e Zoom")
    print("==============================================")
    print("1 -> imagem original")
    print("2 -> canais RGB")
    print("3 -> Zoom In quadrado")
    print("4 -> Zoom In linear")
    print("5 -> Zoom Out quadrado")
    print("6 -> Zoom Out por media")
    print("7 -> comparacao Zoom In (original | quadrado | linear)")
    print("8 -> comparacao Zoom Out (original | quadrado | media)")
    print("9 -> desafio: fronteira vermelho | azul (Zoom In)")
    print("F -> alterna factor 2 / 3")
    print("H -> ajuda")
    print("ESC -> sair")
    print()


def process_input(window):
    global mode, factor

    if glfw.get_key(
        window,
        glfw.KEY_ESCAPE
    ) == glfw.PRESS:
        glfw.set_window_should_close(
            window,
            True
        )

    keys = [
        glfw.KEY_1,
        glfw.KEY_2,
        glfw.KEY_3,
        glfw.KEY_4,
        glfw.KEY_5,
        glfw.KEY_6,
        glfw.KEY_7,
        glfw.KEY_8,
        glfw.KEY_9,
    ]

    for index, key in enumerate(keys, start=1):
        if glfw.get_key(window, key) == glfw.PRESS:
            mode = index

    f_down = glfw.get_key(window, glfw.KEY_F) == glfw.PRESS

    if f_down and not process_input.f_was_down:
        factor = 3 if factor == 2 else 2

    process_input.f_was_down = f_down

    if glfw.get_key(window, glfw.KEY_H) == glfw.PRESS:
        print_help()


process_input.f_was_down = False


def main():
    window = create_window()

    program = create_shader_program()

    original_image = create_demo_image()

    vertices = build_scene_vertices(
        original_image
    )

    vao, vbo = create_geometry(
        vertices
    )

    glViewport(
        0,
        0,
        WIDTH,
        HEIGHT
    )

    print_help()
    print_inspection(original_image)

    last_state = None

    while not glfw.window_should_close(
        window
    ):
        process_input(
            window
        )

        if (mode, factor) != last_state:
            last_state = (mode, factor)
            print_shapes(original_image)

        vertices = build_scene_vertices(
            original_image
        )

        update_vbo(
            vbo,
            vertices
        )

        glClearColor(
            0.08,
            0.08,
            0.10,
            1.0
        )

        glClear(
            GL_COLOR_BUFFER_BIT
        )

        glUseProgram(
            program
        )

        glBindVertexArray(
            vao
        )

        glDrawArrays(
            GL_TRIANGLES,
            0,
            len(vertices) // 5
        )

        glBindVertexArray(
            0
        )

        glfw.swap_buffers(
            window
        )

        glfw.poll_events()

    glDeleteVertexArrays(
        1,
        [vao]
    )

    glDeleteBuffers(
        1,
        [vbo]
    )

    glDeleteProgram(
        program
    )

    glfw.destroy_window(
        window
    )

    glfw.terminate()


if __name__ == "__main__":
    main()