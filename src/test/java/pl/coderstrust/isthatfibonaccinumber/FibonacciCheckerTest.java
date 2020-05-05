package pl.coderstrust.isthatfibonaccinumber;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciCheckerTest {

    @Test
    public void shouldReturnTrueForFibonacciNumber() throws IOException {
        //given
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        List<String> fibonacciNumbers = Files.readAllLines(Path.of("src/test/resources/fibonacciNumbers.txt"));
        for (String number : fibonacciNumbers) {
            //when
            boolean isFibonacci = fibonacciChecker.isFibonacciNumber(Long.parseLong(number));
            //then
            assertTrue(isFibonacci, "Failed at number: " + number);
        }
    }

    @Test
    public void shouldReturnFalseForNotFibonacciNumber() throws IOException {
        //given
        FibonacciChecker fibonacciChecker = new FibonacciChecker();
        List<Long> nonFibonacciNumbers = getListOfNotFibbonaciNumbers();
        for (Long number : nonFibonacciNumbers) {
            //when
            boolean isFibonacci = fibonacciChecker.isFibonacciNumber(number);
            //then
            assertFalse(isFibonacci, "Failed at number:" + number);
        }
    }

    public static List<Long> getListOfNotFibbonaciNumbers() throws IOException {
        List<String> fibonacciNumbers = Files.readAllLines(Path.of("src/test/resources/fibonacciNumbers.txt"));
        List<Long> nonFibonacci = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            long randomNumber = random.nextLong();
            if (!fibonacciNumbers.contains(randomNumber)) {
                nonFibonacci.add(randomNumber);
            }
        }
        return nonFibonacci;
    }
}
