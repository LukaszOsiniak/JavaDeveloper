package pl.coderstrust.christmastree;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put size of Christmas Tree:");
        int size = scan.nextInt();
        getChristmasTree(size);
    }

    public static String[] getChristmasTree(int size) {
        if (size < 3) {
            throw new IllegalArgumentException("Provided size cannot be lower than 3");
        }
        String[] result = new String[size + 1];
        String space = " ";
        String asterisk = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                sb.append(space);
            }
            for (int j = 0; j < (i + 1) * 2 - 1; j++) {
                sb.append(asterisk);
            }
            result[i] = sb.toString();
            sb.setLength(0);
        }
        for (int i = 0; i < size - 2; i++) {
            sb.append(space);
        }
        sb.append(asterisk).append(asterisk);
        result[size] = sb.toString();
        return result;
    }
}
