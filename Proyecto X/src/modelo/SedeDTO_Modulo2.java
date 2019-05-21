/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad El Bosque (Bogot� - Colombia)
 * Facultad de Ingenier�a.
 * 
 * Proyecto Gesti�n casa de apuestas.
 * M�dulo 2: Gesti�n de sedes.
 * Autores: Jairo Urbina, Daniela L�pez, Andrea D�az, Sergio Solano.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package modelo;

import java.io.Serializable;
/**
 * Clase que representa una sede.
 */
public class SedeDTO_Modulo2 implements Serializable {
	

	//-----------------------------------------------------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------------------------------------------------
	
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo que representa el n�mero de empleados dentro de la sede.
	 */
	private int numEmpleados;
	
	/**
	 * Atributo que representa el nombre de la sede.
	 */
	private String nombre;
	
	/**
	 * Atributo que representa la localidad en la cual se encuentra la sede.
	 */
	private String localidad;
	
	//-----------------------------------------------------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------------------------------------------------
	/**
	 * Construye una nueva instancia de una sede.
	 * @param pNumEpleados El numero de empleados. pNumEmpleados>=0.
	 * @param pLocalidad La localidad de la sede. pLocalidad != null
	 */
	public SedeDTO_Modulo2(int pNumEpleados, String pNombre, String pLocalidad) {
		
		this.numEmpleados =  pNumEpleados;
		this.localidad = pLocalidad;
		this.nombre = pNombre;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// M�todos
	//-----------------------------------------------------------------------------------------------------------
	/**
	 * retorna el numero de empleados.
	 * @return el numero de empleados.
	 */
	public int getNumEmpleados(){
		return numEmpleados;
	}
	/**
	 * retorna la localidad de la sede.
	 * @return la localidad de la sede.
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * Modifica el n�mero de empleados de la sede. <br>
     * <b>pre: </b> El n�mero de empleados ya ha sido inicializado. <br>
     * <b>post: </b> Se actualiz� el n�mero de empleados de la sede.
	 * @param pNuevoNumero El nuevo n�mero de empleados de la sede.
	 */
	public void setNumEmpleados(int pNuevoNumero) {
		this.numEmpleados = pNuevoNumero;
	}
	
	/**
	 * Modifica el n�mero de empleados de la sede. <br>
     * <b>pre: </b> El nombre ya ha sido inicializado. <br>
     * <b>post: </b> Se actualiz� el n�mero de empleados de la sede.
	 * @param pNuevoNumero El nuevo n�mero de empleados de la sede.
	 */
	public void setNombre(String pNuevoNombre) {
		this.nombre = pNuevoNombre;
	}

}
