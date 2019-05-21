package vista;
import java.awt.*;
import javax.swing.*;

import controlador.Controlador;


/**
 * @author Camilo
 *
 */
public class VentanaDAC_Modulo5 extends JFrame{
	private static final long serialVersion = 1L;
	private PanelBusquedaDAC_Modulo5 panelBusquedaDAC_Modulo5;
	private PanelReportePantallaDAC_Modulo5 panelReportePantallaDAC_Modulo5;
	private PanelImpresionDAC_Modulo5 panelImpresionDAC_Modulo5;
	
	public VentanaDAC_Modulo5(Controlador controlador) {
		
		setSize(500, 700);
		setResizable(true);
		setTitle("Total de apuestas por sede");
	
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		panelBusquedaDAC_Modulo5 = new PanelBusquedaDAC_Modulo5();
		add(panelBusquedaDAC_Modulo5,BorderLayout.NORTH);
		
		panelReportePantallaDAC_Modulo5 = new PanelReportePantallaDAC_Modulo5 ();
		add(panelReportePantallaDAC_Modulo5, BorderLayout.CENTER);
		
		panelImpresionDAC_Modulo5 = new PanelImpresionDAC_Modulo5 ();
		add(panelImpresionDAC_Modulo5, BorderLayout.SOUTH);
		
		panelBusquedaDAC_Modulo5.getButBuscar().addActionListener(controlador);
		panelImpresionDAC_Modulo5.getButImpexc().addActionListener(controlador);
		panelImpresionDAC_Modulo5.getButImppdf().addActionListener(controlador);
		panelImpresionDAC_Modulo5.getButAtras().addActionListener(controlador);
	
	}

	public PanelBusquedaDAC_Modulo5 getPanelBusquedaDAC() {
		return panelBusquedaDAC_Modulo5;
	}

	public void setPanelBusquedaDAC(PanelBusquedaDAC_Modulo5 panelBusquedaDAC_Modulo5) {
		this.panelBusquedaDAC_Modulo5 = panelBusquedaDAC_Modulo5;
	}

	public PanelReportePantallaDAC_Modulo5 getPanelReportePantallaDAC() {
		return panelReportePantallaDAC_Modulo5;
	}

	public void setPanelReportePantallaDAC(PanelReportePantallaDAC_Modulo5 panelReportePantallaDAC_Modulo5) {
		panelReportePantallaDAC_Modulo5 = panelReportePantallaDAC_Modulo5;
	}

	public PanelImpresionDAC_Modulo5 getPanelImpresionDAC() {
		return panelImpresionDAC_Modulo5;
	}

	public void setPanelImpresionDAC(PanelImpresionDAC_Modulo5 panelImpresionDAC_Modulo5) {
		this.panelImpresionDAC_Modulo5 = panelImpresionDAC_Modulo5;
	}
	
}
