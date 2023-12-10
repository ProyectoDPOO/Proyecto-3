package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaAlquiler {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Consultar Alquiler");
        frame.setSize(500, 450);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
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

        JTextField txtIdAlquiler = new JTextField(20);
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
        JTextField[] txtCamposAlquiler = new JTextField[parametrosAlquiler.length];

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
                // Aquí deberías agregar la lógica para consultar un alquiler por su ID.
                // Supongamos que obtienes los datos del alquiler en el siguiente formato:
                String[] datosAlquiler = {
                    "Cliente Consultado", "Vehículo Consultado", "Fecha de Recogida Consultada",
                    "Rango de Horas de Recogida Consultado", "Sede de Recogida Consultada",
                    "Fecha de Entrega Consultada", "Rango de Horas de Entrega Consultado",
                    "Sede de Entrega Consultada", "Seguros Consultados", "Conductores Consultados"
                };

                // Rellenar los campos de visualización con los datos del alquiler consultado
                for (int i = 0; i < datosAlquiler.length; i++) {
                    txtCamposAlquiler[i].setText(datosAlquiler[i]);
                }
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

