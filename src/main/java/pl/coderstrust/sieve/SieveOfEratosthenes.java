package pl.coderstrust.sieve;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put maximum number that will limit our seach of primary numbers:");
        int maximumNumber = scan.nextInt();
        System.out.println(Arrays.toString(sieve(maximumNumber)));
    }

    public static int[] sieve(int maximumNumber) {
        int[] array = new int[maximumNumber];
        filledArray(array);
        for (int i = 2; i < array.length; i++) {
            for (int j = i * 2; j < array.length; j += i) {
                array[j] = 0;
            }
        }
        return array;
    }

    private static void filledArray(int[] array) {
        for (int j = 1; j < array.length; j++)
            array[j] = j;
    }
}
