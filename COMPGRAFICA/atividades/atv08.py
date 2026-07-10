import glfw
from OpenGL.GL import *

# =========================
# VARIÁVEIS GLOBAIS
# =========================
modo_atual = "TRIANGULO"
cor = [1.0, 1.0, 1.0]
historico_formas = []
PASSO = 0.05

# =========================
# FUNÇÕES DE CRIAÇÃO E DESENHO
# =========================

def criarPonto(x, y): return [(x, y)]

def criarTriangulo(x, y):
    l, a = 0.15, 0.2
    return [(x, y + a), (x - l, y - a), (x + l, y - a)]

def criarLinha(x, y):
    return [(x - 0.1, y - 0.1), (x + 0.1, y + 0.1)]

def criarQuadrado(x, y):
    l = 0.15
    return [(x-l, y+l), (x+l, y+l), (x+l, y-l), (x-l, y-l)]

def desenharTodasAsFormas():
    global historico_formas
    for forma in historico_formas:
        vertices = forma["vertices"]
        tipo = forma["tipo"]
        glColor3fv(forma["cor"])

        if tipo == "PONTO":
            glPointSize(10.0)
            glBegin(GL_POINTS)
            for v in vertices: glVertex2fv(v)
            glEnd()
        elif tipo == "LINHA":
            glBegin(GL_LINES)
            for v in vertices: glVertex2fv(v)
            glEnd()
        elif tipo == "TRIANGULO":
            glBegin(GL_TRIANGLES)
            for v in vertices: glVertex2fv(v)
            glEnd()
        elif tipo == "QUADRADO":
            glBegin(GL_TRIANGLE_FAN) # GL_QUADS é depreciado
            for v in vertices: glVertex2fv(v)
            glEnd()

# =========================
# MOVIMENTO E COR
# =========================

def moverUltimaForma(dx, dy):
    if historico_formas:
        for i in range(len(historico_formas[-1]["vertices"])):
            v = historico_formas[-1]["vertices"][i]
            historico_formas[-1]["vertices"][i] = (v[0] + dx, v[1] + dy)

def alterarCorUltimaForma():
    if historico_formas:
        historico_formas[-1]["cor"] = list(cor)

# =========================
# CALLBACKS (TECLADO E MOUSE)
# =========================

def key_callback(window, key, scancode, action, mods):
    global modo_atual, cor, historico_formas
    if action == glfw.PRESS:
        # Formas
        mapa_formas = {glfw.KEY_T: "TRIANGULO", glfw.KEY_Q: "QUADRADO", 
                       glfw.KEY_L: "LINHA", glfw.KEY_P: "PONTO"}
        if key in mapa_formas: modo_atual = mapa_formas[key]
        
        # Cores
        mapa_cores = {glfw.KEY_R: [1,0,0], glfw.KEY_G: [0,1,0], glfw.KEY_B: [0,0,1],
                      glfw.KEY_Y: [1,1,0], glfw.KEY_M: [1,0,1], glfw.KEY_W: [1,1,1]}
        if key in mapa_cores: cor = mapa_cores[key]
        
        # Ações
        if key == glfw.KEY_C: historico_formas.clear()
        if key == glfw.KEY_ENTER: alterarCorUltimaForma()
        if key == glfw.KEY_LEFT: moverUltimaForma(-PASSO, 0)
        if key == glfw.KEY_RIGHT: moverUltimaForma(PASSO, 0)
        if key == glfw.KEY_UP: moverUltimaForma(0, PASSO)
        if key == glfw.KEY_DOWN: moverUltimaForma(0, -PASSO)

def cliqueMouse(window, button, action, mods):
    global historico_formas
    if button == glfw.MOUSE_BUTTON_LEFT and action == glfw.PRESS:
        xm, ym = glfw.get_cursor_pos(window)
        w, h = glfw.get_window_size(window)
        x, y = (xm / w) * 2 - 1, 1 - (ym / h) * 2
        
        funcoes = {"TRIANGULO": criarTriangulo, "QUADRADO": criarQuadrado, 
                   "LINHA": criarLinha, "PONTO": criarPonto}
        
        historico_formas.append({"tipo": modo_atual, "vertices": funcoes[modo_atual](x, y), "cor": list(cor)})
    
    elif button == glfw.MOUSE_BUTTON_RIGHT and action == glfw.PRESS:
        historico_formas.clear()

# =========================
# MAIN
# =========================

def main():
    if not glfw.init(): return
    window = glfw.create_window(800, 600, "Editor Gráfico", None, None)
    glfw.make_context_current(window)
    glfw.set_mouse_button_callback(window, cliqueMouse)
    glfw.set_key_callback(window, key_callback)
    
    while not glfw.window_should_close(window):
        glClear(GL_COLOR_BUFFER_BIT)
        desenharTodasAsFormas()
        glfw.swap_buffers(window)
        glfw.poll_events()
    glfw.terminate()

if __name__ == "__main__": main()