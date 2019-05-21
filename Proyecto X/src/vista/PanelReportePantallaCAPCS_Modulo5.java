package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelReportePantallaCAPCS_Modulo5 extends JPanel {

	private JTextArea txtReporte;
	private static final long serialVersionUID = 1L;

	public PanelReportePantallaCAPCS_Modulo5() {
		
		setLayout(new GridLayout(1, 1, 100, 100));
		TitledBorder border = BorderFactory.createTitledBorder("Resultados");
		setBorder(border);
		border.setTitleColor(Color.BLACK);

		txtReporte = new JTextArea("");
		txtReporte.setForeground(Color.BLACK);
		txtReporte.setBackground(Color.WHITE);
		txtReporte.setEditable(false);
		txtReporte.setLineWrap(true);
		txtReporte.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(txtReporte);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		add(scrollPane);

	}

	public JTextArea getTxtReporte() {
		return txtReporte;
	}

	public void setTxtReporte(JTextArea txtReporte) {
		this.txtReporte = txtReporte;
	}

}
