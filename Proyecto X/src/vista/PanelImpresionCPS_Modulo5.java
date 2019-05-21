package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelImpresionCPS_Modulo5 extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btonImprimirPDF;
	private JButton btonImprimirEXCEL;
	private JButton btonAtras;
	public static final String EXCELCPS= "Excel CPS";
	public static final String PDFCPS = "PDF CPS";
	public static final String ATRASCPS ="Atras CPS ";
	
	public PanelImpresionCPS_Modulo5 () {
		setLayout(new GridLayout(1, 3, 10,10));
		TitledBorder border = BorderFactory.createTitledBorder("Impresión");
		setBorder(border);
		border.setTitleColor(Color.BLACK);
		
		btonImprimirPDF = new JButton("Imprimir PDF");
		btonImprimirPDF.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		btonImprimirPDF.setPreferredSize(new Dimension(10, 25));
		btonImprimirPDF.setActionCommand(PDFCPS);
		
		btonImprimirEXCEL = new JButton("Imprimir Excel");
		btonImprimirEXCEL.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		btonImprimirEXCEL.setPreferredSize(new Dimension(10, 25));
		btonImprimirEXCEL.setActionCommand(EXCELCPS);
		
		btonAtras = new JButton("Atras");
		btonAtras.setPreferredSize(new Dimension(10, 25));
		btonAtras.setActionCommand(ATRASCPS);
		btonAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));
		
		add(btonImprimirPDF);
		add(btonImprimirEXCEL);
		add(btonAtras);
	}
	
	public JButton getBtonImprimirPDF() {
		return btonImprimirPDF;
	}

	public void setBtonImprimirPDF(JButton btonImprimirPDF) {
		this.btonImprimirPDF = btonImprimirPDF;
	}

	public JButton getBtonImprimirEXCEL() {
		return btonImprimirEXCEL;
	}

	public void setBtonImprimirEXCEL(JButton btonImprimirEXCEL) {
		this.btonImprimirEXCEL = btonImprimirEXCEL;
	}
	public JButton getBtonAtras() {
		return btonAtras;
	}
	public void setBtonAtras(JButton btonAtras) {
		this.btonAtras = btonAtras;
	}

	public static String getExcelCPS() {
		return EXCELCPS;
	}

	public static String getPdfCPS() {
		return PDFCPS;
	}

	public static String getAtrasCPS() {
		return ATRASCPS;
	}
	
	
	
	

}
