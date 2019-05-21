package vista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelImpresionCAPCS__Modulo5 extends JPanel {
	private JButton butImprimirPDF;
	private JButton butImprimirEXCEL;
	private JButton butAtras;
	private static final long serialVersionUID = 1L;

	public static final String ATRASCAPCS = "Atras CAPCS";
	public static final String EXCELCAPCS= "Excel CAPCS";
	public static final String PDFCAPCS = "PDF CAPCS";
	
	public PanelImpresionCAPCS__Modulo5 () {
		setLayout(new GridLayout(1, 3, 10 , 70 ));//70, 70
		TitledBorder border = BorderFactory.createTitledBorder("Imprimir");
		setBorder(border);
		border.setTitleColor(Color.BLACK);
		
		butImprimirPDF = new JButton("Imprimir PDF");
		butImprimirPDF.setActionCommand(PDFCAPCS);
		butImprimirPDF.setPreferredSize(new Dimension(10, 25));
		butImprimirPDF.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		
		butImprimirEXCEL = new JButton("Imprimir Excel");
		butImprimirEXCEL.setActionCommand(EXCELCAPCS);
		butImprimirEXCEL.setPreferredSize(new Dimension(10, 25));
		butImprimirEXCEL.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		
		butAtras = new JButton("Atras Menu");
		butAtras.setActionCommand(ATRASCAPCS);
		butAtras.setPreferredSize(new Dimension(10, 25));
		butAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));
		
		add(butImprimirPDF);
		add(butImprimirEXCEL);
		add(butAtras);
		

	}

	public JButton getButImprimirPDF() {
		return butImprimirPDF;
	}

	public void setButImprimirPDF(JButton butImprimirPDF) {
		this.butImprimirPDF = butImprimirPDF;
	}

	public JButton getButImprimirEXCEL() {
		return butImprimirEXCEL;
	}

	public void setButImprimirEXCEL(JButton butImprimirEXCEL) {
		this.butImprimirEXCEL = butImprimirEXCEL;
	}

	public static String getExcelCAPCS() {
		return EXCELCAPCS;
	}

	public static String getPdfCAPCS() {
		return PDFCAPCS;
	}

	public JButton getButAtras() {
		return butAtras;
	}

	public void setButAtras(JButton butAtras) {
		this.butAtras = butAtras;
	}

	public static String getAtrasCAPCS() {
		return ATRASCAPCS;
	}
	
	
}
