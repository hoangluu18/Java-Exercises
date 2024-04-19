package basic_knowledge;

import java.util.Scanner;

public class bai2 {
	
	private double a, b;
	
	public void input() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("nhập giá trị a và b: ");
			this.a = scanner.nextDouble();
			this.b = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("Đã xảy ra lỗi khi nhập dữ liệu. Vui lòng nhập số.");
			System.exit(0);
		}
	}
	
	public void solveEquation() {
		if(a == 0) {
			if(b == 0) {
				System.out.println("phương trình có vô số nghiệm.");
			}
			else {
				System.out.println("phương trình vô nghiệm.");
			}
		}
		else {
			double result = -b / a;
			System.out.println("phương trình có nghiệm x = " + result);
		}
	}
	
	public static void main(String[] args) {
		bai2 equation = new bai2();
		equation.input();
		equation.solveEquation();
	}
}
