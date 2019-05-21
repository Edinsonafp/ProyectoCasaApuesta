package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropiedadesCasaApuesta_Modulo1 {

	private Properties prop;
	private String archivoprop;
	private String nombre1;
	private String numeroSedes1;
	private String presupuestoTotal1;
	private String respuesta;
	private CasaDeApuestas_Modulo1 casaApusta;


	public PropiedadesCasaApuesta_Modulo1() {
		
		
		archivoprop = "data\\config.properties";
		prop = new Properties();
		nombre1 = null;
		numeroSedes1 = null;
		presupuestoTotal1 = null;
		respuesta = "";

	}

	/*
	 * metodo que crea eñ archivo config.properties, recibe los tres datos
	 * ingresados en la interfaz y que los tendra controlador, el cual lo dara al
	 * metodo. se crean las variables nombre1, numerosedes1 y presupuestototal1,
	 * donde se se guardaran los parametros
	 */
	public String crearPropiedades(String nombre, String numeroSedes, String presupuestoTotal) 
	{
		
		
		nombre1 = nombre;
		numeroSedes1 = numeroSedes;
		presupuestoTotal1 = presupuestoTotal;
		/*int numeroSe = Integer.parseInt(numeroSedes1);
		double PresupuestoT = Double.parseDouble(presupuestoTotal1);*/
			
				// si los parametros estan vacios mandara error porque los espacios en la interfaz no ah sido llenados por completo. y se  verifica que  
		 //el numero de sedes y el presupuesto sea mayor a cero y el numero de sedes solo tenga tres gitos maximo.
		  // sino se guardaran las variables nombre, numerso sedes y presupuesto en el archivo que se crea.
			/*	if (nombre.equals("")  || numeroSedes.equals("") || presupuestoTotal.equals("") || numeroSe <= 0 || PresupuestoT <= 0 || numeroSe > 1000) 
				{
					respuesta = "error de datos";
				}
				else
				{*/
		try {
					prop.setProperty("nombre", nombre1);
					prop.setProperty("numeroDeSedes",numeroSedes1);
					prop.setProperty("presupuesto",presupuestoTotal1);
				
						prop.store(new FileOutputStream(archivoprop), null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					respuesta = "archivo propiedades creado";
			//	}

				
			

		return respuesta;

	}

	/*
	 * los metodos leer uno leer 2 y leer 3 , cada uno lee una de las tres variables
	 * que se guardaron , leer1 lee el nombre , leer2 lee el numero de sedes y leer3
	 * lee el presupuesto
	 */

	public String leer1() {
		String respuesta1 = "";

		try {
			prop.load(new FileInputStream(archivoprop));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		respuesta1 = prop.getProperty("nombre ");

		return respuesta1;
	}

	public String leer2() {
		String respuesta1 = "";

		try {
			prop.load(new FileInputStream(archivoprop));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		respuesta1 = prop.getProperty("numeroDeSedes ");

		return respuesta1;
	}

	public String leer3() {
		String respuesta1 = "";

		try {
			prop.load(new FileInputStream(archivoprop));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		respuesta1 = prop.getProperty("presupuesto ");

		return respuesta1;
	}

	/*
	 * el metodo de modificar archivo recibe tre parametros que seran los parametros
	 * que recibira de vista
	 * 
	 */
	
	
	public String modificarPropiedades(String nombre, String numeroSedes, String presupuestoTotal) {

		// si los parametros estan vacios mandara error porque los espacios en la
		// interfaz no ah sido llenados por completo. y se verifica que
		// el numero de sedes y el presupuesto sea mayor a cero y el numero de sedes
		// solo tenga tres gitos maximo.

		String respuesta1 = "";

		nombre1 = nombre;
		numeroSedes1 = numeroSedes;
		presupuestoTotal1 = presupuestoTotal;
		int numeroSe = Integer.parseInt(numeroSedes1);
		double PresupuestoT = Double.parseDouble(presupuestoTotal1);

		if (nombre.equals("") || numeroSedes.equals("") || presupuestoTotal.equals("") || numeroSe <= 0
				|| PresupuestoT <= 0 || numeroSe > 1000) {
			respuesta1 = "error en la operacion";
		}

		else {
			prop.setProperty("nombre ", nombre1);
			prop.setProperty("numeroDeSedes ", numeroSedes1);
			prop.setProperty("presupuesto ", presupuestoTotal1);
			try {
				prop.store(new FileOutputStream(archivoprop), null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			respuesta1 = "exitosa la operación";

		}

		return respuesta1;
	}

}
