package pl.coderstrust.myownarraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

public abstract class ListBaseTest {

    public abstract List<Long> createList();

    @Test
    public void shouldReturnSizeZeroWhenEmpty() {
        //given
        List<Long> listOfNumbers = createList();
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(0, size);
    }

    @Test
    public void shouldReturnCorrectSizeAfterAdd() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(2, size);
    }

    @Test
    public void shouldReturnTrueWhenEmpty() {
        //given
        List<Long> listOfNumbers = createList();
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertTrue(isEmpty);
    }

    @Test
    public void shouldReturnFalseWhenAdded() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertFalse(isEmpty);
    }

    @Test
    public void containsShouldReturnTrue() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        boolean contains = listOfNumbers.contains(2L);
        //then
        assertTrue(contains);
    }

    @Test
    public void containsShouldReturnFalse() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        boolean contains = listOfNumbers.contains(4L);
        //then
        assertFalse(contains);
    }

    @Test
    public void shouldReturnIteratorObject() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        //when
        Iterator<Long> iterator = listOfNumbers.iterator();
        //then
        assertNotNull(iterator);
        assertEquals(1L, iterator.next());
    }

    @Test
    public void shouldReturnCorrectArray() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        //when
        Object[] array = listOfNumbers.toArray();
        //then
        assertEquals(2, array.length);
        assertEquals(1L, array[0]);
        assertEquals(2L, array[1]);
    }

    @Test
    public void shouldReturnCorrectArrayOfType() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        //when
        Long[] array = listOfNumbers.toArray(new Long[0]);
        //then
        assertEquals(2, array.length);
        assertEquals(1L, array[0]);
        assertEquals(2L, array[1]);
    }

    @Test
    public void shouldAddCorrect() {
        //given
        List<Long> listOfNumbers = createList();
        //when
        boolean changed = listOfNumbers.add(2L);
        //then
        assertTrue(changed);
        assertEquals(1, listOfNumbers.size());
        assertEquals(2L, listOfNumbers.get(0));
    }

    @Test
    public void shouldRemoveElement() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        boolean removed = listOfNumbers.remove(2L);
        //then
        assertTrue(removed);
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfContainsAllElements() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> otherlistOfNumbers = new ArrayList<>();
        otherlistOfNumbers.add(2L);
        otherlistOfNumbers.add(3L);
        //when
        boolean containsAll = listOfNumbers.containsAll(otherlistOfNumbers);
        //then
        assertTrue(containsAll);
    }

    @Test
    public void shouldReturnFalseIfDoesNotContainsAllElements() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> otherlistOfNumbers = new ArrayList<>();
        otherlistOfNumbers.add(2L);
        otherlistOfNumbers.add(7L);
        //when
        boolean containsAll = listOfNumbers.containsAll(otherlistOfNumbers);
        //then
        assertFalse(containsAll);
    }

    @Test
    public void shouldReturnTrueIfAddedAllElements() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> toBeAdded = new ArrayList<>();
        toBeAdded.add(2L);
        toBeAdded.add(7L);
        //when
        boolean addedAll = listOfNumbers.addAll(toBeAdded);
        //then
        assertTrue(addedAll);
        assertEquals(2L, listOfNumbers.get(3));
        assertEquals(7L, listOfNumbers.get(4));
        assertEquals(5, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfAddedAllElementsAtGivenIndex() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> toBeAddedAtGivenIndex = new ArrayList<>();
        toBeAddedAtGivenIndex.add(5L);
        toBeAddedAtGivenIndex.add(7L);
        //when
        boolean addedAll = listOfNumbers.addAll(1, toBeAddedAtGivenIndex);
        //then
        assertTrue(addedAll);
        assertEquals(1L, listOfNumbers.get(0));
        assertEquals(5L, listOfNumbers.get(1));
        assertEquals(7L, listOfNumbers.get(2));
        assertEquals(2L, listOfNumbers.get(3));
        assertEquals(3L, listOfNumbers.get(4));
        assertEquals(5, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfRemovedAllElements() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> toBeRemoved = new ArrayList<>();
        toBeRemoved.add(2L);
        toBeRemoved.add(3L);
        //when
        boolean removedAll = listOfNumbers.removeAll(toBeRemoved);
        //then
        assertTrue(removedAll);
        assertEquals(1L, listOfNumbers.get(0));
        assertEquals(1, listOfNumbers.size());
    }

    @Test
    public void shouldReturnTrueIfDidNotRemoveAllElements() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> toBeRemoved = new ArrayList<>();
        toBeRemoved.add(2L);
        toBeRemoved.add(7L);
        //when
        boolean removedAll = listOfNumbers.removeAll(toBeRemoved);
        //then
        assertTrue(removedAll);
        assertEquals(1L, listOfNumbers.get(0));
        assertEquals(3L, listOfNumbers.get(1));
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldRetainProvidedElementsCorrectly() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        List<Long> toBeRetained = new ArrayList<>();
        toBeRetained.add(2L);
        toBeRetained.add(3L);
        //when
        boolean retainedAll = listOfNumbers.retainAll(toBeRetained);
        //then
        assertTrue(retainedAll);
        assertEquals(2L, listOfNumbers.get(0));
        assertEquals(3L, listOfNumbers.get(1));
        assertEquals(2, listOfNumbers.size());
    }

    @Test
    public void shouldReturnVoidWhenCleared() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        listOfNumbers.clear();
        //then
        assertEquals(0, listOfNumbers.size());
        assertTrue(listOfNumbers.isEmpty());
    }

    @Test
    public void shouldGetElementAtGivenIndex() {
        //given
        List<Long> listOfNumbers = createList();
        Long element = 2L;
        listOfNumbers.add(element);
        //when
        Long get = listOfNumbers.get(0);
        //then
        assertEquals(element, get);
    }

    @Test
    public void shouldSetElementAtSpecifiedPosition() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        Long set = listOfNumbers.set(1, 5L);
        //then
        assertEquals(2L, set);
        assertEquals(5L, listOfNumbers.get(1));
    }

    @Test
    public void shouldAddElementAtSpecifiedPosition() {
        //given
        List<Long> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        listOfNumbers.add(1, 5L);
        //then
        assertEquals(5L, listOfNumbers.get(1));
        assertEquals(2L, listOfNumbers.get(2));
        assertEquals(3L, listOfNumbers.get(3));
        assertEquals(4, listOfNumbers.size());
    }

    @Test
    public void shouldRemoveElementAtSpecifiedPosition() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        Long remove = listOfNumbers.remove(1);
        //then
        assertEquals(2L, remove);
        assertEquals(3L, listOfNumbers.get(1));
    }

    @Test
    public void shouldReturnIndexAtFirstOccurrence() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        int indexOf = listOfNumbers.indexOf(3L);
        int indexOfNonExistingEl = listOfNumbers.indexOf(5L);
        //then
        assertEquals(2, indexOf);
        assertEquals(-1, indexOfNonExistingEl);
    }

    @Test
    public void shouldReturnLastIndexOccuarnce() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(1L);
        listOfNumbers.add(3L);
        //when
        int lastIndexOf = listOfNumbers.lastIndexOf(1L);
        int indexOfNonExistingEl = listOfNumbers.indexOf(5L);
        //then
        assertEquals(2, lastIndexOf);
        assertEquals(-1, indexOfNonExistingEl);
    }

    @Test
    public void shouldReturnListIterator() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        ListIterator<Long> listIterator = listOfNumbers.listIterator();
        //then
        assertEquals(0, listIterator.nextIndex());
        assertEquals(1L, listIterator.next());
    }

    @Test
    public void shouldReturnListIteratorAtSpecPosition() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        //when
        ListIterator<Long> listIterator = listOfNumbers.listIterator(1);
        //then
        assertEquals(1, listIterator.nextIndex());
        assertEquals(2L, listIterator.next());
    }

    @Test
    public void shouldReturnSubListFromBaseList() {
        //given
        List<Long> listOfNumbers = createList();
        listOfNumbers.add(1L);
        listOfNumbers.add(2L);
        listOfNumbers.add(3L);
        listOfNumbers.add(4L);
        //when
        List<Long> sublist = listOfNumbers.subList(1, 2);
        //then
        assertEquals(2L, sublist.get(0));
        assertEquals(1, sublist.size());
    }
}
