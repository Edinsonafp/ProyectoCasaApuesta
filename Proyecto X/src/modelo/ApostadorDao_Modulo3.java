package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ApostadorDao_Modulo3 {
	//----------------------------------------------------------------------------------------------------------
	// Atributos
	//---------------------------------------------------------------------------------------------------------
	
	/**
	 * Atributo que representa la lista donde se guardan los objetos de apoostador
	 */
	private ArrayList<ApostadorDto_Modulo3>apostadores;
	
	/**
	 * Atributo que representa la ruta donde se guarda el ArrayList de objetos de tipo
	 * ApostadorDto
	 */
	private String ruta;
	

	//----------------------------------------------------------------------------------------------------------
	// Constructor
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa el ArrayList de apostadores y la ruta
	 * 
	 */
	public ApostadorDao_Modulo3() {
		
		apostadores = new ArrayList<>();
		ruta = "data\\apostadores.dat";
	}
	
	//----------------------------------------------------------------------------------------------------------
	// M�todos
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Verifica la existencia de una cedula 
	 * @param cedula
	 * @return true si existe , false si no existe
	 */
	public boolean estaEnLista(int cedula) {
		
		boolean rta = false;
		System.out.println(apostadores.size());
		System.out.println("Esta es" + cedula);
		for (int i = 0; i<apostadores.size(); i++) {
			ApostadorDto_Modulo3 actual=apostadores.get(i);
			
			if (actual.getCedula() == cedula) {
				rta = true;
			}
		}
		
		return rta;
	}
	
	/**
	 * Verifica la existencia de una cedula en el ArrayList de apostadores  
	 * @param cedula
	 * @return el objeto con la misma cedula entrada por parametro
	 * 		   null si no hay ningun objeto con la cedulaentrada por parametro
	 */
	public ApostadorDto_Modulo3 encontrarApostador(int cedula) {
		ApostadorDto_Modulo3 rta=null;
		
		for(int i=0;i<apostadores.size();i++) {
			ApostadorDto_Modulo3 actual=apostadores.get(i);
			if(actual.getCedula()==cedula) {
				rta=actual;
			}
		}
		
		return rta;
	}
	
	/**
	 * Valida que el archivo "apostadores.dat" est� creado para poder modificar los datos
	 * @return true si existe , false si no existe
	 */
	public boolean exisistenciaArchivo() {
		
		boolean rta = false;
		File actual = new File(ruta);
		
		if (actual.exists()) {
			rta = true;
		}
		
		return rta;
	}
	
	/**
	 * Guarda en el archivo "apostadores.dat" un ArrayList de objetos ApostadorDto
	 * @param apostador
	 * @return true si Guard�, fasle si no
	 */
	public boolean guardarDato(ArrayList<ApostadorDto_Modulo3> apostador) {
	 
		boolean rta = false;

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.writeObject(apostador);
			out.close();
			rta = true;	
		}
		catch(IOException r) {
			r.printStackTrace();	
		}
		
		return rta;
	}
	/**
	 * Crea el Archivo Apostadores con el nombre "apostadores.dat"
	 * @return true si lo crea , false si no 
	 */
	public boolean CrearArchivo() {
		boolean rta = false;
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta));
			out.close();
			rta=true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return rta;
	}
	
	//----------------------------------------------------------------------------------------------------------
	// M�todos CRUD
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Crea un nuevo objeto de tipo ApostadorDto y actualiza el ArrayList apostadores 
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param sedeDeJuego
	 * @param direccion
	 * @param celular
	 * @return
	 */
	public String crearApostador(String nombre,String apellido,int cedula,String sedeDeJuego,String direccion,int celular) {
		
		String rta = "No Fue posible Crear el Apostador con la cedula "+cedula;
		ApostadorDto_Modulo3 nuevo = null;
		
		if (estaEnLista(cedula) == false) {	
			nuevo = new ApostadorDto_Modulo3(nombre, apellido, cedula, sedeDeJuego, direccion, celular);
			apostadores.add(nuevo);
			rta="Apostador creado con exito";
		}
		
		guardarDato(apostadores);
		
		return rta;
	}
	
	
	/**
	 * Lee el archivo y devuelve los datos de los apostadores.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String leerApostador() {
	
		String rta = "";
		ObjectInputStream in;
		ArrayList<ApostadorDto_Modulo3> actual = apostadores;
		
		try {
			in = new ObjectInputStream(new FileInputStream(ruta));
			apostadores = (ArrayList<ApostadorDto_Modulo3>) in.readObject();
			in.close();
			
			for (int i=0;i<apostadores.size();i++) {
				
				rta += "NOMBRE: " + apostadores.get(i).getNombre()+"\n";
				rta += "APELLIDO: " + apostadores.get(i).getApellido()+"\n";
				rta += "IDENTIFICACION: " + apostadores.get(i).getCedula()+"\n";
				//rta += "SEDE: " + actual.get(i).getSedeDeJuego().toString();
				rta += "DIRECCION: " + apostadores.get(i).getDireccion()+"\n";
				rta += "CELULAR: " + apostadores.get(i).getCelular();
			}			
		}
		catch (IOException  | ClassNotFoundException a) {
			a.printStackTrace();
		}
		
		return rta;
	}
	
	/**
	 * Actualiaza los datos de apostador
	 * @param cedula
	 * @param nNombre
	 * @param nApellido
	 * @param nSede
	 * @param nDireccion
	 * @param nCelular
	 * @return Exitoso si fue posible modificar , Error si no fue posible modificar
	 */
	public String ActualizarApostador(int cedula,String nNombre,String nApellido,String nSede,String nDireccion,int nCelular ) {
		
		String rta = "No existe el Apostador";
		
		for (int i = 0; i<apostadores.size(); i++) {
			
			ApostadorDto_Modulo3 actual = apostadores.get(i);
			
			
			if(actual.getCedula() == cedula ) {
				actual.setNombre(nNombre);
				actual.setApellido(nApellido);
				actual.setSedeDeJuego(nSede);
				actual.setDireccion(nDireccion);
				actual.setCelular(nCelular);
				
				rta = "Exitoso";
			}
			else { rta = "Error"; }
		}
		guardarDato(apostadores);
		
		return rta;
	}
	
	/**
	 * Busca un Apostador por cedula y lo elimina de la lista apostadores.
	 * @param cedula
	 * @return
	 */
	public String eliminarApostador(int cedula) {
	
		String rta="Error";
		System.out.println("que se dice");
		for (int i = 0; i<apostadores.size(); i++) {
			
			ApostadorDto_Modulo3 actual = apostadores.get(i);
			
			if (actual.getCedula() == cedula) {
				
				apostadores.remove(actual);
				rta="eliminado";
			}
		}
		
		guardarDato(apostadores);
		
		return rta;
	}
	
	//----------------------------------------------------------------------------------------------------------
	// M�todos GET y SET
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @return lista de apostadores
	 */
	public ArrayList<ApostadorDto_Modulo3> getApostadores() {
		return apostadores;
	}
	
	/**
	 * Modifica la lista de apostadores
	 * @param apostadores
	 */
	public void setApostadores(ArrayList<ApostadorDto_Modulo3> apostadores) {
		this.apostadores = apostadores;
	}
	

}
