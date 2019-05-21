package vista;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import modelo.SedeDTO_Modulo2;

public class DialogoListaSedes_Modulo2 extends JDialog {
	
	
	
	//------------------------------------------------------------------------------------------------------------------------
	// Atributos
	//------------------------------------------------------------------------------------------------------------------------
	
	
	  /**
	 * Serial de defecto.
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Scroll que contiene la lista de sedes.
     */
    private JScrollPane scroll;

    /**
     * La lista de sedes.
     */
    private JList<String> sedes;
    
	//------------------------------------------------------------------------------------------------------------------------
	// Constructor
	//------------------------------------------------------------------------------------------------------------------------
	
	
    
    public DialogoListaSedes_Modulo2(ArrayList<SedeDTO_Modulo2> pSedes) {
    	
    	setSize (250,170);
		setResizable(false);
		setTitle("Lista de sedes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
    	
    	
    	sedes = new JList<String>();
    	
    	
    	DefaultListModel<String> listModel = new DefaultListModel<String>();
    	
    	for(int i=0; i<pSedes.size(); i++) {
    		
    	    listModel.add(i, (i+1)+"."+pSedes.get(i).getNombre());
    	}
    	
    	sedes.setModel(listModel);
    	
        scroll = new JScrollPane( );
        scroll.setViewportView( sedes );
        scroll.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        
        
        sedes.addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent pEvento) { 
             if (pEvento.getClickCount() == 2) { 
            	 int index = sedes.locationToIndex(pEvento.getPoint());
            	 String mensaje="Nombre: "+pSedes.get(index).getNombre() + "\n" + "Localidad: "+pSedes.get(index).getLocalidad()+"\n"+"Numero de empleados: "+pSedes.get(index).getNumEmpleados();              
             JOptionPane.showMessageDialog(null, mensaje , "Datos de la sede", JOptionPane.INFORMATION_MESSAGE);
             } 
            } 
        }); 
        
        add(scroll, BorderLayout.CENTER);
    	
    }
    
	//------------------------------------------------------------------------------------------------------------------------
	// Métodos
	//------------------------------------------------------------------------------------------------------------------------
	
	
    

}
