package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import modelo.ApuestasDTO_Modulo4.Tipo;
import modelo.ApostadorDto_Modulo3;
import modelo.Mundo;
import vista.DialogoBuscarSede_Modulo2;
import vista.DialogoModificarSede_Modulo2;
import vista.Interfaz;
import vista.PanelSedes_Modulo2;
import vista.VentanaDatosCreacionSede_Modulo2;

public class Controlador implements ActionListener {

	private Interfaz interfaz;
	private Mundo mundo;
	

	String [] futbol = new String [14];
	String [] futbolNuevo = new String[14];
	String [] dias = new String[7];
	String [] astroT = new String [5];
	double [] valorAstro = new double [5];
	String [] devolver = new String [14];
	boolean futboN = false;
	boolean error = false;
	int valorDeApuestasA = 0; int valorDeApuestasB = 0;	int contador = 0;int contadorNuevo = 0;	
	ArrayList<String> prub;
	ArrayList<String> localidades;
	ArrayList<String> numerosBalto;
	ArrayList<String> numerosZodiaco;
	ArrayList<String> signosZodiaco;

	public Controlador() {
		prub = new ArrayList<String>();
		numerosBalto = new ArrayList<String>();
		numerosZodiaco = new ArrayList<String>();
		signosZodiaco = new ArrayList<String>();
		localidades = new ArrayList<String>();
		interfaz = new Interfaz(this);
		interfaz.setVisible(true);
		mundo = new Mundo();
		mundo.getMundoModulo3().leerArchivo();
		
		localidades = mundo.getMundoModulo4().getApuestas().darLocalidades();
		prub = mundo.getMundoModulo4().getApuestas().getNombresSede();
		 interfaz.getModulo4_Interfaz().getcSedes().setModel(new DefaultComboBoxModel(prub.toArray()));
		 interfaz.getModulo4_Interfaz().getcSedes2().setModel(new DefaultComboBoxModel(localidades.toArray()) );
		 interfaz.getModulo4_Interfaz().getcFutbol().setModel(new DefaultComboBoxModel(mundo.getMundoModulo4().getApuestas().cargarPartidos()));
		 interfaz.getInterfaz_Modulo3().getDialogoFormulario().llenarSedeComboBox(mundo.getModulo2().getSedeDAO().leerArchivo());
		 interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().llenarSedeComboBox(mundo.getModulo2().getSedeDAO().leerArchivo());
			interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelBusqueda()
			.llenarSedeComboBox(mundo.getModulo2().getSedeDAO().leerArchivo());

	interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelBusqueda()
			.llenarSedeComboBox(mundo.getModulo2().getSedeDAO().leerArchivo());
	
	interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().llenarSedeComboBox(mundo.getModulo2().getSedeDAO().leerArchivo());
		

	}
	


	public void actionPerformed(ActionEvent evento) {

		// Modulo1-Comienza
		
		
		

		if (evento.getActionCommand().equals(interfaz.CREARCASAAPUESTA)) {
			interfaz.getModulo1_Interfaz().getVentanaCrear().setVisible(true);

			System.out.println("Ventana crear Casa de apuesta Modulo 1");
		} else if (evento.getActionCommand().equals(interfaz.MODIFICARCASAAPUESTA)) {
			interfaz.getModulo1_Interfaz().getVentanaModificar().setVisible(true);
			System.out.println("Ventana modificar Casa de apuesta Modulo 1");

		} else if (evento.getActionCommand()
				.equals(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().GUARDARMOD1)) {

			if ((interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre().getText().equals(""))
					|| (Double.valueOf(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
							.getTxtpresupuesto().getText()) <= 0)
					|| (Integer.parseInt(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
							.getText()) <= 0)) {

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().mostrarMensaje(
						"Puede que no haya colocado el nombre y el numero de presupuesto o sede no puede ser igual a cero");
			} else {
				mundo.getModulo1().crearCasa(
						interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre().getText(),
						Integer.parseInt(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
								.getText()),
						Double.valueOf(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
								.getText()));

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
						.mostrarMensaje("Se creo la casa de apuesta exitosamente");
				interfaz.getModulo1_Interfaz().getVentanaCrear().setVisible(false);

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
						.mostrarMensaje(mundo.getModulo1().getPropiedades().crearPropiedades(
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre()
										.getText(),
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
										.getText(),
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
										.getText()));
			}
			System.out.println("Guardar panel crear modulo 1");

		} else if (evento.getActionCommand()
				.equals(interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().ATRASCREARMOD1)) {
			interfaz.getModulo1_Interfaz().getVentanaCrear().setVisible(false);
			System.out.println("Atras panel crear modulo 1");
		} else if (evento.getActionCommand()
				.equals(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar().MODIFICARMOD1)) {
			if ((interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre().getText().equals(""))
					|| (Double.valueOf(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar()
							.getTxtpresupuesto().getText()) <= 0)
					|| (Integer.parseInt(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar()
							.getTxtsedes().getText()) <= 0)) {

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
						.mostrarMensaje("El numero de presupuesto o sede no puede ser igual a cero");
			} else {
				mundo.getModulo1().crearCasa(
						interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre().getText(),
						Integer.parseInt(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar()
								.getTxtsedes().getText()),
						Double.valueOf(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar()
								.getTxtsedes().getText()));

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
						.mostrarMensaje("Se modifico la casa de apuesta exitosamente");
				interfaz.getModulo1_Interfaz().getVentanaModificar().setVisible(false);

				interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear()
						.mostrarMensaje(mundo.getModulo1().getPropiedades().crearPropiedades(
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtnombre()
										.getText(),
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
										.getText(),
								interfaz.getModulo1_Interfaz().getVentanaCrear().getPanelCrear().getTxtsedes()
										.getText()));
			}

			System.out.println("Modificar panel modificar modulo 1");
		} else if (evento.getActionCommand()
				.equals(interfaz.getModulo1_Interfaz().getVentanaModificar().getPanelModificar().ATRASMODIFICARMOD1)) {
			interfaz.getModulo1_Interfaz().getVentanaModificar().setVisible(false);
			System.out.println("Atras panel modificar modulo 1");
		} else if (evento.getActionCommand().equals(interfaz.LEERCASASAPUESTA)) {
			interfaz.getModulo1_Interfaz().getVentanaMostrar().setVisible(true);
			interfaz.getModulo1_Interfaz().getVentanaMostrar().getPanelMostrar().getTxtnombre()
					.setText(mundo.getModulo1().getCasaApuesta().getNombreCasa());
			interfaz.getModulo1_Interfaz().getVentanaMostrar().getPanelMostrar().getTxtpresupuesto()
					.setText(Double.toString(mundo.getModulo1().getCasaApuesta().getPresupuesto()));
			interfaz.getModulo1_Interfaz().getVentanaMostrar().getPanelMostrar().getTxtsedes()
					.setText(Integer.toString(mundo.getModulo1().getCasaApuesta().getNumeroSedes()));

			System.out.println("Ventana mostrar Casa de apuesta Modulo 1");

		} else if (evento.getActionCommand()
				.equals(interfaz.getModulo1_Interfaz().getVentanaMostrar().getPanelMostrar().ATRASLEERMOD1)) {
			interfaz.getModulo1_Interfaz().getVentanaMostrar().setVisible(false);
			System.out.println("Atras Panelmostrar Casa de apuesta Modulo 1");
		}

		// Modulo1-TERMINA

		// Modulo 2 - Comienza
		if (evento.getActionCommand().equals(PanelSedes_Modulo2.CREAR_SEDE)) {

			try {
				String[] pLocalidades = mundo.getModulo2().getGestionSedes().darLocalidades();
				interfaz.getPanelSedes().inicializarVentanaCreacionSedes(this, pLocalidades);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (evento.getActionCommand().equals(VentanaDatosCreacionSede_Modulo2.CREAR)) {

			try {
				String pLocalidad = interfaz.getPanelSedes().getVentanaCreacionSede().darNombreLocalidad();
				int pNumEmpleados = interfaz.getPanelSedes().getVentanaCreacionSede().darNumeroEmpleados();
				String pNombreSede = interfaz.getPanelSedes().getVentanaCreacionSede().darNombreSede();

				mundo.getModulo2().getGestionSedes().getSede().crearSede(pNumEmpleados, pNombreSede, pLocalidad);
				JOptionPane.showMessageDialog(interfaz, "Se creó la sede", "Archivo creado",
						JOptionPane.INFORMATION_MESSAGE);
				interfaz.getPanelSedes().getVentanaCreacionSede().limpiar();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(interfaz, e.getMessage(), "Error de datos", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}

		if (evento.getActionCommand().equals(PanelSedes_Modulo2.MODIFICAR_SEDE)) {
			if (mundo.getModulo2().getGestionSedes().verificarArchivo() == false) {
				JOptionPane.showMessageDialog(interfaz, "No existe archivo", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					interfaz.getPanelSedes().inicializarDialogoBuscarSede(this, mundo.getModulo2().getGestionSedes().darSedes());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(interfaz, e.getMessage(), "Error de datos",
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}

		}

		if (evento.getActionCommand().equals(DialogoBuscarSede_Modulo2.ACEPTAR)) {
			try {
				interfaz.getPanelSedes().inicializarDialogoModificar(
						interfaz.getPanelSedes().getDialogoBuscarSede().verificarCasillas(), this);
				interfaz.getPanelSedes().getDialogoBuscarSede().setVisible(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(interfaz, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();

			}
		}

		if (evento.getActionCommand().equals(DialogoModificarSede_Modulo2.SELECCIONAR_OTRA_SEDE)) {
			interfaz.getPanelSedes().getDialogoModificar().setVisible(false);
			interfaz.getPanelSedes().getDialogoBuscarSede().setVisible(true);
		}

		if(evento.getActionCommand().equals(DialogoModificarSede_Modulo2.TERMINAR)) {
			int pNumeroEmpleadosNuevo=-1;
			String pNombreNuevo=null;
			
			try {
				String pNombreSede= interfaz.getPanelSedes().getDialogoBuscarSede().getComboSedes().getSelectedItem().toString();
		
				if(interfaz.getPanelSedes().getDialogoBuscarSede().verificarCasillas()==0) {
					pNumeroEmpleadosNuevo=interfaz.getPanelSedes().getDialogoModificar().darNuevoNumeroEmpleados();
					pNombreNuevo="$$$";
				}
				if(interfaz.getPanelSedes().getDialogoBuscarSede().verificarCasillas()==1) {
					pNombreNuevo=interfaz.getPanelSedes().getDialogoModificar().darNuevoNombre();
					pNumeroEmpleadosNuevo= -1;
				}
				if(interfaz.getPanelSedes().getDialogoBuscarSede().verificarCasillas()==2) {
					pNombreNuevo=interfaz.getPanelSedes().getDialogoModificar().darNuevoNombre();
					pNumeroEmpleadosNuevo = interfaz.getPanelSedes().getDialogoModificar().darNuevoNumeroEmpleados();
				}
				if(interfaz.getPanelSedes().mostrarConfirmacion(interfaz) ==true) {
					mundo.getModulo2().getSedeDAO().modificarDatosSedes(pNombreSede, pNumeroEmpleadosNuevo, pNombreNuevo);
					interfaz.getPanelSedes().getDialogoModificar().setVisible(false);
				}
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(interfaz, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

		if (evento.getActionCommand().equals(PanelSedes_Modulo2.VER_SEDES)) {
			if (mundo.getModulo2().getGestionSedes().verificarArchivo() == false) {
				JOptionPane.showMessageDialog(interfaz, "No existe archivo", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				interfaz.getPanelSedes().mostrarListaSedes(mundo.getModulo2().getGestionSedes().darSedes());
			}
		}

		// Modulo 2 - Termina

		// modulo 3 - Comienza

		if (evento.getActionCommand().equals(interfaz.getPanelClientes().opcionNuevoUsuario)) {
			System.out.println("BOTON NUEVO USUARIO");

			interfaz.getInterfaz_Modulo3().getDialogoFormulario().setVisible(true);
		} else if (evento.getActionCommand().equals(interfaz.getPanelClientes().opcionEditarUsuario)) {
			System.out.println("BOTON EDITAR USUARIO");
			interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar().setVisible(true);
		} else if (evento.getActionCommand().equals(interfaz.getPanelClientes().opcionCrearArchivo)) {
			System.out.println("BOTON CREAR ARCHIVO");

			mundo.getMundoModulo3().pruebaArchivo();
		} else if (evento.getActionCommand().equals(interfaz.getPanelClientes().opcionBuscarUsuario)) {
			System.out.println("BOTON BUSCAR USUARIO");
			String cedulaABuscarString = interfaz.getPanelClientes().getIdTextField().getText();
			int cedulaABuscar = 0;

			try {
				cedulaABuscar = Integer.parseInt(cedulaABuscarString);
				ApostadorDto_Modulo3 auxiliar = mundo.getMundoModulo3().encontrar(cedulaABuscar);
				if (auxiliar != null) {
					interfaz.escribirDato("Nombre: " + auxiliar.getNombre() + "\n" + "Apellido: "
							+ auxiliar.getApellido() + "\n" + "Cedula: " + auxiliar.getCedula() + "\n" + "Direccion: "
							+ auxiliar.getDireccion() + "\n" + "Sede: " + auxiliar.getSedeDeJuego() + "\n" + "Movil: "
							+ auxiliar.getCelular());
				} else {
					interfaz.escribirDato(" El Apostador no Existe");
				}
			} catch (NumberFormatException e) {

				interfaz.escribirDato("inserte un dato de tipo numerico menor de 10 digitos");

				e.printStackTrace();

			}
			mundo.getMundoModulo3().buscarUsuario(cedulaABuscar);
		} else if (evento.getActionCommand()
				.equals(interfaz.getInterfaz_Modulo3().getDialogoFormulario().opcionGuardarDatos)) {
			System.out.println("BOTON CREAR USUARIO");

			if (interfaz.getInterfaz_Modulo3().getDialogoFormulario().tomarDatosDelFormulario() == true
					&& interfaz.getInterfaz_Modulo3().getDialogoFormulario().getErrores() == "") {
				try {
					String nombreARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormulario().nombreARegistrar;
					String apellidoARegistrar = interfaz.getInterfaz_Modulo3()
							.getDialogoFormulario().apellidoARegistrar;
					String direccionARegistrar = interfaz.getInterfaz_Modulo3()
							.getDialogoFormulario().direccionARegistrar;
					int cedulaARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormulario().cedulaARegistrar;
					String sedeDeJuegoARegistrar = interfaz.getInterfaz_Modulo3()
							.getDialogoFormulario().sedeDeJuegoARegistrar;
					int movilARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormulario().movilARegistrar;

					mundo.getMundoModulo3().crearNuevoUsuario(nombreARegistrar, apellidoARegistrar, cedulaARegistrar,
							sedeDeJuegoARegistrar, direccionARegistrar, movilARegistrar);
				} catch (Exception e) {
					e.printStackTrace();
				}
				interfaz.getInterfaz_Modulo3().getDialogoFormulario().dispose();
			} else {
				interfaz.getInterfaz_Modulo3().getDialogoFormulario().mostrarCuadroErrores();
			}
		} else if (evento.getActionCommand()
				.equals(interfaz.getInterfaz_Modulo3().getDialogoFormulario().opcionEliminarDatos)) {
			System.out.println("BOTON ELIMINAR USUARIO");

			// if (interfaz.getModulo3().getDialogoFormulario().tomarDatosDelFormulario() ==
			// true) {
			try {
				int cedulaABorrar = Integer.parseInt(
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getCedulaTextField().getText());

				interfaz.escribirDato(mundo.getMundoModulo3().elminarApostador(cedulaABorrar));

			} catch (Exception e) {
				e.printStackTrace();
			}
			interfaz.getInterfaz_Modulo3().getDialogoFormulario().dispose();
			// }
		} else if (evento.getActionCommand()
				.equals(interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().opcionActualizarDatos)) {
			System.out.println("BOTON MODIFICAR USUARIO");
			try {
				String nombreARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion()
						.getNombreTextField().getText();
				String apellidoARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion()
						.getApellidoTextField().getText();
				String direccionARegistrar = interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion()
						.getDireccionTextField().getText();
				int cedulaARegistrar = Integer.parseInt(
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getCedulaTextField().getText());
				String sedeDeJuegoARegistrar = interfaz.getInterfaz_Modulo3()
						.getDialogoFormularioEdicion().sedeDeJuegoARegistrar;
				int movilARegistrar = Integer.parseInt(
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getMovilTextField().getText());

				interfaz.escribirDato(mundo.getMundoModulo3().actualizarUsuario(nombreARegistrar, apellidoARegistrar,
						cedulaARegistrar, sedeDeJuegoARegistrar, direccionARegistrar, movilARegistrar));
			} catch (Exception e) {
				e.printStackTrace();
			}
			interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().dispose();
		} else if (evento.getActionCommand()
				.equals(interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar().ACEPTAR)) {
			System.out.println("BOTON ACEPTAR (Editar Usuario)");
			String cedulaAEditarString = interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar()
					.getTextoNumeroDeDocumento().getText();
			int cedulaAEditar = 0;

			if (cedulaAEditarString != null && !cedulaAEditarString.equals("")) {
				try {

					cedulaAEditar = Integer.parseInt(cedulaAEditarString);
					ApostadorDto_Modulo3 auxiliar = mundo.getMundoModulo3().encontrar(cedulaAEditar);

					if (mundo.getMundoModulo3().usuarioExistente(cedulaAEditar) == true) {
						mundo.getMundoModulo3().buscarUsuario(cedulaAEditar);

						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getNombreTextField()
								.setText(auxiliar.getNombre());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getApellidoTextField()
								.setText(auxiliar.getApellido());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getCedulaTextField()
								.setText("" + auxiliar.getCedula());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getDireccionTextField()
								.setText(auxiliar.getDireccion());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getMovilTextField()
								.setText("" + auxiliar.getCelular());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().getSedeLabel()
								.setText("" + auxiliar.getSedeDeJuego());
						interfaz.getInterfaz_Modulo3().getDialogoFormularioEdicion().setVisible(true);
						interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar().dispose();
					} else {
						System.out.println("USUARIO NO ENCONTRADO");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe ingresar el nÃºmero de documento del usuario a editar",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (evento.getActionCommand()
				.equals(interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar().CANCELAR)) {
			System.out.println("BOTON CANCELAR (Editar Usuario)");
			interfaz.getInterfaz_Modulo3().getDialogoFormulario().dispose();
			interfaz.getInterfaz_Modulo3().getDialogoUsuarioAEditar().setVisible(false);
		}

		if (interfaz.getInterfaz_Modulo3().getDialogoFormulario().sedeComboBox.getSelectedItem()
				.toString() == "Seleccione un sede") {
			interfaz.getInterfaz_Modulo3().getDialogoFormulario().sedeLabel.setText("");
		} else {
			interfaz.getInterfaz_Modulo3().getDialogoFormulario().sedeLabel.setText(
					interfaz.getInterfaz_Modulo3().getDialogoFormulario().sedeComboBox.getSelectedItem().toString());
		}

		// modulo 3 -Termina

		// Modulo 4- Comienza

		int marcador = 0;
		int[] marcadores = new int[14];
		int marcadorNuevo = 0;
		int[] marcadoresNuevo = new int[14];
		
		String[] numerosBaloto1 = new String[6];
		String[] numerosBaloto2 = new String[6];
		String[] numerosBaloto3 = new String[6];
		String[] numerosBaloto4 = new String[6];
		String[] numerosBaloto5 = new String[6];
		String[] numerosAstro1 = new String[4];
		String[] numerosAstro2 = new String[4];
		String[] numerosAstro3 = new String[4];
		String[] numerosAstro4 = new String[4];
		String[] numerosAstro5 = new String[4];
		
		
		if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().GENERAR)) {
//			este arreglo sirve para cuando el cliente quiera hacer alguna modificacion de algun partido
			
			devolver [0] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(0).toString();
			devolver [1] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(1).toString();
			devolver [2] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(2).toString();
			devolver [3] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(3).toString();
			devolver [4] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(4).toString();
			devolver [5] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(5).toString();
			devolver [6] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(6).toString();
			devolver [7] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(7).toString();
			devolver [8] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(8).toString();
			devolver [9] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(9).toString();
			devolver [10] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(10).toString();
			devolver [11] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(11).toString();
			devolver [12] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(12).toString();
			devolver [13] =interfaz.getModulo4_Interfaz().getcFutbol().getItemAt(13).toString();
			
			int valor = Integer.parseInt( interfaz.getModulo4_Interfaz().getSpinner1().getValue().toString());
			int valor2 = Integer.parseInt(interfaz.getModulo4_Interfaz().getSpinner2().getValue().toString());
			
			interfaz.getModulo4_Interfaz().getLblFutbol().setVisible(true);
			interfaz.getModulo4_Interfaz().getBtnLocal().setVisible(true);
			interfaz.getModulo4_Interfaz().getBtnEmpate().setVisible(true);
			interfaz.getModulo4_Interfaz().getBtnVisitante().setVisible(true);
			interfaz.getModulo4_Interfaz().getcFutbol().setEnabled(true);
			interfaz.getModulo4_Interfaz().gettFutbol().setVisible(true);
			interfaz.getModulo4_Interfaz().getLblPreciof().setVisible(true);
			
//			la funcion de switch segun la cantidad de baloto o superastro se puedan ver e interactuar
			
			switch (valor) {
			
			case 0:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(false);
				break;
			case 1:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(true);
				valorDeApuestasB = 1;
				break;
			case 2:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(true);
				valorDeApuestasB = 2;
				break;
			case 3:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(true);
				valorDeApuestasB = 3;
				break;
			case 4:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(true);
				valorDeApuestasB=4;
				break;
			case 5:
				interfaz.getModulo4_Interfaz().gettBaloto1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettBaloto5().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb3().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValorb5().setVisible(true);
				interfaz.getModulo4_Interfaz().getLblPreciob().setVisible(true);
				valorDeApuestasB=5;
				break;
			default:
				break;
			}
			
			switch (valor2) {
			
			case 0:
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(false);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(false);
				break;
			case 1:
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(false);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(false);
				valorDeApuestasA=1;
				break;
			case 2:;
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(false);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(false);
				valorDeApuestasA = 2;
				break;
			case 3:
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(true);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(false);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(false);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(false);
				valorDeApuestasA=3;
				break;
			case 4:
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(true);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(false);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(false);
				valorDeApuestasA=4;
				break;
			case 5:
				interfaz.getModulo4_Interfaz().gettAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro1().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro2().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro3().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro3().setVisible(true);	
				interfaz.getModulo4_Interfaz().gettAstro4().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro4().setVisible(true);
				interfaz.getModulo4_Interfaz().gettAstro5().setVisible(true);
				interfaz.getModulo4_Interfaz().getcAstro5().setVisible(true);
				interfaz.getModulo4_Interfaz().getLblPrecioa().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor1a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor2a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor3a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor4a().setVisible(true);
				interfaz.getModulo4_Interfaz().gettValor5a().setVisible(true);
				valorDeApuestasA = 5;
				break;
			default:
				break;
			}
		}
		
		if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().BLOQUEO)) {
			
//			si el usuario esta registrado se bloquean los espacios con los datos del nombre, cedula y sede del registro, utilizando el boton de CONFRIMAR
		
			String[] datos = new String[3];
			String nombre = interfaz.getModulo4_Interfaz().gettNombre().getText();
			String  cedula =  interfaz.getModulo4_Interfaz().gettCedula().getText();
			String sede =   interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString();
			this.mundo.getMundoModulo4().getApuestas().buscarNombre(nombre,cedula,sede);
			
			if(interfaz.getModulo4_Interfaz().gettNombre().getText().equalsIgnoreCase(nombre)
			&& interfaz.getModulo4_Interfaz().gettCedula().getText().equalsIgnoreCase(cedula)
			&& interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString().equalsIgnoreCase(sede)) {
				
				interfaz.getModulo4_Interfaz().gettNombre().setEditable(false);
				interfaz.getModulo4_Interfaz().gettCedula().setEditable(false);	
				interfaz.getModulo4_Interfaz().getcSedes().setEnabled(false);
				interfaz.getModulo4_Interfaz().getBtConfirmar().setEnabled(false);
				interfaz.getModulo4_Interfaz().getBtnInformacion().setEnabled(true);
				interfaz.escribirMensaje("Su registro fue un exito, seleccione INFORMACION para continuar.");
			}
			else {
				interfaz.escribirMensaje("Verifique que escribio los datos correctamente, o vaya a registrarse");
			}
		}
		
		if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().AGREGAR)) {	

//			los datos que el usuario ingrese como el numero de baloto o superastro, como el zoodiaco, la fecha la sede donde hace la apuesta y el valor se registrara
			
			String mensaje = ""; int contador = 0;
			
			
		    int cedula = Integer.parseInt(interfaz.getModulo4_Interfaz().gettCedula().getText());
			String sede = interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString();
			String dia = interfaz.getModulo4_Interfaz().getcFecha().getSelectedItem().toString();
			String valor1 =interfaz.getModulo4_Interfaz().gettValor1a().getText(); 
			String baloto1 = interfaz.getModulo4_Interfaz().gettBaloto1().getText();
			String baloto2 =interfaz.getModulo4_Interfaz().gettBaloto2().getText();
			String baloto3 = interfaz.getModulo4_Interfaz().gettBaloto3().getText();
			String baloto4 =interfaz.getModulo4_Interfaz().gettBaloto4().getText();
			String baloto5 = interfaz.getModulo4_Interfaz().gettBaloto5().getText();
			String balotoValor = interfaz.getModulo4_Interfaz().gettValorb1().getText();
			String astro1 = interfaz.getModulo4_Interfaz().gettAstro1().getText();
			String astro2 = interfaz.getModulo4_Interfaz().gettAstro2().getText();
			String astro3 = interfaz.getModulo4_Interfaz().gettAstro3().getText();
			String astro4 = interfaz.getModulo4_Interfaz().gettAstro4().getText();
			String astro5 = interfaz.getModulo4_Interfaz().gettAstro5().getText();
			String astroValor1 = interfaz.getModulo4_Interfaz().gettValor1a().getText();
			String astroValor2 = interfaz.getModulo4_Interfaz().gettValor2a().getText();
			String astroValor3 = interfaz.getModulo4_Interfaz().gettValor3a().getText();
			String astroValor4 = interfaz.getModulo4_Interfaz().gettValor4a().getText();
			String astroValor5 = interfaz.getModulo4_Interfaz().gettValor5a().getText();
			String preciof = interfaz.getModulo4_Interfaz().gettFutbol().getText();
//			si el usuario solo decide apostar cierta cantidad el resto cuente como 0 y no se sume a la apuesta
			
				if (baloto1.isEmpty() == true) {
					baloto1 = "0";
				}
				if (baloto2.isEmpty() == true) {
					baloto2 = "0";
				}
				if (baloto3.isEmpty() == true) {
					baloto3 = "0";
				}
				if (baloto4.isEmpty() == true) {
					baloto4 = "0";
				}
				if (baloto5.isEmpty() == true) {
					baloto5 = "0";
				}
				if (astro1.isEmpty()==true) {
				astro1 = "0";
				}
				if (astro2.isEmpty()==true) {
				 astro2 = "0";
				}
				if (astro3.isEmpty()==true) {
					astro3 = "0";
				}
				if (astro4.isEmpty()==true) {
					astro4 = "0";
				}
				if (astro5.isEmpty()==true) {
					astro5 = "0";
				}
				
				String astroC1 = interfaz.getModulo4_Interfaz().getcAstro1().getSelectedItem().toString();
				String astroC2 = interfaz.getModulo4_Interfaz().getcAstro2().getSelectedItem().toString();
				String astroC3 = interfaz.getModulo4_Interfaz().getcAstro3().getSelectedItem().toString();
				String astroC4 = interfaz.getModulo4_Interfaz().getcAstro4().getSelectedItem().toString();
				String astroC5 = interfaz.getModulo4_Interfaz().getcAstro5().getSelectedItem().toString();

				int [] baloto = new int [valorDeApuestasB];
				int [] astro = new int [valorDeApuestasA];
				String [] astroT = new String [valorDeApuestasA];
				
				int i = 0;	int x = 0; int w = 0;
				String llenar ="";
				
//				se vayan agregando todas las apuestas que el usuario desea realizar
				
				try 
				{
				
				while ( i <= baloto.length-1) 
				{
				if (i==0) {
					numerosBaloto1 = baloto1.split(" ");
					this.numerosBalto.add(baloto1);
					int[] numerosBaloto1I = new int[6];
					for(int q=0;q<6;q++)
					{
						numerosBaloto1I[q] = Integer.parseInt(numerosBaloto1[q]);
					}
				mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, 5000, numerosBaloto1I, Tipo.BALOTO);	
				}

				if (i==1) 
				{
					numerosBaloto2 = baloto2.split(" ");
					this.numerosBalto.add(baloto2);
					int[] numerosBaloto2I = new int[6];
					for(int q=0;q<6;q++)
					{
						numerosBaloto2I[q] = Integer.parseInt(numerosBaloto2[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, 5000, numerosBaloto2I, Tipo.BALOTO);
				}
				if (i==2) {
					this.numerosBalto.add(baloto3);
					numerosBaloto3 = baloto3.split(" ");
					int[] numerosBaloto3I = new int[6];
					for(int q=0;q<6;q++)
					{
						numerosBaloto3I[q] = Integer.parseInt(numerosBaloto3[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, 5000, numerosBaloto3I, Tipo.BALOTO);
				}
				if(i==3) {
					numerosBaloto4 = baloto4.split(" ");
					this.numerosBalto.add(baloto4);
					int[] numerosBaloto4I = new int[6];
					for(int q=0;q<6;q++)
					{
						numerosBaloto4I[q] = Integer.parseInt(numerosBaloto4[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, 5000, numerosBaloto4I, Tipo.BALOTO);
				}
				if(i==4) {
					this.numerosBalto.add(baloto5);
					numerosBaloto5 = baloto5.split(" ");
					int[] numerosBaloto5I = new int[6];
					for(int q=0;q<6;q++)
					{
						numerosBaloto5I[q] = Integer.parseInt(numerosBaloto5[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, 5000, numerosBaloto5I, Tipo.BALOTO);
				}
				i++;
				}
				
				while(x <= astro.length-1) {

				if(x==0) {
					valorAstro[0] = Double.parseDouble(astroValor1);
					
					numerosAstro1 = astro1.split(" ");
					this.numerosZodiaco.add(astro1);
					this.signosZodiaco.add(astroC1);
					int[] numerosAstro1I = new int[4];
					
					for(int q=0;q<4;q++)
					{
						numerosAstro1I[q] = Integer.parseInt(numerosAstro1[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, valorAstro[0], astroC1, numerosAstro1I, Tipo.SUPERASTRO);
				}
				if(x==1) {
					valorAstro[1] = Double.parseDouble(astroValor2);
					numerosAstro2 = astro2.split(" ");
					this.numerosZodiaco.add(astro2);
					this.signosZodiaco.add(astroC2);
					int[] numerosAstro2I = new int[4];
					for(int q=0;q<4;q++)
					{
						numerosAstro2I[q] = Integer.parseInt(numerosAstro2[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, valorAstro[1], astroC2, numerosAstro2I, Tipo.SUPERASTRO);
				}
				if(x==2) {
					valorAstro[2] = Double.parseDouble(astroValor3);
					numerosAstro3 = astro3.split(" ");
					this.numerosZodiaco.add(astro3);
					this.signosZodiaco.add(astroC3);
					int[] numerosAstro3I = new int[4];
					for(int q=0;q<4;q++)
					{
						numerosAstro3I[q] = Integer.parseInt(numerosAstro3[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, valorAstro[2], astroC3, numerosAstro3I, Tipo.SUPERASTRO);
				}
				if(x==3) {
					valorAstro[3] = Double.parseDouble(astroValor4);
					numerosAstro4 = astro4.split(" ");
					this.numerosZodiaco.add(astro4);
					this.signosZodiaco.add(astroC4);
					int[] numerosAstro4I = new int[4];
					for(int q=0;q<4;q++)
					{
						numerosAstro4I[q] = Integer.parseInt(numerosAstro4[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, valorAstro[3], astroC4, numerosAstro4I, Tipo.SUPERASTRO);
				}
				if(x==4) {
					valorAstro[4] = Double.parseDouble(astroValor5);
					numerosAstro5 = astro5.split(" ");
					this.numerosZodiaco.add(astro5);
					this.signosZodiaco.add(astroC5);
					int[] numerosAstro5I = new int[4];
					for(int q=0;q<4;q++)
					{
						numerosAstro5I[q] = Integer.parseInt(numerosAstro5[q]);
					}
					mundo.getMundoModulo4().getApuestas().crearApuesta(sede, cedula, dia, valorAstro[4], astroC5, numerosAstro5I, Tipo.SUPERASTRO);
				}
				x++;
				}
				
			}
				catch (NumberFormatException e) {
				   error = true;
				}
				
				String nombreSede = interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString();
				mundo.getMundoModulo4().getApuestas().crearApuesta(nombreSede, cedula, dia, marcadores,103431, Tipo.MARCADORES);
				
				
				
				mensaje += "La sede: "+sede+ " , es donde esta realizando su apuesta"+"\n";
				mensaje += "El dia "+dia+" , esta realizando las apuestas: "+"\n";
				System.out.println(baloto.length);
				for (int j = 0; j < baloto.length; j++) {
					System.out.println("ingreso:" + baloto[j]);
					mensaje +="El numero de su Baloto es: "+ this.numerosBalto.get(j)+" , su Precio es: "+balotoValor+"\n";
				}
				
				for (int j = 0; j < astroT.length; j++) {
					 mensaje += "El numero del SuperAstro es: "+ this.numerosZodiaco.get(j)+" , con su Zoodiaco: "+this.signosZodiaco.get(j)+" , su Precio es: "+valorAstro[j]+"\n";
				}
		
				for (int j = 0; j < futbol.length; j++) {
					contador++;
					if (futbol[j]==null) {
						contador--;
					}
					if(contador == 14) {
						
						mensaje += "Los Resultados De Los Partidos Seleccionados Son:"+"\n";
						mensaje +=futbol[0]+"\n";
						mensaje +=futbol[1]+"\n";
						mensaje +=futbol[2]+"\n";
						mensaje +=futbol[3]+"\n";
						mensaje +=futbol[4]+"\n";
						mensaje +=futbol[5]+"\n";
						mensaje +=futbol[6]+"\n";
						mensaje +=futbol[7]+"\n";
						mensaje +=futbol[8]+"\n";
						mensaje +=futbol[9]+"\n";
						mensaje +=futbol[10]+"\n";
						mensaje +=futbol[11]+"\n";
						mensaje +=futbol[12]+"\n";
						mensaje +=futbol[13]+"\n";
						mensaje += "Usted aposto por los 14 partidos: "+preciof+"\n";
					}
				}
				mensaje += "Si desea su compra seleccione: CONFIRMAR, de lo Ccontrario seleccione: REGRESAR y modifique.";
				
//			si existe una excepcion pueda modificarla sin darle el resultado final
				
				if (error==true) {
					JOptionPane.showMessageDialog(null, "Solo puede ingresar nuevo, para realizar la apuesta");
				}
				
				if(error == false) {
					int respuesta = interfaz.opciones(mensaje);
					if (respuesta==0) {
						interfaz.escribirMensaje("Su apuesta, fue agregada con exito.");
						futboN = false;
						interfaz.getModulo4_Interfaz().getSpinner1().setValue(0);
						interfaz.getModulo4_Interfaz().getSpinner2().setValue(0);
						
					   }
					   else {
						   interfaz.escribirMensaje("Modifique las apuestas necesarias.");
						   
						   interfaz.getModulo4_Interfaz().getcFutbol().setModel(new DefaultComboBoxModel(devolver));
						   
						    futbol[0]= null;
						    futbol[1]= null;  
						    futbol[2]= null;
						    futbol[3]= null;
						    futbol[4]= null;
						    futbol[5]= null;
						    futbol[6]= null;
						    futbol[7]= null;
						    futbol[8]= null;
						    futbol[9]= null;
						    futbol[10]= null;
						    futbol[11]= null;
						    futbol[12]= null;
						    futbol[13]= null;
			   }
			}
		}
				   
//		estos 3 ultimos if con sus respectivos botones vaya contado los partidos, independientemente se escoja local, visitante, o empate
		
//		dar una guia al usuario de como debe apostar correctamente y hasta no finalizar no podra apostar
		
		if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().INFORMACION)) {
			
			interfaz.getModulo4_Interfaz().getcSedes2().setEnabled(true);
			interfaz.getModulo4_Interfaz().getcFecha().setEnabled(true);
			interfaz.getModulo4_Interfaz().getSpinner1().setEnabled(true);
			interfaz.getModulo4_Interfaz().getSpinner2().setEnabled(true);
			interfaz.getModulo4_Interfaz().getBtAgregar().setEnabled(true);
			interfaz.getModulo4_Interfaz().getBtGenerar().setEnabled(true);
			
			interfaz.escribirMensaje("Hola usuario."+"\n"+
					"Lea atentamente la informacion dada, para que asi pueda realizar los diferentes tipos de apuesta correctamente."+"\n"+ 
					"Al ingresar los numeros correspondiente en cada espacio, coloque un espacio para que se registre cada numero correcto"+"\n"+		
					"1) Si desea realizar una o mas Apuesta de Baloto, tiene una capacidad de maximo 5 veces de apostar en ello, digitando maximo 6 numeros(separados por espacio) y con valor predeterminado de $5000."+"\n"+
					"2) Si desea realizar una o mas Apuestas de SuperAstro, tiene una capacidad de maximo 5 veces de apostar en ello, digitando un maximo de 4 numeros(separados por espacio) y escogiendo un tipo de Zoodiaco y darle un valor a la apuesta de 10 digitos."+"\n"+
					"3) Si desea realizar una apuesta en Futbol, este tipo de apuesta debe apostar los 14 partidos establecidos y darle un valor de 10 digitos, por el total de los 14 partidos."+"\n"+
					"4) Si el usuario no apuesta por los 14 partidos completos, su apuesta no se realizara."+"\n"+
					"5) Si por casualidad se decide por hacer un cambio, debe darle en regresar, despues de haber confirmado, no podra desacer la apuesta."+"\n"+
					"Espero tenga un buen dia y disfrute realizando su apuesta.");
		}
		if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().LEER)) {

		}
		if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().FACTURA)) {
			
			this.mundo.getMundoModulo4().getApuestas().factura(interfaz.getModulo4_Interfaz().gettCedula().getText().toString(), interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString(), interfaz.getModulo4_Interfaz().getcFecha().getSelectedItem().toString(), this.numerosBalto, this.numerosZodiaco, this.signosZodiaco, this.valorAstro,interfaz.getModulo4_Interfaz().gettFutbol().getText() );
			System.out.println(this.mundo.getMundoModulo4().getApuestas().getFactura());
			JOptionPane.showMessageDialog(null, this.mundo.getMundoModulo4().getApuestas().getFactura());
			interfaz.getModulo4_Interfaz().gettNombre().setEditable(true);
			interfaz.getModulo4_Interfaz().gettCedula().setEditable(true);	
			interfaz.getModulo4_Interfaz().getcSedes().setEnabled(true);
			interfaz.getModulo4_Interfaz().getBtConfirmar().setEnabled(true);
			
			interfaz.getModulo4_Interfaz().getBtnInformacion().setEnabled(false);
			interfaz.getModulo4_Interfaz().getSpinner1().setEnabled(false);
			interfaz.getModulo4_Interfaz().getSpinner1().setEnabled(false);
			interfaz.getModulo4_Interfaz().gettAstro1().setText("");
			interfaz.getModulo4_Interfaz().gettAstro2().setText("");
			interfaz.getModulo4_Interfaz().gettAstro3().setText("");
			interfaz.getModulo4_Interfaz().gettAstro4().setText("");
			interfaz.getModulo4_Interfaz().gettAstro5().setText("");
			interfaz.getModulo4_Interfaz().gettValor1a().setText("");
			interfaz.getModulo4_Interfaz().gettValor2a().setText("");
			interfaz.getModulo4_Interfaz().gettValor3a().setText("");
			interfaz.getModulo4_Interfaz().gettValor4a().setText("");
			
			interfaz.getModulo4_Interfaz().gettBaloto1().setText("");
			interfaz.getModulo4_Interfaz().gettBaloto2().setText("");
			interfaz.getModulo4_Interfaz().gettBaloto3().setText("");
			interfaz.getModulo4_Interfaz().gettBaloto4().setText("");
			interfaz.getModulo4_Interfaz().gettBaloto5().setText("");
			
			
		
		}
         if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().ELIMINAR)) {
        	 int valor = Integer.parseInt( interfaz.getModulo4_Interfaz().getSpinner1().getValue().toString());
  			int valor2 = Integer.parseInt(interfaz.getModulo4_Interfaz().getSpinner2().getValue().toString());
        	 String zodiaco = interfaz.getModulo4_Interfaz().getcAstro1().getSelectedItem().toString();
        	 int cedula = Integer.parseInt(interfaz.getModulo4_Interfaz().gettCedula().getText());
        	 String nombreSede = interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString();
        	 int[] numerosSuperastro = new int[4];
        	 
        	 String[] numerosStrings = new String[4];
        	 int [] numerosBaloto = new int[6];
        	 String[] nStrings= new String[6];
        	 String textF = interfaz.getModulo4_Interfaz().gettAstro1().getText();
        	 String txtB = interfaz.getModulo4_Interfaz().gettBaloto1().getText();
        	
          	 
        	 numerosStrings = textF.split(" ");
        	 nStrings = txtB.split(" ");
        	 if (valor2 == 1) {

        		 for(int x=0;x<4;x++)
            	 {

            		 numerosSuperastro[x] = Integer.parseInt(numerosStrings[x]);
            		 
            	 }
				
        		 
        		 mundo.getMundoModulo4().getApuestas().borrarApuestas(numerosSuperastro, zodiaco, cedula, nombreSede);
			}
        	 
        	 
        	 if (valor == 1) {
        		 
        		 for (int i = 0; i < 6; i++) {
     				numerosBaloto[i]= Integer.parseInt(nStrings[i]);
     			}
           
        		 mundo.getMundoModulo4().getApuestas().borrarApuestas(numerosBaloto, cedula, nombreSede);
				
			} 	 
        	 mundo.getMundoModulo4().getApuestas().borrarApuestas(cedula, marcadores, nombreSede);	 
		}
         
         if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().ACTUALIZAR)) {
        	 
        	
        	 int valor = Integer.parseInt( interfaz.getModulo4_Interfaz().getSpinner1().getValue().toString());
  			int valor2 = Integer.parseInt(interfaz.getModulo4_Interfaz().getSpinner2().getValue().toString());
         	 String zodiaco = interfaz.getModulo4_Interfaz().getcAstro1().getSelectedItem().toString();
         	 int cedula = Integer.parseInt(interfaz.getModulo4_Interfaz().gettCedula().getText());
         	 String nombreSede = interfaz.getModulo4_Interfaz().getcSedes().getSelectedItem().toString();
         	 String dia = interfaz.getModulo4_Interfaz().getcFecha().getSelectedItem().toString();
         	 
	         int[] numerosSuperastro = new int[4];
        	 String[] numerosStrings = new String[4];
        	 String textF = interfaz.getModulo4_Interfaz().gettAstro1().getText();
        	 numerosStrings = textF.split(" ");
        	 int [] numerosSuperastroNuevo = new int [4];
        	 String [] nuevoSuStrings = new String[4];
        	 String txTnuevoS = interfaz.getModulo4_Interfaz().gettAstro2().getText();
        	 String zodiacoNuevo =  interfaz.getModulo4_Interfaz().getcAstro2().getSelectedItem().toString();
        	 
        	 nuevoSuStrings = txTnuevoS.split(" ");
        	
        	 
        	 
        	 int [] numerosBaloto = new int[6];
        	
        	 String[] nStrings= new String[6];
        	 String txtB = interfaz.getModulo4_Interfaz().gettBaloto1().getText();
        	 nStrings = txtB.split(" ");
        	 int [] numerosBalotoNuevo = new int [6];
        	 String [] nuevoStrings = new String [6];
        	 String txtnuevoB = interfaz.getModulo4_Interfaz().gettBaloto2().getText();
        	 nuevoStrings = txtnuevoB.split(" ");
        	 
                if (valor == 2) {
        		 
        		 for (int i = 0; i < 6; i++) {
     				numerosBaloto[i]= Integer.parseInt(nStrings[i]);
     			}
        		for (int i = 0; i < 6; i++) {
					numerosBalotoNuevo[i] = Integer.parseInt(nuevoStrings[i]);
				} 
           
        		mundo.getMundoModulo4().getApuestas().actualizarDatosApuestas(nombreSede, cedula, dia, 5000, numerosBaloto, Tipo.BALOTO, numerosBalotoNuevo);
				JOptionPane.showMessageDialog(null,"Se a guardado la actualización");
			}
                
                if (valor2 == 2) {

           		 for(int x=0;x<4;x++)
               	 {

               		 numerosSuperastro[x] = Integer.parseInt(numerosStrings[x]);
               		 
               	 }
           		 for (int i = 0; i < 4; i++) {
					numerosSuperastroNuevo[i]= Integer.parseInt(nuevoSuStrings[i]);
				}
   				
           		 
           		mundo.getMundoModulo4().getApuestas().actualizarDatosApuestas(nombreSede, cedula, dia, valor2, zodiaco, numerosSuperastro, Tipo.SUPERASTRO, numerosSuperastroNuevo, zodiacoNuevo);
           		JOptionPane.showMessageDialog(null,"Se a guardado la actualización");
   			}
                
                mundo.getMundoModulo4().getApuestas().actualizarDatosApuestas(nombreSede, cedula, dia, valor, marcadores, marcadoresNuevo, Tipo.MARCADORES);
                JOptionPane.showMessageDialog(null,"Se a guardado la actualización");
         }   
         
         if (contador <  14) {
        	 
        	 if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().LOCAL)) {
					
			
					
					futbol [contador]=" Local:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
					contador++;
					interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
					marcador = 1;
					marcadores[contador-1] = marcador;
					
				}
				
				if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().VISITANTE)) {
					
					
					
					futbol[contador]= " Visitante:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
					contador++;
					interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
					marcador = 2;
					marcadores[contador-1] = marcador;
				}
				
				if(evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().EMPATE)) {
					
			
					
					futbol[contador]=" Empate:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
					contador++;
					interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
					marcador = 3;
					marcadores[contador-1] = marcador;
				}
			if (contador == 14) {
				futboN= true;
			}
			
		}
     
         
         if (futboN == true ) {
//				contador++;
			
				  interfaz.getModulo4_Interfaz().getcFutbol().setModel(new DefaultComboBoxModel(devolver));
				int j =  interfaz.opciones("desea rellenar otro el futbol");
					  if (j ==1) {
						  
						  if ( contador >= 14 && contadorNuevo <14) {
								
								System.out.println(contadorNuevo);
								
								
								   if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().LOCAL)) {
									   futbolNuevo[contadorNuevo]= " Local:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
										contadorNuevo++;
										interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
										marcadorNuevo = 1;
										marcadoresNuevo[contadorNuevo-1] = marcadorNuevo;
									   
								   }
				                 
				                   if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().VISITANTE)) {
				                	   futbolNuevo[contadorNuevo]= " Visitante:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
				   					contadorNuevo++;
				   					interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
				   					marcadorNuevo = 2;
									marcadoresNuevo[contadorNuevo-1] = marcadorNuevo;
									   
								   }
				                   if (evento.getActionCommand().equals(interfaz.getModulo4_Interfaz().EMPATE)) {
				                	   futbolNuevo[contadorNuevo]= " Empate:  "+interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem().toString();
				   					contadorNuevo++;
				   					interfaz.getModulo4_Interfaz().getcFutbol().removeItem(interfaz.getModulo4_Interfaz().getcFutbol().getSelectedItem());
				   					marcadorNuevo = 3;
									marcadoresNuevo[contadorNuevo-1] = marcadorNuevo;
									   
								   }
				                   System.out.println(contadorNuevo); 
								   
							}
						 
						
					}
				  
				  
//				  contador++;
				  
			}
				
	
				System.out.println(contador); 
			
		
	
		
		
		
		
		
		
		// Modulo 4 - termina

				// MODULO 5-Comienza
				if (evento.getActionCommand().equals(interfaz.LISTADOSXSEDE)) { // JAIME
					interfaz.getModulo5_Interfaz().getVentanaCPS().setVisible(true);
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelBusqueda().BUSCARCPS)) {

					try {
						interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelReporte().getTxtClientes().setText(
								mundo.getModulo5().getReportes().buscarDatosCPS((String) (interfaz.getModulo5_Interfaz()
										.getVentanaCPS().getPanelBusqueda().getSeleccionSede().getSelectedItem())));
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Boton buscar Jaime");
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelImprimir().EXCELCPS)) {
					System.out.println("Boton EXCEL Jaime");
					/*
					 * mundo.getModulo5().getReportes().crearArchivoExcel((String)
					 * (interfaz.getModulo5_Interfaz().getVentanaCPS()
					 * .getPanelBusqueda().getSeleccionSede().getSelectedItem()));
					 */

					try {
						mundo.getModulo5().getReportes().crearArchivoExcelCPS();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelImprimir().PDFCPS)) {
					System.out.println("Boton PDF Jaime");

					try {
						mundo.getModulo5().getReportes().crearArchivoPDF();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCPS().getPanelImprimir().ATRASCPS)) {
					System.out.println("Boton ATRAS Jaime");
					interfaz.getModulo5_Interfaz().getVentanaCPS().setVisible(false);
				} // hasta aqui jaime

				else if (evento.getActionCommand().equals(interfaz.VALORTOTALDEAPUESTAS)) {
					interfaz.getModulo5_Interfaz().getVentanaCVTAC().setVisible(true);
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCVTAC().getPanelBusqueda().BUSCARCVTAC)) {
					System.out.println("Boton buscar Manuel");
					interfaz.getModulo5_Interfaz().getVentanaCVTAC().getPanelReporte().getTxtReporte()
							.setText(mundo.getModulo5().getReportes().buscarDatosCVTAC((Integer.parseInt(interfaz
									.getModulo5_Interfaz().getVentanaCVTAC().getPanelBusqueda().getTxtId().getText()))));

				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCVTAC().getPanelImpresion().EXCELCVTAC)) {
					System.out.println("Boton Excel Manuel");

					try {
						mundo.getModulo5().getReportes().crearArchivoExcelCVTAC();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCVTAC().getPanelImpresion().PDFCVTAC)) {
					System.out.println("Boton PDF Manuel");

					try {
						mundo.getModulo5().getReportes().crearArchivoPDF();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCVTAC().getPanelImpresion().ATRASCVTAC)) {
					System.out.println("Boton Atras Manuel");
					interfaz.getModulo5_Interfaz().getVentanaCVTAC().setVisible(false);
				} // hasta aqui manuel

				else if (evento.getActionCommand().equals(interfaz.DETALLEDEAPUESTAS)) {
					interfaz.getModulo5_Interfaz().getVentanaCAPCS().setVisible(true);
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelBusqueda().BUSCARCAPCS)) {
					System.out.println("Boton buscar Edinson");
					
					
					interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelReporte().getTxtReporte().setText(mundo.getModulo5().getReportes().buscarDatosCAPCS(
							Integer.parseInt(interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelBusqueda().getTxtId().getText()),
							((String) (interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelBusqueda().getComboSede()
									.getSelectedItem()))));

				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelImpresion().PDFCAPCS)) {
					System.out.println("Boton PDF Edinson");
					try {
						mundo.getModulo5().getReportes().crearArchivoPDF();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelImpresion().EXCELCAPCS)) {
					System.out.println("Boton EXCEL Edinson");
					try {
						mundo.getModulo5().getReportes().crearArchivoExcelCAPCS();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaCAPCS().getPanelImpresion().ATRASCAPCS)) {
					System.out.println("Boton ATRAS Edinson");
					interfaz.getModulo5_Interfaz().getVentanaCAPCS().setVisible(false);
				} // hasta aqui Edinson

				else if (evento.getActionCommand().equals(interfaz.TOTALDEAPUESTASXTIPODEJUEGO)) {
					interfaz.getModulo5_Interfaz().getVentanaDAC().setVisible(true);
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaDAC().getPanelBusquedaDAC().BUSCARDAC)) {
					System.out.println("Boton buscar Camilo");
					//mundo.getModulo5().getReportes().buscarDatosDAC(((String)(interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().getSede().getSelectedItem())), ((String)(interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().getJuego().getSelectedItem())));
				interfaz.getModulo5_Interfaz().getVentanaDAC().getPanelReportePantallaDAC().getTxtValores().setText(mundo.getModulo5().getReportes().buscarDatosDAC(((String)(interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().getSede().getSelectedItem())), ((String)(interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().getJuego().getSelectedItem()))));
				
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaDAC().getPanelImpresionDAC().PDFDAC)) {
					System.out.println("Boton PDF Camilo");
					try {
						mundo.getModulo5().getReportes().crearArchivoPDF();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaDAC().getPanelImpresionDAC().EXCELDAC)) {
					System.out.println("Boton EXCEL Camilo");
					try {
						mundo.getModulo5().getReportes().crearArchivoExcelDAC(((String)(interfaz.getModulo5().getVentanaDAC().getPanelBusquedaDAC().getJuego().getSelectedItem())));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (evento.getActionCommand()
						.equals(interfaz.getModulo5_Interfaz().getVentanaDAC().getPanelImpresionDAC().ATRASDAC)) {
					System.out.println("Boton ATRAS Camilo");
					interfaz.getModulo5_Interfaz().getVentanaDAC().setVisible(false);
				} // hasta aqui Camilo
					// MODULO 5-TERMINA
	}

}
