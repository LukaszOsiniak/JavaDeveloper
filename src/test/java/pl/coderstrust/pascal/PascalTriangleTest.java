package pl.coderstrust.pascal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PascalTriangleTest {
    @ParameterizedTest
    @MethodSource("pascalTriangleArguments")
    void shouldCreatePascalTriangle(int levels, int[][] numbers) {
        //When
        int[][] actual = PascalTriangle.createPascalTriangle(levels);

        //Then
        assertArrayEquals(numbers, actual);
    }

    static Stream<Arguments> pascalTriangleArguments() {
        return Stream.of(
                arguments(3, new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 2, 1}}),
                arguments(5, new int[][]{{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 2, 1, 0, 0},
                        {1, 3, 3, 1, 0}, {1, 4, 6, 4, 1}})
        );
    }

    @Test
    void shouldThrowExceptionForInvalidLevels() {
        //Given
        int levels = 0;

        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> PascalTriangle.printPascalTriangle(levels));

        //Then
        assertEquals(exception.getMessage(), "Levels cannot be lower than zero");
    }
}
