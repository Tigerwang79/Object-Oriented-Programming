package abstractgeometricshapes;

public class Circle extends GeometricShape {

    private final double radius;

    public Circle(int r) {
        this.radius = r;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * radius);

    }

}
