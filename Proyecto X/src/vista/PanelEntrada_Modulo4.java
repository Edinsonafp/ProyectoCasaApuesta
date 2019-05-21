package vista;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Atxy2k.CustomTextField.RestrictedTextField;


public class PanelEntrada_Modulo4 extends JPanel{
	

	private static final long serialVersionUID = 1L;
	
	JSpinner spinner1, spinner2;
	JTextField tNombre, tCedula, tFutbol;
	JTextField tBaloto1, tBaloto2, tBaloto3, tBaloto4, tBaloto5;
	JTextField tAstro1, tAstro2, tAstro3, tAstro4, tAstro5;
	JTextField tValorb1, tValorb2, tValorb3, tValorb4, tValorb5, tValor1a, tValor2a, tValor3a, tValor4a, tValor5a;
	JComboBox cSedes, cSedes2, cAstro1, cAstro2, cAstro3, cAstro4, cAstro5, cFecha, cFutbol;
	JButton btConfirmar, btGenerar, btAgregar, btnFactura,btnLocal, btnVisitante, btnEmpate, btnInformacion;
	JButton btnActualizar, btnEliminar, btnLeer;
	JLabel lblFutbol, lblPreciob, lblPrecioa, lblPreciof;
	
	public static final String ELIMINAR = "Elimine";
	public static final String LEER = "Lea";
	public static final String ACTUALIZAR = "Actualizar";
	public static final String AGREGAR = "Agrege";
	public static final String FACTURA = "Factura";
	public static final String BLOQUEO = "Verificar";
	public static final String GENERAR = "Generar";
	public static final String LOCAL = "LOCAL";
	public static final String VISITANTE = "Visitante";
	public static final String EMPATE = "Empate";
	public static final String INFORMACION = "Informacion";
	
	public PanelEntrada_Modulo4() {
		
		setPreferredSize(new Dimension(1000, 520));
		setLayout(null);
		TitledBorder border = BorderFactory.createTitledBorder("Generar apuestas");
		setBorder(border);
		
		JLabel lNombre = new JLabel("Nombre Completo:");
		lNombre.setForeground(Color.BLACK);
	
		lNombre.setBounds(10, 20, 115, 15);
		add(lNombre);
		
		tNombre = new JTextField();
		//tNombre.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tNombre.setBounds(130, 17, 85, 20);
		add(tNombre);
		tNombre.setColumns(15);
		
		JLabel lCedula = new JLabel("Numero De Identificacion \"C.C\":");
		lCedula.setForeground(Color.BLACK);
		//lCedula.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lCedula.setBounds(10, 45, 200, 15);
		add(lCedula);
		
		
		tCedula= new JTextField();
		//tCedula.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tCedula.setBounds(220, 42, 85, 20);
		add(tCedula);
		RestrictedTextField tc = new RestrictedTextField(tCedula);
		tc.setLimit(10);
		tc.setOnlyNums(false);
		tCedula.setColumns(15);
		
		JLabel lblSedes = new JLabel("Sede Donde Se Registro:");
		lblSedes.setForeground(Color.BLACK);
		//lblSedes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSedes.setBounds(10, 75, 145, 15);
		add(lblSedes);
	
		cSedes = new JComboBox();
		cSedes.setForeground(Color.BLACK);
		//cSedes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cSedes.setBounds(165, 71, 130, 25);
		cSedes.setMaximumRowCount(21);
		cSedes.setModel(new DefaultComboBoxModel(new String[] {"Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontión", "Engatiá", "Suba" , "Barrios Unidos", "Teusaquillo", "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"}));
		add(cSedes);
		
		btConfirmar = new JButton("Confirmar.");
		btConfirmar.setForeground(Color.BLACK);
		//btConfirmar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btConfirmar.setBounds(356, 70, 100, 25);
		btConfirmar.setActionCommand(BLOQUEO);
		add(btConfirmar);
		
		cFecha = new JComboBox();
		//cFecha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cFecha.setBounds(895, 52, 85, 25);
		cFecha.setMaximumRowCount(7);
		cFecha.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		add(cFecha);
		cFecha.setEnabled(false);
		
		JLabel lBaloto = new JLabel("Baloto");
		lBaloto.setForeground(Color.BLACK);
		//lBaloto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lBaloto.setBounds(10, 142, 45, 15);
		add(lBaloto);
		
		SpinnerModel sp1 = new SpinnerNumberModel(0, 0, 5, 1);
		spinner1 = new JSpinner(sp1);
		//spinner1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		spinner1.setBounds(60, 137, 50, 25);
		add(spinner1);
		spinner1.setEnabled(false);
		
		tBaloto1= new JTextField();
		//tBaloto1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tBaloto1.setBounds(10, 200, 80, 20);
		add(tBaloto1);
		tBaloto1.setVisible(false);
		RestrictedTextField tb1 = new RestrictedTextField(tBaloto1);
		tb1.setLimit(16);
		tb1.setOnlyNums(false);
		tBaloto1.setColumns(15);
		
		tBaloto2= new JTextField();
		//tBaloto2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tBaloto2.setBounds(10, 230, 80, 20);
		add(tBaloto2);
		tBaloto2.setVisible(false);
		RestrictedTextField tb2 = new RestrictedTextField(tBaloto2);
		tb2.setLimit(16);
		tb2.setOnlyNums(false);
		tBaloto2.setColumns(15);
		
		tBaloto3= new JTextField();
		//tBaloto3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tBaloto3.setBounds(10, 260, 80, 20);
		add(tBaloto3);
		tBaloto3.setVisible(false);
		RestrictedTextField tb3 = new RestrictedTextField(tBaloto3);
		tb3.setLimit(16);
		tb3.setOnlyNums(false);
		tBaloto3.setColumns(15);
		
		tBaloto4= new JTextField();
		//tBaloto4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tBaloto4.setBounds(10, 290, 80, 20);
		add(tBaloto4);
		tBaloto4.setVisible(false);
		RestrictedTextField tb4 = new RestrictedTextField(tBaloto4);
		tb4.setLimit(16);
		tb4.setOnlyNums(false);
		tBaloto4.setColumns(15);
		
		tBaloto5= new JTextField();
		//tBaloto5.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tBaloto5.setBounds(10, 320, 80, 20);
		add(tBaloto5);
		tBaloto5.setVisible(false);
		RestrictedTextField tb5 = new RestrictedTextField(tBaloto5);
		tb5.setLimit(16);
		tb5.setOnlyNums(false);
		tBaloto5.setColumns(15);
			
		JLabel lAstro = new JLabel("SuperAstro");
		lAstro.setForeground(Color.BLACK);
		//lAstro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lAstro.setBounds(175, 142, 80, 15);
		add(lAstro);
		
		SpinnerModel sp2 = new SpinnerNumberModel(0, 0, 5, 1);
		spinner2 = new JSpinner(sp2);
		//spinner2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		spinner2.setBounds(255, 137, 50, 25);
		add(spinner2);
		spinner2.setEnabled(false);
		
		tAstro1= new JTextField();
	//	tAstro1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tAstro1.setBounds(175, 200, 80, 20);
		RestrictedTextField ta1 = new RestrictedTextField(tAstro1);
		ta1.setLimit(8);
		
		add(tAstro1);
		tAstro1.setVisible(false);
		tAstro1.setColumns(15);
	
		tAstro2= new JTextField();
		//tAstro2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tAstro2.setBounds(175, 230, 80, 20);
		RestrictedTextField ta2 = new RestrictedTextField(tAstro2);
		
		ta2.setOnlyNums(false);
		add(tAstro2);
		tAstro2.setVisible(false);
		tAstro2.setColumns(15);
		ta2.setLimit(8);

		tAstro3= new JTextField();
		//tAstro3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tAstro3.setBounds(175, 260, 80, 20);
		RestrictedTextField ta3 = new RestrictedTextField(tAstro3);
		ta3.setLimit(8);
		
		add(tAstro3);
		tAstro3.setVisible(false);
		tAstro3.setColumns(15);
		
		tAstro4= new JTextField();
		//tAstro4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tAstro4.setBounds(175, 290, 80, 20);
		RestrictedTextField ta4 = new RestrictedTextField(tAstro4);
		ta4.setLimit(8);
		ta4.setOnlyNums(false);
		add(tAstro4);
		tAstro4.setVisible(false);
		tAstro4.setColumns(15);

		tAstro5= new JTextField();
		//tAstro5.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		tAstro5.setBounds(175, 320, 80, 20);
		RestrictedTextField ta5 = new RestrictedTextField(tAstro5);
		ta5.setLimit(8);
		ta5.setOnlyNums(false);
		add(tAstro5);
		tAstro5.setVisible(false);
		tAstro5.setColumns(15);
			
		btGenerar = new JButton("Generar. | Regresar.");
		//btGenerar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btGenerar.setBounds(790, 270, 170, 25);
		btGenerar.setActionCommand(GENERAR);
		add(btGenerar);
		btGenerar.setEnabled(false);
		
		cAstro1 = new JComboBox();
		cAstro1.setForeground(Color.BLACK);
	//	cAstro1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cAstro1.setBounds(265, 200, 100, 20);
		cAstro1.setMaximumRowCount(12);
		cAstro1.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Géminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		add(cAstro1);
		cAstro1.setVisible(false);
		
		cAstro2 = new JComboBox();
		cAstro2.setForeground(Color.BLACK);
		//cAstro2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cAstro2.setBounds(265, 230, 100, 20);
		cAstro2.setMaximumRowCount(12);
		cAstro2.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Géminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		add(cAstro2);
		cAstro2.setVisible(false);
		
		cAstro3 = new JComboBox();
		cAstro3.setForeground(Color.BLACK);
		//cAstro3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cAstro3.setBounds(265, 260, 100, 20);
		cAstro3.setMaximumRowCount(12);
		cAstro3.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Géminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		add(cAstro3);
		cAstro3.setVisible(false);
		
		cAstro4 = new JComboBox();
		cAstro4.setForeground(Color.BLACK);
		//cAstro4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cAstro4.setBounds(265, 290, 100, 20);
		cAstro4.setMaximumRowCount(12);
		cAstro4.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Géminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		add(cAstro4);
		cAstro4.setVisible(false);
		
		cAstro5 = new JComboBox();
		cAstro5.setForeground(Color.BLACK);
		//cAstro5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cAstro5.setBounds(265, 320, 100, 20);
		cAstro5.setMaximumRowCount(12);
		cAstro5.setModel(new DefaultComboBoxModel(new String[] {"Aries", "Tauro", "Géminis", "Cancer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis"}));
		add(cAstro5);
		cAstro5.setVisible(false);
		
		btAgregar = new JButton("Agregar.");
		//btAgregar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btAgregar.setBounds(790, 340, 100, 25);
		btAgregar.setActionCommand(AGREGAR);
		add(btAgregar);	
		btAgregar.setEnabled(false);
		
		btnFactura = new JButton("Factura");
		
		//btnFactura.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnFactura.setBounds(790, 440, 100, 25);
		btnFactura.setActionCommand(FACTURA);
		add(btnFactura);	
		
		
		
		
		cFutbol = new JComboBox();
		//cFutbol.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cFutbol.setBounds(465, 173, 173, 20);
		cFutbol.setMaximumRowCount(14);
		cFutbol.setModel(new DefaultComboBoxModel(new String[]{"Nacional VS Millonarios", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		add(cFutbol);
		cFutbol.setEnabled(false);
		
		lblFutbol = new JLabel("<html>Escoja el resultado de cada partido.<html>");
		lblFutbol.setForeground(Color.BLACK);
		//lblFutbol.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblFutbol.setBounds(660, 130, 130, 30);
		add(lblFutbol);
		lblFutbol.setVisible(false);
		
		JLabel lblGenerar = new JLabel("<html>Genere los campos de apuesta. Regrese si desea hacer alguna modificacion.<html>");
		lblGenerar.setVerticalAlignment(SwingConstants.TOP);
		lblGenerar.setForeground(Color.BLACK);
		//lblGenerar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblGenerar.setBounds(790, 210, 190, 50);
		add(lblGenerar);
			
		JLabel lblAgrege = new JLabel("Agrege su apuesta.");
		//lblAgrege.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblAgrege.setForeground(Color.BLACK);
		lblAgrege.setBounds(790, 310, 110, 15);
		add(lblAgrege);
		
		JLabel lblConfirmar = new JLabel("<html>Confirme que esta registrado.<html>");
		lblConfirmar.setForeground(Color.BLACK);
		//lblConfirmar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblConfirmar.setBounds(356, 10, 110, 40);
		add(lblConfirmar);
		
		btnLocal = new JButton("Local.");
		//btnLocal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnLocal.setBounds(660, 170, 100, 25);
		add(btnLocal);
		btnLocal.setActionCommand(LOCAL);
		btnLocal.setVisible(false);
		
		btnVisitante = new JButton("Visitante.");
		//btnVisitante.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnVisitante.setBounds(660, 205, 100, 25);
		add(btnVisitante);
		btnVisitante.setActionCommand(VISITANTE);
		btnVisitante.setVisible(false);
		
		btnEmpate = new JButton("Empate.");
		//btnEmpate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnEmpate.setBounds(660, 240, 100, 25);
		add(btnEmpate);
		btnEmpate.setActionCommand(EMPATE);
		btnEmpate.setVisible(false);
		
		JLabel lblSede = new JLabel("Sede Donde Hace La Apuesta:");
		lblSede.setForeground(Color.BLACK);
		//lblSede.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblSede.setBounds(665, 15, 180, 15);
		add(lblSede);
			
		JLabel lblFutbol_1 = new JLabel("Futbol:");
		lblFutbol_1.setForeground(Color.BLACK);
	//	lblFutbol_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblFutbol_1.setBounds(465, 142, 45, 15);
		add(lblFutbol_1);
		
		cSedes2= new JComboBox();
		cSedes2.setForeground(Color.BLACK);
		//cSedes2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		cSedes2.setModel(new DefaultComboBoxModel(new String[] {"Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontión", "Engatiá", "Suba" , "Barrios Unidos", "Teusaquillo", "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"}));
		cSedes2.setBounds(855, 11, 130, 25);
		cSedes2.setMaximumRowCount(21);
		add(cSedes2);
		cSedes2.setEnabled(false);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.BLACK);
		//lblFecha.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblFecha.setBounds(840, 55, 45, 15);
		add(lblFecha);
		
		tValorb1 = new JTextField("$ 5000");
		//tValorb1 .setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tValorb1.setBounds(100, 200, 50, 20);
		add(tValorb1);
		tValorb1.setColumns(15);
		tValorb1.setVisible(false);
		tValorb1.setEditable(false);
		
		tValorb2 = new JTextField("$ 5000");
	//	tValorb2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tValorb2.setBounds(100, 230, 50, 20);
		add(tValorb2);
		tValorb2.setColumns(15);
		tValorb2.setVisible(false);
		tValorb2.setEditable(false);
		
		tValorb3 = new JTextField("$ 5000");
		//tValorb3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tValorb3.setBounds(100, 260, 50, 20);
		add(tValorb3);
		tValorb3.setColumns(15);
		tValorb3.setVisible(false);
		tValorb3.setEditable(false);
		
		tValorb4 = new JTextField("$ 5000");
		//tValorb4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tValorb4.setBounds(100, 290, 50, 20);
		add(tValorb4);
		tValorb4.setColumns(15);
		tValorb4.setVisible(false);
		tValorb4.setEditable(false);
		
		tValorb5 = new JTextField("$ 5000");
		//tValorb5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		tValorb5.setBounds(100, 320, 50, 20);
		add(tValorb5);
		tValorb5.setColumns(15);
		tValorb5.setVisible(false);
		tValorb5.setEditable(false);
		
		lblPreciob = new JLabel("Precio.");
		lblPreciob.setForeground(Color.BLACK);
		//lblPreciob.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPreciob.setBounds(100, 173, 46, 14);
		add(lblPreciob);
		lblPreciob.setVisible(false);
		
		tValor1a = new JTextField();
		//tValor1a.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tValor1a.setBounds(375, 200, 85, 20);
		RestrictedTextField tva1 = new RestrictedTextField(tValor1a);
		tva1.setLimit(10);
		tva1.setOnlyNums(false);
		add(tValor1a);
		tValor1a.setColumns(15);
		tValor1a.setVisible(false);
		
		tValor2a = new JTextField();
		tValor2a.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tValor2a.setBounds(375, 230, 85, 20);
		RestrictedTextField tva2 = new RestrictedTextField(tValor2a);
		tva2.setLimit(10);
		tva2.setOnlyNums(false);
		add(tValor2a);
		tValor2a.setColumns(15);
		tValor2a.setVisible(false);
		
		tValor3a = new JTextField();
		//tValor3a.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tValor3a.setBounds(375, 260, 85, 20);
		RestrictedTextField tva3 = new RestrictedTextField(tValor3a);
		tva3.setLimit(10);
		tva3.setOnlyNums(false);
		add(tValor3a);
		tValor3a.setColumns(15);
		tValor3a.setVisible(false);
		
		tValor4a = new JTextField();
	//	tValor4a.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tValor4a.setBounds(375, 290, 85, 20);
		RestrictedTextField tva4 = new RestrictedTextField(tValor4a);
		tva4.setLimit(10);
		tva4.setOnlyNums(false);
		add(tValor4a);
		tValor4a.setColumns(15);
		tValor4a.setVisible(false);
		
		tValor5a = new JTextField();
		//tValor5a.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tValor5a.setBounds(375, 320, 85, 20);
		RestrictedTextField tva5 = new RestrictedTextField(tValor5a);
		tva5.setLimit(10);
		tva5.setOnlyNums(false);
		add(tValor5a);
		tValor5a.setColumns(15);
		tValor5a.setVisible(false);
		
		lblPrecioa = new JLabel("Precio.");
		//lblPrecioa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPrecioa.setForeground(Color.BLACK);
		lblPrecioa.setBounds(375, 173, 45, 15);
		add(lblPrecioa);
		lblPrecioa.setVisible(false);
		
		JLabel lblInformacion = new JLabel("<html>Informacion sobre el tipo de apuestas.<html>");
		lblInformacion.setVerticalAlignment(SwingConstants.TOP);
		lblInformacion.setForeground(Color.BLACK);
		//lblInformacion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblInformacion.setBounds(790, 130, 190, 35);
		add(lblInformacion);
		
		btnInformacion = new JButton("Informacion.");
		//btnInformacion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnInformacion.setBounds(790, 175, 130, 25);
		btnInformacion.setActionCommand(INFORMACION);
		add(btnInformacion);
		btnInformacion.setEnabled(false);
		
		tFutbol = new JTextField();
		//tFutbol.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		tFutbol.setBounds(660, 275, 100, 20);
		RestrictedTextField tvaf = new RestrictedTextField(tFutbol);
		tvaf.setLimit(10);
		tvaf.setOnlyNums(false);
		add(tFutbol);
		tFutbol.setColumns(15);
		tFutbol.setVisible(false);
		
		lblPreciof = new JLabel("Precio:");
		lblPreciof.setForeground(Color.BLACK);
		//lblPreciof.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblPreciof.setBounds(590, 275, 50, 15);
		add(lblPreciof);
		lblPreciof.setVisible(false);
		
		 btnActualizar = new JButton("Actualizar.");
	//	btnActualizar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnActualizar.setBounds(10, 440, 100, 25);
		btnActualizar.setActionCommand(ACTUALIZAR);
		add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar.");
		//btnEliminar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnEliminar.setBounds(120, 440, 100, 25);
		btnEliminar.setActionCommand(ELIMINAR);
		add(btnEliminar);
		
	    btnLeer = new JButton("Leer.");
		//btnLeer.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnLeer.setBounds(230, 440, 100, 25);
		btnLeer.setActionCommand(LEER);
//		add(btnLeer);
		
	}
	
	// setter's y getter's de todos los objetos dentro del panel.
	
	public JButton getBtnFactura() {
		return btnFactura;
	}

	public void setBtnFactura(JButton btnFactura) {
		this.btnFactura = btnFactura;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnLeer() {
		return btnLeer;
	}

	public void setBtnLeer(JButton btnLeer) {
		this.btnLeer = btnLeer;
	}

	public JSpinner getSpinner1() {
		return spinner1;
	}

	public void setSpinner1(JSpinner spinner1) {
		this.spinner1 = spinner1;
	}

	public JSpinner getSpinner2() {
		return spinner2;
	}

	public void setSpinner2(JSpinner spinner2) {
		this.spinner2 = spinner2;
	}

	public JTextField gettNombre() {
		return tNombre;
	}

	public void settNombre(JTextField tNombre) {
		this.tNombre = tNombre;
	}

	public JTextField gettCedula() {
		return tCedula;
	}

	public void settCedula(JTextField tCedula) {
		this.tCedula = tCedula;
	}

	public JTextField gettFutbol() {
		return tFutbol;
	}

	public void settFutbol(JTextField tFutbol) {
		this.tFutbol = tFutbol;
	}

	public JTextField gettBaloto1() {
		return tBaloto1;
	}

	public void settBaloto1(JTextField tBaloto1) {
		this.tBaloto1 = tBaloto1;
	}

	public JTextField gettBaloto2() {
		return tBaloto2;
	}

	public void settBaloto2(JTextField tBaloto2) {
		this.tBaloto2 = tBaloto2;
	}

	public JTextField gettBaloto3() {
		return tBaloto3;
	}

	public void settBaloto3(JTextField tBaloto3) {
		this.tBaloto3 = tBaloto3;
	}

	public JTextField gettBaloto4() {
		return tBaloto4;
	}

	public void settBaloto4(JTextField tBaloto4) {
		this.tBaloto4 = tBaloto4;
	}

	public JTextField gettBaloto5() {
		return tBaloto5;
	}

	public void settBaloto5(JTextField tBaloto5) {
		this.tBaloto5 = tBaloto5;
	}

	public JTextField gettAstro1() {
		return tAstro1;
	}

	public void settAstro1(JTextField tAstro1) {
		this.tAstro1 = tAstro1;
	}

	public JTextField gettAstro2() {
		return tAstro2;
	}

	public void settAstro2(JTextField tAstro2) {
		this.tAstro2 = tAstro2;
	}

	public JTextField gettAstro3() {
		return tAstro3;
	}

	public void settAstro3(JTextField tAstro3) {
		this.tAstro3 = tAstro3;
	}

	public JTextField gettAstro4() {
		return tAstro4;
	}

	public void settAstro4(JTextField tAstro4) {
		this.tAstro4 = tAstro4;
	}

	public JTextField gettAstro5() {
		return tAstro5;
	}

	public void settAstro5(JTextField tAstro5) {
		this.tAstro5 = tAstro5;
	}

	public JTextField gettValorb1() {
		return tValorb1;
	}

	public void settValorb1(JTextField tValorb1) {
		this.tValorb1 = tValorb1;
	}

	public JTextField gettValorb2() {
		return tValorb2;
	}

	public void settValorb2(JTextField tValorb2) {
		this.tValorb2 = tValorb2;
	}

	public JTextField gettValorb3() {
		return tValorb3;
	}

	public void settValorb3(JTextField tValorb3) {
		this.tValorb3 = tValorb3;
	}

	public JTextField gettValorb4() {
		return tValorb4;
	}

	public void settValorb4(JTextField tValorb4) {
		this.tValorb4 = tValorb4;
	}

	public JTextField gettValorb5() {
		return tValorb5;
	}

	public void settValorb5(JTextField tValorb5) {
		this.tValorb5 = tValorb5;
	}

	public JTextField gettValor1a() {
		return tValor1a;
	}

	public void settValor1a(JTextField tValor1a) {
		this.tValor1a = tValor1a;
	}

	public JTextField gettValor2a() {
		return tValor2a;
	}

	public void settValor2a(JTextField tValor2a) {
		this.tValor2a = tValor2a;
	}

	public JTextField gettValor3a() {
		return tValor3a;
	}

	public void settValor3a(JTextField tValor3a) {
		this.tValor3a = tValor3a;
	}

	public JTextField gettValor4a() {
		return tValor4a;
	}

	public void settValor4a(JTextField tValor4a) {
		this.tValor4a = tValor4a;
	}

	public JTextField gettValor5a() {
		return tValor5a;
	}

	public void settValor5a(JTextField tValor5a) {
		this.tValor5a = tValor5a;
	}

	public JComboBox getcSedes() {
		return cSedes;
	}

	public void setcSedes(JComboBox cSedes) {
		this.cSedes = cSedes;
	}

	public JComboBox getcSedes2() {
		return cSedes2;
	}

	public void setcSedes2(JComboBox cSedes2) {
		this.cSedes2 = cSedes2;
	}

	public JComboBox getcAstro1() {
		return cAstro1;
	}

	public void setcAstro1(JComboBox cAstro1) {
		this.cAstro1 = cAstro1;
	}

	public JComboBox getcAstro2() {
		return cAstro2;
	}

	public void setcAstro2(JComboBox cAstro2) {
		this.cAstro2 = cAstro2;
	}

	public JComboBox getcAstro3() {
		return cAstro3;
	}

	public void setcAstro3(JComboBox cAstro3) {
		this.cAstro3 = cAstro3;
	}

	public JComboBox getcAstro4() {
		return cAstro4;
	}

	public void setcAstro4(JComboBox cAstro4) {
		this.cAstro4 = cAstro4;
	}

	public JComboBox getcAstro5() {
		return cAstro5;
	}

	public void setcAstro5(JComboBox cAstro5) {
		this.cAstro5 = cAstro5;
	}

	public JComboBox getcFecha() {
		return cFecha;
	}

	public void setcFecha(JComboBox cFecha) {
		this.cFecha = cFecha;
	}

	public JComboBox getcFutbol() {
		return cFutbol;
	}

	public void setcFutbol(JComboBox cFutbol) {
		this.cFutbol = cFutbol;
	}

	public JButton getBtConfirmar() {
		return btConfirmar;
	}

	public void setBtConfirmar(JButton btConfirmar) {
		this.btConfirmar = btConfirmar;
	}

	public JButton getBtGenerar() {
		return btGenerar;
	}

	public void setBtGenerar(JButton btGenerar) {
		this.btGenerar = btGenerar;
	}

	public JButton getBtAgregar() {
		return btAgregar;
	}

	public void setBtAgregar(JButton btAgregar) {
		this.btAgregar = btAgregar;
	}

	public JButton getBtnLocal() {
		return btnLocal;
	}

	public void setBtnLocal(JButton btnLocal) {
		this.btnLocal = btnLocal;
	}

	public JButton getBtnVisitante() {
		return btnVisitante;
	}

	public void setBtnVisitante(JButton btnVisitante) {
		this.btnVisitante = btnVisitante;
	}

	public JButton getBtnEmpate() {
		return btnEmpate;
	}

	public void setBtnEmpate(JButton btnEmpate) {
		this.btnEmpate = btnEmpate;
	}

	public JButton getBtnInformacion() {
		return btnInformacion;
	}

	public void setBtnInformacion(JButton btnInformacion) {
		this.btnInformacion = btnInformacion;
	}

	public JLabel getLblFutbol() {
		return lblFutbol;
	}

	public void setLblFutbol(JLabel lblFutbol) {
		this.lblFutbol = lblFutbol;
	}

	public JLabel getLblPreciob() {
		return lblPreciob;
	}

	public void setLblPreciob(JLabel lblPreciob) {
		this.lblPreciob = lblPreciob;
	}

	public JLabel getLblPrecioa() {
		return lblPrecioa;
	}

	public void setLblPrecioa(JLabel lblPrecioa) {
		this.lblPrecioa = lblPrecioa;
	}

	public JLabel getLblPreciof() {
		return lblPreciof;
	}

	public void setLblPreciof(JLabel lblPreciof) {
		this.lblPreciof = lblPreciof;
	}	
}
