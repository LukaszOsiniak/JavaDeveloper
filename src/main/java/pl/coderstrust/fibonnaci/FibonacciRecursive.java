package pl.coderstrust.fibonnaci;

import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj numer n:");
        long fibonacciNumberInOrder = scan.nextInt();
        System.out.println(fibonacci(fibonacciNumberInOrder));
    }

    public static long fibonacci(long fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0){
            throw new IllegalArgumentException("Fibonacci number cannot be lower than zero");
        }
        if (fibonacciNumberInOrder <= 1) {
            return fibonacciNumberInOrder;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
    }
}
