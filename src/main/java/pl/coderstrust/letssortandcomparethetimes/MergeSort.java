package pl.coderstrust.letssortandcomparethetimes;

public class MergeSort implements SortingMethod {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        return sort(array, 0, array.length - 1);
    }

    public int[] sort(int[] array, int beginIndex, int endIndex) {
        if (endIndex - beginIndex + 1 == 1) {
            return array;
        }
        int leftBeginIndex = beginIndex;
        int leftEndIndex = beginIndex + (endIndex - beginIndex) / 2;
        int rightBeginIndex = beginIndex + ((endIndex - beginIndex) / 2) + 1;
        int rightEndIndex = endIndex;
        if (rightEndIndex >= array.length) {
            rightEndIndex--;
        }
        sort(array, leftBeginIndex, leftEndIndex);
        sort(array, rightBeginIndex, rightEndIndex);
        return merge(array, leftBeginIndex, leftEndIndex, rightBeginIndex, rightEndIndex);
    }

    public static int[] merge(int[] array, int leftBeginIndex, int leftEndIndex, int rightBeginIndex, int rightEndIndex) {
        int i = leftBeginIndex;
        int j = rightBeginIndex;
        int leftLength = leftEndIndex - leftBeginIndex + 1;
        int rightLength = rightEndIndex - rightBeginIndex + 1;
        int[] result = new int[leftLength + rightLength];
        int resultIndex = 0;
        while (i - leftBeginIndex < leftLength && j - rightBeginIndex < rightLength) {
            if (array[i] >= array[j]) {
                result[resultIndex] = array[j];
                j++;
                resultIndex++;
            } else {
                result[resultIndex] = array[i];
                i++;
                resultIndex++;
            }
        }
        while (i - leftBeginIndex < leftLength) {
            result[resultIndex] = array[i];
            i++;
            resultIndex++;
        }
        while (j - rightBeginIndex < rightLength) {
            result[resultIndex] = array[j];
            j++;
            resultIndex++;
        }
        for (int k = 0, m = leftBeginIndex; k < result.length; k++, m++) {
            array[m] = result[k];
        }
        return array;
    }
}
