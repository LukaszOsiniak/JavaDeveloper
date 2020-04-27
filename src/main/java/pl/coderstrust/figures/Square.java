package pl.coderstrust.figures;

public class Square extends Rectangle implements Figure {

    @Override
    public double calculateArea() {
        return side*side;
    }

    public double getSide() {
        return side;
    }

    private double side;
    //a*a
}
