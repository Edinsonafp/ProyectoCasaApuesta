package modelo;

import modelo.ApuestasDTO_Modulo4.Tipo;

public interface ApuestaInterface 
{

	public String crearApuesta(String sede,int cedula,String dia,double valor,String zodiaco,int[] numerosSuperastro, Tipo tipo);
	public String crearApuesta(String sede,int cedula,String dia,double valor,int[]numerosBaloto, Tipo tipo);
	public String crearApuesta(String sede,int cedula,String dia,int[] marcador, double valor, Tipo tipo);
	public String borrarApuestas(int[] numerosSuperastro,String zodiaco, int cedula, String sede);
	public String borrarApuestas(int[] numerosBaloto,int cedula, String sede);
	public String borrarApuestas(int cedula,int[] marcadores, String sede);
	public String leerApuestas(Tipo tipo, String sede);
	public String actualizarDatosApuestas(String sede, int cedula, String dia, double valor, String zodiaco, int[] numerosSuperastro, Tipo tipo,int[] numerosSuperastroNuevo,String zodiacoNuevo);
	public String actualizarDatosApuestas(String sede,int cedula,String dia,double valor,int[]numerosBaloto, Tipo tipo, int[] numerosBalotoNuevo);
	public String actualizarDatosApuestas(String sede,int cedula,String dia,double valor,int[] marcador,int[] marcadorNuevo,Tipo tipo);
}
