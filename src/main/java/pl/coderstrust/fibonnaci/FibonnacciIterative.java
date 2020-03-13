package pl.coderstrust.fibonnaci;

import java.util.Scanner;

public class FibonnacciIterative {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj numer n:");
        long fibonacciNumberInOrder = scan.nextLong();
        System.out.println(fibonacci(fibonacciNumberInOrder));
    }

    public static long fibonacci(long fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder < 0) {
            throw new IllegalArgumentException("Fibonacci number cannot be lower than zero");
        }
        if (fibonacciNumberInOrder <= 1) {
            return fibonacciNumberInOrder;
        }
        int temp = 0;
        int previousValue = 1;
        int actualValue = 1;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            actualValue = temp + previousValue;
            temp = previousValue;
            previousValue = actualValue;
        }
        return actualValue;
    }
}
