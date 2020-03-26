package pl.coderstrust.christmastree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChristmasTreeTest {
    @ParameterizedTest
    @MethodSource("inputAndExpectedOutput")
    void printChristmasTree(int size, String lineExpected, int row) {
        //Given
        //int size = 4;
        //When
        String[] actual = ChristmasTree.printChristmasTree(size);
        //Then
        assertEquals(lineExpected, actual[row]);
    }

    static Stream<Arguments> inputAndExpectedOutput() {
        return Stream.of(
                arguments(5, "  *****", 2),
                arguments(7, "*************", 6)
        );
    }

//    @ParameterizedTest
//    @MethodSource("trunkAtTheRightPlace")
//    @Test
//    void printChristmasTree1(int size, String[] arrayExpected) {
//        //Given
//
//        //When
//        String[] actual = ChristmasTree.printChristmasTree(size);
//        //Then
//        assertEquals(arrayExpected, actual[size]);
//    }
//    static Stream<Arguments> trunkAtTheRightPlace() {
//        return Stream.of(
//                arguments(5, new String[], 3),
//                arguments(7, )
//        );
//    }
}
