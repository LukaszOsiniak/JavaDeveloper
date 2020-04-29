package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest extends FigureTest {

    @ParameterizedTest
    @MethodSource("providedValues")
    public void shouldReturnCorrectAreaValue(double sideA, double sideB, double area) {
        //given
        Rectangle rectangle = new Rectangle(sideA, sideB);
        //When
        double result = rectangle.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedValues() {
        return Stream.of(
                arguments(5, 6, 30),
                arguments(2, 6, 12)
        );
    }
}
