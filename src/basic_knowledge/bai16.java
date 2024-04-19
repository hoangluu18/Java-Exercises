package basic_knowledge;

public class bai16{
   
    public static boolean isPalindrome(int M) {
        int originalNumber = M;
        int reversedNumber = 0;
        while (M != 0) {
            int digit = M % 10; 
            reversedNumber = reversedNumber * 10 + digit; 
            M /= 10; 
        }
        return originalNumber == reversedNumber; 
    }

    public static void main(String[] args) {
        int M = 12321; 
        if (isPalindrome(M)) {
            System.out.println(M + " là số đối xứng.");
        } else {
            System.out.println(M + " không phải là số đối xứng.");
        }
    }
}

