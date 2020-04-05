package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put number of levels in Pascal triangle:");
        int levels = scan.nextInt();
        printPascalTriangle(levels);
    }

    public static void printPascalTriangle(int levels) {
        List<String> triangle = createPascalTriangle(levels);

        for (int i = 0; i < triangle.size(); i++) {
            System.out.format("%" + (triangle.size() - i) + "s%s%n", "", triangle.get(i));
        }
    }

    public static List<String> createPascalTriangle(int levels) {
        if (levels < 1) {
            throw new IllegalArgumentException("Levels cannot be lower than zero");
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < (i + 1); j++) {
                sb.append(calculateValue(i, j)).append(" ");
            }
            result.add(sb.toString().trim());
            sb.setLength(0);
        }
        return result;
    }

    private static int calculateValue(int row, int column) {
        return factorial(row) / (factorial(column) * factorial(row - column));
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
