package pl.coderstrust.myownarraylist;

import java.lang.reflect.Array;
import java.util.*;

public class MyOwnArrayList<T> implements List<T> {

    private Object[] array = new Object[100];

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
    public Iterator<T> iterator() {
        return new MyOwnArrayListIterator(0, size(), array);
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public <E> E[] toArray(E[] providedArray) {
        if (providedArray.length >= size()) {
            System.arraycopy(array, 0, providedArray, 0, size());
            return providedArray;
        } else {
            E[] newArray = (E[]) Array.newInstance(providedArray.getClass().getComponentType(), size());
            for (int i = 0; i < size(); i++) {
                newArray[i] = (E) array[i];
            }
            return newArray;
        }
    }

    @Override
    public boolean add(T element) {
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
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<T> iterator = (Iterator<T>) collection.iterator();
        int indexToPutElement = size();
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        for (int j = size() - 1; j >= i; j--) {
            array[j + collection.size()] = array[j];
        }
        Iterator<T> iterator = (Iterator<T>) collection.iterator();
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
        addAll((Collection<? extends T>) collection);
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        Object temp = array[index];
        array[index] = element;
        return (T) temp;
    }

    @Override
    public void add(int index, T element) {
        for (int j = size() - 1; j >= index; j--) {
            array[index + 1] = array[index];
        }
        array[index] = element;
    }

    @Override
    public T remove(int index) {
        Object temp = array[index];
        for (int j = index; j < size(); j++) {
            array[index] = array[index + 1];
        }
        return (T) temp;
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
    public ListIterator<T> listIterator() {
        return new MyOwnArrayListIterator(0, size(), array);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyOwnArrayListIterator(index, size(), array);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new MyOwnArrayList();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((T) array[i]);
        }
        return subList;
    }
}
