package Aplicacion;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JPanel;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



@SuppressWarnings("serial")
public class OpcionCliente extends JFrame {
	
	public OpcionCliente() 
	{
		setTitle("Opciones del cliente");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,250);
		setLayout (new BorderLayout());
	
		
        JPanel centro = new JPanel(new GridLayout(3, 1));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton reserva = new JButton("Generar reserva");
        
        reserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					reserva ventana = new reserva ();
					ventana.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
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
        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
       
		centro.add(reserva);
        centro.add(infoCliente);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);

        setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new OpcionCliente();
	
	}
}
