package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Reportes_Modulo5 {

	private ArrayList<ApostadorDto_Modulo3> apostadores;
	private String rutaApostadores = "data\\\\apostadores.dat";
	private String contenido;
	private String [][]  datosCPS;
	private String [][] datosCVTAC = new String[1][6];
	private String [][] datosCAPCS = new String[1][9];
	private String [][] datosDAC = new String[1][5];
	

	public Reportes_Modulo5() {

	}

	public String buscarDatosCPS(String sede) throws DocumentException {

		String reportePantalla = "Sede: " + sede + "\n\nLista de clientes: \n\n";
		int filas = 0;
		ObjectInputStream in;
		apostadores = new ArrayList<>();

		try {

			in = new ObjectInputStream(new FileInputStream(rutaApostadores));
			apostadores = (ArrayList<ApostadorDto_Modulo3>) in.readObject();

			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getSedeDeJuego().equalsIgnoreCase(sede)) {
				reportePantalla += apostadores.get(i).getNombre() + " " + apostadores.get(i).getApellido() + " "
						+ apostadores.get(i).getCedula() + " " + apostadores.get(i).getDireccion() + " "
						+ apostadores.get(i).getCelular() + "\n";
				filas++;
			}
		}
		
		
		datosCPS = new String [filas][5];
		int agregar =0;
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getSedeDeJuego().equalsIgnoreCase(sede)) {
				
				
					datosCPS[agregar][0]=apostadores.get(i).getNombre();
					datosCPS[agregar][1]=apostadores.get(i).getApellido();
					datosCPS[agregar][2]=Integer.toString(apostadores.get(i).getCedula());
					datosCPS[agregar][3]=apostadores.get(i).getDireccion();
					datosCPS[agregar][4]=Integer.toString(apostadores.get(i).getCelular());
				agregar++;
				
			}
			
		}
		
		contenido = reportePantalla;
		return reportePantalla;

	}

	public void crearArchivoExcelCPS () throws FileNotFoundException, IOException {
		String[] header = {"Nombre","Apellido", "Cedula", "Direccion", "Celular"};
		String ruta = "data\\ReporteClientePorSede.xlsx";
		String hoja = "Hoja1";

		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFCell celda;
		XSSFCellStyle border = libro.createCellStyle();
		XSSFCellStyle borderHeader = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		XSSFFont font1 = libro.createFont();
		
		font.setFontHeight(9);
		font.setFontName("Arial");
		border.setBorderBottom(BorderStyle.MEDIUM);
		border.setBorderTop(BorderStyle.MEDIUM);
		border.setBorderRight(BorderStyle.MEDIUM);
		border.setBorderLeft(BorderStyle.MEDIUM);
		
		borderHeader.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		borderHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font1.setColor(IndexedColors.WHITE.getIndex());
		
		for (int i = 0; i < datosCPS.length + 1; i++) { // filas
			XSSFRow fila = hoja1.createRow(i); // crea las filas
			for (int j = 0; j < header.length; j++) { // columnas
				if (i == 0) {
					celda = fila.createCell(j); // se crea la celda para la cabecera
					celda.setCellStyle(borderHeader);
					borderHeader.setFont(font1);

					System.out.println(header[j]);
					celda.setCellValue(header[j]);
					hoja1.autoSizeColumn(j);
				} else {

					celda = fila.createCell(j);
					celda.setCellStyle(border);
					border.setFont(font);
					celda.setCellValue(datosCPS[i - 1][j]);
					hoja1.autoSizeColumn(j);
				}

				System.out.print("i:" + i + " j: " + j + " || ");
			}
			System.out.println();
		} // fin for

		File file;
		file = new File(ruta);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
		}
		
		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}
		
	}
	
	
	public String buscarDatosCVTAC (int id) {
		
		System.out.println("id en reportes "+id);
		
		ObjectInputStream in;
		String reportePantalla = "El usuario: \n";
		int apuesta = 0;
		try {

			in = new ObjectInputStream(new FileInputStream(rutaApostadores));
			apostadores = (ArrayList<ApostadorDto_Modulo3>) in.readObject();

			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getCedula()==id) {
				reportePantalla += apostadores.get(i).getNombre() + " " + apostadores.get(i).getApellido() + " "
						+ apostadores.get(i).getCedula() + " " + apostadores.get(i).getDireccion() + " "
						+ apostadores.get(i).getCelular() + "\n\n";
						datosCVTAC[0][0]=apostadores.get(i).getNombre();
						datosCVTAC[0][1]=apostadores.get(i).getApellido();
						datosCVTAC[0][2]=Integer.toString(apostadores.get(i).getCedula());
						datosCVTAC[0][3]=apostadores.get(i).getDireccion();
						datosCVTAC[0][4]=Integer.toString(apostadores.get(i).getCelular());
				
			}else if(datosCVTAC[0][2]=="") {
				reportePantalla="El usuario no existe\n\n";
			}
		}
		
		reportePantalla+="Valor total de apuestas: \n\n"+apuesta+"$";
		
		contenido = reportePantalla;
		return reportePantalla;
	}
	
	public String buscarDatosCAPCS(int id, String sede) {
		System.out.println("id en reportes "+id+" en: "+sede);
		
		String reportePantalla = "El usuario: \n";
		ObjectInputStream in;
	
		int totalBaloto = 0;
		int totalSuperAstro = 0;
		int totalFutbol = 0;
		
		try {

			in = new ObjectInputStream(new FileInputStream(rutaApostadores));
			apostadores = (ArrayList<ApostadorDto_Modulo3>) in.readObject();

			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getCedula()==id) {
				reportePantalla += apostadores.get(i).getNombre() + " " + apostadores.get(i).getApellido() + " "
						+ apostadores.get(i).getCedula() + " " + apostadores.get(i).getDireccion() + " "
						+ apostadores.get(i).getCelular() + "\n\n";
						datosCAPCS[0][0]=apostadores.get(i).getNombre();
						datosCAPCS[0][1]=apostadores.get(i).getApellido();
						datosCAPCS[0][2]=Integer.toString(apostadores.get(i).getCedula());
						datosCAPCS[0][3]=apostadores.get(i).getDireccion();
						datosCAPCS[0][4]=Integer.toString(apostadores.get(i).getCelular());
						datosCAPCS[0][5]=sede;
						
				
			}else if(datosCAPCS[0][2]=="") {
				reportePantalla="El usuario no existe\n\n";
			}
		}
		
		reportePantalla+="Valor total de apuestas: \n\nTotal apuestas en baloto: "+totalBaloto+"$\nTotal apuestas en SuperAstro: "+totalSuperAstro+"$\nTotal apuestas de futbol: "+totalFutbol+"$";
		
		contenido = reportePantalla;
		
		
		return reportePantalla;
	}
	public void crearArchivoExcelCVTAC () throws FileNotFoundException, IOException {
		
		String[] header = {"Nombre","Apellido", "Cedula", "Direccion", "Celular", "TotalApuesta"};
		String ruta = "data\\ReporteTotalApuestaCliente.xlsx";
		String hoja = "Hoja1";

		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFCell celda;
		XSSFCellStyle border = libro.createCellStyle();
		XSSFCellStyle borderHeader = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		XSSFFont font1 = libro.createFont();
		font.setFontHeight(9);
		font.setFontName("Arial");
		border.setBorderBottom(BorderStyle.MEDIUM);
		border.setBorderTop(BorderStyle.MEDIUM);
		border.setBorderRight(BorderStyle.MEDIUM);
		border.setBorderLeft(BorderStyle.MEDIUM);
		
		borderHeader.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		borderHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font1.setColor(IndexedColors.WHITE.getIndex());
		
		for (int i = 0; i < datosCVTAC.length + 1; i++) { // filas
			XSSFRow fila = hoja1.createRow(i); // crea las filas
			for (int j = 0; j < header.length; j++) { // columnas
				if (i == 0) {
					celda = fila.createCell(j); // se crea la celda para la cabecera
					celda.setCellStyle(borderHeader);
					borderHeader.setFont(font1);

					System.out.println(header[j]);
					celda.setCellValue(header[j]);
					hoja1.autoSizeColumn(j);
				} else {

					celda = fila.createCell(j);
					celda.setCellStyle(border);
					border.setFont(font);
					celda.setCellValue(datosCVTAC[i - 1][j]);
					hoja1.autoSizeColumn(j);
				}

				System.out.print("i:" + i + " j: " + j + " || ");
			}
			System.out.println();
		} // fin for

		File file;
		file = new File(ruta);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
		}
		
		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}
		
	}
	
	public String buscarDatosDAC (String sede, String juego) {

		System.out.println("juego "+juego+" en: "+sede);
		int totalBaloto = 0;
		int totalSuperAstro = 0;
		int totalFutbol = 0;
		
		String reportePantalla = "\nTotal de apuestas por juegos en la sede: "+sede+"  \n\n";
		ObjectInputStream in;
	
		
		datosDAC[0][0]=sede;
		
		if(juego.equalsIgnoreCase("baloto")) {
			reportePantalla+="Total Baloto: "+(datosDAC[0][1]=Integer.toBinaryString(totalBaloto))+"\n";
			
		}else if(juego.equalsIgnoreCase("superastro")) {
			reportePantalla+="Total Super Astro: "+(datosDAC[0][2]=Integer.toBinaryString(totalSuperAstro))+"\n";
			
		}else if(juego.equalsIgnoreCase("futbol")) {
			reportePantalla+="Total Futbol: "+(datosDAC[0][3]=Integer.toBinaryString(totalFutbol))+"\n";
			
		}
			
		//reportePantalla+="Total: "+(datosDAC[0][4]=Integer.toBinaryString(totalBaloto+totalFutbol+totalSuperAstro))+"\n";
		
		
	
		
		contenido = reportePantalla;
		
		
		System.out.println(reportePantalla);
		
		return reportePantalla;
	}
	
public void crearArchivoExcelCAPCS () throws FileNotFoundException, IOException {
		
		String[] header = {"Nombre","Apellido", "Cedula", "Direccion", "Celular", "Aposto en la sede" ,"Total Baloto", "Total Super Astro", "Total Futbol"};
		String ruta = "data\\ReporteTotalApuestasClientesEnSede.xlsx";
		String hoja = "Hoja1";

		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFCell celda;
		XSSFCellStyle border = libro.createCellStyle();
		XSSFCellStyle borderHeader = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		XSSFFont font1 = libro.createFont();
		font.setFontHeight(9);
		font.setFontName("Arial");
		border.setBorderBottom(BorderStyle.MEDIUM);
		border.setBorderTop(BorderStyle.MEDIUM);
		border.setBorderRight(BorderStyle.MEDIUM);
		border.setBorderLeft(BorderStyle.MEDIUM);
		
		borderHeader.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		borderHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font1.setColor(IndexedColors.WHITE.getIndex());
		
		for (int i = 0; i < datosCAPCS.length + 1; i++) { // filas
			XSSFRow fila = hoja1.createRow(i); // crea las filas
			for (int j = 0; j < header.length; j++) { // columnas
				if (i == 0) {
					celda = fila.createCell(j); // se crea la celda para la cabecera
					celda.setCellStyle(borderHeader);
					borderHeader.setFont(font1);

					System.out.println(header[j]);
					celda.setCellValue(header[j]);
					hoja1.autoSizeColumn(j);
				} else {

					celda = fila.createCell(j);
					celda.setCellStyle(border);
					border.setFont(font);
					celda.setCellValue(datosCAPCS[i - 1][j]);
					hoja1.autoSizeColumn(j);
				}

				System.out.print("i:" + i + " j: " + j + " || ");
			}
			System.out.println();
		} // fin for

		File file;
		file = new File(ruta);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
		}
		
		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}
		
	}
	
	
	public void crearArchivoExcelDAC (String juego) throws FileNotFoundException, IOException {
		
		String[] header = {"SEDE",juego};
		String ruta = "data\\ReporteTotalporJuegoenSede.xlsx";
		String hoja = "Hoja1";
		
		int x = 0;
		int baloto=1;
		int superAstro=2;
		int futbol=3;
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFCell celda;
		XSSFCellStyle border = libro.createCellStyle();
		XSSFCellStyle borderHeader = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		XSSFFont font1 = libro.createFont();
		font.setFontHeight(9);
		font.setFontName("Arial");
		border.setBorderBottom(BorderStyle.MEDIUM);
		border.setBorderTop(BorderStyle.MEDIUM);
		border.setBorderRight(BorderStyle.MEDIUM);
		border.setBorderLeft(BorderStyle.MEDIUM);
		
		borderHeader.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		borderHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		font1.setColor(IndexedColors.WHITE.getIndex());
		
		for (int i = 0; i < datosDAC.length + 1; i++) { // filas
			XSSFRow fila = hoja1.createRow(i); // crea las filas
			for (int j = 0; j < header.length; j++) { // columnas
				if (i == 0) {
					celda = fila.createCell(j); // se crea la celda para la cabecera
					celda.setCellStyle(borderHeader);
					borderHeader.setFont(font1);

					System.out.println(header[j]);
					celda.setCellValue(header[j]);
					hoja1.autoSizeColumn(j);
				} else if(j==0) { 
				
					celda = fila.createCell(j);
					celda.setCellStyle(border);
					
					border.setFont(font);
					celda.setCellValue(datosDAC[i - 1][0]);
					hoja1.autoSizeColumn(j);
					
				}else	if(juego.equalsIgnoreCase("baloto") ){
				

					celda = fila.createCell(j);
					celda.setCellStyle(border);
					
					border.setFont(font);
					celda.setCellValue(datosDAC[i - 1][1]);
					hoja1.autoSizeColumn(j);
				} else if(juego.equalsIgnoreCase("superastro") ){
					celda = fila.createCell(j);
					celda.setCellStyle(border);
					
					border.setFont(font);
					celda.setCellValue(datosDAC[i - 1][2]);
					hoja1.autoSizeColumn(j);
					
				}else if(juego.equalsIgnoreCase("futbol")){
				
					celda = fila.createCell(j);
					celda.setCellStyle(border);
					
					border.setFont(font);
					celda.setCellValue(datosDAC[i - 1][3]);
					hoja1.autoSizeColumn(j);
					
				}
				
				

				System.out.print("i:" + i + " j: " + j + " || ");
			}
			System.out.println();
		} // fin for

		File file;
		file = new File(ruta);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");
		}
		
		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}
		
	}

	public void crearArchivoExcel(String sede) {

		String[][] palabras = { { "Mami", "Bebe", "Gata", "Cachorra" },
				{ "Yo quiero", "Yo puedo", "Yo vine a", "Me dejaste" },
				{ "Encenderte", "Meterte", "Perrearte", "Cogelte" }, { "Suave", "Lento", "Rapido", "Fuerte" },
				{ "Hasta que salga el sol", "Toda la noche", "Tu encima de mi", "Pegada de la pared" },
				{ "Diciendome que te de", "Sin Compromiso", "Brrrr", "Sin Miedo" } };

		String[] prueba = { "1", "2", "3", "4" };

		String ruta = "data\\Reporte.xlsx";
		String hoja = "Hoja1";

		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja1 = libro.createSheet(hoja);
		XSSFCell celda;
		XSSFCellStyle border = libro.createCellStyle();
		XSSFFont font = libro.createFont();
		font.setFontHeight(9);
		font.setFontName("Arial");

		border.setBorderBottom(BorderStyle.MEDIUM);
		border.setBorderTop(BorderStyle.MEDIUM);
		border.setBorderRight(BorderStyle.MEDIUM);
		border.setBorderLeft(BorderStyle.MEDIUM);

		for (int i = 0; i < palabras.length + 1; i++) { // filas
			XSSFRow fila = hoja1.createRow(i); // crea las filas
			for (int j = 0; j < prueba.length; j++) { // columnas
				if (i == 0) {
					celda = fila.createCell(j); // se crea la celda para la cabecera
					celda.setCellStyle(border);
					border.setFont(font);

					System.out.println(prueba[j]);
					celda.setCellValue(prueba[j]);
					hoja1.autoSizeColumn(j);
				} else {

					celda = fila.createCell(j);
					celda.setCellStyle(border);
					border.setFont(font);
					celda.setCellValue(palabras[i - 1][j]);
					hoja1.autoSizeColumn(j);
				}

				System.out.print("i:" + i + " j: " + j + " || ");
			}
			System.out.println();
		} // fin for

		File file;
		file = new File(ruta);
		try (FileOutputStream fileOuS = new FileOutputStream(file)) {
			if (file.exists()) {// si el archivo existe se elimina
				file.delete();
				System.out.println("Archivo eliminado");
			}
			libro.write(fileOuS);
			fileOuS.flush();
			fileOuS.close();
			System.out.println("Archivo Creado");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			File objetofile = new File(ruta);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}
	}// fin metodo crear

	// link
	// https://www.ecodeup.com/como-escribir-y-leer-archivos-microsoft-excel-en-java/
	
	public void crearArchivoPDF() throws DocumentException {
		System.out.println("PDF EN MUNDO");
		String rutaPDF = "data\\Reporte.pdf";
		
		File f = new File(rutaPDF);

		try {
			FileOutputStream archivoPDF = new FileOutputStream(f);
			Document doc = new Document();
			PdfWriter.getInstance(doc, archivoPDF);
			doc.open();
			doc.add(new Paragraph(contenido));
			doc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			File objetofile = new File(rutaPDF);
			Desktop.getDesktop().open(objetofile);

		} catch (IOException ex) {

			System.out.println(ex);
		}

	}

	public ArrayList<ApostadorDto_Modulo3> getApostadores() {
		return apostadores;
	}

	public void setApostadores(ArrayList<ApostadorDto_Modulo3> apostadores) {
		this.apostadores = apostadores;
	}

}
