package pl.coderstrust.multiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please give size of multiplication table:");
        int size = scan.nextInt();
        printMultiplicationTable(size);
    }

    public static int[][] createMultiplicationTable(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size cannot be lower than 1");
        }
        int[][] matrix = new int[size + 1][size + 1];
        matrix[0][0] = -1;
        for (int i = 1; i < matrix.length; i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = i;
            for (int j = 1; j < matrix.length; j++) {
                matrix[i][j] = i * j;
            }
        }
        return matrix;
    }

    static void printMultiplicationTable(int size) {
        int[][] table = createMultiplicationTable(size);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (i == 0 && j == 0) {
                    System.out.format("%3s", "");
                } else {
                    System.out.format("%3d", table[j][i]);
                }
            }
            System.out.println();
        }
    }
}
