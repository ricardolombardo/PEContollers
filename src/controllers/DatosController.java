package controllers;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.PaisDAO;
import entities.paises.Pais;
import tasks.PBICalculationTask;
import views.MensajeView;

public class DatosController {
	
	public static void cargarDatosPais(Hashtable<String,Pais> paises) {
		
		PaisDAO paisDao=new PaisDAO();
		paisDao.getPaises();
		JTable tabla = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Pais");
		model.addColumn("Cantidad Personas");
		model.addColumn("Coeficiente Intelectual Promedio");
		model.addColumn("Consumo");
		model.addColumn("Consumo per capita");
		model.addColumn("Minerales");
		model.addColumn("Petroleo");
		model.addColumn("PBI");
		
		for(String cvPais:paises.keySet()) {
			Pais pais=paises.get(cvPais);
			
			PBICalculationTask pbiTask=new PBICalculationTask();
			pbiTask.setPais(pais);
			pbiTask.executeTask();
			
			model.addRow(new Object[] {pais.getNombre(),
					pais.getCantidadPersonas(),
					pais.getCoeficienteIntelectualPromedio(),
					pais.getConsumo(),
					pais.getConsumoPerCapita(),
					pais.getRecursos().get("Mineral").getValor(),
					pais.getRecursos().get("Petroleo").getValor(),
					pbiTask.getPbi()
					});
			paisDao.insertarPaisSimulacion(cvPais, 1, 1980);
			
		}
		tabla.setModel(model);
		JScrollPane scrollPane = new JScrollPane(tabla);
		MensajeView mensaje = new MensajeView("Datos");			
		mensaje.getPanelCentral().add(scrollPane, BorderLayout.CENTER);
	}

}
