package modelo;

public class Juegos_Modulo1 {

	
	private Baloto_Modulo1 baloto_Modulo1;
	private MarcadoresDeFutbol_Modulo1 marcadores;
	private Superastro superastro;
	
	public Juegos_Modulo1() {
		
		baloto_Modulo1 = new Baloto_Modulo1();
		marcadores= new MarcadoresDeFutbol_Modulo1();
		superastro = new Superastro();
		
		
	}

	public Baloto_Modulo1 getBaloto() {
		return baloto_Modulo1;
	}

	public void setBaloto(Baloto_Modulo1 baloto_Modulo1) {
		this.baloto_Modulo1 = baloto_Modulo1;
	}

	public MarcadoresDeFutbol_Modulo1 getMarcadores() {
		return marcadores;
	}

	public void setMarcadores(MarcadoresDeFutbol_Modulo1 marcadores) {
		this.marcadores = marcadores;
	}

	public Superastro getSuperastro() {
		return superastro;
	}

	public void setSuperastro(Superastro superastro) {
		this.superastro = superastro;
	}
	
	
}
