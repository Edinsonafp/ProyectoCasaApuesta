package modelo;

import modelo.ApuestasDAO_Modulo4;

public class Mundo_Modulo4 {

	private ApuestasDAO_Modulo4 apuestas;
	private SedeDAO_Modulo2 sedeDao;
	
	
	public Mundo_Modulo4() {
		
		apuestas = new ApuestasDAO_Modulo4();
		sedeDao = new SedeDAO_Modulo2();
		
	}
	
	public ApuestasDAO_Modulo4 getApuestas() {
		return apuestas;
	}

	public void setApuestas(ApuestasDAO_Modulo4 apuestas) {
		this.apuestas = apuestas;
	}

	public SedeDAO_Modulo2 getSedeDao() {
		return sedeDao;
	}

	public void setSedeDao(SedeDAO_Modulo2 sedeDao) {
		this.sedeDao = sedeDao;
	}

	
}
