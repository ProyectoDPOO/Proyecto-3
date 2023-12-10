package Aplicacion;

import javax.swing.*;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CrearCategoria extends JFrame {
    private JTextField[] txtCamposCategoria;
    private JComboBox<String> temporadaAltaCombo;
    private EmpresaAlquilerVehiculo empresa;
    public CrearCategoria() throws FileNotFoundException, IOException {
    	this.empresa = new EmpresaAlquilerVehiculo();
        setTitle("Crear Categoría de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Categoría de Vehículo");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearCategoriaPanel = new JPanel(new GridLayout(7, 2));
        panel.add(crearCategoriaPanel, BorderLayout.CENTER);

        String[] parametrosCategoria = {
                "Nombre de Categoría:", "Tarifa Temporada Alta:", "Tarifa Temporada Baja:",
                "Tarifa Conductor Adicional:", "Tarifa Entregar Otra Sede:",
                "Temporada Alta:", " "
        };
        txtCamposCategoria = new JTextField[parametrosCategoria.length];

        for (int i = 0; i < parametrosCategoria.length; i++) {
            if (i < 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                JTextField txtCampo = new JTextField(20);
                txtCamposCategoria[i] = txtCampo;
                crearCategoriaPanel.add(txtCampo);
            } else if (i == 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                temporadaAltaCombo = new JComboBox<>(new String[]{"Sí", "No"});
                crearCategoriaPanel.add(temporadaAltaCombo);
            } else {
                // Espacio en blanco para separar
                crearCategoriaPanel.add(new JLabel(" "));
                crearCategoriaPanel.add(new JLabel(" "));
            }
        }

        JButton crearCategoriaButton = new JButton("Crear Categoría");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearCategoriaButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear categoría
        crearCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCategoria = txtCamposCategoria[0].getText();
                int tarifaTemporadaAlta = Integer.parseInt(txtCamposCategoria[1].getText());
                int tarifaTemporadaBaja = Integer.parseInt(txtCamposCategoria[2].getText());
                int tarifaConductorAdicional = Integer.parseInt(txtCamposCategoria[3].getText());
                int tarifaEntregarOtraSede = Integer.parseInt(txtCamposCategoria[4].getText());
                boolean temporadaAlta = temporadaAltaCombo.getSelectedItem().equals("Sí");

                empresa.registrarCategoria(nombreCategoria,tarifaTemporadaAlta, tarifaTemporadaBaja, tarifaConductorAdicional, tarifaEntregarOtraSede,temporadaAlta);

                JOptionPane.showMessageDialog(null, "Categoría de vehículo creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
    public CrearCategoria(EmpresaAlquilerVehiculo empresa)  {
    	this.empresa = empresa;
        setTitle("Crear Categoría de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        Color backgroundColor = new Color(176, 196, 222);

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Categoría de Vehículo");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearCategoriaPanel = new JPanel(new GridLayout(7, 2));
        panel.add(crearCategoriaPanel, BorderLayout.CENTER);

        String[] parametrosCategoria = {
                "Nombre de Categoría:", "Tarifa Temporada Alta:", "Tarifa Temporada Baja:",
                "Tarifa Conductor Adicional:", "Tarifa Entregar Otra Sede:",
                "Temporada Alta:", " "
        };
        txtCamposCategoria = new JTextField[parametrosCategoria.length];

        for (int i = 0; i < parametrosCategoria.length; i++) {
            if (i < 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                JTextField txtCampo = new JTextField(20);
                txtCamposCategoria[i] = txtCampo;
                crearCategoriaPanel.add(txtCampo);
            } else if (i == 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                temporadaAltaCombo = new JComboBox<>(new String[]{"Sí", "No"});
                crearCategoriaPanel.add(temporadaAltaCombo);
            } else {
                // Espacio en blanco para separar
                crearCategoriaPanel.add(new JLabel(" "));
                crearCategoriaPanel.add(new JLabel(" "));
            }
        }

        JButton crearCategoriaButton = new JButton("Crear Categoría");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearCategoriaButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear categoría
        crearCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCategoria = txtCamposCategoria[0].getText();
                int tarifaTemporadaAlta = Integer.parseInt(txtCamposCategoria[1].getText());
                int tarifaTemporadaBaja = Integer.parseInt(txtCamposCategoria[2].getText());
                int tarifaConductorAdicional = Integer.parseInt(txtCamposCategoria[3].getText());
                int tarifaEntregarOtraSede = Integer.parseInt(txtCamposCategoria[4].getText());
                boolean temporadaAlta = temporadaAltaCombo.getSelectedItem().equals("Sí");

                empresa.registrarCategoria(nombreCategoria,tarifaTemporadaAlta, tarifaTemporadaBaja, tarifaConductorAdicional, tarifaEntregarOtraSede,temporadaAlta);

                JOptionPane.showMessageDialog(null, "Categoría de vehículo creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
        new CrearCategoria(empresa);
    }
}
