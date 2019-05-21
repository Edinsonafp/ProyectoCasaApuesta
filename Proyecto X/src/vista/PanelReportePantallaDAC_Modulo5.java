package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PanelReportePantallaDAC_Modulo5 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labResultado;
	private JTextArea txtValores;
	private JTextField txtMonto;

	public PanelReportePantallaDAC_Modulo5() {
		setLayout(new GridLayout(1, 3));
		TitledBorder border = BorderFactory.createTitledBorder("lista de juegos por sede");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		labResultado = new JLabel("lista de juegos por sede");
		txtValores = new JTextArea("");
		txtValores.setForeground(Color.BLACK);
		txtValores.setBackground(Color.WHITE);
		txtValores.setEditable(false);
		txtValores.setLineWrap(true);
		txtValores.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(txtValores);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		add(scrollPane);

	}

	public JLabel getLabResultado() {
		return labResultado;
	}

	public void setLabResultado(JLabel labResultado) {
		this.labResultado = labResultado;
	}

	public JTextField getTxtMonto() {
		return txtMonto;
	}

	public void setTxtMonto(JTextField txtMonto) {
		this.txtMonto = txtMonto;
	}

	public JTextArea getTxtValores() {
		return txtValores;
	}

	public void setTxtValores(JTextArea txtValores) {
		this.txtValores = txtValores;
	}

	
}
