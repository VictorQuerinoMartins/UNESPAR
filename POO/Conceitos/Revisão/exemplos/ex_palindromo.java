package Revisão.exemplos;

public class ex_palindromo {
    public static void main(String args[]) {
        int maior = 0;
        for(int i=1; i<1000; i++) {
            for(int j=1; j<1000; j++) {
                // System.out.printf("%d x %d = %d\n", i, j, i*j);
                String str = Integer.toString(i*j);
                boolean flag = true;
                for(int k=0; k<str.length()/2; k++) {
                    if(str.charAt(k) != str.charAt(str.length()-1-k)) {
                        flag = false;
                    }
                }
                if(flag == true) {
                    if(i*j > maior) {
                        maior = i*j;
                    }
                    System.out.printf("%d x %d = %d\n", i, j, i*j);
                }
            }
        }
        System.out.println(maior);
    }

}