package testing;

import java.util.Hashtable;

import entities.*;
import views.MapaPanel;
import views.Principal;

public class Test3 {
	public static void main(String args[]) {

		PaisFactory factory = new ArgentinaFactory();
		Pais argentina = factory.crearPais();

	    System.out.println("Cantidad de Personas " + argentina.getCantidadPersonas());
	    System.out.println("Coeficiente Intelectual del pais " + argentina.getCoeficienteIntelectual());
	    System.out.println("Coeficiente Intelectual Promedio del pais " + argentina.getCoeficienteMentalPromedio());
	    System.out.println("Consumo del pais " + argentina.getConsumo());
	    
	    
	    PaisFactory brasilFactory = new BrasilFactory();
		Pais brasil = brasilFactory.crearPais();
	    
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
