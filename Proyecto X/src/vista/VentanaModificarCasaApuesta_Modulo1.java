package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controlador.Controlador;



public class VentanaModificarCasaApuesta_Modulo1 extends JFrame{
	
	private PanelModificarCasaApuesta_Modulo1 panelModificar;
	
	public VentanaModificarCasaApuesta_Modulo1 (Controlador control) {
		
		setSize(500,200);
		setResizable(false);
		setTitle("Casa de apuestas");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		panelModificar = new PanelModificarCasaApuesta_Modulo1();
		
		add(panelModificar);
		
		panelModificar.getButModificar().addActionListener(control);
		panelModificar.getButAtras().addActionListener(control);
	}

	public PanelModificarCasaApuesta_Modulo1 getPanelModificar() {
		return panelModificar;
	}

	public void setPanelModificar(PanelModificarCasaApuesta_Modulo1 panelModificar) {
		this.panelModificar = panelModificar;
	}

	
}
