package pl.coderstrust.foobar;

public class FooBar {
    public static void main(String[] args) {
        int number = 100;
        printFooBar(number);
    }

    public static String[] printFooBar(int number) {
        String[] newArray = new String[number];
        for (int i = 0; i < number; i++) {
            String tempStr;
            tempStr = i + " ";
            if (i % 3 == 0) {
                tempStr = tempStr + "Foo";
            }
            if (i % 5 == 0) {
                tempStr = tempStr + "Bar";
            }
            System.out.println(tempStr);
            newArray[i] = tempStr;
        }
        return newArray;
    }
}
