package model;

import java.awt.Color;

public enum NivelIntelectual {

    ALTO(0.6, Color.YELLOW),
    MEDIO(0.2, Color.BLUE),
    BAJO(0.0, Color.GREEN);

    private final double minimo;
    private final Color color;

    NivelIntelectual(double minimo, Color color) {
        this.minimo = minimo;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static NivelIntelectual fromPromedio(double promedio) {
        for (NivelIntelectual nivel : values()) {
            if (promedio >= nivel.minimo) {
                return nivel;
            }
        }
        return BAJO;
    }
}
