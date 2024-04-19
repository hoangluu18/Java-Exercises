package basic_knowledge;

import java.util.Scanner;

public class bai12 {
	
	public void SumAndProductOfDigits() {
			int m;
			Scanner scanner = new Scanner(System.in);
			m = scanner.nextInt();
			
	        int sum = 0;
	        int product = 1;
	        while (m > 0) {
	            int digit = m % 10;
	            sum += digit; 
	            product *= digit; 
	            m /= 10;
	        }
	        System.out.println("Tổng các chữ số của là: " + sum);
	        System.out.println("Tích các chữ số của là: " + product);
	        scanner.close();
	}
    public static void main(String[] args) {
       bai12 test = new bai12();
       test.SumAndProductOfDigits();
    }
}
