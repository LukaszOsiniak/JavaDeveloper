package pl.coderstrust.figures;

public class Trapezoid implements Figure {

    private double baseA;
    private double baseB;
    private double height;

    public Trapezoid(double baseA, double baseB, double height) {
        this.baseA = baseA;
        this.baseB = baseB;
        this.height = height;
    }

    public void setBaseA(double baseA) {
        this.baseA = baseA;
    }

    public void setBaseB(double baseB) {
        this.baseB = baseB;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseA() {
        return baseA;
    }

    public double getBaseB() {
        return baseB;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return ((baseA+baseB)/2)*height;
    }
}
