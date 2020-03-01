package pl.coderstrust;

public class Zadanie1 {

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if (i % 3 != 0 && i % 5 != 0 && i % 15 != 0) {
                System.out.println(i);
            } else if (i % 3 == 0 && i % 15 != 0) {
                System.out.println(i + " Foo");

            } else if (i % 5 == 0 && i % 15 != 0) {
                System.out.println(i + " Bar");
            } else if (i % 15 == 0) {
                System.out.println(i + " FooBar");

            }
        }
    }
}
