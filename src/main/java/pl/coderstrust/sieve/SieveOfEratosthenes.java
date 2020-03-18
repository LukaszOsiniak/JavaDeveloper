package pl.coderstrust.sieve;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put maximum number that will limit our seach of primary numbers:");
        int maximumNumber = scan.nextInt();
        int[] zmienna = sieve(maximumNumber);
        System.out.println(Arrays.toString(zmienna));
        System.out.println(counter(zmienna));
    }

    public static int[] sieve(int maximumNumber) {
        int[] array = new int[maximumNumber];
        filledArray(array);
        for (int i = 2; i < array.length; i++) {
            for (int j = i + i; j < array.length; j += i) {
                array[j] = 0;
            }
        }
        return array;
    }

    private static void filledArray(int[] array) {
        for (int j = 2; j < array.length; j++)
            array[j] = j;
    }

    private static int counter(int[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            //System.out.println("Moje i " + i );
            if (array[i] != 0) {
                a++;
            }
        }
        return a;
    }

//    public static void mainn(String[] args) {
//        int[] newArray = new int[a];
//        if(array[i] != 0) {
//          array[i] = newArray [i]
    //   return array
//    }

}
