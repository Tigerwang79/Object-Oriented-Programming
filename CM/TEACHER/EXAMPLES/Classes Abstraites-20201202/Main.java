package abstractgeometricshapes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        //creating a GeometricShape list
        List<GeometricShape> l = new ArrayList<>();
        l.add(new Circle(2));
        l.add(new Circle(3));
        l.add(new Rectangle(2, 3));

        GeometricShape.print(l);

        //creating a stream s from l
        Stream<GeometricShape> s = l.stream();

        //computes the sum of the perimeter of circles
        double result
                = s.filter((x) -> (x instanceof Circle))
                .map(x -> x.perimeter())
                .reduce(0.0, (x, y) -> x + y);

        System.out.println(result);
    }

}
