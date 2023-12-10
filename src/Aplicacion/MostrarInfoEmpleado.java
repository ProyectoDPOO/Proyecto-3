package Aplicacion;

import javax.swing.*;

import Modelo.Empleado;
import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


@SuppressWarnings("serial")
public class MostrarInfoEmpleado extends JDialog {
	

	 private JTextField nombreEmpleadoField;
	 private JTextField nombreUsuarioField;
	 private JTextField rolField;
	 private JTextField sedeField;
	 private EmpresaAlquilerVehiculo empresa;
    public MostrarInfoEmpleado(EmpresaAlquilerVehiculo empresa) {
    	
    	this.empresa =empresa;
        setTitle("Información del Empleado");
        setSize(600, 200); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(176, 196, 222));
        
        nombreEmpleadoField = new JTextField();
        agregarCampo(panel, "Nombre del Empleado: ", nombreEmpleadoField);
        
        JButton buscar = new JButton("Buscar");
        panel.add(buscar);

        nombreUsuarioField = new JTextField();
        rolField = new JTextField();
        sedeField = new JTextField();
        
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreEmpleado = nombreEmpleadoField.getText();
                Empleado empleado = empresa.mostrarEmpleado(nombreEmpleado);

                if (empleado != null) {
                	
                    nombreUsuarioField.setText("Nombre de Usuario: " + empleado.getNombreUsuario());
                    rolField.setText("Rol: " + empleado.getRol());
                    sedeField.setText("Sede: " + empleado.getSede());
                } else {
                	
                    JOptionPane.showMessageDialog(null, "El empleado no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        nombreUsuarioField.setEditable(false);
        rolField.setEditable(false);
        sedeField.setEditable(false);

        agregarCampo(panel, "Nombre de Usuario: ", nombreUsuarioField);
        agregarCampo(panel, "Rol: ", rolField);
        agregarCampo(panel, "Sede: ", sedeField);
        
        JButton salirSistema = new JButton("Salir del sistema");

        salirSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel inferior = new JPanel();
        inferior.add(salirSistema);
        add(inferior, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
        
    }

    private void agregarCampo(JPanel panel, String etiqueta, JComponent componente) {
        JPanel campoPanel = new JPanel();
        campoPanel.setLayout(new BoxLayout(campoPanel, BoxLayout.X_AXIS));
        campoPanel.add(new JLabel(etiqueta));
        campoPanel.add(componente);
        panel.add(campoPanel);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException
	{
		EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
		new MostrarInfoEmpleado(empresa);}


}