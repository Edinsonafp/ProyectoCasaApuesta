package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelImpresionDAC_Modulo5 extends JPanel {
	
	private JButton butImppdf ;
	private JButton butImpexc ;
	private JButton butAtras ;
	
	public static final String PDFDAC = "imprimir PDF";
	public static final String EXCELDAC = "imprimir Excel";
	public static final String ATRASDAC = "atras";	
	public PanelImpresionDAC_Modulo5() {
		
		setLayout( new GridLayout(1,3) );
		TitledBorder border = BorderFactory.createTitledBorder("Manera de Impresión");
		border.setTitleColor(Color.BLACK);
		setBorder( border );
		
		butImppdf= new JButton("Imprimir PDF");
		butImppdf.setActionCommand(PDFDAC);
		butImppdf.setPreferredSize(new Dimension(10, 25));
		butImppdf.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		
		butImpexc= new JButton("Imprimir Excel");
		butImpexc.setActionCommand(EXCELDAC);
		butImpexc.setPreferredSize(new Dimension(10, 25));
		butImpexc.setIcon(new ImageIcon("data\\imagenes\\imprimir.png"));
		
		butAtras= new JButton("Atras");
		butAtras.setActionCommand(ATRASDAC);
		butAtras.setPreferredSize(new Dimension(10, 25));
		butAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));
		
		add(butImppdf);
		add(butImpexc);
		add(butAtras);
	
}

	public JButton getButImppdf() {
		return butImppdf;
	}

	public void setButImppdf(JButton butImppdf) {
		this.butImppdf = butImppdf;
	}

	public JButton getButImpexc() {
		return butImpexc;
	}

	public void setButImpexc(JButton butImpexc) {
		this.butImpexc = butImpexc;
	}

	public JButton getButAtras() {
		return butAtras;
	}

	public void setButAtras(JButton butAtras) {
		this.butAtras = butAtras;
	}

}
