package basic_knowledge;

import java.util.Scanner;

public class bai7 {
	private int month, year;
	
	public void input() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Nhập tháng và năm: ");
			this.month = scanner.nextInt();
			this.year = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Nhập kiểu dữ liệu không hợp lệ");
			System.exit(0);
		}
	}
	
	public boolean isLeapYear() {
		return (this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0);
	}
	
	public void getDaysInMonth() {
		switch (this.month) {
		   case 1:
		   case 3:
		   case 5:
		   case 7:
		   case 8:
		   case 10:
		   case 12:
			   System.out.println("Số ngày trong tháng là: " + 31);
			   break;
		   case 4:
		   case 6:
		   case 9:
		   case 11:
			   System.out.println("Số ngày trong tháng là: " + 30);
			   break;
		   case 2:
			   if(isLeapYear()) {
				   System.out.println("Số ngày trong tháng là: " + 29);
			   } else {
				   System.out.println("Số ngày trong tháng là: " + 28);
			   }
			   break;
		   default:
			   System.out.println("Tháng không hợp lệ.");
			   break;
		}
	}

	public static void main(String[] args) {
		bai7 calendar = new bai7(); 
		calendar.input(); 
		calendar.getDaysInMonth();
	}
}
