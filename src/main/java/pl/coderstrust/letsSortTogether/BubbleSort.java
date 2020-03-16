package pl.coderstrust.letsSortTogether;

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
            throw new IllegalArgumentException("Array cannot be empty");
        }
        for (int i = 0; i < (array.length - 1); i++) {
            for (int j = 0; j < (array.length - 1 - i); j++) {
                if (array[j] <= array[j + 1]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j + 1];
        array[j + 1] = array[j];
        array[j] = temp;
    }
}
