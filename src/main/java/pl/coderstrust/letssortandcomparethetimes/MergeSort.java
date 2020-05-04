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
        int rightBeginIndex = beginIndex + ((endIndex - beginIndex) / 2) + 1;
        int rightEndIndex = endIndex;
        if (rightEndIndex >= array.length) {
            rightEndIndex--;
        }
        int leftBeginIndex = beginIndex;
        int leftEndIndex = beginIndex + (endIndex - beginIndex) / 2;
        sort(array, leftBeginIndex, leftEndIndex);
        sort(array, rightBeginIndex, rightEndIndex);
        return merge(array, leftBeginIndex, leftEndIndex, rightBeginIndex, rightEndIndex);
    }

    public static int[] merge(int[] array, int leftBeginIndex, int leftEndIndex, int rightBeginIndex, int rightEndIndex) {
        int leftCurrentIndex = leftBeginIndex;
        int rightCurrentIndex = rightBeginIndex;
        int leftLength = leftEndIndex - leftBeginIndex + 1;
        int rightLength = rightEndIndex - rightBeginIndex + 1;
        int[] mergeArray = new int[leftLength + rightLength];
        int resultIndex = 0;
        while (leftCurrentIndex - leftBeginIndex < leftLength && rightCurrentIndex - rightBeginIndex < rightLength) {
            if (array[leftCurrentIndex] >= array[rightCurrentIndex]) {
                mergeArray[resultIndex++] = array[rightCurrentIndex++];
            } else {
                mergeArray[resultIndex++] = array[leftCurrentIndex++];
            }
        }
        while (leftCurrentIndex - leftBeginIndex < leftLength) {
            mergeArray[resultIndex++] = array[leftCurrentIndex++];
        }
        while (rightCurrentIndex - rightBeginIndex < rightLength) {
            mergeArray[resultIndex++] = array[rightCurrentIndex++];
        }
        for (int k = 0, m = leftBeginIndex; k < mergeArray.length; k++, m++) {
            array[m] = mergeArray[k];
        }
        return array;
    }
}
