package Aplicacion;

import javax.swing.*;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ConsultaAlquiler extends JFrame {
    private JTextField txtIdAlquiler;
    private JTextField[] txtCamposAlquiler;
    private EmpresaAlquilerVehiculo empresa;
    public ConsultaAlquiler() throws FileNotFoundException, IOException {
    	this.empresa = new EmpresaAlquilerVehiculo();
        setTitle("Consultar Alquiler");
        setSize(500, 450);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        add(panel);
        panel.setLayout(new BorderLayout());

        // Parte de consulta
        JPanel consultaPanel = new JPanel(new BorderLayout());
        panel.add(consultaPanel, BorderLayout.NORTH);

        JLabel consultaLabel = new JLabel("Consultar Alquiler");
        consultaLabel.setHorizontalAlignment(JLabel.CENTER);
        consultaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        consultaPanel.add(consultaLabel, BorderLayout.NORTH);

        JPanel idAlquilerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        consultaPanel.add(idAlquilerPanel, BorderLayout.CENTER);

        JLabel idAlquilerLabel = new JLabel("ID Alquiler a consultar:");
        idAlquilerPanel.add(idAlquilerLabel);

        txtIdAlquiler = new JTextField(20);
        idAlquilerPanel.add(txtIdAlquiler);

        JButton consultarAlquilerButton = new JButton("Consultar Alquiler");
        consultaPanel.add(consultarAlquilerButton, BorderLayout.SOUTH);

        // Parte de visualización de alquiler
        JPanel visualizacionPanel = new JPanel(new GridLayout(10, 2));
        panel.add(visualizacionPanel, BorderLayout.CENTER);

        // Define los campos de alquiler
        String[] parametrosAlquiler = {
                "Cliente:", "Vehículo:", "Fecha de Recogida:", "Rango de Horas de Recogida:",
                "Sede de Recogida:", "Fecha de Entrega:", "Rango de Horas de Entrega:",
                "Sede de Entrega:", "Seguros:", "Conductores:"
        };
        txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

        // Agregar los campos y etiquetas de alquiler
        for (int i = 0; i < parametrosAlquiler.length; i++) {
            agregarParametro(visualizacionPanel, parametrosAlquiler[i]);
            JTextField txtCampo = new JTextField(20);
            txtCampo.setEditable(false);
            txtCamposAlquiler[i] = txtCampo;
            visualizacionPanel.add(txtCampo);
        }

        // Botón de regresar
        JButton regresarButton = new JButton("Regresar");
        panel.add(regresarButton, BorderLayout.SOUTH);

        // Agregar un listener al botón de consultar alquiler
        consultarAlquilerButton.addActionListener(new ActionListener() {
            @Override
            	public void actionPerformed(ActionEvent e) {
                
                ArrayList datosAlquiler = empresa.consultaAlquiler(Integer.parseInt(txtIdAlquiler.getText()));

                
                for (int i = 0; i < datosAlquiler.size(); i++) {
                    txtCamposAlquiler[i].setText((String) datosAlquiler.get(i));
                }
                dispose(); 
            
            }
        });

        // Agregar un listener al botón de regresar
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana actual
            }
        });

        setVisible(true);
    }
    public ConsultaAlquiler(EmpresaAlquilerVehiculo empresa) {
    	this.empresa =empresa;
        setTitle("Consultar Alquiler");
        setSize(500, 450);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        add(panel);
        panel.setLayout(new BorderLayout());

        // Parte de consulta
        JPanel consultaPanel = new JPanel(new BorderLayout());
        panel.add(consultaPanel, BorderLayout.NORTH);

        JLabel consultaLabel = new JLabel("Consultar Alquiler");
        consultaLabel.setHorizontalAlignment(JLabel.CENTER);
        consultaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        consultaPanel.add(consultaLabel, BorderLayout.NORTH);

        JPanel idAlquilerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        consultaPanel.add(idAlquilerPanel, BorderLayout.CENTER);

        JLabel idAlquilerLabel = new JLabel("ID Alquiler a consultar:");
        idAlquilerPanel.add(idAlquilerLabel);

        txtIdAlquiler = new JTextField(20);
        idAlquilerPanel.add(txtIdAlquiler);

        JButton consultarAlquilerButton = new JButton("Consultar Alquiler");
        consultaPanel.add(consultarAlquilerButton, BorderLayout.SOUTH);

        // Parte de visualización de alquiler
        JPanel visualizacionPanel = new JPanel(new GridLayout(10, 2));
        panel.add(visualizacionPanel, BorderLayout.CENTER);

        // Define los campos de alquiler
        String[] parametrosAlquiler = {
                "Cliente:", "Vehículo:", "Fecha de Recogida:", "Rango de Horas de Recogida:",
                "Sede de Recogida:", "Fecha de Entrega:", "Rango de Horas de Entrega:",
                "Sede de Entrega:", "Seguros:", "Conductores:"
        };
        txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

        // Agregar los campos y etiquetas de alquiler
        for (int i = 0; i < parametrosAlquiler.length; i++) {
            agregarParametro(visualizacionPanel, parametrosAlquiler[i]);
            JTextField txtCampo = new JTextField(20);
            txtCampo.setEditable(false);
            txtCamposAlquiler[i] = txtCampo;
            visualizacionPanel.add(txtCampo);
        }

        // Botón de regresar
        JButton regresarButton = new JButton("Regresar");
        panel.add(regresarButton, BorderLayout.SOUTH);


        consultarAlquilerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ArrayList datosAlquiler = empresa.consultaAlquiler(Integer.parseInt(txtIdAlquiler.getText()));

                
                for (int i = 0; i < datosAlquiler.size(); i++) {
                    txtCamposAlquiler[i].setText((String) datosAlquiler.get(i));
                }
                dispose(); 
            }
        });


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

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
        new ConsultaAlquiler();
    }
}


