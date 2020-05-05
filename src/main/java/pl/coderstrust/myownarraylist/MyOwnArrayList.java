package pl.coderstrust.myownarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnArrayList<T> implements List<T> {

    private Object[] array = new Object[10];

    private int arraySize;

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }

    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < arraySize; i++) {
            if (element != null && element.equals(array[i])) {
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
        Object[] newArray = new Object[arraySize];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public <E> E[] toArray(E[] providedArray) {
        if (providedArray.length >= arraySize) {
            System.arraycopy(array, 0, providedArray, 0, arraySize);
            Arrays.fill(providedArray, arraySize, providedArray.length, null);
            return providedArray;
        }
        return (E[]) Arrays.copyOfRange(array, 0, arraySize, providedArray.getClass());
    }

    @Override
    public boolean add(T element) {
        array[arraySize] = element;
        arraySize++;
        return true;
    }

    @Override
    public boolean remove(Object objToRemove) {
        for (int i = 0; i < arraySize; i++) {
            if (objToRemove.equals(array[i])) {
                array[i] = null;
                for (int j = i; j < arraySize - 1; j++) {
                    array[j] = array[j + 1];
                }
                arraySize--;
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
        int indexToPutElement = arraySize;
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
            arraySize++;
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        for (int j = arraySize - 1; j >= i; j--) {
            array[j + collection.size()] = array[j];
        }
        Iterator<T> iterator = (Iterator<T>) collection.iterator();
        int indexToPutElement = i;
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
            arraySize++;
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
        for (int i = 0; i < arraySize; i++) {
            array[i] = null;
        }
        arraySize=0;
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
        for (int j = arraySize - 1; j >= index; j--) {
            array[index + 1] = array[index];
        }
        array[index] = element;
        arraySize++;
    }

    @Override
    public T remove(int index) {
        Object temp = array[index];
        for (int j = index; j < size(); j++) {
            array[index] = array[index + 1];
        }
        arraySize--;
        return (T) temp;
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < arraySize; i++) {
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
        int lastIndex = -1;
        for (int i = 0; i < arraySize; i++) {
            if (element.equals(array[i])) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyOwnArrayListIterator(0, arraySize, array);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyOwnArrayListIterator(index, arraySize, array);
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
