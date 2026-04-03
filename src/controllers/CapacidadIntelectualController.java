package controllers;

import java.util.Hashtable;

import javax.swing.JPanel;

import entities.Pais;
import model.NivelIntelectual;
import views.MapaPanel;

public class CapacidadIntelectualController extends UseCaseControleller{
	
	public static void mostrarCapacidadIntelectual(Hashtable<String,Pais> paises, MapaPanel panelMapa) {
		for(String cvPais:paises.keySet()) {
			Pais pais=paises.get(cvPais);
			for(String cvSector:pais.getSectores().keySet()) {
				JPanel panelRegion=panelMapa.getPanelIJ(pais.getSectores().get(cvSector).getCoordenadaX(), pais.getSectores().get(cvSector).getCoordenadaY());
				
				double promedio = pais.getSectores().get(cvSector).getCoeficienteMentalPromedio();

				NivelIntelectual nivel = NivelIntelectual.fromPromedio(promedio);
				panelRegion.setBackground(nivel.getColor());
			}
		}
	}

}
