/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad El Bosque (Bogotá - Colombia)
 * Facultad de Ingeniería.
 * 
 * Proyecto Gestión casa de apuestas.
 * Módulo 4: Apuestas.
 * Autores: Daniel Otero,Brihan Herrera ,Yeferson Linares ,Felipe Galindo .
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;

import modelo.ApuestasDTO_Modulo4.Tipo;

public class ApuestasDAO_Modulo4 implements ApuestaInterface
{

	/**
	Atributos para inciar la clase DTO de apuestas
*/	
	private ApostadorDao_Modulo3 apostadores;
	private SedeDAO_Modulo2 sedes;
	private String factura;
	private String[] partidos;
	private ArrayList<String> nombresSede;
	private ArrayList<ApuestasDTO_Modulo4> datosPartidos;
	private ArrayList<ApuestasDTO_Modulo4> datosBaloto;
	private ArrayList<ApuestasDTO_Modulo4> datosSuperastro;
	private ArrayList<ApuestasDTO_Modulo4> datosMarcadores;
	
	/**
	Rutas donde seran guardados los archivos binarios
	 */
	
	
	private String rutaSuperastro = "./data/apuestas-superastro-";
	private String rutaBaloto = "./data/apuestas-baloto-";
	private String rutaMarcadores = "./data/apuestas-marcadores-";
	private String rutaSedes = "./data/sedes.dat";
	private String rutaApostadores = "./data/apostadores.dat";
	
	
	/**
	Constructor DAO incializa cada atributo
	se ejecutar el metodo LeerApostador con el fin de validar que existan apostadores antes de realizar cualquier tipo de apuesta
	 
	 */
	
	public ApuestasDAO_Modulo4()
	{
		System.out.println("entro");
		apostadores = new ApostadorDao_Modulo3();
		apostadores.leerApostador();
		sedes = new SedeDAO_Modulo2();

		datosBaloto = new ArrayList<>();
		datosMarcadores = new ArrayList<>();
		datosSuperastro = new ArrayList<>();
		this.nombresSede = new ArrayList<>();
		
		this.traerNombres();
	
	}

	/**
	Retorna arrelgo con todos los nombres de las sedes disponibles
*/
	
	public ArrayList<String> getNombresSede() {
		return nombresSede;
	}


	public void setNombresSede(ArrayList<String> nombresSede) {
		this.nombresSede = nombresSede;
	}

	/**
	Verifica que si existan sedes en las localidades guardandolas en arrayList
*/
	public void traerNombres() {
		
		ArrayList<SedeDTO_Modulo2> sede = new ArrayList<>();
		
		sede = this.sedes.leerArchivo();
		for(int i = 0; i < sede.size();i++) {
			this.nombresSede.add(sede.get(i).getNombre());
		}
		
		
	}

	/**
	
 	@param nombre: nombre del apostador , cc: cédula del apostador,Sede: sede donde se realizo la apuesta.
*/
	public String[] buscarNombre(String nombre, String cc,String sede) {
		String[] datos = new String[3];
		int cedula = Integer.parseInt(cc);
		
		for(int i = 0; i < apostadores.getApostadores().size(); i++) {
			
			if(apostadores.getApostadores().get(i).getCedula() == cedula && apostadores.getApostadores().get(i).getNombre().equals(nombre) ) {
				datos[0] = cc;
				datos[1] = nombre;
			}		
		}
		for(int i = 0; i < nombresSede.size() ; i++) {
			
			if(nombresSede.get(i).equals(sede)) {
				datos[2] = sede;
			}	
		}
		return datos;
	}
	
	public void factura(String cedula, String sede,String fecha,ArrayList<String> numBaloto, ArrayList<String> numZodiaco,ArrayList<String> zodiaco,double[] valorAstro,String precio ) {
		factura ="";
		int contador = 0;
		double contador2 = 0.0;
		factura = "Casa de apuestas"+"\n";
		factura += "\n";
		factura += "Cédula: "+ cedula +"\n";
		factura += "\n";
		factura += "Sede: "+ sede +"\n";
		factura += "\n";
		factura += "Fecha: "+ fecha +"\n";
		factura += "\n";
		factura += "Balotos :"+"\n";
		for(int i =0; i < numBaloto.size();i++) {
			factura += "  "+ i+1 + ": "+numBaloto.get(i) +"\n";
			contador+=1;
		}
		factura += "\n";
		contador = contador * 5000;
		factura += "Valor Total: "+ contador +"\n";
		factura += "\n";
		factura += "SuperAstro: " +"\n";
		for(int i =0; i < numZodiaco.size();i++) {
			factura +="  "+ i+1 + ": "+numZodiaco.get(i) +"\n";
			contador2 += valorAstro[i];
		}
		factura += "\n";
		factura += "Valor Total: "+ contador2 +"\n";
		factura += "\n";
		factura += "Fútbol: " +"\n";
		factura += "\n";
		factura += precio;
	}
	
	
public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	/*
	Crea un
*/
	public String[] cargarPartidos()
	{
		partidos = new String[] {"Nacional vs America","Millonarios vs Tolima","Equidad vs Medellin","Cali vs Pasto",
				"patriotas vs Cucuta","Santafe vs Huila","America vs Millonarios","Junior vs Nacional","Huila vs Tolima",
				"Equidad vs Pasto","Cali vs Cucuta","Pasto vs Patriotas","Santafe vs Huila","Junior vs Cali"};
		return partidos;
	}

	
	
	@Override
	public String crearApuesta(String nombreSede, int cedula, String dia, double valor, String zodiaco, int[] numerosSuperastro, Tipo tipo) 
	{
		ArrayList<ApuestasDTO_Modulo4> datosV = new ArrayList<>();
		boolean log = false;
		int contador = 0;
		String ruta = rutaSuperastro;
		String respuesta = "Se agrego";
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
//		int ced = Integer.parseInt(cedula);
		
		System.out.println(cedula);
		boolean bandera = apostadores.estaEnLista(cedula);
	
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		for(int a=0;a<numerosSuperastro.length;a++)
		{
			if(numerosSuperastro[a]>-1 && numerosSuperastro[a]<10)
			{
				contador++;
			}
		}
		if(contador==4)
		{
			log = true;
		}
		else
		{
			respuesta = "Ingresaste un número invalido";
		}
		System.out.println(bandera);
		System.out.println(sed.getNombre());
		System.out.println(log);
		
		if(bandera && sed!=null && log)
		{
			System.out.println(sed.getLocalidad());
			ruta +=sed.getLocalidad()+".dat";
			System.out.println(ruta);
			objeto.setSede(sed.getLocalidad());
			objeto.setCedula(cedula);
			objeto.setDia(dia);
			objeto.setValor(valor);
			objeto.setZodiaco(zodiaco);
			objeto.setNumerosSuperastro(numerosSuperastro);
			objeto.setTipo(tipo.SUPERASTRO);
			datosSuperastro.add(objeto);
			System.out.println(" Este es el zodiaco" + datosSuperastro.get(0).getZodiaco());
			for(int x=0;x<datosSuperastro.size();x++)
			{
				if(datosSuperastro.get(x).getSede().equals(sed.getLocalidad()))
				{
					datosV.add(datosSuperastro.get(x));
				}
			}
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(new FileOutputStream(ruta));
				out.writeObject(datosV);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			respuesta = "Fallo, no se logro agregar";
		}
		
		return respuesta;
	}

	@Override
	public String crearApuesta(String nombreSede, int cedula, String dia, double valor, int[] numerosBaloto,Tipo tipo) 
	{
		ArrayList<ApuestasDTO_Modulo4> datosV = new ArrayList<>();
		int contador = 0;
		int contador2 = 0;
		boolean log = false;
		
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = rutaBaloto+sed.getLocalidad()+".dat";
		String respuesta = "Se agrego";
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
//		int ced = Integer.parseInt(cedula);
		
		boolean bandera = apostadores.estaEnLista(cedula);
		
		for(int x=0; x<6;x++)
		{
			if(numerosBaloto[x]>=1 && numerosBaloto[x]<=45)
			{
				contador++;
				if(datosBaloto.size()==0)
				{
					log = true;
				}
				else
				{
					for(int z=0;z<datosBaloto.size();z++)
					{
						if(numerosBaloto[x]==datosBaloto.get(z).getNumerosBaloto()[x]) 
						{
							contador2++;
						}
					}
				}
			}
			else
			{
				respuesta = "No se agrego";
			}
		}
		if(contador==6 && contador2!=6)
		{
			log = true;
		}
		if(bandera && sed!=null && log)
		{
			objeto.setSede(sed.getLocalidad());
			objeto.setCedula(cedula);
			objeto.setDia(dia);
			objeto.setValor(valor);
			objeto.setNumerosBaloto(numerosBaloto);
			objeto.setTipo(tipo.BALOTO);
			datosBaloto.add(objeto);
			for(int p=0;p<datosBaloto.size();p++)
			{
				if(datosBaloto.get(p).getSede().equals(sed.getLocalidad()))
				{
					datosV.add(datosBaloto.get(p));
				}
			}
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(new FileOutputStream(ruta));
				out.writeObject(datosV);
				out.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			respuesta = "Fallo, no se logro agregar";
		}
		return respuesta;
	}

	@Override
	public String crearApuesta(String nombreSede, int cedula, String dia, int[] marcador,double valor, Tipo tipo) 
	{
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = rutaMarcadores+sed.getLocalidad()+".dat";
		ArrayList<ApuestasDTO_Modulo4> datosV = new ArrayList<>();
		String respuesta = "Se agrego";
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
//		int ced = Integer.parseInt(cedula);
				
		boolean bandera = apostadores.estaEnLista(cedula);
	
		
		if(bandera && sed !=null)
		{
			objeto.setSede(sed.getLocalidad());
			objeto.setCedula(cedula);
			objeto.setDia(dia);
			objeto.setValor(valor);
			objeto.setMarcador(marcador);
			objeto.setTipo(tipo.MARCADORES);
			datosMarcadores.add(objeto);
			for(int x=0;x<datosMarcadores.size();x++)
			{
				if(datosMarcadores.get(x).getSede().equals(sed.getLocalidad()))
				{
					datosV.add(datosMarcadores.get(x));
				}
			}
			ObjectOutputStream out;
			try {
				out = new ObjectOutputStream(new FileOutputStream(ruta));
				out.writeObject(datosV);
				out.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			respuesta = "Fallo, no se logro agregar";
		}
		return respuesta;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String borrarApuestas(int[] numerosSuperastro, String zodiaco, int cedula,String nombreSede) 
	{
		ArrayList<ApuestasDTO_Modulo4> datosSuperastro = new ArrayList<ApuestasDTO_Modulo4>();
		String respuesta = "Exito";
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = rutaSuperastro+sed.getLocalidad()+".dat";
		boolean log = false;
//		int ced = Integer.parseInt(cedula);
		
		boolean bandera = apostadores.estaEnLista(cedula);
		
		ObjectInputStream input;
			try 
			{
				input = new ObjectInputStream(new FileInputStream(ruta));
				datosSuperastro = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
				input.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		if(sed!=null && bandera)
		{
			int x = 0;
			while(x<datosSuperastro.size() && !log)
			{
				ApuestasDTO_Modulo4 pro = datosSuperastro.get(x);
				if(pro.getZodiaco().equals(zodiaco) && pro.getCedula()==cedula && pro.getNumerosSuperastro()[0]==numerosSuperastro[0]
						&& pro.getNumerosSuperastro()[1]==numerosSuperastro[1] && pro.getNumerosSuperastro()[2]==numerosSuperastro[2]
								&& pro.getNumerosSuperastro()[3]==numerosSuperastro[3])
				{
					datosSuperastro.remove(pro);
					ObjectOutputStream out;
					try 
					{
						out = new ObjectOutputStream(new FileOutputStream(ruta));
						out.writeObject(datosSuperastro);
						out.close();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					log = true;
				}
				else respuesta = "No se logro";
				x++;
			}
		}
		else respuesta = "No se encuentra la sede, o cedula del apostador";
		return respuesta;
	}

	@Override
	public String borrarApuestas(int[] numerosBaloto, int cedula, String nombreSede) 
	{
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String respuesta = "Exito";
		String ruta = rutaBaloto+sed.getLocalidad()+".dat";
		ArrayList<ApuestasDTO_Modulo4> datosBaloto = new ArrayList<>();
//		int ced = Integer.parseInt(cedula);
		
		boolean bandera = apostadores.estaEnLista(cedula);
	
		boolean log = false;
		ObjectInputStream input;
		try 
		{
			input = new ObjectInputStream(new FileInputStream(ruta));
			ArrayList<ApuestasDTO_Modulo4> datosApuestas = new ArrayList<ApuestasDTO_Modulo4>();
			datosBaloto = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(sed!=null && bandera)
		{
			for(int x=0;x<datosBaloto.size() && !log;x++)
			{
				ApuestasDTO_Modulo4 pro = datosBaloto.get(x);
				if(pro.getCedula()==cedula && pro.getNumerosBaloto()[0]==numerosBaloto[0] && pro.getNumerosBaloto()[1]==numerosBaloto[1] 
						&& pro.getNumerosBaloto()[2]==numerosBaloto[2] && pro.getNumerosBaloto()[3]==numerosBaloto[3] && pro.getNumerosBaloto()[4]==numerosBaloto[4]
								&& pro.getNumerosBaloto()[5]==numerosBaloto[5])
				{
					datosBaloto.remove(pro);
					ObjectOutputStream out;
					try 
					{
						out = new ObjectOutputStream(new FileOutputStream(ruta));
						out.writeObject(datosBaloto);
						out.close();
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
					log=true;
				}
				else
				{
					respuesta = "No se logro";
				}
			}
		}
		else
		{
			respuesta = "No se logro";
		}
		return respuesta;
	}

	@Override
	public String borrarApuestas(int cedula,int[] marcadores, String nombreSede) 
	{
		int contador = 0;
		boolean resp = false;
		ArrayList<ApuestasDTO_Modulo4> datosMarcadores = new ArrayList<ApuestasDTO_Modulo4>();
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = rutaMarcadores+sed.getLocalidad()+".dat";
		String respuesta = "Exito";
		boolean log = false;
		ObjectInputStream input;
//		int ced = Integer.parseInt(cedula);
		
		boolean bandera = apostadores.estaEnLista(cedula);
		
		if(sed!=null && bandera)
		{
			try 
			{
				input = new ObjectInputStream(new FileInputStream(ruta));
				datosMarcadores = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
				input.close();
			} catch (IOException | ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			for(int x=0;x<datosMarcadores.size() && !log;x++)
			{
				ApuestasDTO_Modulo4 pro = datosMarcadores.get(x);
				for(int a=0;a<14;a++)
				{
					if(pro.getMarcador()[a]==marcadores[a])
					{
						contador++;
					}
				}
				if(contador==14) resp = true;
				if(pro.getCedula()==cedula && resp)
				{
					datosMarcadores.remove(pro);
					log=true;
				}
				else
				{
					respuesta = "No se logro";
				}
			}
			ObjectOutputStream out;
			try 
			{
				out = new ObjectOutputStream(new FileOutputStream(ruta));
				out.writeObject(datosMarcadores);
				out.close();
			} catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			respuesta = "No se logro";
		}
		return respuesta;
	}
	
	@SuppressWarnings("unchecked")
	public String leerApuestas(Tipo tipo, String nombreSede)
	{
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = "";
		String mensaje = "Exito";
		ObjectInputStream input;
		if(tipo==tipo.BALOTO) ruta = rutaBaloto;
		if(tipo==tipo.MARCADORES) ruta = rutaMarcadores;
		if(tipo==tipo.SUPERASTRO) ruta = rutaSuperastro;
		try 
		{
			ruta+=sed.getLocalidad()+".dat";
			input = new ObjectInputStream(new FileInputStream(ruta));
			ArrayList<ApuestasDTO_Modulo4> datosApuestas = new ArrayList<>();
			datosApuestas = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
//			datosPartidos = (ArrayList<ApuestasDTO>)input.readObject();
			input.close();
		} catch (FileNotFoundException e) 
		{
			mensaje = "No se encontro el archivo, intenta escribir primero";
			e.printStackTrace();
		} catch (IOException e) 
		{
			mensaje = "Error de lectura";
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return mensaje;
	}

	@Override
	public String actualizarDatosApuestas(String nombreSede, int cedula, String dia, double valor, String zodiaco,int[] numerosSuperastro, Tipo tipo, int[] numerosSuperastroNuevo,String zodiacoNuevo)  
	{
		String respuesta = "Exito";
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		int x = 0;
		String ruta = rutaSuperastro+sed.getLocalidad()+".dat";
		boolean z = false;
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
		ArrayList<ApuestasDTO_Modulo4> datosRecibidos = new ArrayList<>();
		ObjectInputStream input;
		try 
		{
			input = new ObjectInputStream(new FileInputStream(ruta));
			datosRecibidos = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		while(x<datosRecibidos.size() && !z)
		{
			ApuestasDTO_Modulo4 pro = datosRecibidos.get(x);
			if(pro.getZodiaco().equals(zodiaco) && pro.getCedula()==cedula && pro.getNumerosSuperastro()[0]==numerosSuperastro[0]
			 && pro.getNumerosSuperastro()[1]==numerosSuperastro[1] && pro.getNumerosSuperastro()[2]==numerosSuperastro[2] && pro.getNumerosSuperastro()[3]==numerosSuperastro[3])
			{
				datosRecibidos.remove(pro);
				objeto.setCedula(cedula);
				objeto.setDia(dia);
				objeto.setNumerosSuperastro(numerosSuperastroNuevo);
				objeto.setValor(valor);
				objeto.setZodiaco(zodiacoNuevo);
				objeto.setSede(sed.getLocalidad());
				datosRecibidos.add(objeto);
				ObjectOutputStream out;
				try 
				{
					out = new ObjectOutputStream(new FileOutputStream(ruta));
					out.writeObject(datosRecibidos);
					out.close();
				} catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			x++;
		}
		return respuesta;
	}

	@Override
	public String actualizarDatosApuestas(String nombreSede, int cedula, String dia, double valor, int[] numerosBaloto, Tipo tipo, int[] numerosBalotoNuevo) 
	{
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String respuesta = "Exito";
		String ruta = rutaBaloto+sed.getLocalidad()+".dat";
		boolean log = false;
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
		ArrayList<ApuestasDTO_Modulo4> datosRecibidos = new ArrayList<>();
		ObjectInputStream input;
		try 
		{
			input = new ObjectInputStream(new FileInputStream(ruta));
			datosRecibidos = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
			input.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int x=0;x<datosRecibidos.size();x++)
		{
			ApuestasDTO_Modulo4 pro = datosRecibidos.get(x);
			if(cedula==pro.getCedula() && numerosBaloto[0]==pro.getNumerosBaloto()[0] && numerosBaloto[1]==pro.getNumerosBaloto()[1] && numerosBaloto[2]==pro.getNumerosBaloto()[2]
					&& numerosBaloto[3]==pro.getNumerosBaloto()[3] && numerosBaloto[4]==pro.getNumerosBaloto()[4] && numerosBaloto[5]==pro.getNumerosBaloto()[5])
			{
				datosRecibidos.remove(pro);
				objeto.setCedula(cedula);
				objeto.setDia(dia);
				objeto.setNumerosBaloto(numerosBalotoNuevo);
				objeto.setSede(sed.getLocalidad());
				objeto.setValor(valor);
				datosRecibidos.add(objeto);
				ObjectOutputStream out;
				try {
					out = new ObjectOutputStream(new FileOutputStream(ruta));
					out.writeObject(datosRecibidos);
					out.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return respuesta;
	}
	
	public ArrayList<String> darLocalidades ()
	{
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<SedeDTO_Modulo2> pro = new ArrayList<>();
		pro = sedes.leerArchivo();
		String dato = "";
		for (int i = 0; i < pro.size(); i++) {
			dato =pro.get(i).getLocalidad();
			lista.add(dato);
		}
		return lista;
	}

	@Override
	public String actualizarDatosApuestas(String nombreSede, int cedula, String dia, double valor, int[] marcador, int[] marcadorNuevo, Tipo tipo)
	{
		SedeDTO_Modulo2 sed = this.sedes.buscarSede(nombreSede);
		String ruta = this.rutaMarcadores+sed.getLocalidad()+".dat";
		int contador = 0;
		String respuesta = "Exito";
		boolean log = false;
		ApuestasDTO_Modulo4 objeto = new ApuestasDTO_Modulo4();
		ArrayList<ApuestasDTO_Modulo4> datosRecibidos = new ArrayList<>();
		ObjectInputStream input;
			try {
				input = new ObjectInputStream(new FileInputStream(ruta));
				datosRecibidos = (ArrayList<ApuestasDTO_Modulo4>)input.readObject();
				input.close();
			} catch (IOException e) {
				respuesta = "Error";
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				respuesta = "Error";
				e.printStackTrace();
			}
			for(int x=0;x<datosRecibidos.size();x++)
			{
				ApuestasDTO_Modulo4 pro = datosRecibidos.get(x);
				for(int z=0;z<pro.getMarcador().length;z++)
				{
					if(pro.getMarcador()[z]==marcador[z]) contador++;
				}
				if(contador==14) log = true;
				if(pro.getCedula()==cedula && log)
				{
					datosRecibidos.remove(pro);
					objeto.setCedula(cedula);
					objeto.setDia(dia);
					objeto.setMarcador(marcadorNuevo);
					objeto.setSede(sed.getLocalidad());
					objeto.setValor(valor);
					objeto.setTipo(Tipo.MARCADORES);
					datosRecibidos.add(objeto);
					ObjectOutputStream out;
					try {
						out = new ObjectOutputStream(new FileOutputStream(ruta));
						out.writeObject(datosRecibidos);
						out.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					respuesta = "Los datos no coinciden";
				}
			}
			System.out.println(respuesta);
		return respuesta;
	}
	
//	public String validarPartidos()
//	{
//		String respuesta = "Exito";
//		if(partidos.getPartidos().size()==14);
//		else respuesta = "No hay suficientes partidos";
//		return respuesta;
//	}
	
/**	public ArrayList<ApuestasDTO> modificarPartidos(String sede,String cedula)
	{
		Apostadores pro = apostadores1.buscarApostador(cedula);
		ArrayList<ApuestasDTO> datos = new ArrayList<>();
		if(pro!=null)
		{
			leerApuestas(Tipo.MARCADORES, sede);
			for(int x=0;x<datosPartidos.size();x++)
			{
				if(datosPartidos.get(x).getCedula().equals(cedula))
				{
					datos.add(datosPartidos.get(x));
				}
			}
		}
		return datos;
	} */
	
	
	
	public String convertirCedula(int cedula)
	{
		String pro = "";
		pro = String.valueOf(cedula);
		return pro;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
