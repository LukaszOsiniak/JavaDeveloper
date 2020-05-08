package pl.coderstrust.myownarraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListBaseTest<E> {

    public abstract List<E> createList();

    protected abstract E wrap(Long number);

    protected abstract void genericAssertEquals(Object expected, Object actual);

    @Test
    public void shouldReturnSizeZeroWhenEmpty() {
        //given
        List<E> listOfNumbers = createList();
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(0, size);
    }

    @Test
    public void shouldReturnCorrectSizeAfterAdd() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(2, size);
    }

    @Test
    public void shouldReturnCorrectSizeWhenAddedMoreElementsThanInitialCapacity() {
        //given
        List<E> listOfNumbers = createList();
        for (long i = 0; i < 15; i++) {
            listOfNumbers.add(wrap(i));
        }
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(15, size);
        genericAssertEquals(13L, listOfNumbers.get(13));
    }

    @Test
    public void shouldReturnTrueWhenEmpty() {
        //given
        List<E> listOfNumbers = createList();
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertTrue(isEmpty);
    }

    @Test
    public void shouldReturnFalseWhenAdded() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertFalse(isEmpty);
    }

    @Test
    public void containsShouldReturnTrue() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        boolean contains = listOfNumbers.contains(wrap(2L));
        //then
        assertTrue(contains);
    }

    @Test
    public void containsShouldReturnFalse() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        boolean contains = listOfNumbers.contains(wrap(4L));
        //then
        assertFalse(contains);
    }

    @Test
    public void shouldReturnIteratorObject() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        //when
        Iterator<E> iterator = listOfNumbers.iterator();
        //then
        assertNotNull(iterator);
        genericAssertEquals(1L, iterator.next());
    }

    @Test
    public void shouldReturnCorrectArray() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        //when
        Object[] array = listOfNumbers.toArray();
        //then
        assertEquals(2, array.length);
        genericAssertEquals(1L, array[0]);
        genericAssertEquals(2L, array[1]);
    }

    @Test
    public void shouldReturnCorrectArrayOfType() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        //when
        @SuppressWarnings("unchecked") E[] array = (E[]) listOfNumbers.toArray(new Object[0]);
        //then
        assertEquals(2, array.length);
        genericAssertEquals(1L, array[0]);
        genericAssertEquals(2L, array[1]);
    }

    @Test
    public void shouldThrowNullPointerExceptionOnToArrayMethod() {
        //given
        List<E> listOfNumbers = createList();
        Object[] nullArray = null;
        //when
        assertThrows(NullPointerException.class, () -> listOfNumbers.toArray(nullArray));
    }

    @Test
    public void shouldAddCorrect() {
        //given
        List<E> listOfNumbers = createList();
        //when
        boolean changed = listOfNumbers.add(wrap(2L));
        //then
        assertTrue(changed);
        assertEquals(1, listOfNumbers.size());
        genericAssertEquals(2L, listOfNumbers.get(0));
    }

    @Test
    public void shouldRemoveElement() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        boolean removed = listOfNumbers.remove(wrap(2L));
        //then
        assertTrue(removed);
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfContainsAllElements() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> otherlistOfNumbers = new ArrayList<>();
        otherlistOfNumbers.add(wrap(2L));
        otherlistOfNumbers.add(wrap(3L));
        //when
        boolean containsAll = listOfNumbers.containsAll(otherlistOfNumbers);
        //then
        assertTrue(containsAll);
    }

    @Test
    public void shouldReturnFalseIfDoesNotContainsAllElements() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> otherlistOfNumbers = new ArrayList<>();
        otherlistOfNumbers.add(wrap(2L));
        otherlistOfNumbers.add(wrap(7L));
        //when
        boolean containsAll = listOfNumbers.containsAll(otherlistOfNumbers);
        //then
        assertFalse(containsAll);
    }

    @Test
    public void shouldReturnTrueIfAddedAllElements() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> toBeAdded = new ArrayList<>();
        toBeAdded.add(wrap(2L));
        toBeAdded.add(wrap(7L));
        //when
        boolean addedAll = listOfNumbers.addAll(toBeAdded);
        //then
        assertTrue(addedAll);
        genericAssertEquals(2L, listOfNumbers.get(3));
        genericAssertEquals(7L, listOfNumbers.get(4));
        assertEquals(5, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfAddedAllElementsAtGivenIndex() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> toBeAddedAtGivenIndex = new ArrayList<>();
        toBeAddedAtGivenIndex.add(wrap(5L));
        toBeAddedAtGivenIndex.add(wrap(7L));
        //when
        boolean addedAll = listOfNumbers.addAll(1, toBeAddedAtGivenIndex);
        //then
        assertTrue(addedAll);
        genericAssertEquals(1L, listOfNumbers.get(0));
        genericAssertEquals(5L, listOfNumbers.get(1));
        genericAssertEquals(7L, listOfNumbers.get(2));
        genericAssertEquals(2L, listOfNumbers.get(3));
        genericAssertEquals(3L, listOfNumbers.get(4));
        assertEquals(5, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfRemovedAllElements() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> toBeRemoved = new ArrayList<>();
        toBeRemoved.add(wrap(2L));
        toBeRemoved.add(wrap(3L));
        //when
        boolean removedAll = listOfNumbers.removeAll(toBeRemoved);
        //then
        assertTrue(removedAll);
        genericAssertEquals(1L, listOfNumbers.get(0));
        assertEquals(1, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfDidNotRemoveAllElements() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> toBeRemoved = new ArrayList<>();
        toBeRemoved.add(wrap(2L));
        toBeRemoved.add(wrap(7L));
        //when
        boolean removedAll = listOfNumbers.removeAll(toBeRemoved);
        //then
        assertTrue(removedAll);
        genericAssertEquals(1L, listOfNumbers.get(0));
        genericAssertEquals(3L, listOfNumbers.get(1));
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldRetainProvidedElementsCorrectly() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        List<E> toBeRetained = new ArrayList<>();
        toBeRetained.add(wrap(2L));
        toBeRetained.add(wrap(3L));
        //when
        boolean retainedAll = listOfNumbers.retainAll(toBeRetained);
        //then
        assertTrue(retainedAll);
        genericAssertEquals(2L, listOfNumbers.get(0));
        genericAssertEquals(3L, listOfNumbers.get(1));
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldThrowNullPointerExceptionOnRetainAllMethod() {
        //given
        List<E> listOfNumbers = createList();
        Collection<E> collectionOfNulls = null;
        //when
        assertThrows(NullPointerException.class, () -> listOfNumbers.retainAll(collectionOfNulls));
    }

    @Test
    public void shouldReturnVoidWhenCleared() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        listOfNumbers.clear();
        //then
        assertEquals(0, listOfNumbers.size());
        assertTrue(listOfNumbers.isEmpty());
    }

    @Test
    public void shouldGetElementAtGivenIndex() {
        //given
        List<E> listOfNumbers = createList();
        E element = wrap(2L);
        listOfNumbers.add(element);
        //when
        E get = listOfNumbers.get(0);
        //then
        assertEquals(element, get);
    }

    @Test
    public void shouldSetElementAtSpecifiedPosition() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        E set = listOfNumbers.set(1, wrap(5L));
        //then
        genericAssertEquals(2L, set);
        genericAssertEquals(5L, listOfNumbers.get(1));
    }

    @Test
    public void shouldAddElementAtSpecifiedPosition() {
        //given
        List<E> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        listOfNumbers.add(1, wrap(5L));
        //then
        genericAssertEquals(5L, listOfNumbers.get(1));
        genericAssertEquals(2L, listOfNumbers.get(2));
        genericAssertEquals(3L, listOfNumbers.get(3));
        assertEquals(4, listOfNumbers.size());
    }

    @Test
    public void shouldRemoveElementAtSpecifiedPosition() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        E remove = listOfNumbers.remove(1);
        //then
        genericAssertEquals(2L, remove);
        genericAssertEquals(3L, listOfNumbers.get(1));
    }

    @Test
    public void shouldReturnIndexAtFirstOccurrence() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        int indexOf = listOfNumbers.indexOf(wrap(3L));
        int indexOfNonExistingEl = listOfNumbers.indexOf(wrap(5L));
        //then
        assertEquals(2, indexOf);
        assertEquals(-1, indexOfNonExistingEl);
    }

    @Test
    public void shouldReturnLastIndexOccuarnce() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(3L));
        //when
        int lastIndexOf = listOfNumbers.lastIndexOf(wrap(1L));
        int indexOfNonExistingEl = listOfNumbers.indexOf(wrap(5L));
        //then
        assertEquals(2, lastIndexOf);
        assertEquals(-1, indexOfNonExistingEl);
    }

    @Test
    public void shouldReturnListIterator() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        ListIterator<E> listIterator = listOfNumbers.listIterator();
        //then
        assertEquals(0, listIterator.nextIndex());
        genericAssertEquals(1L, listIterator.next());
    }

    @Test
    public void shouldReturnListIteratorAtSpecPosition() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        //when
        ListIterator<E> listIterator = listOfNumbers.listIterator(1);
        //then
        assertEquals(1, listIterator.nextIndex());
        genericAssertEquals(2L, listIterator.next());
    }

    @Test
    public void shouldReturnSubListFromBaseList() {
        //given
        List<E> listOfNumbers = createList();
        listOfNumbers.add(wrap(1L));
        listOfNumbers.add(wrap(2L));
        listOfNumbers.add(wrap(3L));
        listOfNumbers.add(wrap(4L));
        //when
        List<E> sublist = listOfNumbers.subList(1, 2);
        //then
        genericAssertEquals(2L, sublist.get(0));
        assertEquals(1, sublist.size());
    }
}
