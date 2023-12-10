package Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Procesamiento.EmpresaAlquilerVehiculo;

public class menuInicial extends JFrame {

    private EmpresaAlquilerVehiculo empresa;

    public menuInicial() {
        // Configuración de la ventana principal
        setTitle("Aplicación Principal");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout para organizar los botones con espacio vertical
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadir espacio alrededor del panel

        placeComponents(panel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        // Botón "Crear Seguro"
        JButton crearSeguroButton = createButton("Crear Seguro");
        panel.add(crearSeguroButton);

        // Agregar espacio vertical
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón "Gestionar Sedes"
        JButton gestionarSedesButton = createButton("Gestionar Sedes");
        panel.add(gestionarSedesButton);

        // Agregar espacio vertical
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón "Gestionar Vehículo"
        JButton gestionarVehiculoButton = createButton("Gestionar Vehículo");
        panel.add(gestionarVehiculoButton);

        // Agregar espacio vertical
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón "Registrar Administrador Local"
        JButton registrarAdminLocalButton = createButton("Registrar Administrador Local");
        panel.add(registrarAdminLocalButton);

        // Agregar espacio vertical
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón "Registrar Cliente"
        JButton registrarClienteButton = createButton("Registrar Cliente");
        panel.add(registrarClienteButton);

        // Agregar espacio vertical
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón "Salir del Sistema"
        JButton salirSistemaButton = createButton("Salir del Sistema");
        panel.add(salirSistemaButton);

        salirSistemaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la aplicación cuando se presiona el botón "Salir del Sistema"
                System.exit(0);
            }
        });

        registrarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrarCliente(null).setVisible(true);
            }
        });

        registrarAdminLocalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrarAdminLocal().setVisible(true);
            }
        });

        crearSeguroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CrearSeguro().setVisible(true);
            }
        });

        gestionarSedesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionarSedes().setVisible(true);
            }
        });

        gestionarVehiculoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GestionarVehiculo().setVisible(true);
            }
        });
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(400, 40)); // Tamaño máximo
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new menuInicial();
            }
        });
    }
}


