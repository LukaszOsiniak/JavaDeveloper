package pl.coderstrust.myownarraylist;

import java.util.ListIterator;

public class MyOwnArrayListIterator implements ListIterator {

    private Long[] elements;
    private int currentIndex;

    public MyOwnArrayListIterator(int currentIndex, int size, Long[] array) {
        this.currentIndex = currentIndex;
        elements = new Long[size];
        for (int i = 0; i < size; i++) {
            elements[i] = array[i];
        }
    }

    @Override
    public boolean hasNext() {
        if (currentIndex < elements.length && elements[currentIndex] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return elements[currentIndex++];
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Object previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        if (currentIndex >= elements.length) {
            return currentIndex;
        }
        return currentIndex;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Object o) {

    }

    @Override
    public void add(Object o) {

    }
}