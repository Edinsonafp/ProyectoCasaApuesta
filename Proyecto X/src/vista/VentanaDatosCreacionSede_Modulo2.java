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

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Panel de datos de la interfaz.
 */
public class VentanaDatosCreacionSede_Modulo2 extends JFrame{

	//----------------------------------------------------------------------------------------------------------
	// Constantes
	//----------------------------------------------------------------------------------------------------------
	
	/*
	 * Comando para el botón crear.
	 */
	public final static String CREAR = "Crear";

	//----------------------------------------------------------------------------------------------------------
	// Atributos
	//----------------------------------------------------------------------------------------------------------
		
	/**
	 * Serial generado.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Campo de texto para la localidad actual seleccionada.
	 */
	private JTextField txtLocalidadActual;
	/**
	 * Lista desplegable con las localidades.
	 */
	private JComboBox<String> lista;
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
	private JButton botonCrear;
	/**
	 * Botón para modificar una sede.
	 */
	private JButton botonModificar;
	
	//----------------------------------------------------------------------------------------------------------
	// Constructor
	//----------------------------------------------------------------------------------------------------------
		
	/**
	 * Inicializa el panel de datos con la lista de localidades.
	 * @param pLocalidades. Es un arreglo que viene de la clase principal del mundo. pLocalidades!=null.
	 */
	
	
	public VentanaDatosCreacionSede_Modulo2(Controlador control,String[] pLocalidades)
	{
		
		
		setLayout( new GridLayout(4,2) );
		setSize (520,200);
		setResizable(false);
		setTitle("Registro de sedes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//Creación de todos los campos de texto y titulos
		txtLocalidadActual = new JTextField(20);
		txtLocalidadActual.setEditable(false);
		
		numeroEmpleados = new JLabel ("Digite la cantidad de trabajadores de la sede");
		txtNumeroEmpleados = new JTextField();
		txtNumeroEmpleados.setForeground(Color.BLACK);
		txtNumeroEmpleados.setBackground(Color.WHITE);
		
		nombreSede = new JLabel ("Digite el nombre de la sede");
		txtNombreSede = new JTextField("");
		txtNombreSede.setForeground(Color.BLACK);
		txtNombreSede.setBackground(Color.WHITE);
		
		botonCrear = new JButton("CREAR ARCHIVO");
		botonCrear.setActionCommand(CREAR);
		
		
		botonCrear.addActionListener(control);

		
		// Crea el JComboBox y agrega los items.
		lista = new JComboBox<String>();
		
		for(int i=0; i<pLocalidades.length; i++) {
			lista.addItem(pLocalidades[i]);
		}
		
		
		//agrega todos los items del panel.
		add(lista);
		
		add(txtLocalidadActual);
		add(numeroEmpleados);
		add(txtNumeroEmpleados);
		add(nombreSede);
		add(txtNombreSede);
		add(new JLabel());
		add(botonCrear);
		
		
		setVisible(true);
		
		
		// Accion a realizar cuando el JComboBox cambia de item seleccionado.
		//Empieza aquí
		lista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtLocalidadActual.setText(lista.getSelectedItem().toString());
			}

		
		});
		//Termina aquí
	}//Aquí se cierra el constructor.
	
	//---------------------------------------------------------------------------------------------------------
	// Métodos
	//---------------------------------------------------------------------------------------------------------

	public String darNombreLocalidad() throws Exception{
		if(txtLocalidadActual.getText().length()==0) {
			throw new Exception("No se ha seleccionado una localidad");
		}
		else {
		return txtLocalidadActual.getText();
		}
	}
	
	public int darNumeroEmpleados() throws Exception{
		
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
	
	public void limpiar() {
		txtLocalidadActual.setText("");
		txtNombreSede.setText("");
		txtNumeroEmpleados.setText("");
		
	}

	//Métodos get.
	
	public JComboBox<String> getLista() {
		return lista;
	}

	public JTextField getTxtNombreSede() {
		return txtNombreSede;
	}

	public JTextField getTxtNumeroEmpleados() {
		return txtNumeroEmpleados;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}
	public JButton getBotonCrear() {
		return botonCrear;
	}
	
	public JTextField getTxtLocalidadActual() {
		return txtLocalidadActual;
	}

}


