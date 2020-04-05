package pl.coderstrust.numbersfromfile;

import java.util.Scanner;

public class NumbersProcessor {
    public String processLine(String line) {
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
