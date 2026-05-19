from OpenGL.GL import *
import glfw

triangulo = None

def atualizar_viewport(window):
    largura, altura = glfw.get_framebuffer_size(window)
    glViewport(0, 0, largura, altura)

def criar_triangulo(x,y):
    largura = 0.25
    altura = 0.3
    
    return[(x,y), (x - largura, y - altura),(x + largura, y - altura)]

def desenhar_triangulo():
    if triangulo is None:
        return
    
    glBegin(GL_TRIANGLES)
    
    glColor3f(0.24, 0.62, 0.17)
    glVertex2f(triangulo[0][0], triangulo[0][1])
    
    glColor3f(0., 0.2, 0.0)
    glVertex2f(triangulo[1][0], triangulo[1][1])
    
    glColor3f(0.0, 0.0, 0.17)
    glVertex2f(triangulo[2][0], triangulo[2][1])
    glEnd()

def click_mouse(window, button, action, mods):
    global triangulo
    if(button == glfw.MOUSE_BUTTON_LEFT and action == glfw.PRESS):
        
        x_mouse, y_mouse = glfw.get_cursor_pos(window)
        largura, altura = glfw.get_window_size(window)
        
        print(x_mouse, y_mouse)
        x,y = converterCoordenadas(x_mouse, y_mouse, largura, altura)
        triangulo = criar_triangulo(x,y)
      
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
        
        desenhar_triangulo()
        
        glfw.swap_buffers(window)
        glfw.poll_events()

    glfw.terminate()

if __name__ == "__main__":
    main()