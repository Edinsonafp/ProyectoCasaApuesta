package modelo;

public class Mundo_Modelo2 {
	
	private GestionSedes_Modulo2 gestionSedes;
	private SedeDAO_Modulo2 sedeDAO;
	private SedeDTO_Modulo2 sedeDTO;
	public Mundo_Modelo2 () {
		
		gestionSedes = new GestionSedes_Modulo2();
		sedeDAO = new SedeDAO_Modulo2();
		//sedeDTO = new SedeDTO_Modulo2();
		
		
	}
	public GestionSedes_Modulo2 getGestionSedes() {
		return gestionSedes;
	}
	public void setGestionSedes(GestionSedes_Modulo2 gestionSedes) {
		this.gestionSedes = gestionSedes;
	}
	public SedeDAO_Modulo2 getSedeDAO() {
		return sedeDAO;
	}
	public void setSedeDAO(SedeDAO_Modulo2 sedeDAO) {
		this.sedeDAO = sedeDAO;
	}
	public SedeDTO_Modulo2 getSedeDTO() {
		return sedeDTO;
	}
	public void setSedeDTO(SedeDTO_Modulo2 sedeDTO) {
		this.sedeDTO = sedeDTO;
	}
	
	

}
