package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import modelo.SedeDTO_Modulo2;

public class PanelSedes_Modulo2 extends JPanel {

	//---------------------------------------------------------------------------------------------------------
	// Constantes
	//---------------------------------------------------------------------------------------------------------
	/**
	 * Comando par el botón Crear Sede.
	 */
	public static final String CREAR_SEDE = "Crear Sede";
	/**
	 * Comando para el botón modificar sede.
	 */
	public static final String MODIFICAR_SEDE = "Modificar Sede";
	/**
	 * Comando para el botón ver sedes.
	 */
	public static final String VER_SEDES = "Ver Sedes";
	
	
	//---------------------------------------------------------------------------------------------------------
	// Atributos
	//---------------------------------------------------------------------------------------------------------
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Botón de crear sede.
	 */
	private JButton butCrearSede;
	/**
	 * Boton de modificar sede.
	 */
	private JButton butModificarSede;
	/**
	 * Botón de ver sedes.
	 */
	private JButton butVerSedes;
	/**
	 * Ventana emergente para creación de sedes.
	 */
	private VentanaDatosCreacionSede_Modulo2 ventanaCreacionSede;
	/**
	 * Dialogo para buscar una sede.
	 */
	private DialogoBuscarSede_Modulo2 dialogoBuscarSede;
	/**
	 * Dialogo para modificar una sede.
	 */
	private DialogoModificarSede_Modulo2 dialogoModificar;
	/**
	 * Dialogo con la lista de sedes.
	 */
	private DialogoListaSedes_Modulo2 listaSedes;
	
	
	//---------------------------------------------------------------------------------------------------------
	// Constructor
	//---------------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa el panel de sedes
	 * @param control. El controlador de la aplicación.
	 */
	public PanelSedes_Modulo2(Controlador control) {
		
		TitledBorder border = BorderFactory.createTitledBorder("Sedes");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		setLayout(new GridLayout(1,4, 10, 40));
		
		butCrearSede = new JButton("Crear Sede");
		butCrearSede.setActionCommand(CREAR_SEDE);
		
		
		butModificarSede = new JButton("Modificar Sede");
		butModificarSede.setActionCommand(MODIFICAR_SEDE);
		
		butVerSedes = new JButton("Ver Sedes Registradas");
		butVerSedes.setActionCommand(VER_SEDES);
		
		
		butCrearSede.addActionListener(control);
		butModificarSede.addActionListener(control);
		butVerSedes.addActionListener(control);
		
		
		add(butCrearSede);
		add(butModificarSede);
		add(butVerSedes);
				
	}
	
	
	//---------------------------------------------------------------------------------------------------------
	// Métodos
	//---------------------------------------------------------------------------------------------------------
	
	/**
	 * Inicializa la ventana de creación de sedes.
	 * @param control. El controlador de la aplicación.
	 * @param pLocalidades. La lista con las localidades de Bogotá.
	 */
	public void inicializarVentanaCreacionSedes(Controlador control, String[] pLocalidades) {
	
		ventanaCreacionSede = new VentanaDatosCreacionSede_Modulo2(control, pLocalidades);
		
	}
	
	/**
	 * Inicializa el dialogo de buscar sede.
	 * @param control. El controlador de la aplicación.
	 * @param pSedes. La lista con las sedes existentes en el archivo "sedes.dat".
	 * @throws Exception Si no hay niguna sede registrada aún.
	 */
	public void inicializarDialogoBuscarSede(Controlador control, ArrayList<SedeDTO_Modulo2> pSedes) throws Exception{
		if(pSedes.size()==0) {
			throw new Exception("No hay ninguna sede registrada");
		}
		dialogoBuscarSede = new DialogoBuscarSede_Modulo2(pSedes, control);
	}
	
	/**
	 * Inicializa el dialogo de modificar sedes.
	 * @param verificacionCasillas. Representa las casillas seleccionadas en el dialogo de buscar sedes.
	 * @param control. El controlador de la aplicación.
	 */
	public void inicializarDialogoModificar(int verificacionCasillas, Controlador control) {
		
		dialogoModificar = new DialogoModificarSede_Modulo2(verificacionCasillas, control);
		
	}
	
	/**
	 * Inicializa una ventana emergente de confirmación.
	 * @param interfaz, la interfaz general de la aplicación.
	 * @return True si el usuario hizo click en "si", false si hizo click en "no".
	 */
	public boolean mostrarConfirmacion(Interfaz interfaz) {
		boolean confirmacion = false;
		int dialogResult = JOptionPane.showConfirmDialog(interfaz,  "¿Quiere guardar todos los cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);
				
		if (dialogResult == JOptionPane.YES_OPTION) {
			confirmacion = true;
		}
		return confirmacion;
	}
	
	/**
	 * Inicializa el dialogo de la lista de sedes.
	 * @param pSedes. La lista de las sedes existentes en el archivo "sedes.dat".
	 */
	public void mostrarListaSedes(ArrayList<SedeDTO_Modulo2> pSedes) {
	
		listaSedes = new DialogoListaSedes_Modulo2(pSedes);
		listaSedes.setVisible(true);
		
	}


	
	//---------------------------------------------------------------------------------------------------------
	// Get y Set
	//---------------------------------------------------------------------------------------------------------

	
	public VentanaDatosCreacionSede_Modulo2 getVentanaCreacionSede() {
		return ventanaCreacionSede;
	}
	
	public JButton getButCrearSede() {
		return butCrearSede;
	}

	public void setButCrearSede(JButton butCrearSede) {
		this.butCrearSede = butCrearSede;
	}

	public JButton getButModificarSede() {
		return butModificarSede;
	}

	public void setButModificarSede(JButton butModificarSede) {
		this.butModificarSede = butModificarSede;
	}

	public JButton getButVerSedes() {
		return butVerSedes;
	}

	public void setButVerSedes(JButton butVerSedes) {
		this.butVerSedes = butVerSedes;
	}

	public static String getCrearsede() {
		return CREAR_SEDE;
	}

	public static String getModificarsede() {
		return MODIFICAR_SEDE;
	}

	public static String getVersedes() {
		return VER_SEDES;
	}


	public DialogoBuscarSede_Modulo2 getDialogoBuscarSede() {
		return dialogoBuscarSede;
	}


	public void setDialogoBuscarSede(DialogoBuscarSede_Modulo2 dialogoBuscarSede) {
		this.dialogoBuscarSede = dialogoBuscarSede;
	}


	public DialogoModificarSede_Modulo2 getDialogoModificar() {
		return dialogoModificar;
	}


	public void setDialogoModificar(DialogoModificarSede_Modulo2 dialogoModificar) {
		this.dialogoModificar = dialogoModificar;
	}






	
}
