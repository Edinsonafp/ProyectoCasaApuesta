package modelo;

import java.io.Serializable;

public class MarcadoresDeFutbol_Modulo1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String local;
	private String visitante;
	private int marcador;
	private String tipo;
	private double presupuesto;
	
	public MarcadoresDeFutbol_Modulo1() {
		nombre = "Marcadores de futbol";
		local = null;
		visitante = null;
		marcador = 0;
		tipo = "deportivo";
		presupuesto = 0;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getVisitante() {
		return visitante;
	}


	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}


	public int getMarcador() {
		return marcador;
	}


	public void setMarcador(int marcador) {
		this.marcador = marcador;
	}


	public String getTipo() {
		return tipo;
	}


	public double getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
	
}
