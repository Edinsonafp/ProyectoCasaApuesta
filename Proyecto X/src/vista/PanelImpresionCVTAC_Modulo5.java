package vista;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelImpresionCVTAC_Modulo5 extends JPanel { //CVTAC : Consulta Valor total de apuestas por cliente
	
	private static final long serialVersionUID = 1L;
	private JButton butImprimirPDF;
	private JButton butImprimirEXCEL;
	private JButton butVolver;
	
	public static final String EXCELCVTAC = "Imprimir Excel";
	public static final String PDFCVTAC = "Imprimir PDF";
	public static final String ATRASCVTAC = "Atrás";
	
	public PanelImpresionCVTAC_Modulo5() {
		setLayout(new GridLayout(1,3,10,70));
		TitledBorder border = BorderFactory.createTitledBorder("Imprimir");
		setBorder(border);
		border.setTitleColor(Color.BLACK);
		
		butImprimirPDF = new JButton("Imprimir PDF");
		butImprimirPDF.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		butImprimirPDF.setPreferredSize(new Dimension(10, 25));
		butImprimirPDF.setActionCommand(PDFCVTAC);
		
		
		butImprimirEXCEL = new JButton("Imprimir Excel");
		butImprimirEXCEL.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		butImprimirEXCEL.setPreferredSize(new Dimension(10, 25));
		butImprimirEXCEL.setActionCommand(EXCELCVTAC);
		
		butVolver = new JButton("Atrás");
		butVolver.setIcon(new ImageIcon("data\\imagenes\\atras.png"));
		butVolver.setPreferredSize(new Dimension(10, 25));
		butVolver.setActionCommand(ATRASCVTAC);
		
		add(butImprimirPDF);
		add(butImprimirEXCEL);
		add(butVolver);
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

	public JButton getButVolver() {
		return butVolver;
	}

	public void setButVolver(JButton butVolver) {
		this.butVolver = butVolver;
	}

	public static String getExcel() {
		return EXCELCVTAC;
	}

	public static String getPdf() {
		return PDFCVTAC;
	}

	public static String getVolver() {
		return ATRASCVTAC;
	}
}