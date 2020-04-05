package pl.coderstrust.numbersfromfile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfNumbersFromFile {
    public static void main(String[] args) {
        try {
            List<String> resultLines = readingNumbersFromFile();
            saveStringToFile(resultLines);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public static List<String> readingNumbersFromFile() throws FileNotFoundException {
        File file = new File("D:\\code\\solutions-18-lukasz\\src\\main\\java\\pl\\coderstrust\\numbersfromfile\\numbers.txt");
        Scanner scanFile = new Scanner(file);
        List<String> resultLines = new ArrayList<>();
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String formattedLine = readAndFormatLine(line);
            resultLines.add(formattedLine);
            System.out.println(formattedLine);
        }
        scanFile.close();
        return resultLines;
    }

    private static String readAndFormatLine(String line) {
        StringBuilder sb = new StringBuilder();
        Scanner scanLine = new Scanner(line);
        int sum = 0;
        while (scanLine.hasNext()) {
            String token = scanLine.next();
            sb.append(token);
            if (scanLine.hasNext()) {
                sb.append("+");
            }
            sum += Integer.parseInt(token);
        }
        sb.append("=").append(sum);
        return sb.toString();
    }

    private static void saveStringToFile(List<String> lines) throws IOException {
        Path path = Paths.get("D:\\code\\solutions-18-lukasz\\src\\main\\java\\pl\\coderstrust\\numbersfromfile\\summingNumbers.txt");
        Files.write(path, lines);
    }
}
