package pl.coderstrust.letssortandcomparethetimes;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortingMethod {
    public int[] sort(int[] array) {
        List<Integer> listToSort = new ArrayList<>();
        for (int i : array) {
            listToSort.add(i);
        }
        List<Integer> sorted = mergeSort(listToSort);
        for (int i = 0; i < sorted.size(); i++) {
            array[i] = sorted.get(i);
        }
        return array;
    }

    public static List<Integer> mergeSort(List<Integer> list) {

        if (list.size() == 1) {
            return list;
        }
        int half = list.size() / 2;
        List<Integer> left = list.subList(0, half);
        List<Integer> right = list.subList(half, list.size());

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() || j < right.size()) {

            if (j == right.size()) {
                result.add(left.get(i));
                i++;
            } else if (i == left.size()) {
                result.add(right.get(j));
                j++;
            } else if (left.size() == 1 && right.size() == 1) {
                if (left.get(i) >= right.get(j)) {
                    result.add(right.get(j));
                    j++;
                } else {
                    result.add(left.get(i));
                    i++;
                }
            } else if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        return result;
    }
}
