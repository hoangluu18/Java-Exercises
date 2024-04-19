package basic_knowledge;

public class bai15 {
    
    public static boolean isSquareNumber(int P) {
        int sqrtP = (int) Math.sqrt(P);
        return sqrtP * sqrtP == P;
    }

    public static void main(String[] args) {
        int P = 16; 
        if (isSquareNumber(P)) {
            System.out.println(P + " là số chính phương.");
        } else {
            System.out.println(P + " không phải là số chính phương.");
        }
    }
}

