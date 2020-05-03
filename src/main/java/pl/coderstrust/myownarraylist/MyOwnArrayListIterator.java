package pl.coderstrust.myownarraylist;

import java.util.Iterator;

public class MyOwnArrayListIterator implements Iterator {

    private Long[] array;
    private int currentIndex = 0;


    public MyOwnArrayListIterator(Long[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (currentIndex + 1 < array.length && array[currentIndex + 1] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return array[currentIndex++];
    }
}
