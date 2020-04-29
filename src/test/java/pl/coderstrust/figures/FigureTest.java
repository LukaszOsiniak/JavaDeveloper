package pl.coderstrust.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {

    @Test
    public void shouldReturnCorrectAreaValue() {
        //given
        Figure figure = new Square(6);

        //When
        double result = figure.calculateArea();

        //Then
        assertEquals(result, 36);
    }
}
