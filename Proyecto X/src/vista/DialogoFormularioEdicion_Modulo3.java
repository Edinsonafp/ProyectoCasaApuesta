package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.SedeDTO_Modulo2;

public class DialogoFormularioEdicion_Modulo3 extends JDialog {

	private String errores = "";
	public String nombreARegistrar, apellidoARegistrar, direccionARegistrar, sedeDeJuegoARegistrar;
	public int cedulaARegistrar, movilARegistrar;
	
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	
	private JLabel apellidoLabel;
	private JTextField apellidoTextField;
	
	private JLabel cedulaLabel;
	private JTextField cedulaTextField;
	
	private JLabel direccionLabel;
	private JTextField direccionTextField;
	
	private JLabel movilLabel;
	private JTextField movilTextField;
	
	public JComboBox sedeComboBox;
	public JLabel sedeLabel;
	
	private JLabel labelBlanco;
	
	private JButton guardarModificarDatos;
	
	private JButton botonActualizarDatos;
    private JButton botonEliminarUsuario;
    public static final String opcionActualizarDatos = "ACTUALIZAR USUARIO";
    public static final String opcionEliminarDatos = "ELIMINAR USUARIO";
	
	
	public DialogoFormularioEdicion_Modulo3(Controlador controlador) {
		
		
				
        setResizable( false );
        setLayout( new BorderLayout( ) );

		JPanel panelFormulario = new JPanel();

        setTitle( "Usuario a Editar" );

		panelFormulario.setBorder(new TitledBorder("Formulario Edicion Usuario"));
		panelFormulario.setLayout(new GridLayout(9, 2));
		
		labelBlanco  = new JLabel("");
		panelFormulario.add(labelBlanco);
		
		labelBlanco  = new JLabel("");
		panelFormulario.add(labelBlanco);
		
		nombreLabel = new JLabel("Nombre:");
		nombreTextField = new JTextField("");
		panelFormulario.add(nombreLabel);
		panelFormulario.add(nombreTextField);
		
		apellidoLabel = new JLabel("Apellido:");
		apellidoTextField = new JTextField("");
		panelFormulario.add(apellidoLabel);
		panelFormulario.add(apellidoTextField);
		
		cedulaLabel = new JLabel("Cedula:");
		cedulaTextField = new JTextField("");
		panelFormulario.add(cedulaLabel);
		panelFormulario.add(cedulaTextField);
		
		direccionLabel = new JLabel("Direccion:");
		direccionTextField = new JTextField("");
		panelFormulario.add(direccionLabel);
		panelFormulario.add(direccionTextField);
		
		movilLabel = new JLabel("Movil:");
		movilTextField = new JTextField("");
		panelFormulario.add(movilLabel);
		panelFormulario.add(movilTextField);
		
		sedeComboBox = new JComboBox();
		

		sedeComboBox.addActionListener(controlador);
		sedeLabel = new JLabel("");
		panelFormulario.add(sedeComboBox);
		panelFormulario.add(sedeLabel);
			
		labelBlanco  = new JLabel("");
		panelFormulario.add(labelBlanco);
		
		labelBlanco  = new JLabel("");
		panelFormulario.add(labelBlanco);
		
		labelBlanco  = new JLabel("");
		panelFormulario.add(labelBlanco);

		botonActualizarDatos = new JButton("Actualizar");
		botonActualizarDatos.setActionCommand(opcionActualizarDatos);
		botonActualizarDatos.addActionListener(controlador);

        botonEliminarUsuario = new JButton( "Eliminar" );
        botonEliminarUsuario.setActionCommand( opcionEliminarDatos );
        botonEliminarUsuario.addActionListener(controlador);
        
        JPanel panelBotonesCrearEliminar = new JPanel();
        panelBotonesCrearEliminar.setLayout(new GridLayout(1, 2));
        panelBotonesCrearEliminar.add(botonActualizarDatos);
        panelBotonesCrearEliminar.add(botonEliminarUsuario);

		panelFormulario.add(panelBotonesCrearEliminar, BorderLayout.SOUTH);
		
		add(panelFormulario, BorderLayout.NORTH);
	
		pack();
		setLocationRelativeTo(null);
	}
	
	// Get - Set
	
	public void llenarSedeComboBox(ArrayList<SedeDTO_Modulo2> Array) {
		
		for (int i = 0; i < Array.size(); i++) {
			sedeComboBox.addItem(Array.get(i).getNombre());
		}
	}
	
	public JTextField getNombreTextField() {
		return nombreTextField;
	}

	public void setNombreTextField(JTextField nombreTextField) {
		this.nombreTextField = nombreTextField;
	}
	
	public String getErrores() {
		return errores;
	}

	public void setErrores(String errores) {
		this.errores = errores;
	}

	public JTextField getApellidoTextField() {
		return apellidoTextField;
	}

	public void setApellidoTextField(JTextField apellidoTextField) {
		this.apellidoTextField = apellidoTextField;
	}

	public JTextField getDireccionTextField() {
		return direccionTextField;
	}

	public void setDireccionTextField(JTextField direccionTextField) {
		this.direccionTextField = direccionTextField;
	}

	public JTextField getMovilTextField() {
		return movilTextField;
	}

	public void setMovilTextField(JTextField movilTextField) {
		this.movilTextField = movilTextField;
	}

	public JLabel getSedeLabel() {
		return sedeLabel;
	}

	public void setSedeLabel(JLabel sedeLabel) {
		this.sedeLabel = sedeLabel;
	}
	
	public JLabel getCedulaLabel() {
		return cedulaLabel;
	}

	public void setCedulaLabel(JLabel cedulaLabel) {
		this.cedulaLabel = cedulaLabel;
	}

	public JTextField getCedulaTextField() {
		return cedulaTextField;
	}

	public void setCedulaTextField(JTextField cedulaTextField) {
		this.cedulaTextField = cedulaTextField;
	}

	public JButton getGuardarModifcarDatos() {
		return guardarModificarDatos;
	}

	public void setGuardarModificarDatos(JButton guardarModificarDatos) {
		this.guardarModificarDatos = guardarModificarDatos;
	}
	
	public JComboBox getLista() {
		return sedeComboBox;		
	}
	
	// Errores
	
	public boolean tomarDatosDelFormulario()  {
		boolean respuesta;
		
		String cedulaString, movilString;
		
		errores = "";
		
		nombreARegistrar = nombreTextField.getText(); 
		apellidoARegistrar = apellidoTextField.getText();
		direccionARegistrar = direccionTextField.getText();
		cedulaString = cedulaTextField.getText();
		sedeDeJuegoARegistrar = sedeLabel.getText();
		movilString = movilTextField.getText();
		
		// Verificar Casillas
		if (esDireccionCorrecta(direccionARegistrar) == false) {
			errores += "Dirección demasiado larga, máx 50 carácteres" + "\n";
		}
		if (esCedulaCorrecta(cedulaString) == false) {
			errores += "Cedula no valida, máx 10 carácteres" + "\n";
		}
		if (esMovilCorrecto(movilString) == false) {
			errores += "Móvil no valido, máx 10 carácteres" + "\n";
		}
		if (esNombreApellidoCorrecto(apellidoARegistrar, apellidoARegistrar) == false) {
			errores += "Debe ingresar al menos un nombre y un apellido" + "\n";
		}

		
		if (nombreARegistrar != "" && apellidoARegistrar != "" && direccionARegistrar != "" && sedeDeJuegoARegistrar != "" && cedulaString != "" && movilString != "") {
			
			try {
				cedulaARegistrar = Integer.parseInt(cedulaString);
			}
			catch( NumberFormatException e1 ) {
                JOptionPane.showMessageDialog( this, "Formato incorrecto, verifique número de cedula", "Error", JOptionPane.ERROR_MESSAGE );
			}
			
			try {				
				movilARegistrar = Integer.parseInt(movilTextField.getText());
			}
			catch( NumberFormatException e1 ) {
                JOptionPane.showMessageDialog( this, "Formato incorrecto, verifique número de móvil", "Error", JOptionPane.ERROR_MESSAGE );
			}
			respuesta = true;
		}
		else {
			errores = "FALTAN DATOS";
			respuesta = false;
		}

		return respuesta;
	}
	
	public boolean esNombreApellidoCorrecto(String nombre, String apellido) {
		boolean respuesta = false;
		
		if (nombre != "" && apellido != "") {
			respuesta = true;
		}
		return respuesta;
	}
	
	
	public boolean esCedulaCorrecta(String cedulaARegistrar) {
		int cedulaLenght = cedulaARegistrar.length();	
		
		if (cedulaLenght <= 10) {
			return true;
		}	
		return false;
	}
	
	public boolean esMovilCorrecto(String movilARegistrar) {

		boolean respuesta = false;
		int movilLenght = movilARegistrar.length();	
		
		String movilARegistrarPrefijo = "";

		if (movilLenght <= 11 && movilLenght > 3) {
			
			movilARegistrarPrefijo = "" + movilARegistrar.charAt(0) + movilARegistrar.charAt(1) + movilARegistrar.charAt(2);
			
			String[] prefijosColombia = {"300", "301", "302", "303", "304", "305", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "350"};
			
			for (int i = 0; i < prefijosColombia.length; i++) {
				if (movilARegistrarPrefijo.equalsIgnoreCase(prefijosColombia[i])) {

					respuesta = true;
				}
			}
		}		

		return respuesta;
	}
	
	
	public boolean esDireccionCorrecta(String direccion) {
		boolean respuesta;
		int direccionLenght = direccion.length();
		
		if (direccionLenght > 50) {
			respuesta = false;
		}
		else {
			respuesta = true;
		}
		
		return respuesta;
	}
	
	public void mostrarCuadroErrores() {
		JOptionPane.showMessageDialog(null, errores, "T�tulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
	
}

