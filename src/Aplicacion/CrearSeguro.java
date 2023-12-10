package Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearSeguro extends JFrame {
	
	private JTextField textFieldTipoSeguro;
    private JTextField textFieldCostoSeguro;
    
    public CrearSeguro() {
        // Configuración de la ventana
        setTitle("Creación de Seguro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Crear un panel para organizar los elementos
        JPanel panelCreacionSeguro = new JPanel();
        panelCreacionSeguro.setLayout(new GridBagLayout());

        // Configuración de restricciones para el diseño del panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar etiquetas y campos de texto
        String[] etiquetas = {
                "Tipo de Seguro:",
                "Costo del Seguro ($):"
        };

        for (String etiqueta : etiquetas) {
            JLabel label = new JLabel(etiqueta);
            JTextField textField = new JTextField(15); // Ajustar el ancho del campo de texto
            // Predeterminar el campo "Costo del Seguro" con un signo $
            if (etiqueta.equals("Costo del Seguro ($):")) {
                textField.setText("$");
            }
            // Agregar etiqueta y campo de texto al panel con restricciones
            panelCreacionSeguro.add(label, gbc);
            gbc.gridx++;
            panelCreacionSeguro.add(textField, gbc);
            gbc.gridx = 0; // Reiniciar la posición en X
            gbc.gridy++;   // Moverse a la siguiente fila
        }

        // Configurar restricciones para los botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = new Insets(20, 10, 10, 10); // Ajustar el espacio superior

        // Crear el botón "Crear Seguro"
        JButton crearSeguroButton = new JButton("Crear Seguro");

        // Agregar un ActionListener al botón "Crear Seguro"
        crearSeguroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para procesar la creación del seguro
                // Puedes agregar aquí la lógica para almacenar los datos ingresados, por ejemplo.
                guardarInformacionSeguro();
            }
        });

        // Agregar el botón "Crear Seguro" al panel con restricciones
        panelCreacionSeguro.add(crearSeguroButton, gbc);

        // Crear el botón "Regresar al Menú Inicial"
        JButton regresarButton = new JButton("Regresar al Menú Inicial");

        // Agregar un ActionListener al botón "Regresar al Menú Inicial"
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para regresar al menú inicial
                // Puedes cerrar esta ventana y abrir la ventana del menú inicial aquí.
                dispose(); // Cierra la ventana actual
                // Lógica para abrir la ventana del menú inicial
                new menuInicial();
            }
        });

        // Configurar restricciones para el botón "Regresar al Menú Inicial"
        gbc.gridx++;
        panelCreacionSeguro.add(regresarButton, gbc);

        // Agregar el panel a la ventana
        add(panelCreacionSeguro);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void guardarInformacionSeguro() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("seguros_creados.txt", true))) {
            // Puedes ajustar esta parte según los datos que desees guardar
            String tipoSeguro = "Tipo de Seguro: " + textFieldTipoSeguro.getText();
            String costoSeguro = "Costo del Seguro: " + textFieldCostoSeguro.getText();

            // Escribir la información en el archivo
            writer.write(tipoSeguro + "\n");
            writer.write(costoSeguro + "\n");
            writer.write("----------------------------------------\n");  // Separador entre registros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Crear una instancia de la clase CrearSeguro al ejecutar el programa
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CrearSeguro();
            }
        });
    }
}
