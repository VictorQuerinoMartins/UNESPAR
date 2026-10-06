# Manipulador e Visualizador de um Objeto 3D

Aplicação em Python + OpenGL moderno (shaders, VAO/VBO/EBO) que manipula um cubo colorido e permite comparar transformações, pivôs, órbita, projeções e posição do observador. Um minimapa 2D (vista de cima) no canto inferior esquerdo acompanha o objeto.

**Integrantes:** Victor Querino Martins

## Execução

```
pip install glfw PyOpenGL numpy
python main.py
```

As informações de estado (projeção, FOV, pivô, órbita, ordem, observador X, Z do objeto) aparecem na barra de título da janela.

## Controles

| Tecla             | Ação                                                              |
| ----------------- | ----------------------------------------------------------------- |
| `←` `→` / `↑` `↓` | Translação em X / Y                                               |
| `W` / `S`         | Translação em Z (aproxima / afasta)                               |
| `I` `K`           | Rotação em X                                                      |
| `J` `L`           | Rotação em Y                                                      |
| `U` `N`           | Rotação em Z                                                      |
| `+` / `-`         | Escala uniforme                                                   |
| `1`               | Projeção paralela                                                 |
| `2`               | Projeção em perspectiva                                           |
| `Q` / `E`         | Diminui / aumenta o FOV (20° a 120°)                              |
| `A` / `D`         | Move o observador em X (centro de projeção)                       |
| `O`               | Alterna a ordem de composição: `T × R × S` ↔ `R × T × S`          |
| `P`               | Alterna rotação em torno da origem ↔ pivô externo `C = (1, 0, 0)` |
| `T`               | Liga/desliga a órbita em torno de `C` (`T(C) · Ry(θ) · T(-C)`)    |
| `C`               | Modo de comparação: x=0, y=0, z=-2, rotação Y=30°                 |
| `R`               | Reseta tudo                                                       |

## Como funciona

- **Model:** `T · Rz · Ry · Rx · S` (ou `R · T · S`). Com pivô externo, `R` vira `T(C) · R · T(-C)`. Na órbita, `T(C) · Ry(θ) · T(-C)` é aplicada por último.
- **View:** `translation(-centro_de_projeção)`, observador inicial em `(0, 0, 3)`.
- **Projeção:** paralela e perspectiva usam a mesma "janela" no plano do observador (distância 3), então a única diferença visível é a profundidade. Shader: `uProjection * uView * uModel * vec4(aPos, 1.0)`.
- **Minimapa:** `x` do mundo → x do mapa, `z` do mundo → y do mapa. Quadrado = objeto, seta amarela = orientação (rotação em Y), cruz cinza = origem, cruz vermelha = pivô. Usa `M2D = T · R · S` com matrizes 3x3.
- **Teste de profundidade:** com `W`/`S`, na perspectiva o cubo encolhe ao se afastar; na paralela, não.
