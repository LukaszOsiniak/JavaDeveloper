package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class ProcessorIntegrationTest {
    private static Processor processor;
    private static final String RESULT_FILE_NAME = "1000result.txt";

    @BeforeAll
    public static void processorInitialization() throws IOException {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        processor = new Processor(numbersProcessor, fileProcessor);
        Files.deleteIfExists(Paths.get(RESULT_FILE_NAME));
    }

    @Test
    public void shouldCreateValidProcessedFile() throws IOException {
        //Given
        String inputFile = "src/test/resources/1000.txt";
        String expectedFile = "src/test/resources/1000expected.txt";

        //When
        processor.process(inputFile, RESULT_FILE_NAME);

        //Then
        assertLinesMatch(Files.readAllLines(Paths.get(expectedFile)), Files.readAllLines(Paths.get(RESULT_FILE_NAME)));
    }
}
