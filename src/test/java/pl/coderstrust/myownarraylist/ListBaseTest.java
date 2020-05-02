package pl.coderstrust.myownarraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListBaseTest {

    @Test
    public void shouldReturnSizeZeroWhenEmpty() {
        //given
        List<Long> listOfNumbers = new ArrayList<>();
        //when
        int size = listOfNumbers.size();
        //then
        assertEquals(0, size);
    }

    @Test
    public void shouldReturnCorrectSizeAfterAdd() {
        //given
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertTrue(isEmpty);
    }

    @Test
    public void shouldReturnFalseWhenAdded() {
        //given
        List<Long> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(1L);
        //when
        boolean isEmpty = listOfNumbers.isEmpty();
        //then
        assertFalse(isEmpty);
    }

    @Test
    public void containsShouldReturnTrue() {
        //given
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
        List<Long> listOfNumbers = new ArrayList<>();
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
}
