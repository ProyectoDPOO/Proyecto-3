package Aplicacion;


import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modelo.Usuario;
import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


@SuppressWarnings("serial")
public class InicioSesion extends JFrame {

	private EmpresaAlquilerVehiculo empresa;
	
	public InicioSesion(EmpresaAlquilerVehiculo empresa) 
	{
		this.empresa = empresa;
		setTitle("Iniciar sesión");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,150);
				
		setLayout (new BorderLayout());
		
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.setBackground(new Color(176, 196, 222));

        panel.add(new JLabel(" Nombre de Usuario:"));
        JTextField usuario = new JTextField();
        panel.add(usuario);
        
        panel.add(new JLabel(" Contraseña:"));
        JPasswordField contrasena = new JPasswordField();
        panel.add(contrasena);
        
        String[] roles = { "Administracion", "Administrador_sede", "Empleado", "Cliente" };
        JComboBox<String> rolComboBox = new JComboBox<>(roles);
        panel.add(new JLabel("Selecciona tu Rol:"));
        panel.add(rolComboBox);
        
        JPanel inferior = new JPanel();
        JButton iniciarSesion = new JButton("Iniciar Sesión");
        
        iniciarSesion.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	
            	String nombreUsuario = usuario.getText();
                char[] contrasenaChars = contrasena.getPassword();
                String contrasena = new String(contrasenaChars);
                String seleccionRol = rolComboBox.getSelectedItem().toString();
            
                if (empresa.verificarUsuario(nombreUsuario)) {
                    Usuario usuario = empresa.inicioSesion(nombreUsuario, contrasena);

                    if (usuario != null) {
                        String rol = "Cliente";
                        if (usuario.getRol() != null) {
                            rol = usuario.getRol().toString();
                        }

                        if (rol.equals(seleccionRol))
                        
                        {
                                         
		                    switch(rol)
							{
							case "Administracion":
								
								OpcionAdministrador adminVentana = new OpcionAdministrador();
							    adminVentana.setVisible(true);
							    dispose();
										
							break;
							
							case "Administrador_sede":
								
								OpcionAdministradorLocal adminSedeVentana = new OpcionAdministradorLocal();
							    adminSedeVentana.setVisible(true);
							    dispose();
								
							break;
							
							case "Empleado":
								
								OpcionEmpleado empleadoVentana = new OpcionEmpleado();
								empleadoVentana.setVisible(true);
							    dispose();
		
								
							break;
							
							case "Cliente":
								
								OpcionCliente clienteVentana = new OpcionCliente();
								clienteVentana.setVisible(true);
							    dispose();
								
							break;
							
							default: 
							
								System.out.println("No es valido");
								break;
							}
                        }
					}
				}

            }
        });
        
        JButton volver = new JButton("Volver al inicio");
        
        volver.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
         
              
            	login inicio = new login();
				inicio.setVisible(true);     
                dispose();
                
            }
        });
        
        
        inferior.add(iniciarSesion);
        inferior.add(volver);
        inferior.setBackground(new Color(70, 130, 180));
        add(inferior,BorderLayout.SOUTH);

        
        add(panel);
        setVisible(true);
	}
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
		new InicioSesion(empresa);
	
	}
	

}
