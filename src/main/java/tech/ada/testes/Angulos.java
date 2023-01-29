package tech.ada.testes;

import java.util.ArrayList;
import java.util.List;

public class Angulos {

    public List<Double> calcula(double lado1, double lado2, double lado3) {
        List<Double> angles = new ArrayList<>();
        var sides = new double[] { lado1, lado2, lado3 };
        for (int i = 0; i < 3; i++) {
            double a = sides[i];
            double b = sides[(i + 1) % 3];
            double c = sides[(i + 2) % 3];
            double angle = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
            angles.add(angle);
        }
        return angles;
    }
}
