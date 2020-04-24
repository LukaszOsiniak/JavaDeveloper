package pl.coderstrust.letssortandcomparethetimes;

public class QuickSort implements SortingMethod {

    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi);
            quickSort(array, pi + 1, high);
        }
        return array;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            }
            while (arr[i] < pivot);
            do {
                j--;
            }
            while (arr[j] > pivot);
            if (i < j) {
                ArraysUtils.swap(arr, i, j);
            } else {
                return j;
            }
        }
    }
}
