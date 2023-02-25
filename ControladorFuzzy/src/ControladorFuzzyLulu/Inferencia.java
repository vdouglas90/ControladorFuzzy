package ControladorFuzzyLulu;

import org.jfree.data.function.Function2D;

/**
 *
 * @author Luiz Bezerra
 */
public class Inferencia implements Function2D {

    private double funcTriangular;
    private double funcTrapezoidal;

    public Inferencia() {
       
    }

    @Override
    public double getValue(double d) {
        double ampX, ampY;
        double aux;

        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double funcTriangular(double x, double a, double b, double c) {
        funcTriangular = Math.max(Math.min((x - a) / (b - a), (c - x) / (c - b)), 0);
        return funcTriangular;
    }

    public double funcTrapezoidal(double x, double a, double b, double c, double d) {
        funcTrapezoidal = Math.max(Math.min((x - a) / (b - a), (d - x) / (d - c)), 0);
        return funcTriangular;
    }

    public double min(double a, double b) {
        return Math.min(a, b);
    }

    public double max(double a, double b) {
        return Math.max(a, b);
    }
}
