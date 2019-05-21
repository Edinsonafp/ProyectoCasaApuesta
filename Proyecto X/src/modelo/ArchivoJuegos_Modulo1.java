package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoJuegos_Modulo1 {

	private String rutaReg = "data\\juegos.dat";
	private File f; 
	private FileOutputStream fos;     
	private DataOutputStream dos;
	private FileInputStream fis;     
	private DataInputStream dis;
	
	
	
	public ArchivoJuegos_Modulo1() {
		
	}
	
	public String escribirRegistro(Juegos_Modulo1 juegos_Modulo1) {
		String mensaje = "Registro de juegos Ingresado!";
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaReg));
			out.writeObject(juegos_Modulo1);
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			mensaje = "Error de IO";
		}
		return mensaje;
	}
	
	
	public void leerRegistro() {
        ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(rutaReg));
			Juegos_Modulo1 ju =(Juegos_Modulo1)in.readObject();	        
	        in.close();	       
	            System.out.println(((Juegos_Modulo1) ju).getBaloto().getNombre());
	            System.out.println(((Juegos_Modulo1) ju).getBaloto().getTipo());
	            System.out.println(((Juegos_Modulo1) ju).getBaloto().getPresupuesto());
	            
	            System.out.println(((Juegos_Modulo1) ju).getMarcadores().getNombre());
	            System.out.println(((Juegos_Modulo1) ju).getMarcadores().getTipo());
	            System.out.println(((Juegos_Modulo1) ju).getMarcadores().getPresupuesto());
	            
	            System.out.println(((Juegos_Modulo1) ju).getSuperastro().getNombre());
	            System.out.println(((Juegos_Modulo1) ju).getSuperastro().getTipo());
	            System.out.println(((Juegos_Modulo1) ju).getSuperastro().getPresupuesto());
	        

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
