package pl.coderstrust.christmastree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChristmasTreeTest {
    @ParameterizedTest
    @MethodSource("christmasTreeArguments")
    void shouldReturnCorrectChristmasTree(int size, String[] expected) {
        //When
        String[] actual = ChristmasTree.getChristmasTree(size);

        //Then
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> christmasTreeArguments() {
        return Stream.of(
                arguments(5, new String[]{"    *", "   ***", "  *****", " *******", "*********", "   **"}),
                arguments(7, new String[]{"      *", "     ***", "    *****", "   *******", "  *********", " ***********", "*************", "     **"})
        );
    }

    @Test
    void shouldThrowException() {
        //Given
        int size = 2;

        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ChristmasTree.getChristmasTree(size));

        //Then
        assertEquals(exception.getMessage(), "Provided size cannot be lower than 3");
    }
}
