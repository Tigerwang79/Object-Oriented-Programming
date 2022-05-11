package abstractgeometricshapes;

public class Rectangle extends GeometricShape {

    private final double WIDTH;
    private final double LENGTH;

    public Rectangle(double w, double l) {
        this.WIDTH = w;
        this.LENGTH = l;
    }

    @Override
    public double perimeter() {
        return (this.LENGTH + this.WIDTH) * 2;
    }

}
