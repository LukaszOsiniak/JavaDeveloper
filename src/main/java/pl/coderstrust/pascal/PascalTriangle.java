package pl.coderstrust.pascal;

import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbę poziomów:");
        int levels = scan.nextInt();

        printpascalTriangle(levels);
    }

    public static void printpascalTriangle(int levels) {
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < (levels - i - 1); j++) {
                System.out.printf("%2s", "");
            }
            for (int j = 0; j < (i + 1); j++) {
                System.out.printf("%4d", calculateValue(i, j));
            }
            System.out.println();
        }
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
