package modelo;

public class Mundo_Modulo1 {
	
	private ArchivoJuegos_Modulo1 archivo;
	private Baloto_Modulo1 baloto;
	private CasaDeApuestas_Modulo1 casaApuesta;
	private Juegos_Modulo1 juegos;
	private MarcadoresDeFutbol_Modulo1 futbol;
	private PropiedadesCasaApuesta_Modulo1 propiedades;
	
	
	public Mundo_Modulo1 () {
		archivo = new ArchivoJuegos_Modulo1();
		baloto = new Baloto_Modulo1();
		casaApuesta = new CasaDeApuestas_Modulo1(null, 0, 0);
		juegos = new Juegos_Modulo1();
		futbol = new MarcadoresDeFutbol_Modulo1();
		propiedades = new PropiedadesCasaApuesta_Modulo1();
	}

	public void crearCasa(String nombre, int sedes, double presupuesto) {
		casaApuesta.setNombreCasa(nombre);
		casaApuesta.setNumeroSedes(sedes);
		casaApuesta.setPresupuesto(presupuesto);
		System.out.println("En casa de apuesta mundo");
	}

	public ArchivoJuegos_Modulo1 getArchivo() {
		return archivo;
	}


	public void setArchivo(ArchivoJuegos_Modulo1 archivo) {
		this.archivo = archivo;
	}


	public Baloto_Modulo1 getBaloto() {
		return baloto;
	}


	public void setBaloto(Baloto_Modulo1 baloto) {
		this.baloto = baloto;
	}


	public CasaDeApuestas_Modulo1 getCasaApuesta() {
		return casaApuesta;
	}


	public void setCasaApuesta(CasaDeApuestas_Modulo1 casaApuesta) {
		this.casaApuesta = casaApuesta;
	}


	public Juegos_Modulo1 getJuegos() {
		return juegos;
	}


	public void setJuegos(Juegos_Modulo1 juegos) {
		this.juegos = juegos;
	}


	public MarcadoresDeFutbol_Modulo1 getFutbol() {
		return futbol;
	}


	public void setFutbol(MarcadoresDeFutbol_Modulo1 futbol) {
		this.futbol = futbol;
	}


	public PropiedadesCasaApuesta_Modulo1 getPropiedades() {
		return propiedades;
	}


	public void setPropiedades(PropiedadesCasaApuesta_Modulo1 propiedades) {
		this.propiedades = propiedades;
	}
	
	

}
