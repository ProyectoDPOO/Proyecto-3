package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



	@SuppressWarnings("serial")
	public class OpcionAdministrador extends JFrame {
	
	public OpcionAdministrador() 
	{
		setTitle("Opciones de Administracion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,250);
		setLayout (new BorderLayout());
		
		
        JPanel centro = new JPanel(new GridLayout(3, 2));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton sede = new JButton("Gestionar sedes");

        sede.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();               
                new GestionarSedes().setVisible(true);
            }
        });

		JButton vehiculo = new JButton("Gestionar vehiculo");
		vehiculo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();               
		        new GestionarVehiculo().setVisible(true);
		    }
		});

	JButton seguro = new JButton("Creacion seguro");
	seguro.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();               
            new CrearSeguro().setVisible(true);
        }
    });

        JButton categoria = new JButton("Registrar Categoria");
        
        categoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	RegistrarCategoria registroCategoria = new RegistrarCategoria(null);
            	registroCategoria.setVisible(true);
			    dispose();
            }
        });
        
        JButton actualizar = new JButton("Actualizar Categoria");
    
        actualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try {
					CrearCategoria ventana = new CrearCategoria ();
					ventana.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
   
		centro.add(sede);
        centro.add(vehiculo);
        centro.add(seguro);
        centro.add(categoria);
        centro.add(actualizar);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);

        setVisible(true);
	}
	
	public static void main(String[] args)
	{
		
		new OpcionAdministrador();
			
	}

}
