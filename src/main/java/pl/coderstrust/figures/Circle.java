package pl.coderstrust.figures;

public class Circle implements Figure{

    private double radius;
    final double CONSTANT_PI = 3.14;

    public Circle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return CONSTANT_PI*radius*radius;
    }
}
