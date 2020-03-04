package pl.coderstrust.MultiplicationTable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wymiar tablicy: ");
        int size = scan.nextInt();
        printMultiplicationTable(size);
    }

    public static void printMultiplicationTable(int size) {
        int i;
        int j;
        for (i = 0; i < (size + 1); i++) {
            for (j = 0; j < (size + 1); j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j == 0) {
                        System.out.print("  ");
                    } else {
                        if (i == 0) {
                            System.out.print(" " + j + " ");
                        } else {
                            System.out.print(" " + i + " ");
                        }
                    }
                } else {
                    System.out.print(" " + (i * j) + " ");
                }
            }
            System.out.println(" ");
        }
    }
}