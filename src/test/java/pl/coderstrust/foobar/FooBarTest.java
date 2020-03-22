package pl.coderstrust.foobar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {
    @Test
    public void shouldReturnValidArray() {
        //Given
        int size = 5;
        String[] arrayExpected = new String[]{"0 FooBar", "1 ", "2 ", "3 Foo", "4 "};

        //When
        String[] actual = FooBar.printFooBar(size);

        //Then
        assertArrayEquals(arrayExpected, actual);
    }

    @Test
    public void shouldReturnValueWithBar() {
        //Given
        int size = 100;
        String expectedAtIndex70 = "70 Bar";

        //When
        String[] actual = FooBar.printFooBar(size);

        //Then
        assertEquals(expectedAtIndex70, actual[70]);
    }

    @Test
    public void shouldReturnValueWithFooBar() {
        //Given
        int size = 100;
        String expectedAtIndex90 = "90 FooBar";

        //When
        String[] actual = FooBar.printFooBar(size);

        //Then
        assertEquals(expectedAtIndex90, actual[90]);
    }
}
