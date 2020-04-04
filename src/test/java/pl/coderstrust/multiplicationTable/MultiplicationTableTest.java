package pl.coderstrust.multiplicationTable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultiplicationTableTest {
    @ParameterizedTest
    @MethodSource("inputSizeAndExpectedTable")
    public void shouldReturnValidTable(int size, int[][] expectedArray) {
        //When
        int[][] actualArray = MultiplicationTable.createMultiplicationTable(size);
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

    static Stream<Arguments> inputSizeAndExpectedTable() {
        return Stream.of(
                arguments(3, new int[][]{{1, 2}, {2, 4}}),
                arguments(5, new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}})
        );
    }

    @ParameterizedTest
    @MethodSource("sizeExpectedValue")
    public void shouldReturnCorrectValue(int size, int expectedValue, int rowIndex, int columnIndex) {
        //When
        int[][] actualArray = MultiplicationTable.createMultiplicationTable(size);
        //Then
        assertEquals(expectedValue, actualArray[rowIndex][columnIndex]);
    }

    static Stream<Arguments> sizeExpectedValue() {
        return Stream.of(
                arguments(5, 16, 4, 4),
                arguments(6, 20, 4, 5),
                arguments(10, 72, 8, 9)
        );
    }
}
