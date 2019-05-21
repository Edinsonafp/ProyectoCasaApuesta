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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
/*
 * Dialogo para modificar sedes.
 */
public class DialogoModificarSede_Modulo2 extends JDialog{
	
	//-----------------------------------------------------------------------------------------------------
	// Constantes
	//-----------------------------------------------------------------------------------------------------
	
	/*
	 * Comando para el botón terminar.
	 */
	public final static String TERMINAR = "Terminar";
	
	/*
	 * Comando para el botón de selección de otra sede.
	 */
	public final static String SELECCIONAR_OTRA_SEDE = "SELECCIONAR OTRA SEDE";
	
	
	//-----------------------------------------------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------------------------------------------

	/**
	 * Serial generado.
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Titulo para número de empleados.
	 */
	private JLabel numeroEmpleados;
	/**
	 * Título para nombre de la sede.
	 */
	private JLabel nombreSede;
	/**
	 * Campo de texto para el nombre de la sede.
	 */
	private JTextField txtNombreSede;
	/**
	 * Campo de texto para el número de empleados de la sede.
	 */
	private JTextField txtNumeroEmpleados;
	/**
	 * Botón para crear una sede.
	 */
	private JButton botonTerminar;
	
	/**
	 * Botón para ir atrás
	 */
	private JButton botonSeleccionarOtro;

	//-----------------------------------------------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa el dialogo de modificación y agrega los elementos en función de las casillas seleccionadas en el dialogo de buscar sedes.
	 * @param datosSeleccionados. Las casillas que han sido seleccionadas en el dialogo de buscar.
	 * @param control. Controlador de la aplicación.
	 */
	public DialogoModificarSede_Modulo2(int datosSeleccionados, Controlador control) {
		
	
		TitledBorder border = BorderFactory.createTitledBorder("Ingrese ID usuario a editar");
		border.setTitleColor(Color.BLACK);
		
		getRootPane().setBorder(border);
		if(datosSeleccionados == 0 || datosSeleccionados==1) {
		setLayout( new GridLayout(2,2));
		
		}
		if(datosSeleccionados==2) {
			setLayout( new GridLayout(3,2));
		}
		setSize (400,150);
		setResizable(false);
		setTitle("Modificar sede");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		numeroEmpleados = new JLabel ("trabajadores de la sede");
		txtNumeroEmpleados = new JTextField();
		txtNumeroEmpleados.setForeground(Color.BLACK);
		txtNumeroEmpleados.setBackground(Color.WHITE);
		
		nombreSede = new JLabel ("Nombre de la sede");
		txtNombreSede = new JTextField("");
		txtNombreSede.setForeground(Color.BLACK);
		txtNombreSede.setBackground(Color.WHITE);
		
		botonTerminar = new JButton("TERMINAR");
		botonTerminar.setActionCommand(TERMINAR);
		
		botonSeleccionarOtro = new JButton(SELECCIONAR_OTRA_SEDE);
		botonSeleccionarOtro.setActionCommand(SELECCIONAR_OTRA_SEDE);
		
		botonTerminar.addActionListener(control);
		botonSeleccionarOtro.addActionListener(control);
		
		if(datosSeleccionados==0) {
			add(numeroEmpleados);
			add(txtNumeroEmpleados);
		}
		
		if(datosSeleccionados==1) {
			add(nombreSede);
			add(txtNombreSede);
		}
		if(datosSeleccionados==2) {
			add(numeroEmpleados);
			add(txtNumeroEmpleados);
			add(nombreSede);
			add(txtNombreSede);
		}
		
		add(botonSeleccionarOtro);
		add(botonTerminar);
		
		setVisible(true);
	}
	
	//-----------------------------------------------------------------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------------------------------------------------------------

	public int darNuevoNumeroEmpleados() throws Exception{
		boolean esEntero;
        try {
            Integer.parseInt(txtNumeroEmpleados.getText());
            esEntero = true;
        } catch (NumberFormatException excepcion) {
            esEntero = false;
        }
	if(esEntero==false) {
		throw new Exception("No hay ningún valor válido en la casilla de numero empleados");
	}
	if(Integer.parseInt(txtNumeroEmpleados.getText())<=0) {
		throw new Exception("El valor ingresado en la casilla de numero empleados no puede ser cero o negativo");
	}
	else return Integer.parseInt(txtNumeroEmpleados.getText());
	}
	
	public String darNombreSede() throws Exception {
		if(txtNombreSede.getText().length()==0) {
			throw new Exception("No hay nada en la casilla de nombre de sede");
		}
		else {
		return txtNombreSede.getText();
		}
	}
	
	
	public String darNuevoNombre() throws Exception{
		if(txtNombreSede.getText().length()==0) {
			throw new Exception("No hay nada en la casilla de nombre de sede");
		}
		else {
		return txtNombreSede.getText();
		}
	}
	

	
	
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------
	//Métodos get
	//-----------------------------------------------------------------------------------------------------------------------
	
	
	public JTextField getTxtNombreSede() {
		return txtNombreSede;
	}
	
	public JTextField getTxtNumeroEmpleados() {
		return txtNumeroEmpleados;
	}


	

}