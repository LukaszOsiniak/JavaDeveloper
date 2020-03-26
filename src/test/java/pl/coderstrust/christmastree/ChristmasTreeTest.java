package pl.coderstrust.christmastree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChristmasTreeTest {
    @ParameterizedTest
    @MethodSource("christmasTreeArguments")
    void shouldReturnCorrectChristmasTree(int size, String lineExpected, int row) {
        //When
        String[] actual = ChristmasTree.getChristmasTree(size);

        //Then
        assertEquals(lineExpected, actual[row]);
    }

    static Stream<Arguments> christmasTreeArguments() {
        return Stream.of(
                arguments(5, "    *", 0),
                arguments(5, "   ***", 1),
                arguments(5, "  *****", 2),
                arguments(5, " *******", 3),
                arguments(5, "*********", 4),
                arguments(5, "   **", 5),
                arguments(7, "      *", 0),
                arguments(7, "*************", 6),
                arguments(7, "     **", 7),
                arguments(12, "           *", 0),
                arguments(12, "          **", 12)
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
