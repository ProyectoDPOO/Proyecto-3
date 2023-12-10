package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reserva {

    	public static void main(String[] args) {
            JFrame frame = new JFrame("Crear Reserva");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            Color backgroundColor = new Color(176, 196, 222); // Color de fondo

            JPanel panel = new JPanel();
            panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
            frame.add(panel);
            panel.setLayout(new BorderLayout());

            JLabel tituloLabel = new JLabel("Crear Reserva");
            tituloLabel.setHorizontalAlignment(JLabel.CENTER);
            tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(tituloLabel, BorderLayout.NORTH);

            JPanel crearReservaPanel = new JPanel(new GridLayout(9, 2));
            panel.add(crearReservaPanel, BorderLayout.CENTER);

            // Define los campos de reserva
            String[] parametrosReserva = {
                "Cliente:", "Categoría del vehículo:", "Sede de Recogida:",
                "Sede de Entrega:", "Fecha de Recogida:", "Fecha de Entrega:",
                "Rango de Horas de Recogida:", "Rango de Horas de Entrega:"
            };
            JTextField[] txtCamposReserva = new JTextField[parametrosReserva.length];

            // Agregar los campos y etiquetas de reserva
            for (int i = 0; i < parametrosReserva.length; i++) {
                agregarParametro(crearReservaPanel, parametrosReserva[i]);
                JTextField txtCampo = new JTextField(20);
                txtCamposReserva[i] = txtCampo;
                crearReservaPanel.add(txtCampo);
            }

            // Botones de Crear Reserva y Regresar
            JButton crearReservaButton = new JButton("Crear Reserva");
            JButton regresarButton = new JButton("Regresar");

            JPanel botonesPanel = new JPanel();
            botonesPanel.add(crearReservaButton);
            botonesPanel.add(regresarButton);
            panel.add(botonesPanel, BorderLayout.SOUTH);

            // Agregar un listener al botón de crear reserva
            crearReservaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí debes agregar la lógica para crear la reserva con los datos ingresados.
                    // Puedes obtener los valores de los campos txtCamposReserva para crear la reserva.
                    // Luego, puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
                    JOptionPane.showMessageDialog(null, "Reserva creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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



