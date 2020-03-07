package pl.coderstrust.multiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wymiar tablicy: ");
        int size = scan.nextInt();
        printMultiplicationTable(size);
    }

    public static void printMultiplicationTable(int size) {
        System.out.format("    ");
        for (int i = 1; i <= size; i++) {
            System.out.format("%4d", i);
        }
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.format("%4d", i);
            for (int j = 1; j <= size; j++) {
                System.out.format("%4d", i * j);
            }
            System.out.println();
        }
    }
}
