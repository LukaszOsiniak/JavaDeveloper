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
            throw IllegalArgumentException
        }
        if (fibonacciNumberInOrder <= 1) {
        }
        return fibonacciNumberInOrder;
    }
}
