package testing;

import java.util.Hashtable;

import constants.PaisesConstants;
import entities.*;
import views.MapaPanel;
import views.Principal;

public class Test3 {
	public static void main(String args[]) {

		
		Pais argentina = AbstractPaisFactory.crearPais(PaisesConstants.ARGENTINA);
	    System.out.println("Cantidad de Personas " + argentina.getCantidadPersonas());
	    System.out.println("Coeficiente Intelectual del pais " + argentina.getCoeficienteIntelectual());
	    System.out.println("Coeficiente Intelectual Promedio del pais " + argentina.getCoeficienteIntelectualPromedio());
	    System.out.println("Consumo del pais " + argentina.getConsumo());
	    System.out.println("Consumo per capita " + argentina.getConsumoPerCapita());
	    System.out.println();
	    
	    Pais brasil = AbstractPaisFactory.crearPais(PaisesConstants.BRASIL);
	    System.out.println("Cantidad de Personas " + brasil.getCantidadPersonas());
	    System.out.println("Coeficiente Intelectual del pais " + brasil.getCoeficienteIntelectual());
	    System.out.println("Coeficiente Intelectual Promedio del pais " + brasil.getCoeficienteIntelectualPromedio());
	    System.out.println("Consumo del pais " + brasil.getConsumo());
	    System.out.println("Consumo per capita " + brasil.getConsumoPerCapita());
		
	    
	    MapaPanel panel = new MapaPanel();
	    
	    Hashtable<String,Object> componentes = new Hashtable<>();
	    Hashtable<String,Pais> paises = new Hashtable<>();
	    
	    paises.put("argentina", argentina);
	    paises.put("brasil", brasil);
	    componentes.put("Paises", paises);
	    componentes.put("PanelMapa", panel);

	    Principal pantalla = new Principal(componentes);
	}
}
