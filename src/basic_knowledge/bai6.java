package basic_knowledge;

import java.util.Scanner;

public class bai6 {
private int a,b;
	
	public void input() {
		try(Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Nhập giá trị a,b ");
			this.a = scanner.nextInt();
			this.b = scanner.nextInt();
			
			
		}catch (Exception e) {
			System.out.println("Nhập kiểu dữ liệu không hợp lệ");
			System.exit(0);
		}
	}
	
	public void PaymentCaculator(){
		int totalPrice = 0;
		if(this.b  < 18 ) {
			totalPrice = (this.b - this.a + 1) * 45000;
		}
		else {
			totalPrice = (this.b - this.a + 1) * 60000;
		}
		System.out.println("tổng số tiền phải trả là: "+ totalPrice);
	}

	public static void main(String[] args) {
		bai6 payment = new bai6();
		payment.input();
		payment.PaymentCaculator();
	}

}
