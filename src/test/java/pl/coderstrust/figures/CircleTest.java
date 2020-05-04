package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CircleTest extends FigureTest {

    @ParameterizedTest
    @MethodSource("providedRadiusAndExpectedArea")
    public void expectedArea(double radius, double area) {
        //Given
        Circle circle = new Circle(radius);
        //When
        double result = circle.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedRadiusAndExpectedArea() {
        return Stream.of(
                arguments(10, 314.1592653589793),
                arguments(0.66, 1.3684777599037141)
        );
    }
}
