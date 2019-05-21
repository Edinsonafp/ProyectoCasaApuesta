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
import javax.swing.border.TitledBorder;

import modelo.SedeDTO_Modulo2;

public class PanelBusquedaCPS_Modulo5 extends JPanel {
	
	private JLabel labSeleccionado;
	private JComboBox seleccionSede;
	private JButton btonBuscar;
	public static final String BUSCARCPS= "BuscarCPS";
	public static final long serialVersionUID = 1L;
	
	public PanelBusquedaCPS_Modulo5 () {
		
		setLayout(new GridLayout(2, 2,5,20));
		TitledBorder border = BorderFactory.createTitledBorder("Consulta de Sede");
		setBorder(border);
		border.setTitleColor(Color.BLACK);
		
		
		
		labSeleccionado = new JLabel("Seleccionado Sede: ");
		seleccionSede = new JComboBox<>();

		seleccionSede.setForeground(Color.BLACK);
		
		btonBuscar = new JButton("Buscar");
		btonBuscar.setActionCommand(BUSCARCPS);
		btonBuscar.setIcon(new ImageIcon("data\\imagenes\\buscar.png"));
		btonBuscar.setPreferredSize(new Dimension(1, 10));
		
	
		
		add(labSeleccionado);
		add(seleccionSede);
		add(new JLabel(""));
		add(btonBuscar);
		
	}
	
public void llenarSedeComboBox(ArrayList<SedeDTO_Modulo2> Array) {
		
		for (int i = 0; i < Array.size(); i++) {
			seleccionSede.addItem(Array.get(i).getNombre());
		}
	}

	public JLabel getLabSeleccionado() {
		return labSeleccionado;
	}

	public void setLabSeleccionado(JLabel labSeleccionado) {
		this.labSeleccionado = labSeleccionado;
	}

	public JComboBox getSeleccionSede() {
		return seleccionSede;
	}

	public void setSeleccionSede(JComboBox seleccionSede) {
		this.seleccionSede = seleccionSede;
	}

	public JButton getBtonBuscar() {
		return btonBuscar;
	}

	public void setBtonBuscar(JButton btonBuscar) {
		this.btonBuscar = btonBuscar;
	}

	public static String getBuscarCPS() {
		return BUSCARCPS;
	}
	
	

}
