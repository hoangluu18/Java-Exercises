package basic_knowledge;

public class bai14 {
    
    public static boolean isPrime(int m) {
        if (m <= 1) {
            return false; 
        }
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 29; 
        if (isPrime(m)) {
            System.out.println(m + " là số nguyên tố.");
        } else {
            System.out.println(m + " không phải là số nguyên tố.");
        }
    }
}
