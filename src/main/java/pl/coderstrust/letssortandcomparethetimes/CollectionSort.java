package pl.coderstrust.letssortandcomparethetimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort implements SortingMethod {
    public int[] sort(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        Collections.sort(list);
        int[] sortedArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sortedArray[i] = list.get(i);
        }
        return sortedArray;
    }
}
