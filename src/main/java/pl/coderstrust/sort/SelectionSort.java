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
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            swap(sortedArray, i, findMaximumIndex(sortedArray, i));
        }
        return sortedArray;
    }

    private static int findMaximumIndex(int[] array, int start) {
        int indexOMaximumValue = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] > array[indexOMaximumValue]) {
                indexOMaximumValue = i;
            }
        }
        return indexOMaximumValue;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
