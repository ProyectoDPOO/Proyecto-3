package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class modificarCategoria {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Consultar y Modificar Categoría de Vehículo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Consultar y Modificar Categoría de Vehículo");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel consultarModificarCategoriaPanel = new JPanel(new GridLayout(8, 2));
        panel.add(consultarModificarCategoriaPanel, BorderLayout.CENTER);

        String[] parametrosCategoria = {
            "Nombre de Categoría:", "Tarifa Temporada Alta:", "Tarifa Temporada Baja:",
            "Tarifa Conductor Adicional:", "Entregar en Otra Sede:",
            "Temporada Alta:", " ", " "
        };
        JTextField[] txtCamposCategoria = new JTextField[parametrosCategoria.length];

        for (int i = 0; i < parametrosCategoria.length; i++) {
            agregarParametro(consultarModificarCategoriaPanel, parametrosCategoria[i]);
            JTextField txtCampo = new JTextField(20);
            txtCamposCategoria[i] = txtCampo;
            consultarModificarCategoriaPanel.add(txtCampo);
        }

        JButton consultarCategoriaButton = new JButton("Consultar Categoría");
        JButton modificarCategoriaButton = new JButton("Modificar Categoría");
        JButton eliminarCategoriaButton = new JButton("Eliminar Categoría");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(consultarCategoriaButton);
        botonesPanel.add(modificarCategoriaButton);
        botonesPanel.add(eliminarCategoriaButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de consultar categoría
        consultarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para consultar la categoría por el nombre de categoría.
                // Luego, llenar los campos de texto con los datos de la categoría consultada.
                // Si la categoría no se encuentra, mostrar un mensaje de error.
            }
        });

        // Agregar un listener al botón de modificar categoría
        modificarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para modificar la categoría con los datos ingresados en los campos.
                // Puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
            }
        });

        // Agregar un listener al botón de eliminar categoría
        eliminarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías agregar la lógica para eliminar la categoría.
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
