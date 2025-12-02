import matplotlib.pyplot as plt
import numpy as np

# Configuração para estilo acadêmico
plt.style.use('default')
plt.rcParams['font.family'] = 'serif'
plt.rcParams['font.size'] = 12

# ==========================================
# GRÁFICO 1: COMPARAÇÃO DE COMPLEXIDADES
# ==========================================
def plot_comparacao():
    # Dados de n (1 a 15 para visualizar bem a curvatura)
    n = np.linspace(1, 15, 100)

    # Funções
    y_log = np.log2(n)
    y_lin = n
    y_nlog = n * np.log2(n)
    y_quad = n**2
    y_exp = 2**n

    plt.figure(figsize=(8, 6))
    
    # Plotando as linhas
    plt.plot(n, y_log, label=r'$O(\log n)$ - Logarítmica', linewidth=2)
    plt.plot(n, y_lin, label=r'$O(n)$ - Linear', linewidth=2)
    plt.plot(n, y_nlog, label=r'$O(n \log n)$ - Linearítmico', linewidth=2, linestyle='--')
    plt.plot(n, y_quad, label=r'$O(n^2)$ - Quadrática', linewidth=2)
    plt.plot(n, y_exp, label=r'$O(2^n)$ - Exponencial', linewidth=2)

    # Ajustes de Limites para o gráfico não ficar distorcido pela exponencial
    plt.ylim(0, 100)
    plt.xlim(1, 15)

    # Decoração
    plt.xlabel('Tamanho da Entrada (n)')
    plt.ylabel('Operações (T)')
    plt.title('Comparação de Crescimento Assintótico')
    plt.grid(True, linestyle=':', alpha=0.6)
    plt.legend()
    
    # Salvar
    plt.savefig('grafico_comparacao.pdf', format='pdf', bbox_inches='tight')
    plt.savefig('grafico_comparacao.png', format='png', dpi=300, bbox_inches='tight')
    plt.show()
    print("Gráfico 1 gerado: grafico_comparacao.pdf")

# ==========================================
# GRÁFICO 2: DEFINIÇÃO FORMAL (Big O)
# ==========================================
def plot_formal():
    # Vamos provar visualmente que 3n + 10 é O(n) usando c=4
    n = np.linspace(0, 20, 100)
    
    f_n = 3 * n + 10      # Função real (custo do algoritmo)
    g_n = 4 * n           # c * g(n) -> Limite superior
    
    plt.figure(figsize=(8, 6))
    
    plt.plot(n, f_n, 'b-', label=r'$f(n) = 3n + 10$', linewidth=2)
    plt.plot(n, g_n, 'r--', label=r'$c \cdot g(n) = 4n$', linewidth=2)
    
    # Ponto de interseção (n0 = 10)
    n0 = 10
    y0 = 3 * 10 + 10 # 40
    
    # Marcando o ponto n0
    plt.scatter([n0], [y0], color='black', zorder=5)
    plt.annotate(r'$n_0$', xy=(n0, 0), xytext=(n0, -5), 
                 arrowprops=dict(facecolor='black', arrowstyle='-'), ha='center')

    # Linha tracejada vertical (Segmento)
    plt.vlines(x=n0, ymin=0, ymax=y0, colors='k', linestyles='dashed')

    # Região onde a condição vale
    plt.text(12, 30, 'Para $n \geq n_0$:\n$f(n) \leq c \cdot g(n)$', fontsize=12, bbox=dict(facecolor='white', alpha=0.8))

    plt.ylim(0, 80)
    plt.xlim(0, 20)
    plt.xlabel('n')
    plt.ylabel('Custo')
    plt.title(r'Definição Formal de $O(g(n))$')
    plt.legend()
    plt.grid(True, linestyle=':', alpha=0.3)
    
    # Salvar
    plt.savefig('grafico_formal.pdf', format='pdf', bbox_inches='tight')
    plt.savefig('grafico_formal.png', format='png', dpi=300, bbox_inches='tight')
    plt.show()
    print("Gráfico 2 gerado: grafico_formal.pdf")

# Rodar as funções
plot_comparacao()
plot_formal()