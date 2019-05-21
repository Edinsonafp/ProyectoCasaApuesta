package vista;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import controlador.Controlador;

public class VentanaCAPCS_Modulo5 extends JFrame { //CAPCS = consulta apuestas por clientes sedes
	
	private PanelBusquedaCAPCS_Modulo5 panelBusqueda;
	private PanelReportePantallaCAPCS_Modulo5 panelReporte;
	private PanelImpresionCAPCS__Modulo5 panelImpresion;
	private static final long serialVersionUID = 1L;
	
	public VentanaCAPCS_Modulo5 (Controlador control) {
		
		setSize(500, 700);
		setResizable(false);
		setTitle("Consulta de apuestas de clientes por sede");
		
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		panelBusqueda = new PanelBusquedaCAPCS_Modulo5();
		
		panelReporte = new PanelReportePantallaCAPCS_Modulo5();
		
		panelImpresion = new PanelImpresionCAPCS__Modulo5();
		
		add(panelBusqueda, BorderLayout.NORTH);
		add(panelReporte, BorderLayout.CENTER);
		add(panelImpresion, BorderLayout.SOUTH);
		
		panelBusqueda.getButBuscar().addActionListener(control);
		panelImpresion.getButImprimirEXCEL().addActionListener(control);
		panelImpresion.getButImprimirPDF().addActionListener(control);
		panelImpresion.getButAtras().addActionListener(control);
	}


	public PanelBusquedaCAPCS_Modulo5 getPanelBusqueda() {
		return panelBusqueda;
	}


	public void setPanelBusqueda(PanelBusquedaCAPCS_Modulo5 panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}


	public PanelReportePantallaCAPCS_Modulo5 getPanelReporte() {
		return panelReporte;
	}

	

	public void setPanelReporte(PanelReportePantallaCAPCS_Modulo5 panelReporte) {
		this.panelReporte = panelReporte;
	}


	public PanelImpresionCAPCS__Modulo5 getPanelImpresion() {
		return panelImpresion;
	}


	public void setPanelImpresion(PanelImpresionCAPCS__Modulo5 panelImpresion) {
		this.panelImpresion = panelImpresion;
	}
	
	
	
}
