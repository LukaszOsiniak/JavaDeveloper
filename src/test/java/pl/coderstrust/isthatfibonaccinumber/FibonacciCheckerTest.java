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
        List<String> fibonacciNumbers = Files.readAllLines(Path.of("src\\test\\resources\\fibonacciNumbers.txt"));
        for (String number : fibonacciNumbers) {
            //when
            boolean isFibonacci = FibonacciChecker.isFibonacciNumber(Long.parseLong(number));
            //then
            assertTrue(isFibonacci);
        }
    }

    @Test
    public void shouldReturnFalseForNotFibonacciNumber() {
        //given
        List<Long> nonFibonacci = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            long randomNumber = random.nextLong();
            if (!FibonacciChecker.isFibonacciNumber(randomNumber)) {
                nonFibonacci.add(random.nextLong());
            }
        }
        for (Long number : nonFibonacci) {
            //when
            boolean isFibonacci = FibonacciChecker.isFibonacciNumber(number);
            //then
            assertFalse(isFibonacci);
        }
    }
}
