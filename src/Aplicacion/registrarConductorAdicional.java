package Aplicacion;

import javax.swing.*;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class registrarConductorAdicional extends JFrame {
    private JTextField[] txtCamposConductor;
    private EmpresaAlquilerVehiculo empresa;
    public registrarConductorAdicional() throws FileNotFoundException, IOException {
    	this.empresa = new EmpresaAlquilerVehiculo();
        setTitle("Crear Conductor Adicional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Conductor Adicional");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearConductorPanel = new JPanel(new GridLayout(8, 2));
        panel.add(crearConductorPanel, BorderLayout.CENTER);

        String[] parametrosConductor = {
                "Nombre:", "Identificación:", "Teléfono:", "Correo:", "Número de Licencia:",
                "País de Expedición:", "Fecha de Licencia:", "Imagen de Licencia:"
        };
        txtCamposConductor = new JTextField[parametrosConductor.length];

        for (int i = 0; i < parametrosConductor.length; i++) {
            agregarParametro(crearConductorPanel, parametrosConductor[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposConductor[i] = txtCampo;
            crearConductorPanel.add(txtCampo);
        }

        JButton crearConductorButton = new JButton("Crear Conductor");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearConductorButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear conductor
        crearConductorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtCamposConductor[0].getText();
                String identificacion = txtCamposConductor[1].getText();
                String telefono = txtCamposConductor[2].getText();
                String correo = txtCamposConductor[3].getText();
                String numeroLicencia = txtCamposConductor[4].getText();
                String paisExpedicion = txtCamposConductor[5].getText();
                String fechaLicencia = txtCamposConductor[6].getText();
                String imgLicencia = txtCamposConductor[7].getText();

                empresa.registrarConductorAdicional(nombre,identificacion,telefono, correo, numeroLicencia,paisExpedicion,fechaLicencia,imgLicencia);

                JOptionPane.showMessageDialog(null, "Conductor adicional creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cerrar la ventana actual
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
    public registrarConductorAdicional(EmpresaAlquilerVehiculo empresa) {
    	this.empresa = empresa;
        setTitle("Crear Conductor Adicional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Conductor Adicional");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearConductorPanel = new JPanel(new GridLayout(8, 2));
        panel.add(crearConductorPanel, BorderLayout.CENTER);

        String[] parametrosConductor = {
                "Nombre:", "Identificación:", "Teléfono:", "Correo:", "Número de Licencia:",
                "País de Expedición:", "Fecha de Licencia:", "Imagen de Licencia:"
        };
        txtCamposConductor = new JTextField[parametrosConductor.length];

        for (int i = 0; i < parametrosConductor.length; i++) {
            agregarParametro(crearConductorPanel, parametrosConductor[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposConductor[i] = txtCampo;
            crearConductorPanel.add(txtCampo);
        }

        JButton crearConductorButton = new JButton("Crear Conductor");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearConductorButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear conductor
        crearConductorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtCamposConductor[0].getText();
                String identificacion = txtCamposConductor[1].getText();
                String telefono = txtCamposConductor[2].getText();
                String correo = txtCamposConductor[3].getText();
                String numeroLicencia = txtCamposConductor[4].getText();
                String paisExpedicion = txtCamposConductor[5].getText();
                String fechaLicencia = txtCamposConductor[6].getText();
                String imgLicencia = txtCamposConductor[7].getText();

                empresa.registrarConductorAdicional(nombre,identificacion,telefono, correo, numeroLicencia,paisExpedicion,fechaLicencia,imgLicencia);

                JOptionPane.showMessageDialog(null, "Conductor adicional creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cerrar la ventana actual
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

    private void agregarParametro(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
        new registrarConductorAdicional(empresa);
    }
}
