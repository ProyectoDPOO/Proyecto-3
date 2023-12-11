package Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestionarSedes extends JFrame {
	
	private JTextField textFieldNombreSede;
    private JTextField textFieldUbicacion;
    private JTextField textFieldHorarioAtencion;
    private JTextField textFieldNombreAdminLocal;
	
    public GestionarSedes() {
        // Configuración de la ventana
        setTitle("Gestionar Sedes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear un panel para organizar los elementos
        JPanel panelGestionSede = new JPanel();
        panelGestionSede.setLayout(new GridLayout(0, 2, 10, 10));

        // Agregar etiquetas y campos de texto
        String[] etiquetas = {
            "Nombre de la Sede:",
            "Ubicación:",
            "Horario de Atención:",
            "Nombre Administrador Local:"
    };

    // Inicializar los campos de texto y agregarlos al panel
    for (int i = 0; i < etiquetas.length; i++) {
        JLabel label = new JLabel(etiquetas[i]);
        JTextField textField = new JTextField(20);
        panelGestionSede.add(label);
        panelGestionSede.add(textField);

        // Asignar los campos de texto a las variables de instancia
        switch (i) {
            case 0:
                textFieldNombreSede = textField;
                break;
            case 1:
                textFieldUbicacion = textField;
                break;
            case 2:
                textFieldHorarioAtencion = textField;
                break;
            case 3:
                textFieldNombreAdminLocal = textField;
                break;
        }
    }

        // Agregar el botón "Buscar" que abre una nueva ventana
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar la búsqueda (puedes personalizar esta parte)
                // Por ejemplo, puedes abrir una nueva ventana para mostrar los resultados.
                JFrame ventanaResultados = new JFrame("Resultados de Búsqueda");
                ventanaResultados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventanaResultados.setSize(300, 200);

                // Crear un panel para mostrar los resultados (puedes ajustar según necesites)
                JPanel panelResultados = new JPanel();
                JLabel resultadoLabel = new JLabel("Resultados de Búsqueda");
                panelResultados.add(resultadoLabel);
                ventanaResultados.add(panelResultados);

                guardarInformacionSede();  // Agregar esta línea para guardar información al buscar

                ventanaResultados.setVisible(true);
            }
        });

        // Agregar el botón "Buscar" al panel
        panelGestionSede.add(buscarButton);

        // Agregar el botón "Regresar al Menú Inicial"
        JButton regresarButton = new JButton("Regresar al Menú Inicial");
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

        // Agregar el botón "Regresar al Menú Inicial" al panel
        panelGestionSede.add(regresarButton);

        // Agregar el panel a la ventana
        add(panelGestionSede);

        // Hacer visible la ventana
        setVisible(true);
    }
    
    private void guardarInformacionSede() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("busquedas_sedes.txt", true))) {
            // Puedes ajustar esta parte según los datos que desees guardar
            String nombreSede = "Nombre de la Sede: " + textFieldNombreSede.getText();
            String ubicacion = "Ubicación: " + textFieldUbicacion.getText();
            String horarioAtencion = "Horario de Atención: " + textFieldHorarioAtencion.getText();
            String nombreAdminLocal = "Nombre Administrador Local: " + textFieldNombreAdminLocal.getText();

            // Escribir la información en el archivo
            writer.write(nombreSede + "\n");
            writer.write(ubicacion + "\n");
            writer.write(horarioAtencion + "\n");
            writer.write(nombreAdminLocal + "\n");
            writer.write("----------------------------------------\n");  // Separador entre registros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarSedes();
            }
        });
    }
}
