package pl.coderstrust.doyoulovestreams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class NumbersUsingStreamsTest {

    @Test
    public void shouldProcessInputFileCorrectly() throws IOException {
        //Given
        String inputFile = "src/test/resources/1000.txt";
        String expectedFile = "src/test/resources/1000expected.txt";
        String resultFile = "1000streamresult.txt";

        //When
        NumbersUsingStreams.processNumbersFromFile(inputFile, resultFile);

        //Then
        assertLinesMatch(Files.readAllLines(Paths.get(expectedFile)), Files.readAllLines(Paths.get(resultFile)));
    }
}
