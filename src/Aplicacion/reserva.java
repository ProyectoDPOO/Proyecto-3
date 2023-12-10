package Aplicacion;

import javax.swing.*;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class reserva extends JFrame {
    private JTextField[] txtCamposReserva;
    private EmpresaAlquilerVehiculo empresa;
    
    public reserva( ) throws FileNotFoundException, IOException {
    	this.empresa=new EmpresaAlquilerVehiculo();;
        setTitle("Crear Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Reserva");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearReservaPanel = new JPanel(new GridLayout(9, 2));
        panel.add(crearReservaPanel, BorderLayout.CENTER);

        String[] parametrosReserva = {
            "Cliente:", "Categoría del vehículo:", "Sede de Recogida:",
            "Sede de Entrega:", "Fecha de Recogida:", "Fecha de Entrega:",
            "Rango de Horas de Recogida:", "Rango de Horas de Entrega:"
        };
        txtCamposReserva = new JTextField[parametrosReserva.length];

        for (int i = 0; i < parametrosReserva.length; i++) {
            agregarParametro(crearReservaPanel, parametrosReserva[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposReserva[i] = txtCampo;
            crearReservaPanel.add(txtCampo);
        }

        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearReservaButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        crearReservaButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String cliente = txtCamposReserva[0].getText();
                String categoriaVehiculo = txtCamposReserva[1].getText();
                String sedeRecogida = txtCamposReserva[2].getText();
                String sedeEntrega = txtCamposReserva[3].getText();
                String fechaRecogida = txtCamposReserva[4].getText();
                String fechaEntrega = txtCamposReserva[5].getText();
                String rangoHorasRecogida = txtCamposReserva[6].getText();
                String rangoHorasEntrega = txtCamposReserva[7].getText();

                empresa.generarReserva(cliente, categoriaVehiculo, sedeRecogida, sedeEntrega,fechaRecogida,
                		fechaEntrega, rangoHorasRecogida, rangoHorasEntrega);

                JOptionPane.showMessageDialog(null, "Reserva creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        regresarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public reserva(EmpresaAlquilerVehiculo empresa) {
    	this.empresa=empresa;
        setTitle("Crear Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Reserva");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearReservaPanel = new JPanel(new GridLayout(9, 2));
        panel.add(crearReservaPanel, BorderLayout.CENTER);

        String[] parametrosReserva = {
            "Cliente:", "Categoría del vehículo:", "Sede de Recogida:",
            "Sede de Entrega:", "Fecha de Recogida:", "Fecha de Entrega:",
            "Rango de Horas de Recogida:", "Rango de Horas de Entrega:"
        };
        txtCamposReserva = new JTextField[parametrosReserva.length];

        for (int i = 0; i < parametrosReserva.length; i++) {
            agregarParametro(crearReservaPanel, parametrosReserva[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposReserva[i] = txtCampo;
            crearReservaPanel.add(txtCampo);
        }

        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearReservaButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        crearReservaButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String cliente = txtCamposReserva[0].getText();
                String categoriaVehiculo = txtCamposReserva[1].getText();
                String sedeRecogida = txtCamposReserva[2].getText();
                String sedeEntrega = txtCamposReserva[3].getText();
                String fechaRecogida = txtCamposReserva[4].getText();
                String fechaEntrega = txtCamposReserva[5].getText();
                String rangoHorasRecogida = txtCamposReserva[6].getText();
                String rangoHorasEntrega = txtCamposReserva[7].getText();

                empresa.generarReserva(cliente, categoriaVehiculo, sedeRecogida, sedeEntrega,fechaRecogida,
                		fechaEntrega, rangoHorasRecogida, rangoHorasEntrega);

                JOptionPane.showMessageDialog(null, "Reserva creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        regresarButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void agregarParametro(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
    	new reserva (empresa);
    }
}
