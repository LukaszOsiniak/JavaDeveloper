package pl.coderstrust.isthatfibonaccinumber;

import java.util.HashSet;

public class FibonacciChecker {

    boolean isFibonacciNumber(long number) {
        long numberA = 0;
        long numberB = 1;
        long sum = 0;
        HashSet<Long> fibonacciSequence = new HashSet<>();

        while (number > sum) {
            for (int i = 2; i <= number; i++) {
                sum = numberA + numberB;
                numberA = numberB;
                numberB = sum;
                fibonacciSequence.add(sum);
                if (fibonacciSequence.contains(number)) {
                    return true;
                }
            }
        }
        return false;
    }
}
