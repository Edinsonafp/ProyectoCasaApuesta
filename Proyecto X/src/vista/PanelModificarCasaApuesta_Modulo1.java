package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelModificarCasaApuesta_Modulo1 extends JPanel {

	private JLabel titulo;
	private JLabel nombre;
	private JLabel sedes;
	private JLabel presupuesto;

	private JTextField txtnombre;
	private JTextField txtsedes;
	private JTextField txtpresupuesto;

	private JButton butModificar;
	private JButton butAtras;

	public static final String ATRASMODIFICARMOD1 = "Atras Modificar";
	public static final String MODIFICARMOD1 = "Modificar";

	public PanelModificarCasaApuesta_Modulo1() {

		setLayout(new GridLayout(4, 2, 5,20));
		TitledBorder border = BorderFactory.createTitledBorder("Modificar casa de apuestas");
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
		txtsedes = new JTextField();
		txtsedes.setBounds(250, 80, 200, 20);
		txtpresupuesto = new JTextField();
		txtpresupuesto.setBounds(250, 110, 200, 20);

		butModificar = new JButton("Guardar");
		butModificar.setActionCommand(MODIFICARMOD1);
		butModificar.setBounds(120, 170, 200, 20);
		butModificar.setIcon(new ImageIcon("data\\imagenes\\guardar.png"));

		butAtras = new JButton("Atras");
		butAtras.setActionCommand(ATRASMODIFICARMOD1);
		butAtras.setBounds(120, 170, 200, 20);
		butAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));

		//add(titulo);
		add(nombre);
		add(txtnombre);
		add(sedes);
		add(txtsedes);
		add(presupuesto);
		
		
		add(txtpresupuesto);
		add(butModificar);
		add(butAtras);

		txtsedes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9')
					e.consume();
			}

		});

		// Solo recibe numeros en el cuadro de texto del presupuesto
		txtpresupuesto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c < '0' || c > '9')
					e.consume();
			}

		});
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

	public JButton getButModificar() {
		return butModificar;
	}

	public void setgetButModificar(JButton butguardar) {
		this.butModificar = butguardar;
	}

	public JButton getButAtras() {
		return butAtras;
	}

	public void setButAtras(JButton butAtras) {
		this.butAtras = butAtras;
	}

	public static String getAtras() {
		return ATRASMODIFICARMOD1;
	}

	public static String getModificar() {
		return MODIFICARMOD1;
	}

}
