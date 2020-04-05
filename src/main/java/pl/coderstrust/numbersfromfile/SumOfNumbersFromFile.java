package pl.coderstrust.numbersfromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SumOfNumbersFromFile {
    public static void main(String[] args) {
        try {
            readingNumbersFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void readingNumbersFromFile() throws FileNotFoundException {
        File file = new File("D:\\code\\solutions-18-lukasz\\src\\main\\java\\pl\\coderstrust\\numbersfromfile\\numbers.txt");
        Scanner scanFile = new Scanner(file);
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String formattedLine = readAndFormatLine(line);
            System.out.println(formattedLine);
        }
        scanFile.close();
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
}
