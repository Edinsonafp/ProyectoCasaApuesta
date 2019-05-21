package vista;

import controlador.Controlador;

public class Modulo1_Interfaz {
	
	
	private VentanaCrearCasaApuesta_Modulo1 ventanaCrear;
	private VentanaModificarCasaApuesta_Modulo1 ventanaModificar;
	private VentanaMostrarCasadeApuesta_Modulo1 ventanaMostrar;
	
	public Modulo1_Interfaz (Controlador control) {
		
		ventanaCrear = new VentanaCrearCasaApuesta_Modulo1(control);
		ventanaModificar = new VentanaModificarCasaApuesta_Modulo1(control);
		ventanaMostrar = new VentanaMostrarCasadeApuesta_Modulo1(control);
	}

	public VentanaCrearCasaApuesta_Modulo1 getVentanaCrear() {
		return ventanaCrear;
	}

	public void setVentanaCrear(VentanaCrearCasaApuesta_Modulo1 ventanaCrear) {
		this.ventanaCrear = ventanaCrear;
	}

	public VentanaModificarCasaApuesta_Modulo1 getVentanaModificar() {
		return ventanaModificar;
	}

	public void setVentanaModificar(VentanaModificarCasaApuesta_Modulo1 ventanaModificar) {
		this.ventanaModificar = ventanaModificar;
	}

	public VentanaMostrarCasadeApuesta_Modulo1 getVentanaMostrar() {
		return ventanaMostrar;
	}

	public void setVentanaMostrar(VentanaMostrarCasadeApuesta_Modulo1 ventanaMostrar) {
		this.ventanaMostrar = ventanaMostrar;
	}
	
	
	
	

}
