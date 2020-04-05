package pl.coderstrust.numbersfromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {
    public List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanFile = new Scanner(file);
        List<String> resultLines = new ArrayList<>();
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            resultLines.add(line);
        }
        scanFile.close();
        return resultLines;
    }

    public void writeLinesToFile(List<String> resultLines, String resultFileName) throws IOException {
        Path path = Paths.get(resultFileName);
        Files.write(path, resultLines);
    }
}
