package testing;

import java.util.Hashtable;
import constants.TipoRegion;
import entities.Ascendencia;
import entities.Pais;
import entities.Persona;
import entities.Sector;
import views.MapaPanel;
import views.Principal;

public class Test2 {

	static int id;
	
	public static void main(String args[]) {
		
		
		Hashtable<String,Sector> sectores=new Hashtable<String,Sector>();
		cargarSectores(sectores);
		Pais pais=cargarPais(sectores);
		
		System.out.println("Cantidad de Personas " + pais.getCantidadPersonas());
		System.out.println("Coeficiente Intelectual del pais " + pais.getCoeficienteIntelectual());
		System.out.println("Coeficiente Intelectual Promedio del pais " + pais.getCoeficienteMentalPromedio());
		System.out.println("Consumo del pais " + pais.getConsumo());
		
		MapaPanel panel =new MapaPanel();
		
		Hashtable<String,Object> componentes=new Hashtable<String,Object>();
		componentes.put("Pais", pais);
		componentes.put("PanelMapa", panel);
		
		Principal pantalla=new Principal(componentes);
		
	}
	
	
	public static void cargarSectores(Hashtable<String,Sector> sectores) {
	
		
		cargarLinea(sectores,50,70,18);
		cargarLinea(sectores,50,70,19);
		cargarLinea(sectores,50,69,20);
		cargarLinea(sectores,54,50,21);
		
		cargarLinea(sectores,54,70,40);
		
	}
	
	
	public static void cargarLinea(Hashtable<String,Sector> sectores, int inicio, int fin,int latitud) {
			
		for (int l=inicio;l<fin;l++) {
			
			Hashtable<String,Persona> personas=new Hashtable<String, Persona>();
			TipoRegion tipo=TipoRegion.CONO_SUR;
			Ascendencia ascendencia=new Ascendencia(0.4,0.5,0.1);
			Sector sector=new Sector(l,latitud,"provinciaArgentina",tipo,ascendencia);
			
			for(int i=0;i<100;i++) {
				Persona p=new Persona(sector);
				personas.put(p.getId(), p);
			}	
			
			sector.setPersonas(personas);
			sectores.put(sector.getId(), sector);
		}
		
	}
	
	public static Pais cargarPais(Hashtable<String,Sector> sectores) {
		
		for(String cvSector:sectores.keySet()) {
			
			Sector sector=sectores.get(cvSector);
			
			Hashtable<String,Persona> personas=new Hashtable<String, Persona>();
			
			for(int i=0;i<100;i++) {
				Persona p=new Persona(sector);
				personas.put(p.getId(), p);
			}	
			
			sector.setPersonas(personas);
		
		}
			
		Ascendencia ascendencia=new Ascendencia(0.4,0.5,0.1);
		TipoRegion tipo=TipoRegion.CONO_SUR;
		
		Pais pais=new Pais(sectores,"provinciaArgentina",tipo,ascendencia);
		
		return pais;
		
	}
	
}
