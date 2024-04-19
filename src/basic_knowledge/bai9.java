package basic_knowledge;

import java.util.Scanner;

public class bai9{
    public static double calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void calculateSum() {
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Nhập giá trị n: ");
        int n = scanner.nextInt();
        
        double sum = 15.0;
        for (int i = 1; i <= n; i++) {
            double term = Math.pow(-1, i) * (1.0 / calculateFactorial(i));
            sum += term;
        }
        
       
        System.out.println("Tổng chuỗi S =  " + sum);

        scanner.close();
        
    }

    public static void main(String[] args) {
      calculateSum();
    
    }
}
