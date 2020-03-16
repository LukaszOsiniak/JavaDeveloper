package pl.coderstrust.letsSortTogether;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {11, 232, 45, 78, 4, 31, 99};
        System.out.println(Arrays.toString(array));
        int[] result = sort(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int maximumIndex = findMaximumIndex(array);
            sortedArray[i] = array[maximumIndex];
            array[maximumIndex] = 0;
        }
        return sortedArray;
    }

    public static int findMaximumIndex(int[] array) {
        int indexOfCurrentMaximumValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[indexOfCurrentMaximumValue]) {
                indexOfCurrentMaximumValue = i;
            }
        }
        return indexOfCurrentMaximumValue;
    }
}
