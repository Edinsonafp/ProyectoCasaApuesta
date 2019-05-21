package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelReportePantallaCPS_Modulo5 extends JPanel {

	public JTextArea txtClientes;
	private static final long serialVersionUID = 1L;

	public PanelReportePantallaCPS_Modulo5() {

		setLayout(new GridLayout(1, 1, 100, 100));
		TitledBorder border = BorderFactory.createTitledBorder("Lista de Sede");
		setBorder(border);
		border.setTitleColor(Color.BLACK);

		txtClientes = new JTextArea("");
		txtClientes.setEditable(false);
		txtClientes.setForeground(Color.BLACK);
		txtClientes.setBackground(Color.WHITE);
		txtClientes.setLineWrap(true);
		txtClientes.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(txtClientes);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		add(scrollPane);

	}

	public JTextArea getTxtClientes() {
		return txtClientes;
	}

	public void setTxtClientes(JTextArea txtClientes) {
		this.txtClientes = txtClientes;
	}

}
