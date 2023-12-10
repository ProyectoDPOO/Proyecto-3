package AplicacionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reservaVehiculo extends JFrame {

    public reservaVehiculo() {
        setTitle("Reservar Vehículo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2, 10, 10)); // Cambiado a 2 columnas con espaciado

        JLabel lblSede = new JLabel("Sede:");
        JTextField txtSede = new JTextField();

        JLabel lblFechaInicio = new JLabel("Fecha de Inicio (dd/mm/yyyy):");
        JTextField txtFechaInicio = new JTextField();

        JLabel lblFechaFin = new JLabel("Fecha de Fin (dd/mm/yyyy):");
        JTextField txtFechaFin = new JTextField();

        JButton btnReservar = new JButton("Reservar Vehículo");

        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para reservar vehículo
                String sede = txtSede.getText();
                String fechaInicio = txtFechaInicio.getText();
                String fechaFin = txtFechaFin.getText();

                // Puedes agregar aquí la lógica para reservar un vehículo.
                // Por ejemplo, puedes llamar a un método de la capa de lógica de negocios.

                // Mostrar mensaje de éxito y abrir la ventana de pago
                JOptionPane.showMessageDialog(null, "Se informa que por usar la nueva aplicación, se aplicará un 10% de descuento. A su vez, es posible que en el momento de la entrega el cliente tenga que pagar un excedente.");
                new pagoReserva();
                
                // Cerrar la ventana de reserva después de realizar la reserva
                dispose();
            }
        });

        // Crear el botón "Regresar al Menú Inicial"
        JButton regresarButton = new JButton("Regresar al Menú Inicial");

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para regresar al menú inicial
                // Puedes cerrar esta ventana y abrir la ventana del menú inicial aquí.
                dispose(); // Cierra la ventana actual
                // Lógica para abrir la ventana del menú inicial
                new interfazUsuario();
            }
        });

        add(lblSede);
        add(txtSede);
        add(lblFechaInicio);
        add(txtFechaInicio);
        add(lblFechaFin);
        add(txtFechaFin);
        add(btnReservar);
        add(regresarButton); // Agregar el botón de regresar

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }
}
