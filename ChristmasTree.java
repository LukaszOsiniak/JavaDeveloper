package pl.coderstrust.ChristmasTree;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wymiar choinki: ");
        int size = scan.nextInt();
        printChristmasTree(size);
    }

    public static void printChristmasTree(int size) {
        for (int i = 0; i <= size; i++) {
            for (int k = 0; k < ((size * 2) - 1); k++) {
                if (i != size) {
                    if (k < (size - 1 - i) || k > (size - 1 + i)) {
                        System.out.print(" ");
                    } else if (k < size || k > size) {
                        System.out.print("*");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    if (k == (size - 1) || k == (size - 2)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}