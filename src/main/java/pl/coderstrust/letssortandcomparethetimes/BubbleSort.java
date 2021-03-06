package pl.coderstrust.letssortandcomparethetimes;

import static pl.coderstrust.letssortandcomparethetimes.ArraysUtils.swap;

public class BubbleSort implements SortingMethod {

    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++)
                if (array[j] >= array[j + 1]) {
                    swap(array, j, j + 1);
                }
        }
        return array;
    }
}
