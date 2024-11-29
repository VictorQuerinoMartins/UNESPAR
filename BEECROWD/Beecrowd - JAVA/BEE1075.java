import java.util.Scanner;

public class BEE1075 {
    public static void main (String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for(int i=0; i < 10000; i++){
            if(i % N == 2){
                System.out.println(i);
            }
        }
    }
}
