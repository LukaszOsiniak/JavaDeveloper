package pl.coderstrust.letssortandcomparethetimes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @MethodSource("getCommonArguments")
    public void shouldSortArray(int[] arrayToSort, int[] rightOutput) {
        long startTime = System.currentTimeMillis();
        //when
        int[] sortedArray = getSortingMethod().sort(arrayToSort);
        long endTime = System.currentTimeMillis();
        System.out.println(getSortingMethod().getClass().getCanonicalName() + " " + (endTime - startTime));
        //then
        assertArrayEquals(rightOutput, sortedArray);
    }

    static int[] oneThousand = new int[1000];
    static int[] oneHundredThousands = new int[100000];
    static int[] oneMillion = new int[1000000];
    static int[] sortedOneThousand;
    static int[] sortedOneHundredThousand;
    static int[] sortedOneMillion;

    static {
        setupRandomData(oneThousand);
        sortedOneThousand = oneThousand.clone();
        Arrays.sort(sortedOneThousand);

        setupRandomData(oneHundredThousands);
        sortedOneHundredThousand = oneHundredThousands.clone();
        Arrays.sort(sortedOneHundredThousand);

        setupRandomData(oneMillion);
        sortedOneMillion = oneMillion.clone();
        Arrays.sort(sortedOneMillion);
    }

    static void setupRandomData(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt();
        }
    }

    static Stream<Arguments> getCommonArguments() {
        return Stream.of(
                arguments(new int[]{1}, new int[]{1}),
                arguments(new int[]{1, 2}, new int[]{1, 2}),
                arguments(new int[]{1, 2, 1}, new int[]{1, 1, 2}),
                arguments(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                arguments(new int[]{54, 32, 78, 1}, new int[]{1, 32, 54, 78}),
                arguments(new int[]{-56, 123, 100, 39, 66, 12, -7}, new int[]{-56, -7, 12, 39, 66, 100, 123}),
                arguments(oneThousand, sortedOneThousand),
                arguments(oneHundredThousands, sortedOneHundredThousand),
                arguments(oneMillion, sortedOneMillion)
        );
    }
}
