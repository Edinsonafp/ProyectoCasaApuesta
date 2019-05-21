package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;



import controlador.Controlador;



public class VentanaCPS_Modulo5 extends JFrame{
	
	private PanelBusquedaCPS_Modulo5 panelBusqueda;
	private PanelReportePantallaCPS_Modulo5 panelReporte;
	private PanelImpresionCPS_Modulo5 panelImprimir;
	private static final long serialVersionUID = 1L;
	
	public VentanaCPS_Modulo5 (Controlador controlador) {
		
		setSize(500,700);
		setResizable (false);
		setTitle("Clientes por Sede");
		
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		panelBusqueda = new PanelBusquedaCPS_Modulo5();
		add(panelBusqueda, BorderLayout.NORTH);
		
		panelReporte = new PanelReportePantallaCPS_Modulo5();
		add(panelReporte, BorderLayout.CENTER);
		
		panelImprimir = new PanelImpresionCPS_Modulo5();
		add(panelImprimir, BorderLayout.SOUTH);
		
		panelBusqueda.getBtonBuscar().addActionListener(controlador);
		panelImprimir.getBtonImprimirPDF().addActionListener(controlador);
		panelImprimir.getBtonImprimirEXCEL().addActionListener(controlador);
		panelImprimir.getBtonAtras().addActionListener(controlador);
		
		
	}

	public PanelBusquedaCPS_Modulo5 getPanelBusqueda() {
		return panelBusqueda;
	}

	public void setPanelBusqueda(PanelBusquedaCPS_Modulo5 panelBuscarCliente) {
		this.panelBusqueda = panelBuscarCliente;
	}

	public PanelReportePantallaCPS_Modulo5 getPanelReporte() {
		return panelReporte;
	}

	public void setPanelReporte(PanelReportePantallaCPS_Modulo5 panelReporte) {
		this.panelReporte = panelReporte;
	}

	public PanelImpresionCPS_Modulo5 getPanelImprimir() {
		return panelImprimir;
	}

	public void setPanelImprimir(PanelImpresionCPS_Modulo5 panelImprimir) {
		this.panelImprimir = panelImprimir;
	}
	
	
	

}
