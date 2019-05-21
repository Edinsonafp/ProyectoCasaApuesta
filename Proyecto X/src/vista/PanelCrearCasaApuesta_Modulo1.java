package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelCrearCasaApuesta_Modulo1 extends JPanel {
	
	
	
	private JLabel titulo;
	private JLabel nombre;
	private JLabel sedes;
	private JLabel presupuesto;
	
	private JTextField txtnombre;
	private JTextField txtsedes;
	private JTextField txtpresupuesto;
	
	private JButton butGuardar;
	private JButton butAtras;
	
	public static final String ATRASCREARMOD1="Atras Crear";
	public static final String GUARDARMOD1="Guardar Crear";
	
	public PanelCrearCasaApuesta_Modulo1 () {
		
		setLayout(new GridLayout(4,2, 5, 20));
		TitledBorder border = BorderFactory.createTitledBorder("Crear casa de apuestas");
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
		
		butGuardar = new JButton("Guardar");
		butGuardar.setActionCommand(GUARDARMOD1);
		butGuardar.setBounds(60, 85, 100, 10);
		butGuardar.setIcon(new ImageIcon("data\\imagenes\\guardar.png"));
		
		
		butAtras = new JButton("Atras");
		butAtras.setActionCommand(ATRASCREARMOD1);
		butAtras.setBounds(60, 85, 100, 10);
		butAtras.setIcon(new ImageIcon("data\\imagenes\\atras.png"));
		
	
		add(nombre);
		add(txtnombre);
		add(sedes);
		add(txtsedes);
		
		add(presupuesto);
		add(txtpresupuesto);
		add(butGuardar);
		add(butAtras);
		
		txtsedes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (c<'0' || c>'9') e.consume();
			}

		});
		
		//Solo recibe numeros en el cuadro de texto del presupuesto
		txtpresupuesto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			if (c<'0' || c>'9') e.consume();
			}

		});
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
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

	public JButton getButGuardar() {
		return butGuardar;
	}

	public void setButGuardar(JButton butguardar) {
		this.butGuardar = butguardar;
	}

	public JButton getButAtras() {
		return butAtras;
	}

	public void setButAtras(JButton butAtras) {
		this.butAtras = butAtras;
	}

	public static String getAtras() {
		return ATRASCREARMOD1;
	}

	public static String getGuardar() {
		return GUARDARMOD1;
	}
	
	
}
