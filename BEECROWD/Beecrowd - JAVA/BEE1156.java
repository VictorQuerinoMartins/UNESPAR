public class BEE1156 {
    public static void main(String[] args) {
        double s = 1.0;
        double x = 2.0;

        for(int i = 3; i <= 39; i+= 2) {
            s = i / x;
            x *= 2;
        }
        System.out.printf("%.2f", s);
    }
}
