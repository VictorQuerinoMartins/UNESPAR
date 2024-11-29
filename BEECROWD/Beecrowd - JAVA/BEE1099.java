import java.util.Scanner;

public class BEE1099 {
    public static void main(String agrs[]) {
        Scanner s = new Scanner(System.in);

        int N, X, Y, soma;

        N = s.nextInt();

        for(int i =0; i < N; i++){
            soma = 0;
            X = s.nextInt();
            Y = s.nextInt();

            if(X<Y){
                for (int j = X+1; j<Y; j++){
                    if(j%2!=0){
                        soma +=j;
                    }
                }
            }
            else{
                for (int j = Y+1; j<X; j++){
                    if(j%2!=0){
                        soma +=j;
                    }
                }
            } 
            System.out.println(soma);
            }
        }

}
