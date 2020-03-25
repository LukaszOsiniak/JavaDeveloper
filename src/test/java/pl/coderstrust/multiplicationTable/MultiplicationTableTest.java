package pl.coderstrust.multiplicationTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTableTest {

    @Test
    public void shouldReturnValidTable() {
        //Given
        int[][] expectedArray = {{1, 2}, {2, 4}};
        int size = 3;

        //When
        int[][] actualArray = MultiplicationTable.printMultiplicationTable(size);
        int[][] subArray = createSubArray(actualArray, 1, 1);
        //Then
        assertArrayEquals(expectedArray, subArray);

    }

    private int[][] createSubArray(int[][] array, int startRow, int startColumn) {
        int newSizeRows = array.length - startRow;
        int newSizeColumns = array[0].length - startColumn;
        int[][] subArray = new int[newSizeRows][newSizeColumns];
        for (int i = startRow; i < array.length; i++) {
            for (int j = startColumn; j < array.length; j++) {
                subArray[i - startRow][j - startColumn] = array[i][j];
            }
        }
        return subArray;
    }

    @Test
    public void shouldReturnCorrectValue() {
        //Given
        int expectedValue = 16;
        int size = 10;
        //When
        int[][] actualArray = MultiplicationTable.printMultiplicationTable(size);

        //Then
        assertEquals(expectedValue, actualArray[4][4]);

    }
}
