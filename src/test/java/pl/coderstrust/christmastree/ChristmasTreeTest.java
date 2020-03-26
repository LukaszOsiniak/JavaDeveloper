package pl.coderstrust.christmastree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChristmasTreeTest {
    @ParameterizedTest
    @MethodSource("inputAndExpectedOutputAtRow")
    void printChristmasTree(int size, String lineExpected, int row) {
        //When
        String[] actual = ChristmasTree.printChristmasTree(size);
        //Then
        assertEquals(lineExpected, actual[row]);
    }

    static Stream<Arguments> inputAndExpectedOutputAtRow() {
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
}
