package Revisão.Treino.Car;

public class Carro {

    //Atributos
    String nome;
    String marca;
    int ano;
    int velocidade;

    //Métodos

    void acelerar(int aceleracao){
        velocidade += aceleracao;
    }

    void frear(int reduzir){
        velocidade -= reduzir;
    }

    void buzinar(){
        System.out.println("bibibbibibbib");
    }
}
