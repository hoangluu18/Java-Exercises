package basic_knowledge;

public class bai1 {
	
	public static int findMaxUsingIf(int a,int b,int c) {
		int max = a;
		if(b > max) {
			max = b;
		}
		if(c > max) {
			max = c;
		}
		return max;
	}
	
	public static int findMaxUsingIfElse(int a,int b,int c) {
		if(a >= b && a >= c) {
			return a;
		}
		else if(b >= a && b >= c) {
			return b;
		}
		else {
			return c; 
		}
	}
	
	public static int findMaxUsingTernaryOperator(int a,int b,int c) {
		int max = (a >= b)? ((a >= c)? a : c ) : ((b >= c)? b : c);
		return max;
	}

	public static void main(String[] args) {
		int a = 10, b = 5, c = 98;
		int result1 = findMaxUsingIf(a, b, c);
		int result2 = findMaxUsingIfElse(a, b, c);
		int result3 = findMaxUsingTernaryOperator(a, b, c);
		 System.out.println("Giá trị lớn nhất khi sử dụng if: " + result1);
		 System.out.println("Giá trị lớn nhất khi sử dụng if else: " + result2);
		 System.out.println("Giá trị lớn nhất khi sử dụng toán tử ba ngôi: " + result3);
	}

}
