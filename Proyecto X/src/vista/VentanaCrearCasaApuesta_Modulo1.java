package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controlador.Controlador;



public class VentanaCrearCasaApuesta_Modulo1 extends JFrame {
	
	private PanelCrearCasaApuesta_Modulo1 panelCrear;
	
	public VentanaCrearCasaApuesta_Modulo1 (Controlador control) {
	
		setSize(500,200);
		setResizable(false);
		setTitle("Casa de apuestas");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		panelCrear = new PanelCrearCasaApuesta_Modulo1();
		
		add(panelCrear);
		
		panelCrear.getButGuardar().addActionListener(control);
		panelCrear.getButAtras().addActionListener(control);
	
	}

	public PanelCrearCasaApuesta_Modulo1 getPanelCrear() {
		return panelCrear;
	}

	public void setPanelCrear(PanelCrearCasaApuesta_Modulo1 panelCrear) {
		this.panelCrear = panelCrear;
	}
	
	
	

}
