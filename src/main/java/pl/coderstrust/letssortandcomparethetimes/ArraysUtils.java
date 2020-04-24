package pl.coderstrust.letssortandcomparethetimes;

public final class ArraysUtils {

    private ArraysUtils() {
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
