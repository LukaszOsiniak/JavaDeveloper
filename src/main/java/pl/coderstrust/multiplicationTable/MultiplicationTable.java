package pl.coderstrust.multiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wymiar tablicy:");
        int size = scan.nextInt();
        printMultiplicationTable(size);
    }

    public static String[][] printMultiplicationTable(int size) {
        String[][] matrix = new String[size][size];
        System.out.format("%4s", "");
        matrix[0][0] = "";
        for (int i = 1; i < size; i++) {
            matrix[0][i] = String.valueOf(i);
            System.out.format("%4d", i);
        }
        System.out.println();
        for (int i = 1; i < size; i++) {
            matrix[i][0] = String.valueOf(i);
            System.out.format("%4d", i);
            for (int j = 1; j < size; j++) {
                matrix[i][j] = String.valueOf(i * j);
                System.out.format("%4d", i * j);
            }
            System.out.println();
        }
        return matrix;
    }
}
