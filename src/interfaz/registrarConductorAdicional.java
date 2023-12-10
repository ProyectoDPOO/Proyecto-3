package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class registrarConductorAdicional {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Crear Conductor Adicional");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Conductor Adicional");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearConductorPanel = new JPanel(new GridLayout(8, 2));
        panel.add(crearConductorPanel, BorderLayout.CENTER);

        String[] parametrosConductor = {
            "Nombre:", "Identificación:", "Teléfono:", "Correo:", "Número de Licencia:",
            "País de Expedición:", "Fecha de Licencia:", "Imagen de Licencia:"
        };
        JTextField[] txtCamposConductor = new JTextField[parametrosConductor.length];

        for (int i = 0; i < parametrosConductor.length; i++) {
            agregarParametro(crearConductorPanel, parametrosConductor[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposConductor[i] = txtCampo;
            crearConductorPanel.add(txtCampo);
        }

        JButton crearConductorButton = new JButton("Crear Conductor");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(crearConductorButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de crear conductor
        crearConductorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para crear el conductor adicional con los datos ingresados.
                // Puedes obtener los valores de los campos txtCamposConductor para crear el conductor.
                // Luego, puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
                JOptionPane.showMessageDialog(null, "Conductor adicional creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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