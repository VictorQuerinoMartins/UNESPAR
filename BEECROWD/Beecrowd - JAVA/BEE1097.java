public class BEE1097 {
    public static void main(String agr[]) {
        int i = 1, j = 7;

        while (i <= 9) {
            System.out.printf("I=%d J=%d\n", i, j);
            System.out.printf("I=%d J=%d\n", i, j - 1);
            System.out.printf("I=%d J=%d\n", i, j - 2);

            i += 2;
            j += 2;
        }
    }
}
