import java.util.Scanner;

public class BEE1160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int PA = sc.nextInt();
            int PB = sc.nextInt();
            double G1 = sc.nextDouble();
            double G2 = sc.nextDouble();

            int anos = 0;

            while(PA <= PB) {
                PA += (int) (PA * (G1/100));
                PB += (int) (PB * (G2/100));
                anos++;

                if(anos > 100) {
                    anos = -1;
                    break;
                }
            }
            if(anos == -1) {
                System.out.println("Main de 1 seculo.");
            }else{
                System.out.println(anos + "anos.");
            }
        }
    }
}
