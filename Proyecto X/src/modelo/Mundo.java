package modelo;


public class Mundo {

	private Mundo_Modulo1 modulo1;
	private Mundo_Modelo2 modulo2;
	private Mundo_Modulo3 mundoModulo3;
	private Mundo_Modulo4 mundoModulo4;
	private Mundo_Modulo5 modulo5;
	
	
	public Mundo () {
		System.out.println("entro");
		modulo1 = new Mundo_Modulo1();
		modulo2 = new Mundo_Modelo2();
		
		mundoModulo3 = new Mundo_Modulo3();
		mundoModulo4 = new Mundo_Modulo4();
		modulo5 = new Mundo_Modulo5();
		
	}
	
	

	
	public Mundo_Modulo4 getMundoModulo4() {
		return mundoModulo4;
	}




	public void setMundoModulo4(Mundo_Modulo4 mundoModulo4) {
		this.mundoModulo4 = mundoModulo4;
	}




	public Mundo_Modelo2 getModulo2() {
		return modulo2;
	}




	public void setModulo2(Mundo_Modelo2 modulo2) {
		this.modulo2 = modulo2;
	}




	public Mundo_Modulo1 getModulo1() {
		return modulo1;
	}




	public void setModulo1(Mundo_Modulo1 modulo1) {
		this.modulo1 = modulo1;
	}




	public Mundo_Modulo3 getMundoModulo3() {
		return mundoModulo3;
	}


	public void setMundoModulo3(Mundo_Modulo3 mundoModulo3) {
		this.mundoModulo3 = mundoModulo3;
	}


	public Mundo_Modulo5 getModulo5() {
		return modulo5;
	}

	public void setModulo5(Mundo_Modulo5 modulo5) {
		this.modulo5 = modulo5;
	}
	
	
}
