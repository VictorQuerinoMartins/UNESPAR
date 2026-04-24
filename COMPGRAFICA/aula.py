import glfw
from OpenGL.GL import *

def desenhar_casa():
    glColor3f(0.85, 0.55, 0.35)
    glBegin(GL_QUADS)
    glVertex2f(-0.6, -0.45)
    glVertex2f(0.6, -0.45)
    glVertex2f(0.6, 0.45)
    glVertex2f(-0.6, 0.45)
    glEnd()

def desenhar_chao():
    glColor3f(0.25, 0.60, 0.25)
    glBegin(GL_QUADS)
    glVertex2f(-1.0, -1.0)
    glVertex2f(1.0, -1.0)
    glVertex2f(1.0, -0.45)
    glVertex2f(-1.0, -0.45)
    glEnd()

def display():
    glClearColor(0.53, 0.81, 0.98, 1.0)
    glClear(GL_COLOR_BUFFER_BIT)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()
    desenhar_chao()
    
def main():
   
    if not glfw.init():
        raise RuntimeError("Erro ao inicialiar OpenGL")

    window = glfw.create_window(900, 700, "Casa", None, None)
    if not window:
        glfw.terminate()
        raise RuntimeError("Não foi possivel criar uma janela")

    glfw.make_context_current(window)

    while not glfw.window_should_close(window):
        glfw.poll_events()
        display()
        glfw.swap_buffers(window)
        
    glfw.destroy_window(window)
    glfw.terminate()

main()
