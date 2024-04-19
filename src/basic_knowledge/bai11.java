package basic_knowledge;

public class bai11 {
    
    public static long doubleFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * doubleFactorial(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
     
        System.out.println(n + "!! = " + doubleFactorial(n));
        
        int m = 6;
        
        System.out.println(m + "!! = " + doubleFactorial(m));
    }
}


