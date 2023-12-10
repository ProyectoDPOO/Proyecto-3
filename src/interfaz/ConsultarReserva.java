package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarReserva {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Consultar Reserva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        // Parte de consulta
        JPanel consultaPanel = new JPanel(new BorderLayout());
        panel.add(consultaPanel, BorderLayout.NORTH);

        JLabel consultaLabel = new JLabel("Consultar Reserva");
        consultaLabel.setHorizontalAlignment(JLabel.CENTER);
        consultaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        consultaPanel.add(consultaLabel, BorderLayout.NORTH);

        JPanel idReservaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        consultaPanel.add(idReservaPanel, BorderLayout.CENTER);

        JLabel idReservaLabel = new JLabel("ID Reserva a consultar:");
        idReservaPanel.add(idReservaLabel);

        JTextField txtIdReserva = new JTextField(20);
        idReservaPanel.add(txtIdReserva);

        JButton consultarReservaButton = new JButton("Consultar Reserva");
        consultaPanel.add(consultarReservaButton, BorderLayout.SOUTH);

        // Parte de visualización de reserva
        JPanel visualizacionPanel = new JPanel(new GridLayout(8, 2));
        panel.add(visualizacionPanel, BorderLayout.CENTER);

        // Define los campos de reserva
        String[] parametrosReserva = {
            "Cliente:", "Categoría del vehículo:", "Sede de Recogida:",
            "Sede de Entrega:", "Fecha de Recogida:", "Fecha de Entrega:",
            "Rango de Horas de Recogida:", "Rango de Horas de Entrega:"
        };
        JTextField[] txtCamposReserva = new JTextField[parametrosReserva.length];

        // Agregar los campos y etiquetas de reserva
        for (int i = 0; i < parametrosReserva.length; i++) {
            agregarParametro(visualizacionPanel, parametrosReserva[i]);
            JTextField txtCampo = new JTextField(20);
            txtCampo.setEditable(false); // Hacer que los campos sean de solo lectura
            txtCamposReserva[i] = txtCampo;
            visualizacionPanel.add(txtCampo);
        }

        // Botón de regresar
        JButton regresarButton = new JButton("Regresar");
        panel.add(regresarButton, BorderLayout.SOUTH);

        // Agregar un listener al botón de consultar reserva
        consultarReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para consultar una reserva por su ID.
                // Supongamos que obtienes los datos de la reserva en el siguiente formato:
                String[] datosReserva = {
                    "Cliente Consultado", "Categoría de Vehículo Consultada", "Sede de Recogida Consultada",
                    "Sede de Entrega Consultada", "Fecha de Recogida Consultada", "Fecha de Entrega Consultada",
                    "Rango de Horas de Recogida Consultado", "Rango de Horas de Entrega Consultado"
                };

                // Rellenar los campos de visualización con los datos de la reserva consultada
                for (int i = 0; i < datosReserva.length; i++) {
                    txtCamposReserva[i].setText(datosReserva[i]);
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
