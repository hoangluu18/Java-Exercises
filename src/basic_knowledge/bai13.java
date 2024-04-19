package basic_knowledge;

public class bai13 {
   
    public static int findUCLN(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

   
    public static int findBCNN(int a, int b) {
        return (a * b) / findUCLN(a, b);
    }

    public static void main(String[] args) {
        int a = 60; 
        int b = 48; 
        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + findUCLN(a, b));
        System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + findBCNN(a, b));
    }
}

