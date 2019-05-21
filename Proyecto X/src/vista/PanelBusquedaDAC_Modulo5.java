package vista;
import java.awt.*;
import java.awt.geom.Arc2D.Double;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import modelo.SedeDTO_Modulo2;

public class PanelBusquedaDAC_Modulo5 extends JPanel{
	private static final long serialVersion = 1L;
	
	private JLabel labEntrada;
	private JLabel labEntrada1;
	private JComboBox sede;
	private JComboBox juego;
	private JTextField txtNumero;
	private JTextField txtNumero1;

	private JButton butBuscar ;
	
	
	
	public static final String BUSCARDAC = "buscar";
	

	public PanelBusquedaDAC_Modulo5() {
		

		setLayout(new GridLayout(4, 3));
		TitledBorder border = BorderFactory.createTitledBorder("datos de la casa");
		border.setTitleColor(Color.black);
		setBorder(border);
		
		labEntrada =new JLabel("Sede");
		sede = new JComboBox();
		sede.setBounds(1, 1, 50, 50);
	
		sede.setForeground(Color.BLACK);
		sede.setBackground(Color.white);
				
		labEntrada1 =new JLabel("Juego");
		juego = new JComboBox();
		juego.setBounds(1, 1, 50, 50);
		juego.addItem("");
		juego.addItem("Baloto");
		juego.addItem("SuperAstro");
		juego.addItem("Futbol");
		
		juego.setForeground(Color.BLACK);
		juego.setBackground(Color.white);
		
	
		butBuscar= new JButton("Buscar");
		butBuscar.setActionCommand(BUSCARDAC);
		butBuscar.setPreferredSize(new Dimension(1, 10));
		butBuscar.setIcon(new ImageIcon("data\\imagenes\\buscar.png"));
		
		add(labEntrada);  add (sede);  
		add(labEntrada1); add (juego); 

		add (new JLabel("")); 
		add (butBuscar);
	
	
	}
	
	public void llenarSedeComboBox(ArrayList<SedeDTO_Modulo2> Array) {
		
		for (int i = 0; i < Array.size(); i++) {
			sede.addItem(Array.get(i).getNombre());
		}
	}

	public JLabel getLabEntrada() {
		return labEntrada;
	}
	public void setLabEntrada(JLabel labEntrada) {
		this.labEntrada = labEntrada;
	}
	public JTextField getTxtNumero() {
		return txtNumero;
	}
	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}
	
	
	public JComboBox getSede() {
		return sede;
	}

	public void setSede(JComboBox sede) {
		this.sede = sede;
	}

	public JComboBox getJuego() {
		return juego;
	}

	public void setJuego(JComboBox juego) {
		this.juego = juego;
	}

	public static long getSerialversion() {
		return serialVersion;
	}

	public static String getBuscardac() {
		return BUSCARDAC;
	}

	public JButton getButBuscar() {
		return butBuscar;
	}
	public void setButBuscar(JButton butBuscar) {
		this.butBuscar = butBuscar;
	}
	public JLabel getLabEntrada1() {
		return labEntrada1;
	}
	public void setLabEntrada1(JLabel labEntrada1) {
		this.labEntrada1 = labEntrada1;
	}
	
	public JTextField getTxtNumero1() {
		return txtNumero1;
	}
	public void setTxtNumero1(JTextField txtNumero1) {
		this.txtNumero1 = txtNumero1;
	}
	public static String getBuscar() {
		return BUSCARDAC;
	}
	
	
	

}
