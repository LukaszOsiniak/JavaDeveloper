package pl.coderstrust.sieve;

import java.nio.channels.MulticastChannel;
import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put maximum number that will limit our seach of primary numbers:");
        int maximumNumber = scan.nextInt();
        int[] primes = sieve(maximumNumber);
        System.out.println(Arrays.toString(primes));
    }

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 0) {
            throw new IllegalArgumentException("Maximum number cannot be negative");
        }
        int[] array = new int[maximumNumber];
        fillArray(array);
        markMultiples(array);
        return fillPrimesArray(array);
    }

    private static void markMultiples(int[] array) {
        for (int i = 2; i < array.length; i++) {
            for (int j = i + i; j < array.length; j += i) {
                array[j] = MULTIPLE_MARKER();
            }
        }
    }

    private static int MULTIPLE_MARKER() {
        return 0;
    }

    private static int[] fillPrimesArray(int[] array) {
        int numberOfPrimes = counter(array);
        int[] primes = new int[numberOfPrimes];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != MULTIPLE_MARKER()) {
                primes[j++] = array[i];
            }
        }
        return primes;
    }

    private static void fillArray(int[] array) {
        for (int j = 2; j < array.length; j++)
            array[j] = j;
    }

    private static int counter(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != MULTIPLE_MARKER()) {
                j++;
            }
        }
        return j;
    }
}
