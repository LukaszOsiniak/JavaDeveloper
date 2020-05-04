package pl.coderstrust.doyoulovestreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.nio.file.Files.write;

public class NumbersUsingStreams {

    public static void main(String[] args) throws IOException {
        Stream<String> myStream = Files.lines(Paths.get("src\\main\\java\\pl\\coderstrust\\doyoulovestreams\\numbers.txt"));
        myStream.filter(e -> NumbersProcessor.isLineValid(e))
                .map(e -> Arrays.stream(e.split(" ")).reduce((str1, str2) -> str1 + "+" + str2).get()
                        + "=" + Arrays.stream(e.split(" ")).mapToInt(p -> Integer.parseInt(p)).sum()
                ).forEach(l -> {
            try {
                write(Paths.get("streamOutput.txt"), Arrays.asList(l), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
