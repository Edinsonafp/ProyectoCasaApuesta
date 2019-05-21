package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CasaDeApuestas_Modulo1 {
	protected String nombreCasa;
	protected int numeroSedes;
	protected double presupuesto;
	protected ArrayList<MarcadoresDeFutbol_Modulo1> marcadores;
	public CasaDeApuestas_Modulo1(String nombreCasa, int numeroSedes, double presupuesto ) {
		
		this.nombreCasa=nombreCasa;
		this.numeroSedes=numeroSedes;
		this.presupuesto=presupuesto;
		marcadores = new ArrayList<MarcadoresDeFutbol_Modulo1>();
		
	}

	public String getNombreCasa() {
		return nombreCasa;
	}

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
	}

	public int getNumeroSedes() {
		return numeroSedes;
	}

	public void setNumeroSedes(int numeroSedes) {
		this.numeroSedes = numeroSedes;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public String validacionSedes(int numeroSedes) {
		String mensaje;
		if (( numeroSedes>0 )&&( numeroSedes<1000 )) {
			mensaje="Numero de sedes validado";
		}else {
			mensaje="Error, ingreso de sedes incorrecto";
		}
		return mensaje;
	}
	
	
	public String validacionPresupuesto(double presupuesto) {
		String mensaje;
		if ( presupuesto>0 ) {	
			mensaje="Numero de presupuesto validado";
		}else {
			mensaje="Error, ingreso de presupuesto incorrecto";
		}
		return mensaje;
	}
	
	
	
}
