package pl.coderstrust.myownarraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnArrayList implements List<Long> {

    private Long[] array = new Long[5];

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (array[0] == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o != null && o.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Long> iterator() {
        return new MyOwnArrayListIterator(array);
    }

    @Override
    public Object[] toArray() {
        Long[] newArray = new Long[size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public <T> T[] toArray(T[] providedArray) {
        if (providedArray.length >= size()) {
            for (int i = 0; i < size(); i++) {
                providedArray[i] = (T) array[i];
            }
            return providedArray;
        } else {
            Long[] newArray = new Long[size()];
            for (int i = 0; i < size(); i++) {
                newArray[i] = (Long) array[i];
            }
            return (T[]) newArray;
        }
    }

    @Override
    public boolean add(Long aLong) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = aLong;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Long> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Long get(int i) {
        return null;
    }

    @Override
    public Long set(int i, Long aLong) {
        return null;
    }

    @Override
    public void add(int i, Long aLong) {

    }

    @Override
    public Long remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Long> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Long> listIterator(int i) {
        return null;
    }

    @Override
    public List<Long> subList(int i, int i1) {
        return null;
    }
}
