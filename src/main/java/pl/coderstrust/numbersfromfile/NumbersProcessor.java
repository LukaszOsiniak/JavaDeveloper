package pl.coderstrust.numbersfromfile;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NumbersProcessor {

    private static final String VALID_LINE_REGEX = "^(\\s*\\d+)+\\s*$";
    private static final Pattern VALID_LINE_PATTERN = Pattern.compile(VALID_LINE_REGEX);

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

    public static boolean isLineValid(String line) {
        if (line == null) {
            return false;
        }
        return VALID_LINE_PATTERN.matcher(line).matches();
    }
}
