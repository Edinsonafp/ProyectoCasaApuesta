package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.SedeDTO_Modulo2;

public class PanelBusquedaCAPCS_Modulo5 extends JPanel { // CAPCS = consulta apuestas por clientes sedes

	private JLabel labId;
	private JLabel labSede;
	private JTextField txtId;
	private JComboBox comboSede;
	private JButton butBuscar;
	private static final long serialVersionUID = 1L;
	public static final String BUSCARCAPCS = "BuscarCAPS";

	public PanelBusquedaCAPCS_Modulo5() {

		setLayout(new GridLayout(3, 2, 5, 20));
		TitledBorder border = BorderFactory.createTitledBorder("Consulta de apuestas de clientes por sede");
		border.setTitleColor(Color.BLACK);
		setBorder(border);

		labId = new JLabel("ID del cliente");
		txtId = new JTextField("");
		txtId.setForeground(Color.BLACK);
		txtId.setBackground(Color.WHITE);

		labSede = new JLabel("Sede");
		comboSede = new JComboBox<>();

		butBuscar = new JButton("Buscar");
		butBuscar.setActionCommand(BUSCARCAPCS);
		butBuscar.setPreferredSize(new Dimension(1, 10));
		butBuscar.setIcon(new ImageIcon("data\\imagenes\\buscar.png"));

		add(labId);
		add(txtId);
		add(labSede);
		add(comboSede);
		add(new JLabel(""));
		add(butBuscar);

	}

	public void llenarSedeComboBox(ArrayList<SedeDTO_Modulo2> Array) {
	
		for (int i = 0; i < Array.size(); i++) {
			
			comboSede.addItem(Array.get(i).getNombre());
		}
	}

	public JLabel getLabId() {
		return labId;
	}

	public void setLabId(JLabel labId) {
		this.labId = labId;
	}

	public JLabel getLabSede() {
		return labSede;
	}

	public void setLabSede(JLabel labSede) {
		this.labSede = labSede;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JComboBox getComboSede() {
		return comboSede;
	}

	public void setComboSede(JComboBox comboSede) {
		this.comboSede = comboSede;
	}

	public JButton getButBuscar() {
		return butBuscar;
	}

	public void setButBuscar(JButton butBuscar) {
		this.butBuscar = butBuscar;
	}

	public static String getBuscar() {
		return BUSCARCAPCS;
	}

}
