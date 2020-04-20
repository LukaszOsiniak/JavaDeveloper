package pl.coderstrust.letssortandcomparethetimes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @ParameterizedTest
    @MethodSource("getCommonArguments")
    public void shouldSortArray(int[] arrayToSort, int[] rightOutput) {
        //when
        long startTime = System.currentTimeMillis();
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
        Random r = new Random();
        for (int i = 0; i < oneThousand.length; i++) {
            oneThousand[i] = r.nextInt();
        }
        sortedOneThousand = oneThousand.clone();
        Arrays.sort(sortedOneThousand);

        for (int i = 0; i < oneHundredThousands.length; i++) {
            oneHundredThousands[i] = r.nextInt();
        }
        sortedOneHundredThousand = oneHundredThousands.clone();
        Arrays.sort(sortedOneHundredThousand);

        for (int i = 0; i < oneMillion.length; i++) {
            oneMillion[i] = r.nextInt();
        }
        sortedOneMillion = oneMillion.clone();
        Arrays.sort(sortedOneMillion);
    }

    static Stream<Arguments> getCommonArguments() {
        return Stream.of(
                Arguments.arguments(new int[]{1}, new int[]{1}),
                Arguments.arguments(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.arguments(new int[]{1, 2, 1}, new int[]{1, 1, 2}),
                Arguments.arguments(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                Arguments.arguments(new int[]{54, 32, 78, 1}, new int[]{1, 32, 54, 78}),
                Arguments.arguments(new int[]{-56, 123, 100, 39, 66, 12, -7}, new int[]{-56, -7, 12, 39, 66, 100, 123}),
                Arguments.arguments(oneThousand, sortedOneThousand),
                Arguments.arguments(oneHundredThousands, sortedOneHundredThousand),
                Arguments.arguments(oneMillion, sortedOneMillion)
        );
    }
}
