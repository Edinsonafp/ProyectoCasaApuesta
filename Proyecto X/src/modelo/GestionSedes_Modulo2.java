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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
 * Clase que representa la gesi�n de las sedes.
 */
public class GestionSedes_Modulo2 {
	
	//------------------------------------------------------------------------------------------------------
	// Atributos 
	//------------------------------------------------------------------------------------------------------
	/**
	 * Atributo que representa la sedeDAO.
	 */
	private SedeDAO_Modulo2 sedeDAO_Modulo2;

	
	//------------------------------------------------------------------------------------------------------
	// Constructor
	//------------------------------------------------------------------------------------------------------
	
	/**
	 *Inicializa el DAO de sede y le da tama�o a la lista de localidades de Bogot�. 
	 */
	public GestionSedes_Modulo2() {

		sedeDAO_Modulo2 = new SedeDAO_Modulo2();
	
	}
	
	//------------------------------------------------------------------------------------------------------
	// M�todos
	//------------------------------------------------------------------------------------------------------
	/**
	 * Lee un archivo txt con las localidades y las agrega a la contenedora.
	 * @return la contenedora con las localidades de Bogot�
	 * @throws Exception Si no se encuentra el archivo de localidades.
	 */
	public String[] darLocalidades() throws Exception {
		
		String[] listaLocalidades= new String[20];
		File f = new File("data\\Localidades.txt");
		int cont = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea!= null) {
				listaLocalidades[cont] = linea;
				linea = br.readLine();
				cont++;

			}
			fr.close();
		}
		catch ( IOException e) {
			throw new Exception( "No se encuentran las localidades en el archivo ");
		}	
		return listaLocalidades;
	}
	
	/**
	 * Verifica si existe el archivo de sedes.dat
	 * @return true si existe, false de lo contrario.
	 */
	public boolean verificarArchivo(){
		boolean rta = false;
		File actual = new File(sedeDAO_Modulo2.rutaReg);
		
		if(actual.exists()) {
			rta = true;
		}
		return rta;
		
	}
	
	
	//M�todos get de los atributos de la clase.
	
	
	public SedeDAO_Modulo2 getSede() {
		return sedeDAO_Modulo2;
	}

	public ArrayList<SedeDTO_Modulo2> darSedes(){
		return sedeDAO_Modulo2.leerArchivo();
	}

}