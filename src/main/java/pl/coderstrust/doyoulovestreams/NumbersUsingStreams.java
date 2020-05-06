package pl.coderstrust.doyoulovestreams;

import pl.coderstrust.numbersfromfile.NumbersProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.nio.file.Files.write;

public class NumbersUsingStreams {

    private static final String SPLIT_NUMBERS_REGEX = "\\s+";

    public static void processNumbersFromFile(String inputFilePath, String outputFilePath) throws IOException {
        Stream<String> myStream = Files.lines(Paths.get(inputFilePath));
        try {
            myStream.filter(line -> NumbersProcessor.isLineValid(line))
                    .map(line -> Arrays.stream(line.split(SPLIT_NUMBERS_REGEX)).filter(str -> !str.isEmpty())
                            .reduce((str1, str2) -> str1 + "+" + str2).get()
                            + "=" + Arrays.stream(line.split(SPLIT_NUMBERS_REGEX)).filter(str -> !str.isEmpty())
                            .mapToInt(numberStr -> Integer.parseInt(numberStr)).sum()
                    ).forEach(line -> {
                try {
                    write(Paths.get(outputFilePath), Arrays.asList(line), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        } finally {
            myStream.close();
        }
    }
}
