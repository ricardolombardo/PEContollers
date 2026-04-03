package controllers;

import java.math.BigDecimal;
import java.util.Hashtable;
import javax.swing.JPanel;
import entities.Pais;
import model.NivelConsumo;
import views.MapaPanel;

public class HabitoConsumoController extends UseCaseControleller{
	
	
	public static void mostrarHabitoConsumo(Hashtable<String,Pais> paises, MapaPanel panelMapa) {
		for(String cvPais:paises.keySet()) {
			Pais pais=paises.get(cvPais);
			for(String cvSector:pais.getSectores().keySet()) {
				//System.out.println("Consumo per capita de "+pais.getNombre()+": "+pais.getConsumoPerCapita());
				JPanel panelRegion=panelMapa.getPanelIJ(pais.getSectores().get(cvSector).getCoordenadaX(), pais.getSectores().get(cvSector).getCoordenadaY());
				
				BigDecimal promedio = pais.getSectores().get(cvSector).getConsumoPromedio();

				NivelConsumo nivel = NivelConsumo.fromPromedio(promedio);
				panelRegion.setBackground(nivel.getColor());
			}
		}
	}

}
