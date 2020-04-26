package pl.coderstrust.isthatfibonaccinumber;

import java.util.HashSet;
import java.util.Set;

public class FibonacciChecker {

    private static Set<Long> bankOfFibonacciNumbers = new HashSet<>();
    private static Set<Long> bankOfNonFibonacciNumbers = new HashSet<>();

    public static boolean isFibonacciNumber(long number) {
        if(number<=0) {
            return false;
        }
        if(bankOfFibonacciNumbers.contains(number)){
            return true;
        }
        if(bankOfNonFibonacciNumbers.contains(number)) {
            return false;
        }
        if((((Math.sqrt((5 * number * number) + 4)) % 1) == 0) || (((Math.sqrt((5 * number * number) - 4)) % 1) == 0)) {
            bankOfFibonacciNumbers.add(number);
            return true;
        }
        bankOfNonFibonacciNumbers.add(number);
        return false;
    }
}
