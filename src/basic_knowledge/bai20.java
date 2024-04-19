package basic_knowledge;

import java.util.Scanner;

public class bai20 {
    public static void main(String[] args) {
        
        int K;
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        
        int position = checkFibonacci(K);
        if (position != -1) {
            System.out.println("Số " + K + " là phần tử thứ " + position + " của dãy Fibonacci.");
        } else {
            System.out.println("Số " + K + " không thuộc dãy Fibonacci.");
        }
        scanner.close();
    }

    public static int checkFibonacci(int k) {
        int a = 1;
        int b = 1;
        int c = 0;
        int position = 1;

        while (a < k) {
            c = a + b;
            a = b;
            b = c;
            position++;
        }

        if (a == k) {
            return position;
        } else {
            return -1; 
        }
    }
}
