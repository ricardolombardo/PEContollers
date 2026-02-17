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

import entities.Pais;
import model.NivelIntelectual;

public class Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelBotones;
	private MapaPanel panelMapa;
	private Hashtable<String,Object> componentes=new Hashtable<String,Object>(); 
	
	public Principal(Hashtable<String,Object> componentes) {
		this.componentes=componentes;
		this.panelMapa =(MapaPanel) componentes.get("PanelMapa");
		this.initComponents();
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
	}
	
	public void initComponents() {
		this.setLayout(new BorderLayout());
		this.add(panelMapa,BorderLayout.CENTER);
		panelBotones=new JPanel();
		panelBotones.setLayout(new GridLayout(20,1,5,5));
		
		
		Pais pais=(Pais) componentes.get("Pais");
		for(String cvSector:pais.getSectores().keySet()) {
			panelMapa.getPanelIJ(pais.getSectores().get(cvSector).getCoordenadaX(), pais.getSectores().get(cvSector).getCoordenadaY()).setBackground(Color.red);
		}
		
		JButton btnCapacIntelec=new JButton("Capac Intele");
		btnCapacIntelec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pais pais=(Pais) componentes.get("Pais");
				for(String cvSector:pais.getSectores().keySet()) {
					JPanel panelRegion=panelMapa.getPanelIJ(pais.getSectores().get(cvSector).getCoordenadaX(), pais.getSectores().get(cvSector).getCoordenadaY());
					
					double promedio = pais.getSectores().get(cvSector).getCoeficienteMentalPromedio();

					NivelIntelectual nivel = NivelIntelectual.fromPromedio(promedio);
					panelRegion.setBackground(nivel.getColor());

				}
				
			}
			
		});
		panelBotones.add(btnCapacIntelec);
		for(int i=0;i<19;i++) {
			JButton btn=new JButton(String.valueOf(i));
			panelBotones.add(btn);
		}
		this.add(panelBotones,BorderLayout.WEST);
	}
	
	public void addComponent(String key,Object object) {
		this.componentes.put(key, object);
	}
	
	

}
