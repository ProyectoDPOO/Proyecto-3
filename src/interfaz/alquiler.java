package interfaz;

import javax.swing.*;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class alquiler extends JFrame {
    private JTextField[] txtCamposAlquiler;

    public alquiler(EmpresaAlquilerVehiculo empresa) {
        setTitle("Crear Alquiler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Alquiler");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearAlquilerPanel = new JPanel(new GridLayout(10, 2));
        panel.add(crearAlquilerPanel, BorderLayout.CENTER);

        // Define los campos de alquiler
        String[] parametrosAlquiler = {
                "Cliente:", "Vehículo:", "Fecha de Recogida:", "Rango de Horas de Recogida:",
                "Sede de Recogida:", "Fecha de Entrega:", "Rango de Horas de Entrega:",
                "Sede de Entrega:", "Seguros:", "Conductores:"
        };
        txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

        // Agregar los campos y etiquetas de alquiler
        for (int i = 0; i < parametrosAlquiler.length; i++) {
            agregarParametro(crearAlquilerPanel, parametrosAlquiler[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposAlquiler[i] = txtCampo;
            crearAlquilerPanel.add(txtCampo);
        }

        // Botones de Crear Alquiler y Regresar
        JButton crearAlquilerButton = new JButton("Crear Alquiler");
        JButton regresarButton = new JButton("Salir");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearAlquilerButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear alquiler
        crearAlquilerButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	String cliente = txtCamposAlquiler[0].getText(); 
            	String vehiculo = txtCamposAlquiler[1].getText();  
                String fechaRecogida = txtCamposAlquiler[2].getText();  
                String rangohrecogida =txtCamposAlquiler[3].getText();  
                String sederecogida = txtCamposAlquiler[4].getText(); 
                String fechaEntrega= txtCamposAlquiler[5].getText(); 
                String Rangoentrega= txtCamposAlquiler[6].getText(); 
                String sedeEntrega= txtCamposAlquiler[7].getText(); 
                String seguros= txtCamposAlquiler[8].getText(); 
                String conductores= txtCamposAlquiler[9].getText(); 
                
                empresa.generarAlquiler(vehiculo, cliente, fechaRecogida,rangohrecogida, sederecogida,
                		fechaEntrega,Rangoentrega, sedeEntrega,seguros,conductores);
                JOptionPane.showMessageDialog(null, "Alquiler creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregar un listener al botón de regresar
        regresarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        setVisible(true);
    }
    
    public alquiler() {
    	EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
        setTitle("Crear Alquiler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Alquiler");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearAlquilerPanel = new JPanel(new GridLayout(10, 2));
        panel.add(crearAlquilerPanel, BorderLayout.CENTER);

        // Define los campos de alquiler
        String[] parametrosAlquiler = {
                "Cliente:", "Vehículo:", "Fecha de Recogida:", "Rango de Horas de Recogida:",
                "Sede de Recogida:", "Fecha de Entrega:", "Rango de Horas de Entrega:",
                "Sede de Entrega:", "Seguros:", "Conductores:"
        };
        txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

        // Agregar los campos y etiquetas de alquiler
        for (int i = 0; i < parametrosAlquiler.length; i++) {
            agregarParametro(crearAlquilerPanel, parametrosAlquiler[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposAlquiler[i] = txtCampo;
            crearAlquilerPanel.add(txtCampo);
        }

        // Botones de Crear Alquiler y Regresar
        JButton crearAlquilerButton = new JButton("Crear Alquiler");
        JButton regresarButton = new JButton("Salir");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearAlquilerButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear alquiler
        crearAlquilerButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	String cliente = txtCamposAlquiler[0].getText(); 
            	String vehiculo = txtCamposAlquiler[1].getText();  
                String fechaRecogida = txtCamposAlquiler[2].getText();  
                String rangohrecogida =txtCamposAlquiler[3].getText();  
                String sederecogida = txtCamposAlquiler[4].getText(); 
                String fechaEntrega= txtCamposAlquiler[5].getText(); 
                String Rangoentrega= txtCamposAlquiler[6].getText(); 
                String sedeEntrega= txtCamposAlquiler[7].getText(); 
                String seguros= txtCamposAlquiler[8].getText(); 
                String conductores= txtCamposAlquiler[9].getText(); 
                
                empresa.generarAlquiler(vehiculo, cliente, fechaRecogida,rangohrecogida, sederecogida,
                		fechaEntrega,Rangoentrega, sedeEntrega,seguros,conductores);
                JOptionPane.showMessageDialog(null, "Alquiler creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregar un listener al botón de regresar
        regresarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        setVisible(true);
    }

    private void agregarParametro(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
    }

    public static void main(String[] args) {
        EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
        new alquiler(empresa);
    }
}