package Aplicacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConsultarSeguro {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Consultar Seguro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Consultar Seguro");
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(tituloLabel, BorderLayout.NORTH);

        JPanel consultarSeguroPanel = new JPanel(new GridLayout(2, 2));
        panel.add(consultarSeguroPanel, BorderLayout.CENTER);

        JLabel tipoSeguroLabel = new JLabel("Tipo de Seguro:");
        JTextField txtTipoSeguro = new JTextField(20);

        JLabel resultadoLabel = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(20);
        txtPrecio.setEditable(false); // Hacer que el campo de precio sea de solo lectura

        consultarSeguroPanel.add(tipoSeguroLabel);
        consultarSeguroPanel.add(txtTipoSeguro);
        consultarSeguroPanel.add(resultadoLabel);
        consultarSeguroPanel.add(txtPrecio);

        JButton consultarSeguroButton = new JButton("Consultar Seguro");
        JButton regresarButton = new JButton("Regresar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(consultarSeguroButton);
        botonesPanel.add(regresarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de consultar seguro
        consultarSeguroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String precioSeguro = "100.00"; // Precio del seguro consultado

                // 
                txtPrecio.setText(precioSeguro);
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
}