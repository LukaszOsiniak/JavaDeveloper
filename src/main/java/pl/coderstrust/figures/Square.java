package pl.coderstrust.figures;

public class Square extends Rectangle implements Figure {

    @Override
    public double calculateArea() {
        return side*side;
    }

    private double side;
    //a*a
}
