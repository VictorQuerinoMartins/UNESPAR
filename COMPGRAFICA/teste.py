import glfw
from OpenGL.GL import *  

# Lista de vértices do triângulo (x, y)
# Cada sublista representa a posição de um ponto na tela
vertices = [
    [-0.5, -0.5],  # Vértice inferior esquerdo
    [0.5, -0.5],   # Vértice inferior direito
    [0, 0.5]       # Vértice superior
]

# Lista de cores para cada vértice (R, G, B)
# Os valores vão de 0 a 1
cores = [
    [1, 0, 0],  # Vermelho
    [0, 1, 0],  # Verde
    [0, 0, 1]   # Azul
]

def init():  # Função para configurações iniciais da aplicação
    glClearColor(1, 1, 1, 1)
    # Define a cor de fundo da janela (R, G, B, Alpha)
    # Aqui está branco

def render():  # Função responsável por desenhar a cena a cada frame
    glClear(GL_COLOR_BUFFER_BIT)
    # Limpa a tela usando a cor definida em glClearColor

    glBegin(GL_TRIANGLES)
    # Informa ao OpenGL que começaremos a desenhar triângulos

    # Percorre cada vértice junto com sua cor correspondente
    for v, c in zip(vertices, cores):
        glColor3fv(c)
        # Define a cor atual usando o vetor RGB

        glVertex2fv(v)
        # Define a posição do vértice na tela

    glEnd()
    # Finaliza o desenho do triângulo

# Função principal do programa
def main():
    glfw.init()  
    # Inicializa a GLFW

    window = glfw.create_window(500, 500, '02 - Triângulo', None, None)
    # Cria a janela de 500x500 pixels com o título informado

    glfw.make_context_current(window)
    # Define o contexto OpenGL dessa janela como o atual

    init()
    # Chama a função de configurações iniciais

    # Loop principal da aplicação
    while not glfw.window_should_close(window):

        glfw.poll_events()
        # Processa eventos da janela (teclado, mouse, etc.)

        render()
        # Desenha a cena (o triângulo)

        glfw.swap_buffers(window)
        # Atualiza a tela exibindo o que foi desenhado

    glfw.terminate()
    # Encerra a GLFW e libera recursos

# Verifica se o arquivo está sendo executado diretamente
if __name__ == '__main__':
    main()