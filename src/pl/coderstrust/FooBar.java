package pl.coderstrust;

public class FooBar {
    public static void printFooBar(int number) {

        for (int i = 0; i < (number + 1); i++) {
            System.out.print(i + " ");

            if (i % 3 == 0) {
                System.out.print("Foo");
            }

            if (i % 5 == 0) {
                System.out.print("Bar");
            }

            System.out.println();

        }

    }

    public static void main(String[] args) {
        int number = 100;

        printFooBar(number);
    }
}

