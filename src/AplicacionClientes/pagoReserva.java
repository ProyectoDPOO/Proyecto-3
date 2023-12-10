package AplicacionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pagoReserva extends JFrame {

    public pagoReserva() {
        setTitle("Completar Pago");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2, 10, 10)); // Cambiado a 2 columnas con espaciado

        JLabel lblTipoPago = new JLabel("Tipo de Pago:");
        JTextField txtTipoPago = new JTextField();

        JLabel lblNumeroPago = new JLabel("Número de Pago:");
        JTextField txtNumeroPago = new JTextField();

        JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento (dd/mm/yyyy):");
        JTextField txtFechaVencimiento = new JTextField();

        JButton btnRealizarPago = new JButton("Realizar Pago");

        btnRealizarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para realizar el pago
                String tipoPago = txtTipoPago.getText();
                String numeroPago = txtNumeroPago.getText();
                String fechaVencimiento = txtFechaVencimiento.getText();

                // Puedes agregar aquí la lógica para procesar el pago.
                // Por ejemplo, puedes llamar a un método de la capa de lógica de negocios.

                // Mostrar mensaje de éxito y aplicar descuento si es el caso
                JOptionPane.showMessageDialog(null, "Pago realizado con éxito. Se aplicó un 10% de descuento.");

                // Cerrar la ventana después de realizar el pago
                dispose();
            }
        });

        add(lblTipoPago);
        add(txtTipoPago);
        add(lblNumeroPago);
        add(txtNumeroPago);
        add(lblFechaVencimiento);
        add(txtFechaVencimiento);
        add(btnRealizarPago);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }
}
