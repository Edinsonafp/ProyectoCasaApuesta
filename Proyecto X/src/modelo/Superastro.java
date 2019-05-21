package modelo;

import java.io.Serializable;

public class Superastro implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int[] numero;
	private String signoZodiacal;
	private double presupuesto;
	private String tipo;
	
	public Superastro() {
		nombre = "Superastro";
		numero = new int[4];
		signoZodiacal = null;
		presupuesto = 0;
		tipo = "loteria";
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getNumero() {
		return numero;
	}

	public void setNumero(int[] numero) {
		this.numero = numero;
	}

	public String getSignoZodiacal() {
		return signoZodiacal;
	}

	public void setSignoZodiacal(String signoZodiacal) {
		this.signoZodiacal = signoZodiacal;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}
