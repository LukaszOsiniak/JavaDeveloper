package pl.coderstrust.myownarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyOwnArrayList<T> implements List<T> {

    private static final int INITIAL_NUMBER_OF_ELEMENTS_IN_ARRAY = 10;
    private static final int EXTENSION_RATIO = 2;
    private static final float DOWNSIZE_THRESHOLD = 0.25f;

    private Object[] array;

    private int arraySize;

    public MyOwnArrayList() {
        array = new Object[INITIAL_NUMBER_OF_ELEMENTS_IN_ARRAY];
        arraySize = 0;
    }

    private MyOwnArrayList(Object[] fromArray) {
        array = new Object[INITIAL_NUMBER_OF_ELEMENTS_IN_ARRAY];
        System.arraycopy(fromArray, 0, array, 0, fromArray.length);
        this.arraySize = fromArray.length;
    }

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
        return new MyOwnArrayListIterator<T>(0, size(), array);
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
        if (providedArray == null) {
            throw new NullPointerException();
        }
        if (providedArray.length >= arraySize) {
            System.arraycopy(array, 0, providedArray, 0, arraySize);
            Arrays.fill(providedArray, arraySize, providedArray.length, null);
            return providedArray;
        }
        @SuppressWarnings("unchecked") E[] newArray = (E[]) Arrays.copyOfRange(array, 0, arraySize, providedArray.getClass());
        return newArray;
    }

    public void extendSizeIfNeeded(int numberOfElementsToBeAdded) {
        if (arraySize + numberOfElementsToBeAdded > array.length) {
            int extendedArraySize = array.length * EXTENSION_RATIO;
            if (arraySize + numberOfElementsToBeAdded > extendedArraySize) {
                extendedArraySize = (arraySize + numberOfElementsToBeAdded) * EXTENSION_RATIO;
            }
            Object[] extendedArray = new Object[extendedArraySize];
            System.arraycopy(array, 0, extendedArray, 0, array.length);
            array = extendedArray;
        }
    }

    @Override
    public boolean add(T element) {
        extendSizeIfNeeded(1);
        array[arraySize] = element;
        arraySize++;
        return true;
    }

    public void downSizeIfNeeded(int numberOfElementsToBeRemoved) {
        if (DOWNSIZE_THRESHOLD * array.length > arraySize - numberOfElementsToBeRemoved) {
            int downSizedArraySize = array.length / EXTENSION_RATIO;
            Object[] downSizedArray = new Object[downSizedArraySize];
            System.arraycopy(array, 0, downSizedArray, 0, arraySize - numberOfElementsToBeRemoved);
            array = downSizedArray;
        }
    }

    @Override
    public boolean remove(Object objToRemove) {
        int indexOf = indexOf(objToRemove);
        if (indexOf != -1) {
            System.arraycopy(array, indexOf + 1, array, indexOf, arraySize - indexOf);
            downSizeIfNeeded(1);
            arraySize--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null) {
            return false;
        }
        extendSizeIfNeeded(collection.size());
        Iterator<? extends T> iterator = collection.iterator();
        int indexToPutElement = arraySize;
        while (iterator.hasNext()) {
            array[indexToPutElement] = iterator.next();
            indexToPutElement++;
        }
        arraySize += collection.size();
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        if (collection == null) {
            return false;
        }
        extendSizeIfNeeded(collection.size());
        System.arraycopy(array, i, array, i + collection.size(), arraySize - i);
        Object[] arrayToBeAdded = collection.toArray();
        System.arraycopy(arrayToBeAdded, 0, array, i, arrayToBeAdded.length);
        arraySize += collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null || !checkIfToBeChangedOnRemoveAll(collection)) {
            return false;
        }
        return reorderIfNeededOnRemoveAll(collection);
    }

    private boolean checkIfToBeChangedOnRemoveAll(Collection<?> collection) {
        for (int j = 0; j < arraySize; j++) {
            if (collection.contains(array[j])) {
                return true;
            }
        }
        return false;
    }

    private boolean reorderIfNeededOnRemoveAll(Collection<?> collection) {
        boolean changed = false;
        int reorderIndex = 0;
        int lastCheckedIndex;
        for (lastCheckedIndex = 0; lastCheckedIndex < arraySize; lastCheckedIndex++) {
            if (!collection.contains(array[lastCheckedIndex])) {
                array[reorderIndex] = array[lastCheckedIndex];
                reorderIndex++;
            }
        }
        if (reorderIndex != lastCheckedIndex) {
            changed = true;
            downSizeIfNeeded(arraySize - reorderIndex);
            arraySize = reorderIndex;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        clear();
        @SuppressWarnings("unchecked") Collection<? extends T> collectionOfNewType = (Collection<? extends T>) collection;
        addAll(collectionOfNewType);
        return true;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_NUMBER_OF_ELEMENTS_IN_ARRAY];
        arraySize = 0;
    }

    @Override
    public T get(int index) {
        @SuppressWarnings("unchecked") T element = (T) array[index];
        return element;
    }

    @Override
    public T set(int index, T element) {
        Object temp = array[index];
        array[index] = element;
        @SuppressWarnings("unchecked") T tempOfGivenType = (T) temp;
        return tempOfGivenType;
    }

    @Override
    public void add(int index, T element) {
        extendSizeIfNeeded(1);
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
        downSizeIfNeeded(1);
        arraySize--;
        @SuppressWarnings("unchecked") T tempOfGivenType = (T) temp;
        return tempOfGivenType;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < arraySize; i++) {
            if (element == null && array[i] == null) {
                return i;
            }
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
        for (int i = arraySize - 1; i >= 0; i--) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyOwnArrayListIterator<T>(0, arraySize, array);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyOwnArrayListIterator<T>(index, arraySize, array);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        Object[] subArray = Arrays.copyOfRange(array, fromIndex, toIndex);
        return new MyOwnArrayList<>(subArray);
    }
}
