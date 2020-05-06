package pl.coderstrust.doyoulovestreams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class NumbersUsingStreamsTest {

    private static final String RESULT_FILE_NAME = "1000streamresult.txt";

    @BeforeAll
    public static void initialize() throws IOException {
        Files.deleteIfExists(Paths.get(RESULT_FILE_NAME));
    }

    @Test
    public void shouldProcessInputFileCorrectly() throws IOException {
        //Given
        String inputFile = "src/test/resources/1000.txt";
        String expectedFile = "src/test/resources/1000expected.txt";
        String resultFile = RESULT_FILE_NAME;

        //When
        NumbersUsingStreams.processNumbersFromFile(inputFile, resultFile);

        //Then
        assertLinesMatch(Files.readAllLines(Paths.get(expectedFile)), Files.readAllLines(Paths.get(resultFile)));
    }
}
