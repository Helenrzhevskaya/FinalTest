package homework4;

import java.util.Arrays;

public class Triangle {

    public Triangle() {
    }

    public static double calculatingTheAreaOfTriangle(double a, double b, double c) throws Exception {
        System.out.println("Этот метод расчитает площадь треугольника");
        if (a + b < c || a + c < b || b + c < a) {
            throw new Exception("Эти стороны не образуют треугольника");

        }
        double p = (a + b + c) / 2.0;
        System.out.println("Perimeter:" + p);

        double square = (p * (p - a) * (p - b) * (p - c));
        System.out.println(square);

        return p;
    }
}
