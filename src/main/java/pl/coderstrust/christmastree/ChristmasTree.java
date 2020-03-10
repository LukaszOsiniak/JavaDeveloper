package pl.coderstrust.christmastree;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj rozmiar choinki: ");
        int size = scan.nextInt();
        printChristmasTree(size);
    }

    public static void printChristmasTree(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i * 2 - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < (size - 1); i++) {
            System.out.print(" ");
        }
        System.out.print("**");
    }
}
