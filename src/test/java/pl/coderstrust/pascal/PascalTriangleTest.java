package pl.coderstrust.pascal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PascalTriangleTest {
    @ParameterizedTest
    @MethodSource("inputAndExpectedOutput")
    void shouldCreatePascalTriangle(int levels, int[][] numbersExpected) {
        //When
        int[][] actual = PascalTriangle.createPascalTriangle(levels);

        //Then
        assertArrayEquals(numbersExpected, actual);
    }

    static Stream<Arguments> inputAndExpectedOutput() {
        return Stream.of(
                arguments(3, new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 2, 1}}),
                arguments(5, new int[][]{{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 2, 1, 0, 0},
                        {1, 3, 3, 1, 0}, {1, 4, 6, 4, 1}})
        );
    }
}