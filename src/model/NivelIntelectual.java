package model;

import java.awt.Color;

public enum NivelIntelectual {

    ALTO(0.8, Color.YELLOW),
    MEDIOALTO(0.6, Color.RED),
    MEDIO(0.4, Color.BLUE),
    MEDIOBAJO(0.2, Color.GREEN),
    BAJO(0.0, Color.BLACK);

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
