package pl.coderstrust.isthatfibonaccinumber;

import java.util.HashSet;
import java.util.Set;

public class FibonacciChecker {

    private Set<Long> bankOfFibonacciNumbers = new HashSet<>();
    private static final int NB_OF_FIBONACCI_LONG_TYPE_RANGE = 93;

    public boolean isFibonacciNumber(long number) {
        return bankOfFibonacciNumbers.contains(number);
    }

    public FibonacciChecker() {
        bankOfFibonacciNumbers.add(0L);
        bankOfFibonacciNumbers.add(1L);
        long temp = 0;
        long previousValue = 1;
        long actualValue = 1;
        for (int i = 2; i < NB_OF_FIBONACCI_LONG_TYPE_RANGE; i++) {
            actualValue = temp + previousValue;
            bankOfFibonacciNumbers.add(actualValue);
            temp = previousValue;
            previousValue = actualValue;
        }
    }
}
