package pl.coderstrust.letssortandcomparethetimes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @Test
    public void shouldSortSimpleArray() {
        // given
        int[] given = new int[]{5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        // when
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();
        System.out.println(getSortingMethod().getClass().getCanonicalName() + " " + (endTime - startTime));
        // then
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("inputArray")
    public void shouldSortArray(int[] arrayToSort, int[] rightOutput) {
        //when
        int[] sortedArray = getSortingMethod().sort(arrayToSort);

        //then
        assertArrayEquals(rightOutput, sortedArray);
    }

    static Stream<Arguments> inputArray() {
        return Stream.of(
                Arguments.arguments(new int[]{1}, new int[]{1}),
                Arguments.arguments(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.arguments(new int[]{1, 2, 1}, new int[]{1, 1, 2}),
                Arguments.arguments(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                Arguments.arguments(new int[]{54, 32, 78, 1}, new int[]{1, 32, 54, 78}),
                Arguments.arguments(new int[]{123, -56, 12, 100, 66, 39, -7}, new int[]{-56, -7, 12, 39, 66, 100, 123})
        );
    }
}
