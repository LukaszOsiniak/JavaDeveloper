package pl.coderstrust.figures;

public class Circle implements Figure{

    @Override
    public double calculateArea() {
        return CONSTANT_PI*radius*radius;
    }

    private double radius;
    final double CONSTANT_PI = 3.14;
    // pi*r^2
}
