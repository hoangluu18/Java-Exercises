package basic_knowledge;

import java.util.Scanner;

public class bai3 {
	private double a,b,c;
	
	public void Input() {
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.print("nhập 3 số a,b,c: ");
			this.a = scanner.nextDouble();
			this.b = scanner.nextDouble();
			this.c = scanner.nextDouble();
		}catch (Exception e) {
			System.out.println("nhập sai kiểu dữ liệu không thể tính toán");
			System.exit(0);
		}
		
	}
	
	public void solveQuadraticEquation() {
		if(a == 0) {
			if(b == 0) {
				if(c == 0) {
					System.out.println("phương trình vô số nghiệm");
				}
				else {
					System.out.println("phương trình vô ngiệm");
				}
			}
			else {
				double result = -c / b;
				System.out.println("phương trình có 1 nghiệm: "+ result);
			}
		}
		else {
			double delta = b * b - 4 * a * c;
			if(delta < 0) {
				System.out.println("phương trình này vô nghiệm");
			}
			else if(delta == 0) {
				double x = -b / (2 * a);
				System.out.println("phương trình này có một nghiệm kép x1 = x2 = "+ x);
			}
			else {
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("phương trình có 2 nghiệm x1 = "+ x1 + "và x2 = "+x2);
			}
			
		}
	}

	public static void main(String[] args) {
		// ax2 + bx + c = 0
		bai3 quadraticEquationBai3 = new bai3();
		quadraticEquationBai3.Input();
		quadraticEquationBai3.solveQuadraticEquation();
	}

}
