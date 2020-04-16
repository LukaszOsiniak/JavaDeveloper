package pl.coderstrust.letssortandcomparethetimes;

public class BubbleSort implements SortingMethod {

    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int[] sortedArray = copyArray(array);
        for (int i = 1; i < sortedArray.length; i++) {
            for (int j = 0; j < sortedArray.length - i; j++)
                if (sortedArray[j] >= sortedArray[j + 1]) {
                    swap(sortedArray, j, j + 1);
                }
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

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
