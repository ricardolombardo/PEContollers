package testing;

import constants.PaisesConstants;
import entities.*;
import entities.paises.AbstractPaisFactory;
import entities.paises.Pais;

public class Test3 {
	public static void main(String args[]) {
		Pais argentina = AbstractPaisFactory.crearPais(PaisesConstants.ARGENTINA);
		Pais brasil = AbstractPaisFactory.crearPais(PaisesConstants.BRASIL);
		
	    System.out.println("Cantidad de Personas " + argentina.getCantidadPersonas());
	    System.out.println("Coeficiente Intelectual del pais " + argentina.getCoeficienteIntelectual());
	    System.out.println("Coeficiente Intelectual Promedio del pais " + argentina.getCoeficienteIntelectualPromedio());
	    System.out.println("Consumo del pais " + argentina.getConsumo());
	    System.out.println("Consumo per capita " + argentina.getConsumoPerCapita());
	    System.out.println();
	    
	    
	    System.out.println("Cantidad de Personas " + brasil.getCantidadPersonas());
	    System.out.println("Coeficiente Intelectual del pais " + brasil.getCoeficienteIntelectual());
	    System.out.println("Coeficiente Intelectual Promedio del pais " + brasil.getCoeficienteIntelectualPromedio());
	    System.out.println("Consumo del pais " + brasil.getConsumo());
	    System.out.println("Consumo per capita " + brasil.getConsumoPerCapita());
		
	    
	}
}
