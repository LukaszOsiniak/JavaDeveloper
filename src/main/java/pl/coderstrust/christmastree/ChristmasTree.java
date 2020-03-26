package pl.coderstrust.christmastree;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please put size of Christmas Tree:");
        int size = scan.nextInt();
        printChristmasTree(size);
    }

    public static String[] printChristmasTree(int size) {
        String[] array = new String[size+1];
        String space = " ";
        String asterisk = "*";
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < size - i - 1; j++) {
                System.out.print(" ");
                builder.append(space);
            }
            for (int j = 0; j < (i + 1) * 2 - 1; j++) {
                System.out.print("*");
                builder.append(asterisk);
            }
            System.out.println();
            array[i] = builder.toString();
        }
        StringBuilder rootRowBuilder = new StringBuilder();
        for (int i = 0; i < size-2; i++) {
            System.out.print(" ");
            rootRowBuilder.append(space);
        }
        System.out.print("**");
        rootRowBuilder.append(asterisk).append(asterisk);
        array[size] = rootRowBuilder.toString();
        return array;
    }
}
