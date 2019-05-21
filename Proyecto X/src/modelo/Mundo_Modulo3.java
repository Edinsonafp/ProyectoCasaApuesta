package modelo;

import java.util.ArrayList;



public class Mundo_Modulo3 {
	//----------------------------------------------------------------------------------------------------------
			// Atributos
			//---------------------------------------------------------------------------------------------------------

		
			/**
			 * Atributo que representa una nueva instacia de sedeDao
			 */
			private SedeDAO_Modulo2 sedeDao;
			
			/**
			 * Atributo que representa una nueva instacia de ApostadorDao
			 */
			private ApostadorDao_Modulo3 apostadorDao;

			//----------------------------------------------------------------------------------------------------------
			// Constructor
			//----------------------------------------------------------------------------------------------------------
			
			/**
			 * Inicializa los atributos
			 */
			public Mundo_Modulo3() {
				
				sedeDao = new SedeDAO_Modulo2();
				apostadorDao = new ApostadorDao_Modulo3();
			}
			

			//----------------------------------------------------------------------------------------------------------
			// M�todos
			//----------------------------------------------------------------------------------------------------------
			
			public ApostadorDto_Modulo3 encontrar(int cedula) {
				return apostadorDao.encontrarApostador(cedula);
			}
			
			public ArrayList<SedeDTO_Modulo2> getSedes(){
				return sedeDao.leerArchivo();
			}
			
			
			public String crearNuevoUsuario(String nombre,String apellido,int cedula,String sedeDeJuego,String direccion,int celular) {
				
				System.out.println("USUARIO CREADO" + "\n");
				return apostadorDao.crearApostador(nombre, apellido, cedula, sedeDeJuego, direccion, celular);
			}
			
			public void buscarUsuario(int cedula) {
				
				System.out.println("BUSCANDO USUARIO" + "\n");
				System.out.println(apostadorDao.encontrarApostador(cedula));
			}
			
			public boolean usuarioExistente(int cedula) {
				
				System.out.println("BUSCANDO USUARIO" + "\n");
				System.out.println(apostadorDao.encontrarApostador(cedula));
				
				return (apostadorDao.estaEnLista(cedula));
			}
			
			public void pruebaArchivo() {
				System.out.println(apostadorDao.CrearArchivo());
			}
			
			
			public void leerArchivo() {
				System.out.println(apostadorDao.leerApostador());
			}
			
			public String actualizarUsuario(String nombre,String apellido,int cedula,String sedeDeJuego,String direccion,int celular) {
				System.out.println("USUARIO ACTUALIZADO" + "\n");
				return apostadorDao.ActualizarApostador(cedula, nombre, apellido, sedeDeJuego, direccion, celular);
			}
			
			public String elminarApostador(int cedula) {
				return apostadorDao.eliminarApostador(cedula);
			}
	
		
	}
