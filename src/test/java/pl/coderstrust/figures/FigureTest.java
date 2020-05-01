package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FigureTest {

    @ParameterizedTest
    @MethodSource("providedFiguresAndExpectedArea")
    public void shouldReturnCorrectAreaValue(Figure figure, double expectedArea) {
        //When
        double result = figure.calculateArea();

        //Then
        assertEquals(expectedArea, result);
    }

    static Stream<Arguments> providedFiguresAndExpectedArea() {
        return Stream.of(
                arguments(new Square(6), 36),
                arguments(new Rectangle(4, 5), 20),
                arguments(new Circle(3), 28.274333882308138),
                arguments(new Triangle(6, 2), 6),
                arguments(new Trapezoid(6, 2, 1), 4)
        );
    }
}
