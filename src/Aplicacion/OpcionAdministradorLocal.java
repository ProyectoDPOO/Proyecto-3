package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class OpcionAdministradorLocal extends JFrame {
	
	public OpcionAdministradorLocal() 
	{
		setTitle("Opciones de Administrador local");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,250);
		setLayout (new BorderLayout());
		

		
        JPanel centro = new JPanel(new GridLayout(3, 2));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton registroEmpleado = new JButton("Registrar empleado");
        registroEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrarAdminLocal().setVisible(true);
            }
        });
        
        JButton infoEmpleado = new JButton("Mostrar informacion empleado");
        
        infoEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MostrarInfoEmpleado infoEmpleadoVentana = new MostrarInfoEmpleado(null);
            	infoEmpleadoVentana.setVisible(true);
			    dispose();
            }
        });
        
        JButton registroCliente = new JButton("Registrar cliente");
        registroCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrarCliente(null).setVisible(true);
            }
        });
        
        JButton infoCliente = new JButton("Mostrar informacion cliente");
        infoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MostrarInfoCliente infoClienteVentana = new MostrarInfoCliente(null);
            	infoClienteVentana.setVisible(true);
			    dispose();
            }
        });
        
        JButton seguro = new JButton("Creacion de Seguro");
            seguro.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    dispose();               
                    new CrearSeguro().setVisible(true);
                }
            });
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        
		centro.add(registroEmpleado);
        centro.add(infoEmpleado);
        centro.add(registroCliente);
        centro.add(infoCliente);
        centro.add(seguro);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);

        setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new OpcionAdministradorLocal();
	
	}
}
