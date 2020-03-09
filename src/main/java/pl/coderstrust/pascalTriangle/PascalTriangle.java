package pl.coderstrust.pascalTriangle;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(factorial(4));
//        int levels = 4;
//        for (int i = 0; i < levels; i++) {
//            for (int k = 0; k < (levels - i - 1); k++) {
//                System.out.print("*");
//            }
//            for (int j = 0; j < (i + 1); j++) {
//                System.out.printf("%2d", j + 1);
//            }
//            System.out.println();
//        }
    }

    public static int calcNumber(int wzór) {
        int result = 0;


        return result;
    }

    public static int factorial(int number) {
        int x = 1;
        for (int i = 0; i < number; i++) {
            x = x * (i + 1);
        }
        return x;
    }
}

