package pl.coderstrust.pascal;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put number of levels in Pascal triangle:");
        int levels = scan.nextInt();
        printPascalTriangle(levels);
    }

    public static void printPascalTriangle(int levels) {
        int[][] matrix = createPascalTriangle(levels);
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < (levels - i - 1); j++) {
                System.out.printf("%2s", "");
            }
            for (int j = 0; j < (i + 1); j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] createPascalTriangle(int levels) {
        if (levels < 1) {
            throw new IllegalArgumentException("Levels cannot be lower than zero");
        }
        int[][] result = new int[levels][levels];
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < (i + 1); j++) {
                result[i][j] = calculateValue(i, j);
            }
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
