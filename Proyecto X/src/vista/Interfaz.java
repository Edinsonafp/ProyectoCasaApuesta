package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

public class Interfaz extends JFrame {

	private JMenu menu, editar, reportes;
	private JMenuBar barraSuperiorMenu;
	private JMenuItem crearCasaApuesta, leerCasaApuesta, editCasaApuesta, repClientesSedes,
			repTotalApuestaCliente, repDetalleApuestaCliente, repTotalApuestaJuego;

	private PanelClientes panelClientes;

	private PanelSedes_Modulo2 panelSedes;

	private Interfaz_Modulo3 interfaz_Modulo3;
	private Modulo1_Interfaz modulo1_Interfaz;
	private Modulo5_Interfaz modulo5_Interfaz;
	
	
	private PanelEntrada_Modulo4 modulo4_Interfaz;

	public static final String CREARCASAAPUESTA = "Crear casa de apuesta";
	public static final String MODIFICARCASAAPUESTA = "Modificar casa de apuesta";
	public static final String LEERCASASAPUESTA = "Leer casa de apuesta";

	public static final String LISTADOSXSEDE = "Lista De Clientes por Sede";
	public static final String VALORTOTALDEAPUESTAS = "Valor Total de Apuestas por Cliente";
	public static final String DETALLEDEAPUESTAS = "Detalles de Apuestas por Cliente";
	public static final String TOTALDEAPUESTASXTIPODEJUEGO = "Total de Apuestas por Tipo de Juego";

	public Interfaz(Controlador control) {

		// Interfaz General Comienza
		setSize(1200, 650);
		setResizable(false);
		setTitle("Programa Casa de Apuestas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		modulo1_Interfaz = new Modulo1_Interfaz(control);
		interfaz_Modulo3 = new Interfaz_Modulo3(control);
		modulo5_Interfaz = new Modulo5_Interfaz(control);

		// BARA MENU SUPERIOS --INICIA
		crearCasaApuesta = new JMenuItem("Crear casa de apuesta");
		crearCasaApuesta.setActionCommand(CREARCASAAPUESTA);
		crearCasaApuesta.addActionListener(control);

		leerCasaApuesta = new JMenuItem("Leer datos casa de apuesta");
		leerCasaApuesta.setActionCommand(LEERCASASAPUESTA);
		leerCasaApuesta.addActionListener(control);

		

		editCasaApuesta = new JMenuItem("Casa de Apuesta");
		editCasaApuesta.setActionCommand(MODIFICARCASAAPUESTA);
		editCasaApuesta.addActionListener(control);

		menu = new JMenu("Menu");
		menu.add(crearCasaApuesta);
		menu.add(leerCasaApuesta);

		repClientesSedes = new JMenuItem("Clientes por sede");
		repClientesSedes.setActionCommand(LISTADOSXSEDE);
		repClientesSedes.addActionListener(control);

		repTotalApuestaCliente = new JMenuItem("Apuestas por cliente");
		repTotalApuestaCliente.setActionCommand(VALORTOTALDEAPUESTAS);
		repTotalApuestaCliente.addActionListener(control);

		repDetalleApuestaCliente = new JMenuItem("Detalles de apuestas por cliente");
		repDetalleApuestaCliente.setActionCommand(DETALLEDEAPUESTAS);
		repDetalleApuestaCliente.addActionListener(control);

		repTotalApuestaJuego = new JMenuItem("Total de apuestas por tipo de juego");
		repTotalApuestaJuego.setActionCommand(TOTALDEAPUESTASXTIPODEJUEGO);
		repTotalApuestaJuego.addActionListener(control);

		editar = new JMenu("Editar");
		
		editar.add(editCasaApuesta);

		reportes = new JMenu("Reportes");
		reportes.add(repClientesSedes);
		reportes.add(repTotalApuestaCliente);
		reportes.add(repDetalleApuestaCliente);
		reportes.add(repTotalApuestaJuego);

		barraSuperiorMenu = new JMenuBar();
		barraSuperiorMenu.add(menu);
		barraSuperiorMenu.add(editar);
		barraSuperiorMenu.add(reportes);

		setJMenuBar(barraSuperiorMenu);

		// BARA MENU SUPERIOS --Termina
		// https://www.lawebdelprogramador.com/codigo/Java/4644-Barra-de-menus-en-Java-con-JMenu.html

		panelClientes = new PanelClientes(control);
		panelClientes.setPreferredSize(new Dimension(200, 300)); // ancho alto

		
		this.modulo4_Interfaz = new PanelEntrada_Modulo4();
		
		modulo4_Interfaz.getBtGenerar().addActionListener(control);
		modulo4_Interfaz.getBtConfirmar().addActionListener(control);
		modulo4_Interfaz.getBtAgregar().addActionListener(control);
		modulo4_Interfaz.getBtnLocal().addActionListener(control);
		modulo4_Interfaz.getBtnVisitante().addActionListener(control);
		modulo4_Interfaz.getBtnEmpate().addActionListener(control);
		modulo4_Interfaz.getBtnInformacion().addActionListener(control);
		modulo4_Interfaz.getBtnActualizar().addActionListener(control);
		modulo4_Interfaz.getBtnEliminar().addActionListener(control);
		modulo4_Interfaz.getBtnLeer().addActionListener(control);
		modulo4_Interfaz.getBtnFactura().addActionListener(control);
		
		

		panelSedes = new PanelSedes_Modulo2(control);
		panelSedes.setPreferredSize(new Dimension(100, 100));
	/*	panelSedes.getButCrearSede().addActionListener(control);
		panelSedes.getButModificarSede().addActionListener(control);
		panelSedes.getButVerSedes().addActionListener(control);*/

		// Interfaz General Termina

		// MODULO 5 - Comienza

		// Modulo 5 Termina

		// Agregar
		//add(pestañas);
		add(modulo4_Interfaz);
		add(panelClientes, BorderLayout.WEST);
		add(panelSedes, BorderLayout.SOUTH);
		// Agregar Termina
	}
	public void escribirMensaje(String mensaje) {
			
			JOptionPane.showMessageDialog(null, mensaje);
		}
		
		public int opciones(String mensaje) {
			
			String[] opcion= {"CONFIRMAR.", "REGRESAR."};
			return JOptionPane.showOptionDialog(null, mensaje, null, 0, JOptionPane.INFORMATION_MESSAGE, null, opcion, null);
		}

	public PanelEntrada_Modulo4 getModulo4_Interfaz() {
		return modulo4_Interfaz;
	}

	public void setModulo4_Interfaz(PanelEntrada_Modulo4 modulo4_Interfaz) {
		this.modulo4_Interfaz = modulo4_Interfaz;
	}

	public void escribirDato(String dato) {
		JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

	public Interfaz_Modulo3 getInterfaz_Modulo3() {
		return interfaz_Modulo3;
	}

	public void setInterfaz_Modulo3(Interfaz_Modulo3 interfaz_Modulo3) {
		this.interfaz_Modulo3 = interfaz_Modulo3;
	}

	public static String getLeercasasapuesta() {
		return LEERCASASAPUESTA;
	}

	public static String getModificarcasaapuesta() {
		return MODIFICARCASAAPUESTA;
	}
	

	public JMenuItem getLeerCasaApuesta() {
		return leerCasaApuesta;
	}

	public void setLeerCasaApuesta(JMenuItem leerCasaApuesta) {
		this.leerCasaApuesta = leerCasaApuesta;
	}

	public JMenuItem getEditCasaApuesta() {
		return editCasaApuesta;
	}

	public void setEditCasaApuesta(JMenuItem editCasaApuesta) {
		this.editCasaApuesta = editCasaApuesta;
	}

	public Modulo1_Interfaz getModulo1_Interfaz() {
		return modulo1_Interfaz;
	}

	public void setModulo1_Interfaz(Modulo1_Interfaz modulo1_Interfaz) {
		this.modulo1_Interfaz = modulo1_Interfaz;
	}

	public Modulo5_Interfaz getModulo5_Interfaz() {
		return modulo5_Interfaz;
	}

	public void setModulo5_Interfaz(Modulo5_Interfaz modulo5_Interfaz) {
		this.modulo5_Interfaz = modulo5_Interfaz;
	}

	public static String getCrearcasaapuesta() {
		return CREARCASAAPUESTA;
	}

	public Modulo5_Interfaz getModulo5() {
		return modulo5_Interfaz;
	}

	public void setModulo5(Modulo5_Interfaz modulo5_Interfaz) {
		this.modulo5_Interfaz = modulo5_Interfaz;
	}

	public static String getListadosxsede() {
		return LISTADOSXSEDE;
	}

	public static String getValortotaldeapuestas() {
		return VALORTOTALDEAPUESTAS;
	}

	public static String getDetalledeapuestas() {
		return DETALLEDEAPUESTAS;
	}

	public static String getTotaldeapuestasxtipodejuego() {
		return TOTALDEAPUESTASXTIPODEJUEGO;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenu getEditar() {
		return editar;
	}

	public void setEditar(JMenu editar) {
		this.editar = editar;
	}

	public JMenu getReportes() {
		return reportes;
	}

	public void setReportes(JMenu reportes) {
		this.reportes = reportes;
	}

	public JMenuBar getBarraSuperiorMenu() {
		return barraSuperiorMenu;
	}

	public void setBarraSuperiorMenu(JMenuBar barraSuperiorMenu) {
		this.barraSuperiorMenu = barraSuperiorMenu;
	}

	public JMenuItem getCrearCasaApuesta() {
		return crearCasaApuesta;
	}

	public void setCrearCasaApuesta(JMenuItem crearCasaApuesta) {
		this.crearCasaApuesta = crearCasaApuesta;
	}

	

	public JMenuItem getEditSede() {
		return editCasaApuesta;
	}

	public void setEditSede(JMenuItem editSede) {
		this.editCasaApuesta = editSede;
	}

	public JMenuItem getRepClientesSedes() {
		return repClientesSedes;
	}

	public void setRepClientesSedes(JMenuItem repClientesSedes) {
		this.repClientesSedes = repClientesSedes;
	}

	public JMenuItem getRepTotalApuestaCliente() {
		return repTotalApuestaCliente;
	}

	public void setRepTotalApuestaCliente(JMenuItem repTotalApuestaCliente) {
		this.repTotalApuestaCliente = repTotalApuestaCliente;
	}

	public JMenuItem getRepDetalleApuestaCliente() {
		return repDetalleApuestaCliente;
	}

	public void setRepDetalleApuestaCliente(JMenuItem repDetalleApuestaCliente) {
		this.repDetalleApuestaCliente = repDetalleApuestaCliente;
	}

	public JMenuItem getRepTotalApuestaJuego() {
		return repTotalApuestaJuego;
	}

	public void setRepTotalApuestaJuego(JMenuItem repTotalApuestaJuego) {
		this.repTotalApuestaJuego = repTotalApuestaJuego;
	}

	public PanelClientes getPanelClientes() {
		return panelClientes;
	}

	public void setPanelClientes(PanelClientes panelClientes) {
		this.panelClientes = panelClientes;
	}
	public PanelSedes_Modulo2 getPanelSedes() {
		return panelSedes;
	}
	public void setPanelSedes(PanelSedes_Modulo2 panelSedes) {
		this.panelSedes = panelSedes;
	}


}
