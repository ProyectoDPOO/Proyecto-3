package Aplicacion;

import javax.swing.*;

import Modelo.Facturar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestionarVehiculo extends JFrame {
    public GestionarVehiculo() {
        // Configuración de la ventana
        setTitle("Gestión Vehículo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        // Panel principal para los botones
        JPanel panelNuevaVentana = new JPanel();
        panelNuevaVentana.setLayout(new BoxLayout(panelNuevaVentana, BoxLayout.Y_AXIS));

        // Botones principales
        JButton agregarVehiculo = new JButton("Agregar Vehículo");
        JButton trasladoVehiculo = new JButton("Traslado Vehículo");
        JButton eliminarVehiculo = new JButton("Eliminar Vehículo");

        // Ajustar el tamaño de los botones principales
        Dimension buttonSize = new Dimension(250, 50);
        agregarVehiculo.setPreferredSize(buttonSize);
        trasladoVehiculo.setPreferredSize(buttonSize);
        eliminarVehiculo.setPreferredSize(buttonSize);

        // Espaciado entre los botones principales
        int spacing = 10;

        // Panel para centrar los botones
        JPanel panelCentro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, spacing, 0); // Espaciado debajo de cada botón

        panelCentro.add(agregarVehiculo, gbc);
        gbc.gridy++;
        panelCentro.add(trasladoVehiculo, gbc);
        gbc.gridy++;
        panelCentro.add(eliminarVehiculo, gbc);

        // Añadir panelCentro al panel principal
        panelNuevaVentana.add(Box.createVerticalGlue());
        panelNuevaVentana.add(panelCentro);
        panelNuevaVentana.add(Box.createVerticalGlue());

        // Botón para regresar al Menú Inicial
        JButton regresarMenuButton = new JButton("Regresar al Menú Inicial");
        regresarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadir botón de regreso al panel
        panelNuevaVentana.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        panelNuevaVentana.add(regresarMenuButton);

        // Acción para regresar al Menú Inicial
        regresarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                new menuInicial(); // Abre la ventana del Menú Inicial
            }
        });

        // Acción para "Agregar Vehículo"
        agregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar la opción "Agregar Vehículo"
                JFrame nuevaVentana = new JFrame("Agregar Vehículo");
                nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentana.setSize(400, 400);

                JPanel panelGestionVehiculo = new JPanel();
                panelGestionVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                String[] etiquetas = {
                        "Placa:",
                        "Marca:",
                        "Modelo:",
                        "Color:",
                        "Transmisión:",
                        "Capacidad:",
                        "Categoría:",
                        "Estado:",
                        "Sede Actual:",
                        "Fecha Disponible:",
                        "Tipo Vehiculo:",
                        "Prima Seguro:",
                };

                JTextField[] camposTexto = new JTextField[etiquetas.length];

                for (int i = 0; i < etiquetas.length; i++) {
                    JLabel label = new JLabel(etiquetas[i]);
                    camposTexto[i] = new JTextField(20);
                    panelGestionVehiculo.add(label);
                    panelGestionVehiculo.add(camposTexto[i]);
                }

                JButton confirmarAgregarButton = new JButton("Agregar Vehículo");
                confirmarAgregarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para agregar el vehículo
                        // Puedes implementar aquí la lógica necesaria
                        // por ejemplo, almacenar los datos ingresados.

                        guardarInformacionVehiculo(camposTexto, "vehiculos.txt");  // Agregar esta línea

                        JOptionPane.showMessageDialog(null, "Vehículo agregado exitosamente");
                        nuevaVentana.dispose(); // Cierra la ventana actual
                    }
                });

                // Botón para regresar a la pantalla principal de "Gestionar Vehículo"
                JButton regresarButton = new JButton("Regresar");
                regresarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nuevaVentana.dispose(); // Cierra la ventana actual
                    }
                });

                // Añadir botones al panel
                panelGestionVehiculo.add(confirmarAgregarButton);
                panelGestionVehiculo.add(regresarButton);

                nuevaVentana.add(panelGestionVehiculo);
                nuevaVentana.setVisible(true);
            }
        });

        // Acción para "Traslado Vehículo"
        trasladoVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar la opción "Traslado Vehículo"
                JFrame nuevaVentana = new JFrame("Traslado Vehículo");
                nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentana.setSize(400, 200);

                JPanel panelTrasladoVehiculo = new JPanel();
                panelTrasladoVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                String[] etiquetasTraslado = {
                        "Sede Actual:",
                        "Nueva Sede:"
                };

                JTextField[] camposTextoTraslado = new JTextField[etiquetasTraslado.length];

                for (int i = 0; i < etiquetasTraslado.length; i++) {
                    JLabel label = new JLabel(etiquetasTraslado[i]);
                    camposTextoTraslado[i] = new JTextField(20);
                    panelTrasladoVehiculo.add(label);
                    panelTrasladoVehiculo.add(camposTextoTraslado[i]);
                }

             // Botón para confirmar la acción de "Traslado Vehículo"
                JButton confirmarTrasladoButton = new JButton("Trasladar Vehículo");
                confirmarTrasladoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para trasladar el vehículo
                        // Puedes implementar aquí la lógica necesaria
                        // por ejemplo, actualizar la sede del vehículo.

                        guardarInformacionVehiculo(camposTextoTraslado, "traslados.txt");  // Agregar esta línea

                        JOptionPane.showMessageDialog(null, "Vehículo trasladado exitosamente");
                        nuevaVentana.dispose(); // Cierra la ventana actual
                    }
                });

                // Botón para regresar a la pantalla principal de "Gestionar Vehículo"
                JButton regresarButton = new JButton("Regresar");
                regresarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nuevaVentana.dispose(); // Cierra la ventana actual
                    }
                });

                // Añadir botones al panel
                panelTrasladoVehiculo.add(confirmarTrasladoButton);
                panelTrasladoVehiculo.add(regresarButton);

                nuevaVentana.add(panelTrasladoVehiculo);
                nuevaVentana.setVisible(true);
            }
        });

     // Acción para "Eliminar Vehículo"
        eliminarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar la opción "Eliminar Vehículo"
                JFrame nuevaVentanaEliminar = new JFrame("Eliminar Vehículo");
                nuevaVentanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentanaEliminar.setSize(400, 200);

                JPanel panelEliminarVehiculo = new JPanel();
                panelEliminarVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                String[] etiquetasEliminar = {
                        "Placa:",
                        "Marca:",
                        "Modelo:"
                };

                JTextField[] camposTextoEliminar = new JTextField[etiquetasEliminar.length];

                for (int i = 0; i < etiquetasEliminar.length; i++) { // CORRECCIÓN AQUÍ
                    JLabel label = new JLabel(etiquetasEliminar[i]);
                    camposTextoEliminar[i] = new JTextField(20);
                    panelEliminarVehiculo.add(label);
                    panelEliminarVehiculo.add(camposTextoEliminar[i]);
                }

             // Botón para confirmar la acción de "Eliminar Vehículo"
                JButton confirmarEliminarButton = new JButton("Eliminar Vehículo");
                confirmarEliminarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para eliminar el vehículo
                        // Puedes implementar aquí la lógica necesaria
                        // por ejemplo, eliminar el registro del vehículo.

                        guardarInformacionVehiculo(camposTextoEliminar, "eliminados.txt");  // Agregar esta línea

                        JOptionPane.showMessageDialog(null, "Vehículo eliminado exitosamente");
                        nuevaVentanaEliminar.dispose(); // Cierra la ventana actual
                    }
                });

                // Botón para regresar a la pantalla principal de "Gestionar Vehículo"
                JButton regresarButton = new JButton("Regresar");
                regresarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nuevaVentanaEliminar.dispose(); // Cierra la ventana actual
                    }
                });

                // Añadir botones al panel
                panelEliminarVehiculo.add(confirmarEliminarButton);
                panelEliminarVehiculo.add(regresarButton);

                nuevaVentanaEliminar.add(panelEliminarVehiculo);
                nuevaVentanaEliminar.setVisible(true);
            }
        });
        

        // Añadir el panel principal a la ventana
        add(panelNuevaVentana);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void guardarInformacionVehiculo(JTextField[] camposTexto, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 0; i < camposTexto.length; i++) {
                String etiqueta = camposTexto[i].getName();
                String valor = camposTexto[i].getText();
                writer.write(etiqueta + ": " + valor + "\n");
            }
            writer.write("----------------------------------------\n");  // Separador entre registros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarVehiculo();
                
            }
        });
    }
}
