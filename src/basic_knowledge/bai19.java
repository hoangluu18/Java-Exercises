package basic_knowledge;

public class bai19 {
	
	public void FibonacciSeries(int n) {
		int firstTerm = 0;
        int secondTerm = 1;
        System.out.println("n số Fibonacci đầu tiên là:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(secondTerm + " ");

            
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
	}
    public static void main(String[] args) {
        int n = 1; 
        bai19 fibonacci = new bai19();
        fibonacci.FibonacciSeries(n);
        
    }
}
