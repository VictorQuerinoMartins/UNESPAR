# Atividade 12 — Manual de Instrução

Aplicação OpenGL que desenha um quadrado e aplica transformações 2D
(translação, rotação e escala) controladas pelo teclado, usando uma
matriz `mat3` enviada como uniform para o vertex shader.

## Requisitos

- Python 3
- Dependências: `glfw`, `numpy`, `PyOpenGL`

```bash
pip install glfw numpy PyOpenGL
```

## Como executar

```bash
cd atividades
python atv12.py
```

## Controles

| Tecla         | Ação                          |
|---------------|-------------------------------|
| ↑ / ↓ / ← / → | Translada o quadrado          |
| R             | Rotaciona no sentido anti-horário |
| Shift + R     | Rotaciona no sentido horário  |
| E             | Diminui a escala               |
| Shift + E     | Aumenta a escala                |
| Esc           | Fecha a janela                 |

A escala é limitada entre 0.2x e 3.0x (`EstadoTransformacao.SCALE_MIN` /
`SCALE_MAX` em [atv12.py](atv12.py)).

## Como funciona

1. `EstadoTransformacao` guarda `tx`, `ty` (translação), `angulo`
   (rotação em graus) e `escala` atuais.
2. A cada quadro, `matriz_final()` monta a matriz de transformação
   compondo escala → rotação → translação: `T @ R @ S`
   (aplicadas da direita para a esquerda, ou seja, a escala é aplicada
   primeiro no espaço local do objeto).
3. A matriz 3×3 resultante é enviada ao shader pelo uniform
   `uTransform` e aplicada a cada vértice: `gl_Position = uTransform * vec3(aPos, 1.0)`.
