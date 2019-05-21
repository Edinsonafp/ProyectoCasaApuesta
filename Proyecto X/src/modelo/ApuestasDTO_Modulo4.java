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

import java.io.Serializable;

public class ApuestasDTO_Modulo4 implements Serializable
{
	
	//-----------------------------------------------------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------------------------------------------------
		
	
	private static final long serialVersionUID = 1L;
	public enum Tipo{SUPERASTRO, BALOTO, MARCADORES};
	
	/**
		Atributos para cada tipo de apuesta y atributos de identificacion obligatorios 
	*/
	private int numeroPartido;
	private String dia;
	private double valor;
	private String sede;
	private int cedula;
	private Tipo tipo;
	private int[] numerosSuperastro;
	private String zodiaco;
	private int[] numerosBaloto;
	private int[] marcador;
	
	/**
	Inciar el atributo de arreglo de baloto y super astro 
	 */
	
	public ApuestasDTO_Modulo4()
	{
		numerosSuperastro = new int[4];
		numerosBaloto = new int[6];
	}
	/**
	Retorna el numero de partido
	 */
	public int getNumeroPartido()
	{
		return numeroPartido;
	}
	
	public void setNumeroPartido(int numeroPartido)
	{
		this.numeroPartido = numeroPartido;
	}
	/**
	Retorna el dia de la apuesta
*/
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	/**
	Retorna el valor de la apuesta
	 */
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	Retorna la sede donde se realiza la apuesta
*/
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	Retorna la cédula del apostador
	 */
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	/**
	Retorna el tipo de apuesta 
	 */
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	/**
	Retorna los números apostados en super astro
*/
	public int[] getNumerosSuperastro() {
		return numerosSuperastro;
	}

	public void setNumerosSuperastro(int[] numerosSuperastro) {
		this.numerosSuperastro = numerosSuperastro;
	}
	/**
	Retorna el signo del zodiaco con el cual se realizo la apuesta
*/
	public String getZodiaco() {
		return zodiaco;
	}

	public void setZodiaco(String zodiaco) {
		this.zodiaco = zodiaco;
	}
	/**
	Retorna el número de la apuesta con la que se realizo la apuesta
*/
	public int[] getNumerosBaloto() {
		return numerosBaloto;
	}

	public void setNumerosBaloto(int[] numerosBaloto) {
		this.numerosBaloto = numerosBaloto;
	}
	/**
	Retorna el marcador de la apuesta
*/
	public int[] getMarcador() {
		return marcador;
	}

	
	public void setMarcador(int[] marcador) {
		this.marcador = marcador;
	}
	
	
	
}
