package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.PaisDAO;
import constants.PaisesConstants;
import controllers.CapacidadIntelectualController;
import controllers.DatosController;
import controllers.HabitoConsumoController;
import entities.paises.Pais;
import model.NivelIntelectual;
import tasks.PBICalculationTask;

public class PrincipalView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelBotones;
	private MapaPanel panelMapa;
	private Hashtable<String,Object> componentes=new Hashtable<String,Object>();
	private Hashtable<String,Color> colorPais=new Hashtable<String,Color>();
	
	public PrincipalView(Hashtable<String,Object> componentes) {
		this.generarColorPais();
		this.componentes=componentes;
		this.panelMapa =(MapaPanel) componentes.get("PanelMapa");
		this.initComponents();
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		this.setLayout(new BorderLayout());
		this.add(panelMapa,BorderLayout.CENTER);
		panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(20,1,5,5));
		
		Hashtable<String,Pais> paises= (Hashtable<String, Pais>) componentes.get("Paises");
		
		for(String cvPais:paises.keySet()) {
			Pais pais=paises.get(cvPais);
			for(String cvSector:pais.getSectores().keySet()) {
				panelMapa.getPanelIJ(pais.getSectores().get(cvSector).getCoordenadaX(), pais.getSectores().get(cvSector).getCoordenadaY()).setBackground(colorPais.get(pais.getNombre()));
			}
		}
		
		JButton btnCapacIntelec=new JButton("Capac Intele");
		btnCapacIntelec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CapacidadIntelectualController.mostrarCapacidadIntelectual(paises, panelMapa);
			}
			
		});
		panelBotones.add(btnCapacIntelec);
		
		JButton btnHabitoConsumo=new JButton("Hab Consumo");
		btnHabitoConsumo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HabitoConsumoController.mostrarHabitoConsumo(paises, panelMapa);
			}
			
		});
		panelBotones.add(btnHabitoConsumo);
		
		JButton btnDatos=new JButton("Datos");
		btnDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				DatosController.cargarDatosPais(paises);
			}
			
		});
		panelBotones.add(btnDatos);
		
		for(int i=0;i<17;i++) {
			JButton btn=new JButton(String.valueOf(i));
			panelBotones.add(btn);
		}
		this.add(panelBotones,BorderLayout.WEST);
	}
	
	public void addComponent(String key,Object object) {
		this.componentes.put(key, object);
	}
	
	public void generarColorPais() {
		colorPais.put(PaisesConstants.ARGENTINA, Color.blue);
		colorPais.put(PaisesConstants.BRASIL, Color.green);
	}
	
}
