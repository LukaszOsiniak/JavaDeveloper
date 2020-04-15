package pl.coderstrust.letssortandcomparethetimes;

import java.util.Arrays;

public class MergeSort implements SortingMethod {
    public int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int half = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        int resultInx = 0;
        while (i < left.length || j < right.length) {
            if (j == right.length) {
                result[resultInx] = left[i];
                i++;
                resultInx++;
            } else if (i == left.length) {
                result[resultInx] = right[j];
                j++;
                resultInx++;
            } else if (left.length == 1 && right.length == 1) {
                if (left[i] >= right[j]) {
                    result[resultInx] = right[j];
                    j++;
                    resultInx++;
                } else {
                    result[resultInx] = left[i];
                    i++;
                    resultInx++;
                }
            } else if (left[i] <= right[j]) {
                result[resultInx] = left[i];
                i++;
                resultInx++;
            } else {
                result[resultInx] = right[j];
                j++;
                resultInx++;
            }
        }
        return result;
    }
}
