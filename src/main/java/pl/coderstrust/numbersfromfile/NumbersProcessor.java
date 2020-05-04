package pl.coderstrust.numbersfromfile;

import java.util.Scanner;

public class NumbersProcessor {

    public String processLine(String line) {
        StringBuilder strBuilder = new StringBuilder();
        Scanner scanLine = new Scanner(line);
        int sum = 0;
        while (scanLine.hasNext()) {
            int token = scanLine.nextInt();
            strBuilder.append(token);
            if (scanLine.hasNext()) {
                strBuilder.append("+");
            }
            sum += token;
        }
        strBuilder.append("=").append(sum);
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanLine = new Scanner("a 1 2");
        while (scanLine.hasNext()) {
            int token = scanLine.nextInt();
            System.out.println(token);
        }
    }
}
