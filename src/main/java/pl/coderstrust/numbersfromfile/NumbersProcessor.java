package pl.coderstrust.numbersfromfile;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        StringBuilder strBuilder = new StringBuilder();
        Scanner scanLine = new Scanner(line);
        int sum = 0;
        while (scanLine.hasNext()) {
            String token = scanLine.next();
            strBuilder.append(token);
            if (scanLine.hasNext()) {
                strBuilder.append("+");
            }
            sum += Integer.parseInt(token);
        }
        strBuilder.append("=").append(sum);
        return strBuilder.toString();
    }
}
