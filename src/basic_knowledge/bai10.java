package basic_knowledge;

import java.util.Scanner;

public class bai10 {
    
    public static long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

   
    public static double calculateSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / factorial(2 * i - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3; 
        System.out.println("Tổng S là: " + calculateSum(n));
    }
}

 

