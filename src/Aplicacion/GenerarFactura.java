package Aplicacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerarFactura {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrarVentana();
            }
        });
    }

    private static void mostrarVentana() {
        JFrame frame = new JFrame("Generar Factura");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
        frame.add(panel);
        panel.setLayout(new BorderLayout());

        JLabel mensajeLabel = new JLabel("");
        mensajeLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(mensajeLabel, BorderLayout.CENTER);

        JButton generarFacturaButton = new JButton("Generar Factura");
        JButton aceptarButton = new JButton("Aceptar");

        JPanel botonesPanel = new JPanel();
        botonesPanel.add(generarFacturaButton);
        botonesPanel.add(aceptarButton);
        panel.add(botonesPanel, BorderLayout.SOUTH);

        // Agregar un listener al botón de generar factura
        generarFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría la lógica para generar la factura
                boolean facturaGeneradaExitosamente = true; // Cambia esto según la lógica de tu aplicación

                if (facturaGeneradaExitosamente) {
                    // Mostrar mensaje de éxito
                    mensajeLabel.setText("Factura generada exitosamente");
                } else {
                    // Mostrar mensaje de error
                    mensajeLabel.setText("Error: la factura no se pudo generar");
                }
            }
        });

        // Agregar un listener al botón de aceptar
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana actual
            }
        });

        frame.setVisible(true);
    }
}
