/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad El Bosque (Bogotá - Colombia)
 * Facultad de Ingeniería.
 * 
 * Proyecto Gestión casa de apuestas.
 * Módulo 2: Gestión de sedes.
 * Autores: Jairo Urbina, Daniela López, Andrea Díaz, Sergio Solano.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package vista;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.SedeDTO_Modulo2;

/*
 * Dialogo encargado de buscar una sede.
 */
public class DialogoBuscarSede_Modulo2 extends JDialog{
	
	//-----------------------------------------------------------------------------------------------------
	// Constantes 
	//-----------------------------------------------------------------------------------------------------
	/**
	 * Comando para el botón Aceptar.
	 */
	public final static String ACEPTAR ="ACEPTAR";
	/*
	 * Comando para el botón Atrás.
	 */
	public final static String ATRAS = "ATRÁS";
	
	//------------------------------------------------------------------------------------------------------
	// Atributos
	//------------------------------------------------------------------------------------------------------
	
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Label con titulo para seleccionar casillas de confirmación.
	 */
	private JLabel titulo;
	/**
	 * Casilla de confirmación para modificar el número de empleados.
	 */
	private JCheckBox numEmpleados;
	/**
	 * Casilla de confirmación para modificar el nombre de sede.
	 */
	private JCheckBox nombre;
	/**
	 * Label para elegir una sede de la lista.
	 */
	private JLabel tituloSedes;
	/**
	 * Lista desplegable que contiene todas las sedes existentes.
	 */
	private JComboBox<String> comboSedes;
	/**
	 * Botón para confirmar y seguir al dialogo de modificación.
	 */
	private JButton btnAceptar;
	/**
	 * Campo de texto para la sede seleccionada.
	 */
	private JTextField txtSedeActual;
	
	//-----------------------------------------------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------------------------------------------
	/**
	 * Inicializa el dialogo de buscar sede con la respectiva lista de sedes.
	 * @param pSedes. Las sedes existentes en el archivo "sedes.dat".
	 * @param control El controlador de la aplicación.
	 */
	public DialogoBuscarSede_Modulo2(ArrayList<SedeDTO_Modulo2> pSedes, Controlador control) {
		
		
		TitledBorder border = BorderFactory.createTitledBorder("Sede");
		border.setTitleColor(Color.BLACK);
		
		getRootPane().setBorder(border);
		setSize (520,170);
		setResizable(false);
		setTitle("Buscar sede");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5,2));
		
		
		titulo= new JLabel("Seleccione qué desea modificar:");
		numEmpleados = new JCheckBox("Número de empleados");
		nombre = new JCheckBox("Nombre de sede");
		btnAceptar=new JButton(ACEPTAR);
		btnAceptar.setActionCommand(ACEPTAR);
		tituloSedes= new JLabel("Seleccione una sede:");
		comboSedes = new JComboBox<String>();
		txtSedeActual= new JTextField();
		txtSedeActual.setEditable(false);
		
		for(int i=0; i<pSedes.size(); i++) {
			comboSedes.addItem(pSedes.get(i).getNombre());
		}
		
		comboSedes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtSedeActual.setText(comboSedes.getSelectedItem().toString());
			}

		
		});
		
		
		add(tituloSedes);
		add(new JLabel());
		add(comboSedes);
		add(txtSedeActual);
		add(titulo);
		add(new JLabel());
		add(numEmpleados);
		add(nombre);
		add(new JLabel());
		add(btnAceptar);
		
		
		setVisible(true);
		
		
		btnAceptar.addActionListener(control);
		
	}
	
	/**
	 * Retorna un entero en función de las casillas de confirmación que estén seleccionadas.
	 * @return  0 si la casilla de numero de empleados está seleccionada. 1 si la casilla de nombre está seleccionada y 2 si ambas casillas están seleccionadas.
	 * @throws Exception Si no hay ninguna casilla seleccionada 
	 */
	public int verificarCasillas() throws Exception{
		int seleccionados = -1;
		
		if(txtSedeActual.getText().length()==0) {
			throw new Exception("No se ha seleccionado una sede");
		}
		if(numEmpleados.isSelected()==true && nombre.isSelected()==false) {
			seleccionados = 0;
		}
		if(numEmpleados.isSelected()==false && nombre.isSelected()==true) {
			seleccionados = 1;
		}
		if(numEmpleados.isSelected()==true && nombre.isSelected()==true) {
			seleccionados = 2;
		}
		if(seleccionados==-1) {
			throw new Exception("No se ha seleccionado ninguna casilla para modificar");
		}
		
		return seleccionados;
	}
	
	
	//Métodos get
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JComboBox<String> getComboSedes() {
		return comboSedes;
	}
	
	
	


}