package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {
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
        for (int i = 0; i < (array.length); i++) {
            for (int j = 0; j < (array.length - i); j++)
                if (array[j] >= array[j + 1]) {
                    swap(array, j, j + 1);
                }
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
