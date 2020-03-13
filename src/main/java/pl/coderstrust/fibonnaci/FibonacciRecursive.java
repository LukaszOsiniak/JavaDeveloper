package pl.coderstrust.fibonnaci;

import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj numer n:");
        long fibonacciNumberInOrder = scan.nextInt();
        System.out.println(fibonacci(fibonacciNumberInOrder));
    }

    private static long fibonacci(long fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 1 || fibonacciNumberInOrder == 2) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
    }
}
