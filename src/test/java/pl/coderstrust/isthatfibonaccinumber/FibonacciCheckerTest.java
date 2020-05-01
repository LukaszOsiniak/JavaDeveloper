package pl.coderstrust.isthatfibonaccinumber;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciCheckerTest {

    @Test
    public void shouldCheckIfFibonacciNumber() throws IOException {
        List<String> fibonacciNumbers = Files.readAllLines(Path.of("src\\test\\resources\\fibonacciNumbers.txt"));
        for (String number : fibonacciNumbers) {
            //when
            boolean isFibonacci = FibonacciChecker.isFibonacciNumber(Long.parseLong(number));
            //then
            assertTrue(isFibonacci);
        }
    }
}
