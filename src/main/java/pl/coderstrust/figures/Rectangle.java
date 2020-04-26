package pl.coderstrust.figures;

public class Rectangle implements Figure{

    @Override
    public double calculateArea() {
        return sideA*sideB;
    }

    private double sideA;
    private double sideB;
    //a*b
}
