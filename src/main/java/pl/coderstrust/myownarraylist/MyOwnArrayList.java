package pl.coderstrust.myownarraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnArrayList implements List<Long> {

    private Long[] array = new Long[100];

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
    public boolean contains(Object elements) {
        for (int i = 0; i < array.length; i++) {
            if (elements != null && elements.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Long> iterator() {
        return new MyOwnArrayListIterator(0, size(), array);
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
                newArray[i] = array[i];
            }
            return (T[]) newArray;
        }
    }

    @Override
    public boolean add(Long element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object objToRemove) {
        if (objToRemove == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (objToRemove.equals(array[i])) {
                array[i] = null;
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        Iterator<Long> iterator = (Iterator<Long>) collection.iterator();
        int indexToPutElement = size();
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Long> collection) {
        for (int j = size() - 1; j >= i; j--) {
            array[j + collection.size()] = array[j];
        }
        Iterator<Long> iterator = (Iterator<Long>) collection.iterator();
        int indexToPutElement = i;
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for (Object element : collection) {
            boolean removedElement = remove(element);
            if (removedElement) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        clear();
        addAll((Collection<? extends Long>) collection);
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @Override
    public Long get(int index) {
        return array[index];
    }

    @Override
    public Long set(int index, Long element) {
        Long temp = array[index];
        array[index] = element;
        return temp;
    }

    @Override
    public void add(int index, Long element) {
        for (int j = size() - 1; j >= index; j--) {
            array[index + 1] = array[index];
        }
        array[index] = element;
    }

    @Override
    public Long remove(int index) {
        Long temp = array[index];
        for (int j = index; j < size(); j++) {
            array[index] = array[index + 1];
        }
        return temp;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        if (element == null) {
            return -1;
        }
        int lastInedex = -1;
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                lastInedex = i;
            }
        }
        return lastInedex;
    }

    @Override
    public ListIterator<Long> listIterator() {
        return new MyOwnArrayListIterator(0, size(), array);
    }

    @Override
    public ListIterator<Long> listIterator(int index) {
        return new MyOwnArrayListIterator(index, size(), array);
    }

    @Override
    public List<Long> subList(int fromIndex, int toIndex) {
        List<Long> subList = new MyOwnArrayList();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(array[i]);
        }
        return subList;
    }
}
