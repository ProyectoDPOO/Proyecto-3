package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CrearCategoria {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Crear Categoría de Vehículo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Crear Categoría de Vehículo");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel crearCategoriaPanel = new JPanel(new GridLayout(7, 2));
        panel.add(crearCategoriaPanel, BorderLayout.CENTER);

        String[] parametrosCategoria = {
            "Nombre de Categoría:", "Tarifa Temporada Alta:", "Tarifa Temporada Baja:",
            "Tarifa Conductor Adicional:", "Entregar en Otra Sede:",
            "Temporada Alta:", " "
        };
        JTextField[] txtCamposCategoria = new JTextField[parametrosCategoria.length];

        for (int i = 0; i < parametrosCategoria.length; i++) {
            if (i < 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                JTextField txtCampo = new JTextField(20);
                txtCamposCategoria[i] = txtCampo;
                crearCategoriaPanel.add(txtCampo);
            } else if (i == 5) {
                agregarParametro(crearCategoriaPanel, parametrosCategoria[i]);
                JComboBox<String> temporadaAltaCombo = new JComboBox<>(new String[]{"Sí", "No"});
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
                // Aquí deberías agregar la lógica para crear la categoría de vehículo con los datos ingresados.
                // Puedes obtener los valores de los campos txtCamposCategoria y el valor seleccionado en el JComboBox.
                // Luego, puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
                JOptionPane.showMessageDialog(null, "Categoría de vehículo creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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