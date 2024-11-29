import java.util.Scanner;

public class BEE1116 {
    public static void main(String agrs[]) {
        Scanner s = new Scanner(System.in);
    int N = s.nextInt();

    for(int i =0; i<N; i++){
        int x = s.nextInt();
        int y = s.nextInt();
            if(y==0){
                System.out.println("divisao impossivel");
            }else{
                System.out.println((double)x/y);
            }
            }
        }
    }
