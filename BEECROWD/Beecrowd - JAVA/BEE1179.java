import java.util.Scanner;

public class BEE1179 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] par = new int[5];
        int[] impar = new int[5];
        int parIndex = 0;
        int imparIndex = 0;

        for(int i = 0; i < 15; i++) {
            int num = scanner.nextInt();
            if(num % 2 == 0) {
                if(parIndex == 5) {

                    for(int j = 0; j < par.length; j++) {
                        System.out.printf("par[%d] = %d%n", j, par[j]);
                    }
                    parIndex = 0;
                }
                par[parIndex] = num;
                parIndex++;
            }else{
                if(imparIndex == 5) {
                    for (int j = 0; j < impar.length; j++) {
                        System.out.printf("impar[%d] = %d%n", j, impar[j]);
                    }
                    imparIndex = 0;
                }
                impar[imparIndex] = num;
                imparIndex++;
            }
        }
        for(int j = 0; j < imparIndex; j++) {
            System.out.printf("impar[%d] = %d%n", j, impar[j]);
        }
        for(int j = 0; j < parIndex; j++) {
            System.out.printf("par[%d] = %d%n", j, par[j]);
        }
    }
}