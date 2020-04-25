package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class ProcessorTest {
    @Mock
    NumbersProcessor numbersProcessor;
//    @Before
//    public void createMocks() {
//        MockitoAnnotations.initMocks(this);
//    }
    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        // given
        when(fileProcessor.readLinesFromFile("fileName.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6"));
        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");

        // when
        processor.process("fileName.txt", "output.txt");

        // then
        verify(fileProcessor).readLinesFromFile("src/test/resources/1000.txt");
        verify(numbersProcessor).processLine("1 2 3");
        verify(fileProcessor).writeLinesToFile(Arrays.asList("1+2+3=6"),  "src/main/java/pl/coderstrust/numbersfromfile/summingNumbers.txt");
    }
}
