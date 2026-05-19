from OpenGL.GL import *
import glfw

posicao = None


def desenhar_foguete(cx, cy):
    glColor3f(0.2, 0.8, 1.0)
    glBegin(GL_LINE_LOOP)
    glVertex2f(cx,        cy + 0.35)
    glVertex2f(cx + 0.10, cy + 0.10)
    glVertex2f(cx + 0.10, cy - 0.20)
    glVertex2f(cx + 0.05, cy - 0.25)
    glVertex2f(cx - 0.05, cy - 0.25)
    glVertex2f(cx - 0.10, cy - 0.20)
    glVertex2f(cx - 0.10, cy + 0.10)
    glEnd()

    glColor3f(1.0, 1.0, 0.2)
    glBegin(GL_LINE_LOOP)
    glVertex2f(cx,        cy + 0.28)
    glVertex2f(cx + 0.06, cy + 0.18)
    glVertex2f(cx,        cy + 0.08)
    glVertex2f(cx - 0.06, cy + 0.18)
    glEnd()

    glColor3f(1.0, 0.5, 0.0)
    glBegin(GL_LINES)
    glVertex2f(cx - 0.10, cy - 0.05)
    glVertex2f(cx - 0.26, cy - 0.25)
    glVertex2f(cx - 0.26, cy - 0.25)
    glVertex2f(cx - 0.10, cy - 0.20)
    glVertex2f(cx + 0.10, cy - 0.05)
    glVertex2f(cx + 0.26, cy - 0.25)
    glVertex2f(cx + 0.26, cy - 0.25)
    glVertex2f(cx + 0.10, cy - 0.20)
    glEnd()

    glColor3f(1.0, 0.3, 0.0)
    glBegin(GL_LINE_STRIP)
    glVertex2f(cx - 0.04, cy - 0.25)
    glVertex2f(cx + 0.04, cy - 0.33)
    glVertex2f(cx - 0.04, cy - 0.41)
    glVertex2f(cx + 0.04, cy - 0.49)
    glVertex2f(cx,        cy - 0.57)
    glEnd()


def click_mouse(window, button, action, mods):
    global posicao
    if button == glfw.MOUSE_BUTTON_LEFT and action == glfw.PRESS:
        x, y = glfw.get_cursor_pos(window)
        w, h = glfw.get_window_size(window)
        posicao = ((x / w) * 2 - 1, 1 - (y / h) * 2)


def main():
    if not glfw.init():
        return

    window = glfw.create_window(800, 600, "Foguete", None, None)
    if not window:
        glfw.terminate()
        return

    glfw.make_context_current(window)
    glfw.set_mouse_button_callback(window, click_mouse)
    glClearColor(0.05, 0.05, 0.15, 1.0)
    glLineWidth(2.0)

    while not glfw.window_should_close(window):
        w, h = glfw.get_framebuffer_size(window)
        glViewport(0, 0, w, h)
        glClear(GL_COLOR_BUFFER_BIT)

        if posicao:
            desenhar_foguete(*posicao)

        glfw.swap_buffers(window)
        glfw.poll_events()

    glfw.terminate()


if __name__ == "__main__":
    main()
