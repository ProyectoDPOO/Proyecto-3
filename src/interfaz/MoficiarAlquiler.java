package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MoficiarAlquiler {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Consultar y Modificar Alquiler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Consultar y Modificar Alquiler");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel consultarModificarAlquilerPanel = new JPanel(new GridLayout(10, 2));
        panel.add(consultarModificarAlquilerPanel, BorderLayout.CENTER);

        String[] parametrosAlquiler = {
            "ID de Alquiler:", "Cliente:", "Vehículo:", "Fecha de Recogida:",
            "Rango de Horas de Recogida:", "Sede de Recogida:",
            "Fecha de Entrega:", "Rango de Horas de Entrega:",
            "Sede de Entrega:", "Seguros y Conductores Adicionales"
        };
        JTextField[] txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

        for (int i = 0; i < parametrosAlquiler.length; i++) {
            agregarParametro(consultarModificarAlquilerPanel, parametrosAlquiler[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposAlquiler[i] = txtCampo;
            consultarModificarAlquilerPanel.add(txtCampo);
        }

        JButton consultarAlquilerButton = new JButton("Consultar Alquiler");
        JButton modificarAlquilerButton = new JButton("Modificar Alquiler");
        JButton eliminarAlquilerButton = new JButton("Eliminar Alquiler");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(consultarAlquilerButton);
        botonesPanel.add(modificarAlquilerButton);
        botonesPanel.add(eliminarAlquilerButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de consultar alquiler
        consultarAlquilerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para consultar el alquiler por el ID de alquiler.
                // Luego, llenar los campos de texto con los datos del alquiler consultado.
                // Si el alquiler no se encuentra, mostrar un mensaje de error.
            }
        });

        // Agregar un listener al botón de modificar alquiler
        modificarAlquilerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para modificar el alquiler con los datos ingresados en los campos.
                // Puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
            }
        });

        // Agregar un listener al botón de eliminar alquiler
        eliminarAlquilerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para eliminar el alquiler.
                // Puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
            }
        });

        // Agregar un listener al botón de regresar
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana actual
            }
        });

        frame.setVisible(true);
    }

    private static void agregarParametro(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
    }
}