package pl.coderstrust.multiplicationTable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultiplicationTableTest {
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

    @Test
    void shouldThrowException() {
        //Given
        int size = 0;
        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MultiplicationTable.createMultiplicationTable(size));
        //Then
        assertEquals(exception.getMessage(), "Size cannot be lower than 1");
    }
}
