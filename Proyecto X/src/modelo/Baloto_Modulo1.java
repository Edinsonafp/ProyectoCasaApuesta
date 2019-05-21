package modelo;

import java.io.Serializable;

public class Baloto_Modulo1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int[] cifras;
	private double presupuesto;
	private String tipo;
	
	public Baloto_Modulo1() {
		nombre = "Baloto";
		cifras = new int[6];
		presupuesto = 0;
		tipo = "chance";
	}
	//Valida las cifras que esten entre 1 y 45 y las asigna al arreglo
	
	public void validarCifras(int[] numeros) {
		for (int i = 0; i < cifras.length; i++) {
			for (int j = 0; j < cifras.length; j++) {
				while(cifras[i] > 0 && cifras[i] < 46 && cifras[i] != cifras[j]) {
					cifras[i] = numeros[i];
				}
			}
		}
	}
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int[] getCifras() {
		return cifras;
	}


	public void setCifras(int[] cifras) {
		this.cifras = cifras;
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
