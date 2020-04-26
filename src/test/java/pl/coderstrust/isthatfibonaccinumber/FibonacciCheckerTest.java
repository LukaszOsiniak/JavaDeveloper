package pl.coderstrust.isthatfibonaccinumber;

import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FibonacciCheckerTest {

    private FibonacciChecker fibonacciChecker;

    @Before
    public void initialize() {
        fibonacciChecker = new FibonacciChecker();
    }

    @ParameterizedTest
    @MethodSource("getNumberAndResult")
    public void shouldCheckIfFibonacciNumber(long number, boolean checker) {
        //when
        boolean checkedNumber = fibonacciChecker.isFibonacciNumber(number);

        //then
        assertEquals(checkedNumber, checker);
    }

    static Stream<Arguments> getNumberAndResult() {
        return Stream.of(
                Arguments.arguments(-1, false),
                Arguments.arguments(0, false),
                Arguments.arguments(1, true),
                Arguments.arguments(2, true),
                Arguments.arguments(3, true),
                Arguments.arguments(4, false),
                Arguments.arguments(5, true),
                Arguments.arguments(10, false),
                Arguments.arguments(13, true),
                Arguments.arguments(15, false),
                Arguments.arguments(256, false)
        );
    }
}
