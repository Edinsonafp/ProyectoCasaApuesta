package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controlador.Controlador;


public class DialogoUsuarioAEditar_Modulo3 extends JDialog {

    public static final String ACEPTAR = "Aceptar";
    public static final String CANCELAR = "Cancelar";

    private JLabel etiquetaNumeroDeDocumento;
    private JTextField textoNumeroDeDocumento;

	private JButton botonAceptar;
    private JButton botonCancelar;    
    
    
    public DialogoUsuarioAEditar_Modulo3(Controlador controlador) {
    	    
    	setTitle("Modificar cliente");
		TitledBorder border = BorderFactory.createTitledBorder("Ingrese ID usuario a editar");
		border.setTitleColor(Color.BLACK);
		
		getRootPane().setBorder(border);
       
        setResizable( false );
        setLayout( new BorderLayout( ) );

        etiquetaNumeroDeDocumento = new JLabel("Numero Documento");
        etiquetaNumeroDeDocumento.setPreferredSize( new Dimension(120, 100));
        
        textoNumeroDeDocumento = new JTextField();
        textoNumeroDeDocumento.setPreferredSize( new Dimension(200, 100));

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener(controlador);

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener(controlador);
        
        JPanel informacion = new JPanel( );
        informacion.setLayout(new GridLayout(2, 2));
		informacion.setPreferredSize(new Dimension(300, 50));

        informacion.add( etiquetaNumeroDeDocumento );
        informacion.add( textoNumeroDeDocumento );
        informacion.add( botonAceptar );
        informacion.add( botonCancelar );
        
        add( informacion, BorderLayout.CENTER );
        pack( );
        setLocationRelativeTo( null );
    }
    
    // Get - Set
    public JTextField getTextoNumeroDeDocumento() {
		return textoNumeroDeDocumento;
	}

	public void setTextoNumeroDeDocumento(JTextField textoNumeroDeDocumento) {
		this.textoNumeroDeDocumento = textoNumeroDeDocumento;
	}
	
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( ACEPTAR ) )  {
        	
            String numeroDeDocumento = textoNumeroDeDocumento.getText( );
            int numeroDeDocumentoComoInt = 0;
            
            if( numeroDeDocumento != null && !numeroDeDocumento.equals( "" ) ) {
            	try {
            		numeroDeDocumentoComoInt = Integer.parseInt( textoNumeroDeDocumento.getText( ) );
                } 
            	catch( NumberFormatException e1 ) {
                    JOptionPane.showMessageDialog( this, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            	
                try {
                	//apostadorDao = new ApostadorDao();
                	//System.out.println(apostadorDao.encontrarApostador(numeroDeDocumentoComoInt));
                	
                	//mundo.buscarUsuario(numeroDeDocumentoComoInt);
                		
                	
                	//if (apostadorDao.encontrarApostador(numeroDeDocumentoComoInt) == null) {
                   //     JOptionPane.showMessageDialog( this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE );
                    //} 
                	//else {
                		//DialogoUsuarioAEditar_Modulo3 dialogo = new DialogoUsuarioAEditar_Modulo3(null);
                		//dialogo.setVisible(true);
                        dispose();
                   // }
            		
                } catch( Exception eFeria) {
                    JOptionPane.showMessageDialog( this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE );
                }
                
                
            } 
            else {
                JOptionPane.showMessageDialog( this, "Debe ingresar el número de documento del usuario a editar", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) ) {
            dispose( );
        }
    }
    
    
}

