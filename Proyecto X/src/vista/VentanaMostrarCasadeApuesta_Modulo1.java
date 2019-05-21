package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controlador.Controlador;

public class VentanaMostrarCasadeApuesta_Modulo1 extends JFrame{
	
	private PanelMostrarCasaApuesta_Modulo1 panelMostrar;
	
	public VentanaMostrarCasadeApuesta_Modulo1 (Controlador control) {
		
		setSize(500,200);
		setResizable(false);
		setTitle("Casa de apuestas");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		panelMostrar = new PanelMostrarCasaApuesta_Modulo1();
		
		add(panelMostrar);
		
		panelMostrar.getButAtras().addActionListener(control);
		
	}

	public PanelMostrarCasaApuesta_Modulo1 getPanelMostrar() {
		return panelMostrar;
	}

	public void setPanelMostrar(PanelMostrarCasaApuesta_Modulo1 panelMostrar) {
		this.panelMostrar = panelMostrar;
	}
	
	

}
