package pl.coderstrust.figures;

public class Trapezoid implements Figure {

    @Override
    public double calculateArea() {
        return ((baseA+baseB)/2)*height;
    }

    private double baseA;
    private double baseB;
    private double height;
    //1/2(a+b)*h
}
