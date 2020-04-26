package pl.coderstrust.figures;

public class Triangle implements Figure {

    @Override
    public double calculateArea() {
        return (base*height)/2;
    }

    private double base;
    private double height;
    //a*h/2
}
