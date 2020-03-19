package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {11, 232, 45, 78, 4, 31, 99, 62, 435, 22};
        System.out.println(Arrays.toString(array));
        int[] result = sort(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int[] sortedArray = copyArray(array);
        for (int i = 0; i < array.length; i++) {
            swap(sortedArray, i, findMinimumIndex(sortedArray, i));
        }
        return sortedArray;
    }

    private static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private static int findMinimumIndex(int[] array, int start) {
        int indexOMinimumValue = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < array[indexOMinimumValue]) {
                indexOMinimumValue = i;
            }
        }
        return indexOMinimumValue;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
