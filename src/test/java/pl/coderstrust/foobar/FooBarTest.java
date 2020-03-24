package pl.coderstrust.foobar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class FooBarTest {
    @ParameterizedTest
    @MethodSource("inputAndExpectedProvider")
    public void shouldReturnValidArray(int size, String[] arrayExpected) {
        //When
        String[] actual = FooBar.printFooBar(size);

        //Then
        assertArrayEquals(arrayExpected, actual);
    }

    static Stream<Arguments> inputAndExpectedProvider() {
        return Stream.of(
                arguments(5, new String[]{"0 FooBar", "1 ", "2 ", "3 Foo", "4 "}),
                arguments(3, new String[]{"0 FooBar", "1 ", "2 "})
        );
    }

    @ParameterizedTest
    @MethodSource("sizeExpectedIndex")
    public void shouldReturnValueWithBar(int size, String expected, int index) {
        //When
        String[] actual = FooBar.printFooBar(size);

        //Then
        assertEquals(expected, actual[index]);
    }

    static Stream<Arguments> sizeExpectedIndex() {
        return Stream.of(
                arguments(100, "70 Bar", 70),
                arguments(100, "90 FooBar", 90),
                arguments(100, "27 Foo", 27)
        );
    }
}
