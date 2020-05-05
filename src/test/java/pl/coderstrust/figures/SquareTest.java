package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquareTest extends FigureTest {

    @ParameterizedTest
    @MethodSource("providedSideAndExpectedArea")
    public void shouldReturnCorrectAreaValue(double side, double area) {
        //Given
        Square square = new Square(side);
        //When
        double result = square.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedSideAndExpectedArea() {
        return Stream.of(
                arguments(5, 25),
                arguments(2, 4)
        );
    }
}
