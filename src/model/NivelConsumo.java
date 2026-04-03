package model;

import java.awt.Color;
import java.math.BigDecimal;

public enum NivelConsumo {
	
	ALTO(0.8, Color.YELLOW),
    MEDIOALTO(0.6, Color.RED),
    MEDIO(0.4, Color.BLUE),
    MEDIOBAJO(0.2, Color.GREEN),
    BAJO(0.0, Color.BLACK);

    private final Color color;
    private final BigDecimal minimo;

    NivelConsumo(double minimo, Color color) {
        this.minimo = BigDecimal.valueOf(minimo);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static NivelConsumo fromPromedio(BigDecimal promedio) {
        for (NivelConsumo nivel : values()) {
            if (promedio.compareTo(nivel.minimo) >= 0) {
                return nivel;
            }
        }
        return BAJO;
    }
}
