package pl.coderstrust.isthatfibonaccinumber;

public class FibonacciChecker {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            calculatingFibonacciNumbers(i);
            System.out.println(calculatingFibonacciNumbers(i));
        }

    }

    boolean isFibonacciNumber(long number) {
        return false;
    }

    public static long calculatingFibonacciNumbers(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci number cannot be lower than zero");
        }
        if (number <= 1) {
            return number;
        }
        int temp = 0;
        int previousValue = 1;
        int actualValue = 1;
        for (int j = 2; j <= number; j++) {
            actualValue = temp + previousValue;
            temp = previousValue;
            previousValue = actualValue;
        }
        return actualValue;
    }
}
