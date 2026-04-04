package controllers;

import java.util.Hashtable;

import constants.PaisesConstants;
import entities.paises.AbstractPaisFactory;
import entities.paises.Pais;
import views.MapaPanel;
import views.PrincipalView;

public class Principal {
	
	public static void main(String args[]) {
		Pais argentina = AbstractPaisFactory.crearPais(PaisesConstants.ARGENTINA);
		Pais brasil = AbstractPaisFactory.crearPais(PaisesConstants.BRASIL);
	    
	    MapaPanel panel = new MapaPanel();
	    
	    Hashtable<String,Object> componentes = new Hashtable<>();
	    Hashtable<String,Pais> paises = new Hashtable<>();
	    
	    paises.put("argentina", argentina);
	    paises.put("brasil", brasil);
	    componentes.put("Paises", paises);
	    componentes.put("PanelMapa", panel);

	    PrincipalView pantalla = new PrincipalView(componentes);
	}

}
