package pl.coderstrust.fibonnaci;

import java.util.Scanner;

public class FibonnacciIterative {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj numer n:");
        long fibonacciNumberInOrder = scan.nextLong();
        System.out.println(fibonacci(fibonacciNumberInOrder));
    }

    private static long fibonacci(long fibonacciNumberInOrder) {
        int a = 0, b = 1, next = 1;
        for (int i = 2; i <= fibonacciNumberInOrder; i++) {
            next = a + b;
            a = b;
            b = next;
        }
        return next;
    }
}
