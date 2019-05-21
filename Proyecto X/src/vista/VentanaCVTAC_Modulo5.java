package vista;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import controlador.Controlador;

public class VentanaCVTAC_Modulo5 extends JFrame{
	private static final long serialVersionUID = 1L;
	private PanelBusquedaCVTAC_Modulo5 panelBusqueda;
	private PanelReportePantallaCVTAC_Modulo5 panelReporte;
	private PanelImpresionCVTAC_Modulo5 panelImpresion;
	
	public VentanaCVTAC_Modulo5(Controlador control) {
		setSize(500,600);
		setResizable(false);
		setTitle("Consulta del valor total de apuestas por cliente");
		
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		panelBusqueda = new PanelBusquedaCVTAC_Modulo5();
		panelReporte = new PanelReportePantallaCVTAC_Modulo5();
		panelImpresion = new PanelImpresionCVTAC_Modulo5();
		
		add(panelBusqueda, BorderLayout.NORTH);
		add(panelReporte, BorderLayout.CENTER);
		add(panelImpresion, BorderLayout.SOUTH);
		
		panelBusqueda.getButBuscar().addActionListener(control);
		panelImpresion.getButImprimirPDF().addActionListener(control);
		panelImpresion.getButImprimirEXCEL().addActionListener(control);
		panelImpresion.getButVolver().addActionListener(control);
	}

	public PanelBusquedaCVTAC_Modulo5 getPanelBusqueda() {
		return panelBusqueda;
	}

	public void setPanelBusqueda(PanelBusquedaCVTAC_Modulo5 panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}

	public PanelReportePantallaCVTAC_Modulo5 getPanelReporte() {
		return panelReporte;
	}

	public void setPanelReporte(PanelReportePantallaCVTAC_Modulo5 panelReporte) {
		this.panelReporte = panelReporte;
	}

	public PanelImpresionCVTAC_Modulo5 getPanelImpresion() {
		return panelImpresion;
	}

	public void setPanelImpresion(PanelImpresionCVTAC_Modulo5 panelImpresion) {
		this.panelImpresion = panelImpresion;
	}
}