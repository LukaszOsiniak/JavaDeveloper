package pl.coderstrust.numbersfromfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName) throws IOException {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            if (!line.isEmpty()) {
                try {
                    resultLines.add(numbersProcessor.processLine(line));
                } catch (NumberFormatException e) {
                    //continue
                }
            }
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }

    public static void main(String[] args) throws IOException {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process("src/test/resources/1000.txt", "src/main/java/pl/coderstrust/numbersfromfile/summingNumbers.txt");
    }
}
