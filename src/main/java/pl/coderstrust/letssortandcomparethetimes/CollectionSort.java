package pl.coderstrust.letssortandcomparethetimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{15, 232, 45, 78, 4, 31, 99, 62, 435, 22};
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);
        }
        Collections.sort(list);
        int[] sortedArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sortedArray[i] = list.get(i);
        }
    }
}
