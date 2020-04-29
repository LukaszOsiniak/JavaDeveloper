package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CircleTest extends FigureTest {

    @ParameterizedTest
    @MethodSource("providedValues")
    public void shouldReturnCorrectAreaValue(double radius, double area) {
        //given
        Circle circle = new Circle(radius);
        //When
        double result = circle.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedValues() {
        return Stream.of(
                arguments(10, 314),
                arguments(0.66, 1.367784)
        );
    }
}
