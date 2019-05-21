/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad El Bosque (Bogot� - Colombia)
 * Facultad de Ingenier�a.
 * 
 * Proyecto Gesti�n casa de apuestas.
 * M�dulo 2: Gesti�n de sedes.
 * Autores: Jairo Urbina, Daniela L�pez, Andrea D�az, Sergio Solano.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que utiliza m�todos chad para objetos de tipo SedeDTO.
 *
 */
public class SedeDAO_Modulo2 {
	
	//----------------------------------------------------------------------------------------------------------
	// Atributos
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Atributo que representa la ruta del archivo sedes.dat;
	 */
	public String rutaReg= "./data/sedes.dat";
	
	/**
	 * Atributo que representa la lista con las sedes.
	 */
	private ArrayList<SedeDTO_Modulo2> sedes;
	
	//----------------------------------------------------------------------------------------------------------
	// Constructor
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa la lista de sedes.
	 */
	public SedeDAO_Modulo2(){
		sedes = new ArrayList<SedeDTO_Modulo2>();
		sedes = leerArchivo();
	}
	
	//----------------------------------------------------------------------------------------------------------
	// M�todos
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Busca una sede por el nombre dado por par�metro.
	 * @param pNombreSede. El nombre de la sede a buscar. pNombreSede != null.
	 * @return La sede con el nombre. null si la sede no existe.
	 */
	public SedeDTO_Modulo2 buscarSede(String pNombreSede) {
		SedeDTO_Modulo2 buscado =null;
		for(int i=0;i<sedes.size();i++) {
			if(sedes.get(i).getNombre().equals(pNombreSede)) {
				buscado = sedes.get(i);
			}
		}
		return buscado;
	}
	
	
	/**
	 * Sobreescribe el archivo de sedes.
	 * @return True si se pudo escribir, false si no.
	 */
	public  boolean escribirArchivo() {
		
		boolean sePudo = false;
		 
			try {
			
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaReg));
				out.writeObject(sedes);
				out.close();
				sePudo=true;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return sePudo;
		}
	
	//----------------------------------------------------------------------------------------------------------
	// M�todos CHAD
	//----------------------------------------------------------------------------------------------------------
	
	/**
	 * Crea una sede y la a�ade a la lista.
	 * @param pNumEmpleados. El n�mero de empleados que tendr� la nueva sede. int pNumEmpleados > 0. 
	 * @param pLocalidad. La localidad en la cual se crear� la nueva sede.
	 * @param pNombre. El nombre que tendr� la nueva sede.
	 * @throws Exception Si;
	 * 1.Ya existe una sede con el nombre ingresado.
	 */
	public void crearSede(int pNumEmpleados, String pNombreSede, String pLocalidad) throws Exception  {
		
		if(buscarSede(pNombreSede)!=null) {
			throw new Exception("Ya existe una sede con el nombre ingresado");
		}
		SedeDTO_Modulo2 nuevo = new SedeDTO_Modulo2(pNumEmpleados, pNombreSede, pLocalidad);
		sedes.add(nuevo);
		escribirArchivo();
	}
	
	/**
	 * Modifica los datos de una sede y lo actualiza en la lista.
	 * @param pNombre. Nombre de la sede a modificar. pNombre != null.
	 * @param pNombreNuevo. Nombre nuevo que tendr� la sede. pNombreNuevo !=Null.
	 * @param pNumeroEmpleadosNuevo. el nuevo n�mero de empleados que tendr� la sede. pNumeroEmpleadosNuevo >0.
	 * @throws Exception Si el nombre nuevo es igual al nombre ya existente.
	 */
	public void modificarDatosSedes(String pNombreSede, int pNumeroEmpleadosNuevo, String pNombreNuevo) throws Exception {
		
		if(pNombreSede.equals(pNombreNuevo)) {
			throw new Exception("EL nuevo nombre es igual al nombre ya existente");
		}
		SedeDTO_Modulo2 buscado = buscarSede(pNombreSede);
		
		if(pNombreNuevo.equals("$$$")) {
			pNombreNuevo=buscado.getNombre();
		}
		
		if(pNumeroEmpleadosNuevo==-1) {
			pNumeroEmpleadosNuevo = buscado.getNumEmpleados();
			}
		
			if(buscarSede(pNombreSede)!=null) {
			buscado.setNombre(pNombreNuevo);
			buscado.setNumEmpleados(pNumeroEmpleadosNuevo);
			escribirArchivo();
			}
		
	
	}
	
	/**
	 * Busca una sede por nombre y la elimina de la lista.
	 * @param pNombre. El nombre de la sede. pNombre != null.
	 */
	public void eliminarSede (String pNombreSede) throws Exception{
		
		if(buscarSede(pNombreSede)==null) {
			throw new Exception("La sede que se intenta eliminar no existe");
		}
		else {
			
		SedeDTO_Modulo2 eliminar = buscarSede(pNombreSede);
		sedes.remove(eliminar);
		escribirArchivo();
		}
	}
	
	/**
	 * Lee el archivo y devuelve la lista de sedes.
	 * @return La lista de sedes.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SedeDTO_Modulo2> leerArchivo() {
		
		
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(rutaReg));
			sedes = (ArrayList<SedeDTO_Modulo2>)in.readObject();
			in.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sedes;
	}
}
