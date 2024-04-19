package basic_knowledge;

import java.util.Scanner;

public class bai8 {
    public static double calculateSum() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Nhập giá trị n: ");
        int n = scanner.nextInt();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        scanner.close();
        return sum;
    }

    public static void main(String[] args) {
    
        double result = calculateSum();
        System.out.println("Tổng chuỗi S là: " + result);

     
    }
}
