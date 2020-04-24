package pl.coderstrust.letssortandcomparethetimes;

public class MergeSort implements SortingMethod {

    public int[] sort(int[] array) {
        return sort(array, 0, array.length);
    }

    public int[] sort(int[] array, int beginIndex, int endIndex) {
        if (endIndex - beginIndex <= 1) {
            return array;
        }
        int leftBeginIndex = beginIndex;
        int leftEndIndex = ((endIndex - beginIndex) / 2) - 1;
        int rightBeginIndex = ((endIndex - beginIndex) / 2);
        int rightEndIndex = endIndex;
        sort(array, leftBeginIndex, leftEndIndex);
        sort(array, rightBeginIndex, rightEndIndex);

        return merge(array, leftBeginIndex, leftEndIndex, rightBeginIndex, rightEndIndex);
    }

    public static int[] merge(int[] array, int leftBeginIndex, int leftEndIndex, int rightBeginIndex, int rightEndIndex) {
        int i = leftBeginIndex, j = rightBeginIndex;
        int resultIndex = leftBeginIndex;
        int leftLength = leftEndIndex - leftBeginIndex;
        int rightLength = rightEndIndex - rightBeginIndex;
        while (i < leftLength && j < rightLength) {
            if (array[i] >= array[j]) {
                array[resultIndex] = array[j];
                j++;
                resultIndex++;
            } else {
                array[resultIndex] = array[i];
                i++;
                resultIndex++;
            }
        }
        while (i < leftLength) {
            array[resultIndex] = array[j];
            j++;
            resultIndex++;
        }
        while (j < rightLength) {
            array[resultIndex] = array[i];
            i++;
            resultIndex++;
        }
        return array;
    }
}
