package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelMostrarCasaApuesta_Modulo1 extends JPanel {

	private JLabel titulo;
	private JLabel nombre;
	private JLabel sedes;
	private JLabel presupuesto;

	private JTextField txtnombre;
	private JTextField txtsedes;
	private JTextField txtpresupuesto;

	private JButton butAtras;

	public static final String ATRASLEERMOD1 = "Atras leer";

	public PanelMostrarCasaApuesta_Modulo1() {

		setLayout(new GridLayout(4, 2, 5, 20));
		TitledBorder border = BorderFactory.createTitledBorder("Datos de la casa de apuestas");
		setBorder(border);
		border.setTitleColor(Color.black);

		titulo = new JLabel("Ingrese los siguientes datos de su casa de apuestas: ");
		titulo.setBounds(20, 20, 350, 20);

		nombre = new JLabel("Nombre de la Casa de apuestas:");
		nombre.setBounds(40, 50, 200, 20);
		sedes = new JLabel("Número de sedes:");
		sedes.setBounds(40, 80, 200, 20);
		presupuesto = new JLabel("Presupuesto total para premios:");
		presupuesto.setBounds(40, 110, 200, 20);

		txtnombre = new JTextField();
		txtnombre.setBounds(250, 50, 200, 20);
		txtnombre.setEditable(false);

		txtsedes = new JTextField();
		txtsedes.setBounds(250, 80, 200, 20);
		txtsedes.setEditable(false);

		txtpresupuesto = new JTextField();
		txtpresupuesto.setBounds(250, 110, 200, 20);
		txtpresupuesto.setEditable(false);

		butAtras = new JButton("Atras");
		butAtras.setActionCommand(ATRASLEERMOD1);
		butAtras.setBounds(120, 170, 200, 20);
		butAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));

		add(nombre);
		add(txtnombre);
		add(sedes);
		add(txtsedes);
		add(presupuesto);

		add(txtpresupuesto);
		add(new JLabel(""));
		add(butAtras);
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getSedes() {
		return sedes;
	}

	public void setSedes(JLabel sedes) {
		this.sedes = sedes;
	}

	public JLabel getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(JLabel presupuesto) {
		this.presupuesto = presupuesto;
	}

	public JTextField getTxtnombre() {
		return txtnombre;
	}

	public void setTxtnombre(JTextField txtnombre) {
		this.txtnombre = txtnombre;
	}

	public JTextField getTxtsedes() {
		return txtsedes;
	}

	public void setTxtsedes(JTextField txtsedes) {
		this.txtsedes = txtsedes;
	}

	public JTextField getTxtpresupuesto() {
		return txtpresupuesto;
	}

	public void setTxtpresupuesto(JTextField txtpresupuesto) {
		this.txtpresupuesto = txtpresupuesto;
	}

	public JButton getButAtras() {
		return butAtras;
	}

	public void setButAtras(JButton butAtras) {
		this.butAtras = butAtras;
	}

	public static String getAtrasleermod1() {
		return ATRASLEERMOD1;
	}

}
