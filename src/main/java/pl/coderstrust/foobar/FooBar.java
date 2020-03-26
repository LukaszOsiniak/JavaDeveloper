package pl.coderstrust.foobar;

public class FooBar {
    public static void main(String[] args) {
        int number = 100;
        printFooBar(number);
    }

    public static String[] printFooBar(int number) {
        String[] newArray = new String[number];
        String space = " ";
        String foo = "Foo";
        String bar = "Bar";
        for (int i = 0; i < number; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i).append(space);
            if (i % 3 == 0) {
                builder.append(foo);
            }
            if (i % 5 == 0) {
                builder.append(bar);
            }
            System.out.println(builder.toString());
            newArray[i] = builder.toString();
        }
        return newArray;
    }
}
