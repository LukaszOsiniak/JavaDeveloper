package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TriangleTest extends FigureTest {

    @ParameterizedTest
    @MethodSource("providedBaseHeightAndExpectedArea")
    public void shouldReturnCorrectAreaValue(double base, double height, double area) {
        //Given
        Triangle triangle = new Triangle(base, height);
        //When
        double result = triangle.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedBaseHeightAndExpectedArea() {
        return Stream.of(
                arguments(4, 4, 8),
                arguments(0.2, 25, 2.5)
        );
    }
}
