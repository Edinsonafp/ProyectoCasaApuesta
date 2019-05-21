package modelo;

import java.io.Serializable;

public class ApostadorDto_Modulo3 implements Serializable {

	// -----------------------------------------------------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------------------------------------------------

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el nombre del apostador
	 */
	private String nombre;

	/**
	 * Atributo que representa el apellido del apostador
	 */
	private String apellido;

	/**
	 * Atributo que representa la cedula del apostador
	 */
	private int cedula;

	/**
	 * Atributo que representa la sede De juego
	 */
	private String sedeDeJuego;

	/**
	 * Atributo que representa la direccion del apostador
	 */
	private String direccion;

	/**
	 * Atributo que representa el celular del apostador
	 */
	private int celular;

	// -----------------------------------------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------------------------------------

	/**
	 * Construye una nueva instancia de Apostador
	 * 
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param sedeDeJuego2
	 * @param direccion
	 * @param celular
	 */
	public ApostadorDto_Modulo3(String nombre, String apellido, int cedula, String sedeDeJuego2, String direccion,
			int celular) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.sedeDeJuego = sedeDeJuego2;
		this.direccion = direccion;
		this.celular = celular;

	}

	// -----------------------------------------------------------------------------------------------------------
	// M�todos get y set
	// -----------------------------------------------------------------------------------------------------------

	/**
	 * 
	 * @return el nombre del apostador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de apostador
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return el apellido del apostador
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Modifica el apellido del apostador
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return la cedula del apostador
	 */
	public int getCedula() {
		return cedula;
	}

	/**
	 * Modifica la cedula del apostador
	 * 
	 * @param cedula
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	 * 
	 * @return sede de juego del apostador
	 */
	public String getSedeDeJuego() {
		return sedeDeJuego;
	}

	/**
	 * Modifica la sede de juego del apostador
	 * 
	 * @param sedeDeJuego
	 */
	public void setSedeDeJuego(String sedeDeJuego) {
		this.sedeDeJuego = sedeDeJuego;
	}

	/**
	 * 
	 * @return direccion del jugador
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direccion del apostador
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return numero de celular del apostador
	 */
	public int getCelular() {
		return celular;
	}

	/**
	 * Modifica el numero celular del apostador
	 * 
	 * @param celular
	 */
	public void setCelular(int celular) {
		this.celular = celular;
	}
}
