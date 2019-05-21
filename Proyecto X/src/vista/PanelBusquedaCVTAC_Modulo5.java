package vista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelBusquedaCVTAC_Modulo5 extends JPanel { //CVTAC : Consulta Valor total de apuestas por cliente
	
	private static final long serialVersionUID = 1L;
	private JLabel labId;
	private JTextField txtId;
	private JButton butBuscar;
	public static final String BUSCARCVTAC = "BuscarCVTAC";
	
	public PanelBusquedaCVTAC_Modulo5() {
		
		setLayout(new GridLayout(2,2, 5 , 20));
		TitledBorder border = BorderFactory.createTitledBorder("Consulta del valor total de apuestas del cliente");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		labId = new JLabel("ID del cliente");
		txtId = new JTextField("");
		txtId.setForeground(Color.BLACK);
		
		butBuscar = new JButton ("Buscar");
		butBuscar.setIcon(new ImageIcon("data\\imagenes\\buscar.png"));
		butBuscar.setPreferredSize(new Dimension(1, 10));
		butBuscar.setActionCommand(BUSCARCVTAC);
		
		add(labId);
		add(txtId);
		add(new JLabel(""));
		add(butBuscar);
		
	}

	public JLabel getLabId() {
		return labId;
	}

	public void setLabId(JLabel labId) {
		this.labId = labId;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JButton getButBuscar() {
		return butBuscar;
	}

	public void setButBuscar(JButton butBuscar) {
		this.butBuscar = butBuscar;
	}

	public static String getBuscar() {
		return BUSCARCVTAC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getBuscarcvtac() {
		return BUSCARCVTAC;
	}
	
	
	
}