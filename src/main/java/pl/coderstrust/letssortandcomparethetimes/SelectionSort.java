package pl.coderstrust.letssortandcomparethetimes;

public class SelectionSort implements SortingMethod {

    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            ArrayUtils.swap(array, i, findMinimumIndex(array, i));
        }
        return array;
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
}
