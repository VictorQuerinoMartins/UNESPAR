package Revisão.exemplos;


public class OperadoresAritmeticos {
    public static void main(String[] args) {
        int x = 10;
        int y = 3;

        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("-X = " + (-x));
        System.out.println("X/Y = " + (x / y));
        System.out.println("Resto de X por Y = " + (x%y));                  //Resulta 1
        System.out.println("Inteiro de X por Y = " + (int) (x / y));        //Resulta 3
        System.out.println("X + 1 = " + (++x));                             //Resulta 11
        

    }
}
