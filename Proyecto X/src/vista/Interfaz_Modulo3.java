package vista;

import controlador.Controlador;

public class Interfaz_Modulo3 {

	private DialogoFormulario_Modulo3 dialogoFormulario;
	private DialogoFormularioEdicion_Modulo3 dialogoFormularioEdicion;
	private DialogoUsuarioAEditar_Modulo3 dialogoUsuarioAEditar;
	
	
	public Interfaz_Modulo3(Controlador control) {
		
		dialogoFormulario = new DialogoFormulario_Modulo3(control);
		dialogoFormulario.setSize(400, 300);
		dialogoUsuarioAEditar = new DialogoUsuarioAEditar_Modulo3(control);
		dialogoFormularioEdicion = new DialogoFormularioEdicion_Modulo3(control);
	}


	// Get - Set
	
	public DialogoFormulario_Modulo3 getDialogoFormulario() {
		return dialogoFormulario;
	}

	public DialogoFormularioEdicion_Modulo3 getDialogoFormularioEdicion() {
		return dialogoFormularioEdicion;
	}


	public void setDialogoFormularioEdicion(DialogoFormularioEdicion_Modulo3 dialogoFormularioEdicion) {
		this.dialogoFormularioEdicion = dialogoFormularioEdicion;
	}


	public void setDialogoFormulario(DialogoFormulario_Modulo3 dialogoFormulario) {
		this.dialogoFormulario = dialogoFormulario;
	}
	
	public DialogoUsuarioAEditar_Modulo3 getDialogoUsuarioAEditar() {
		return dialogoUsuarioAEditar;
	}

	public void setDialogoUsuarioAEditar(DialogoUsuarioAEditar_Modulo3 dialogoUsuarioAEditar) {
		this.dialogoUsuarioAEditar = dialogoUsuarioAEditar;
	}
	
	
}
