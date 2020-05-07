package pl.coderstrust.myownarraylist;

import jdk.jshell.spi.ExecutionControl;

import java.util.ListIterator;

public class MyOwnArrayListIterator<T> implements ListIterator<T> {

    private Object[] elements;
    private int currentIndex;
    private int numberOfElements;

    public MyOwnArrayListIterator(int currentIndex, int numberOfElements, Object[] array) {
        this.currentIndex = currentIndex;
        this.numberOfElements = numberOfElements;
        elements = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < numberOfElements;
    }

    @Override
    public T next() {
        @SuppressWarnings("unchecked") T nextElement = (T) elements[currentIndex++];
        return nextElement;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public T previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return currentIndex;
    }

    @Override
    public int previousIndex() {
        if(currentIndex==0){
            return -1;
        } else {
            return currentIndex-1;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void set(Object o) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void add(Object o) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
