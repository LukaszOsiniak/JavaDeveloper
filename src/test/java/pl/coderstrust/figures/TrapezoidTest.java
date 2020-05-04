package pl.coderstrust.figures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TrapezoidTest {

    @ParameterizedTest
    @MethodSource("providedBasesHeightAndExpectedArea")
    public void shouldReturnCorrectAreaValue(double baseA, double baseB, double height, double area) {
        //Given
        Trapezoid trapezoid = new Trapezoid(baseA, baseB, height);
        //When
        double result = trapezoid.calculateArea();
        //Then
        assertEquals(result, area);
    }

    static Stream<Arguments> providedBasesHeightAndExpectedArea() {
        return Stream.of(
                arguments(3, 4, 6, 21),
                arguments(0.88, 4, 5, 12.2)
        );
    }
}
