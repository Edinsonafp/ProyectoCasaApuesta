package vista;

import controlador.Controlador;

public class Modulo5_Interfaz {
	
	private VentanaCPS_Modulo5 ventanaCPS_Modulo5;
	private VentanaCAPCS_Modulo5 ventanaCAPCS_Modulo5;
	private VentanaCVTAC_Modulo5 ventanaCVTAC_Modulo5;
	private VentanaDAC_Modulo5 ventanaDAC_Modulo5;
	
	public Modulo5_Interfaz (Controlador control) {
		
		ventanaCPS_Modulo5 = new VentanaCPS_Modulo5(control);
		ventanaCAPCS_Modulo5 = new VentanaCAPCS_Modulo5(control);
		ventanaCVTAC_Modulo5 = new VentanaCVTAC_Modulo5(control);
		ventanaDAC_Modulo5 = new VentanaDAC_Modulo5(control);
		
		
	}

	public VentanaCPS_Modulo5 getVentanaCPS() {
		return ventanaCPS_Modulo5;
	}

	public void setVentanaCPS(VentanaCPS_Modulo5 ventanaCPS_Modulo5) {
		this.ventanaCPS_Modulo5 = ventanaCPS_Modulo5;
	}

	public VentanaCAPCS_Modulo5 getVentanaCAPCS() {
		return ventanaCAPCS_Modulo5;
	}

	public void setVentanaCAPCS(VentanaCAPCS_Modulo5 ventanaCAPCS_Modulo5) {
		this.ventanaCAPCS_Modulo5 = ventanaCAPCS_Modulo5;
	}

	public VentanaCVTAC_Modulo5 getVentanaCVTAC() {
		return ventanaCVTAC_Modulo5;
	}

	public void setVentanaCVTAC(VentanaCVTAC_Modulo5 ventanaCVTAC_Modulo5) {
		this.ventanaCVTAC_Modulo5 = ventanaCVTAC_Modulo5;
	}

	public VentanaDAC_Modulo5 getVentanaDAC() {
		return ventanaDAC_Modulo5;
	}

	public void setVentanaDAC(VentanaDAC_Modulo5 ventanaDAC_Modulo5) {
		this.ventanaDAC_Modulo5 = ventanaDAC_Modulo5;
	}
	
	
	
	

}
