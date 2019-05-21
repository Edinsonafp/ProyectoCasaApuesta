package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelClientes extends JPanel{
	


		public static final String opcionNuevoUsuario = "NUEVO USUARIO";
	    public static final String opcionEditarUsuario = "EDITAR USUARIO";
	    public static final String opcionCrearArchivo = "CREAR ARCHIVO";
	    public static final String opcionBuscarUsuario = "BUSCAR USUARIO";
	    
	    private JButton botonCrearArchivo;
	    private JButton botonNuevoUsuario;
	    private JButton botonEditarUsuario;
	    private JButton botonBuscarUsuario;

	    private JLabel labelBlanco;
	    private JLabel labelBlanco2;
	    private JLabel labelBuscarUsuario;
	    private JLabel labelHerramientasUsuario;

		private JTextField idTextField;
		
		
		public PanelClientes(Controlador controlador) {

			TitledBorder border = BorderFactory.createTitledBorder("Clientes");

			setLayout( new GridLayout(2, 1) );
	        //setBackground( Color.WHITE );
			border.setTitleColor(Color.BLACK);
			setBorder(border);
	        
	        botonNuevoUsuario = new JButton("Nuevo Usuario");
	        botonNuevoUsuario.setActionCommand(opcionNuevoUsuario);
	        botonNuevoUsuario.addActionListener(controlador);

	        botonEditarUsuario = new JButton( "Modificar Usuario" );
	        botonEditarUsuario.setActionCommand(opcionEditarUsuario);
	        botonEditarUsuario.addActionListener(controlador);

	        botonCrearArchivo = new JButton("Crear Archivo");
	        botonCrearArchivo.setActionCommand(opcionCrearArchivo);
	        botonCrearArchivo.addActionListener(controlador);

	        labelBlanco = new JLabel(" ");
	        labelBlanco2 = new JLabel(" ");
	        labelBuscarUsuario = new JLabel("Buscar Usuario");
	        labelHerramientasUsuario = new JLabel("Herramientas");
	        
	        idTextField = new JTextField("");
	        botonBuscarUsuario = new JButton("Buscar");
	        botonBuscarUsuario.setActionCommand(opcionBuscarUsuario);
	        botonBuscarUsuario.addActionListener(controlador);

	        
	        // Buscar Usuario
	        JPanel panelBuscarUsuario = new JPanel();
	        panelBuscarUsuario.setLayout(new GridLayout(8, 1));
	        panelBuscarUsuario.add(labelBlanco2);
	        panelBuscarUsuario.add(labelBuscarUsuario);
	        panelBuscarUsuario.add(labelBlanco);
	        panelBuscarUsuario.add(idTextField);
	        panelBuscarUsuario.add(botonBuscarUsuario, BorderLayout.SOUTH);

	        add(panelBuscarUsuario, BorderLayout.NORTH);

	        
	        // Botones
	        JPanel panelBotonesEdicionCreacion = new JPanel();
	        panelBotonesEdicionCreacion.setLayout(new GridLayout(5, 1));
	        panelBotonesEdicionCreacion.add(labelHerramientasUsuario);
	        panelBotonesEdicionCreacion.add(botonNuevoUsuario);
	        panelBotonesEdicionCreacion.add(botonEditarUsuario);
	      //  panelBotonesEdicionCreacion.add(botonCrearArchivo);
	        
	        add(panelBotonesEdicionCreacion, BorderLayout.SOUTH);
	        

		}


		public JButton getBotonCrearArchivo() {
			return botonCrearArchivo;
		}


		public void setBotonCrearArchivo(JButton botonCrearArchivo) {
			this.botonCrearArchivo = botonCrearArchivo;
		}


		public JButton getBotonNuevoUsuario() {
			return botonNuevoUsuario;
		}


		public void setBotonNuevoUsuario(JButton botonNuevoUsuario) {
			this.botonNuevoUsuario = botonNuevoUsuario;
		}


		public JButton getBotonEditarUsuario() {
			return botonEditarUsuario;
		}


		public void setBotonEditarUsuario(JButton botonEditarUsuario) {
			this.botonEditarUsuario = botonEditarUsuario;
		}


		public JButton getBotonBuscarUsuario() {
			return botonBuscarUsuario;
		}


		public void setBotonBuscarUsuario(JButton botonBuscarUsuario) {
			this.botonBuscarUsuario = botonBuscarUsuario;
		}


		public JLabel getLabelBlanco() {
			return labelBlanco;
		}


		public void setLabelBlanco(JLabel labelBlanco) {
			this.labelBlanco = labelBlanco;
		}


		public JLabel getLabelBlanco2() {
			return labelBlanco2;
		}


		public void setLabelBlanco2(JLabel labelBlanco2) {
			this.labelBlanco2 = labelBlanco2;
		}


		public JLabel getLabelBuscarUsuario() {
			return labelBuscarUsuario;
		}


		public void setLabelBuscarUsuario(JLabel labelBuscarUsuario) {
			this.labelBuscarUsuario = labelBuscarUsuario;
		}


		public JLabel getLabelHerramientasUsuario() {
			return labelHerramientasUsuario;
		}


		public void setLabelHerramientasUsuario(JLabel labelHerramientasUsuario) {
			this.labelHerramientasUsuario = labelHerramientasUsuario;
		}


		public JTextField getIdTextField() {
			return idTextField;
		}


		public void setIdTextField(JTextField idTextField) {
			this.idTextField = idTextField;
		}


		public static String getOpcionnuevousuario() {
			return opcionNuevoUsuario;
		}


		public static String getOpcioneditarusuario() {
			return opcionEditarUsuario;
		}


		public static String getOpcioncreararchivo() {
			return opcionCrearArchivo;
		}


		public static String getOpcionbuscarusuario() {
			return opcionBuscarUsuario;
		}
		
	




	
	

}
