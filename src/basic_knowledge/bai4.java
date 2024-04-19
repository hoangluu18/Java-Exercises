package basic_knowledge;

import java.util.Scanner;

import javax.print.attribute.DateTimeSyntax;

public class bai4 {
	private double a,b,c,d,e,f;
	
	public void input() {
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println("ax + by = c\ndx + ey = f\nNhập giá trị a,b,c,d,e,f:\n");
			this.a = scanner.nextDouble();
			this.b = scanner.nextDouble();
			this.c = scanner.nextDouble();
			this.d = scanner.nextDouble();
			this.e = scanner.nextDouble();
			this.f = scanner.nextDouble();
		}catch (Exception e) {
			System.out.println("Nhập kiểu dữ liệu không hợp lệ");
			System.exit(0);
		}
		
		
	}
	
	public void SolveLinearEquation() {
		double Det = a * e - b * d;
		double DetX = c * e - f * b;
		double DetY = a * f - c * d;
		
		if(Det == 0) {
			if(DetX + DetY == 0) {
				System.out.println("hệ phương trình có vô số nghiệm");
			}
			else {
				System.out.println("hệ phương trình vô nghiệm");
			}
			
		}else {
			double x = DetX / Det;
			double y = DetY / Det;
			 System.out.println("Nghiệm của hệ phương trình:");
	         System.out.println("x = " + x);
	         System.out.println("y = " + y);
		}
	}

	public static void main(String[] args) {
		
		bai4 linearEquationBai4 = new bai4();
		linearEquationBai4.input();
		linearEquationBai4.SolveLinearEquation();
		
	}

}
