#ifndef RETAN_H_INCLUD
#define RETAN_H_INCLUD

typedef struct{
    float comprimento;
    float largura;
}Retangulo;

Retangulo criarRetangulo (float comprimento, float largura);
float calcularArea(Retangulo ret);

#endif /*RETAN_H*/
