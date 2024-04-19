package basic_knowledge;

import java.util.Scanner;

public class bai5 {
	private double a,b,c;
	
	public void input() {
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Nhập giá trị a,b,c: ");
			this.a = scanner.nextDouble();
			this.b = scanner.nextDouble();
			this.c = scanner.nextDouble();
			
		}catch (Exception e) {
			System.out.println("Nhập kiểu dữ liệu không hợp lệ");
			System.exit(0);
		}
	}
	
	public void findMiddleNumber() {
		if((a <= b && b <= c) || (c <= b && b <= a)) {
			System.out.println("Số trung gian là: " + b);
		}
		else if((a >= b && a <= c) || (a >= c && a <= b)) {
			System.out.println("Số trung gian là: " + a);
		}
		else {
			System.out.println("Số trung gian là: " + c);
		}
	}

	public static void main(String[] args) {
		bai5 middleNumber = new bai5();
		middleNumber.input();
		middleNumber.findMiddleNumber();

	}

}
