package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class ProcessorIntegrationTest {
    private static Processor processor;

    @BeforeAll
    public static void processorInitialization() {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        processor = new Processor(numbersProcessor, fileProcessor);
    }

    @Test
    public void shouldCreateValidProcessedFile() throws IOException {
        //Given
        String inputFile = "src/test/resources/1000.txt";
        String expectedFile = "src/test/resources/1000expected.txt";
        String resultFile = "1000result.txt";

        //When
        processor.process(inputFile, resultFile);

        //Then
        assertLinesMatch(Files.readAllLines(Paths.get(expectedFile)), Files.readAllLines(Paths.get(resultFile)));
    }
}
