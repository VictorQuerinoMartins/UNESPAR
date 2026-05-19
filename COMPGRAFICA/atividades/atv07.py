
from OpenGL.GL import *
import glfw

desenha = None

def atualizar_viewport(window):
    largura, altura = glfw.get_framebuffer_size(window)
    glViewport(0, 0, largura, altura)


def desenhar_desenho():
    if desenha is None:
        return
    
    glBegin(GL_LINES)
    glColor3f(1.0, 0.0, 0.0)
    
   
def click_mouse(window, button, action, mods):
    global desesnha
    if(button == glfw.MOUSE_BUTTON_LEFT and action == glfw.PRESS):
        
        x_mouse, y_mouse = glfw.get_cursor_pos(window)
        largura, altura = glfw.get_window_size(window)
        
        print(x_mouse, y_mouse)
        x,y = converterCoordenadas(x_mouse, y_mouse, largura, altura)
        desenhar = desenhar_desenho(x,y)
      
def converterCoordenadas(x_mouse, y_mouse, largura, altura):
    x = (x_mouse / largura) * 2 - 1
    y= 1 -(y_mouse / altura) * 2
    return (x, y)

def main():
    if not glfw.init():
        print("Erro ao inicializar o GLFW")
        return
    
    largura = 800
    altura = 600
    
    window = glfw.create_window(largura, altura, "Janela Careca", None, None)
    
    if not window:
        print("Erro ao criar janela")
        return
    
    glfw.make_context_current(window)       # inforamndo janela de renderização
    
    glfw.set_mouse_button_callback(window, click_mouse)
    
    glClearColor(0.1, 0.1, 0.1, 1.0)
    
    while not glfw.window_should_close(window):
        atualizar_viewport(window)
        
        glClear(GL_COLOR_BUFFER_BIT)
        
        desenhar_desenho()
        
        glfw.swap_buffers(window)
        glfw.poll_events()

    glfw.terminate()

if __name__ == "__main__":
    main()