package abstractgeometricshapes;

import java.util.List;

public abstract class GeometricShape {

    private double x;
    private double y;

    public abstract double perimeter();

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void print(List<GeometricShape> l) {
        for (GeometricShape g : l) {
            System.out.println(g.perimeter());
        }
    }

}
