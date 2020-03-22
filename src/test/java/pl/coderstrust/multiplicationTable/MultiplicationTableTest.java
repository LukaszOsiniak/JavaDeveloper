package pl.coderstrust.multiplicationTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTableTest {
    @Test
    public void printMultiplicationTable() {
        //Given
        String[][] expectedArray = {{"", "1", "2"}, {"1", "1", "2"}, {"2", "2", "4"}};
        int size = 3;
        //When
        String[][] actualArray = MultiplicationTable.printMultiplicationTable(size);

        //Then
        assertArrayEquals(expectedArray, actualArray);

    }

    @Test
    public void printMultiplicationTable1() {
        //Given
        String expectedValue = "16";
        int size = 10;
        //When
        String[][] actualArray = MultiplicationTable.printMultiplicationTable(size);

        //Then
        assertEquals(expectedValue, actualArray[4][4]);

    }
}
