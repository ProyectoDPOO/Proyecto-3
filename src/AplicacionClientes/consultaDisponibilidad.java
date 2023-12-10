package AplicacionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultaDisponibilidad extends JFrame {

    public consultaDisponibilidad() {
        setTitle("Consulta de Reserva");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        JLabel lblSede = new JLabel("Sede:");
        JTextField txtSede = new JTextField();

        JLabel lblFechaInicio = new JLabel("Fecha de Inicio (dd/mm/yyyy):");
        JTextField txtFechaInicio = new JTextField();

        JLabel lblFechaFin = new JLabel("Fecha de Fin (dd/mm/yyyy):");
        JTextField txtFechaFin = new JTextField();

        JButton btnConsultar = new JButton("Consultar Disponibilidad");

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para consultar disponibilidad
                String sede = txtSede.getText();
                String fechaInicio = txtFechaInicio.getText();
                String fechaFin = txtFechaFin.getText();

                // Puedes agregar aquí la lógica para obtener la lista de carros disponibles.
                // Por ejemplo, puedes llamar a un método de la capa de lógica de negocios.

                // Mostrar los resultados o realizar alguna acción adicional
                mostrarCarrosDisponibles(); // Método para mostrar la ventana con la lista de carros
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

        // Panel para los dos últimos botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(btnConsultar);
        buttonsPanel.add(regresarButton);

        add(lblSede);
        add(txtSede);
        add(lblFechaInicio);
        add(txtFechaInicio);
        add(lblFechaFin);
        add(txtFechaFin);
        add(new JLabel()); // Espacio en blanco
        add(buttonsPanel); // Agregar el panel con los botones

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private void mostrarCarrosDisponibles() {
        // Lógica para obtener la lista de carros disponibles
        // (puedes reemplazar esto con la lógica específica de tu aplicación)
        String[] carrosDisponibles = {"Carro 1", "Carro 2", "Carro 3", "Carro 4"};

        // Crear la ventana para mostrar la lista de carros
        JFrame carrosFrame = new JFrame("Carros Disponibles");
        carrosFrame.setSize(300, 200);
        carrosFrame.setLayout(new BorderLayout());

        // Crear la lista de carros
        JList<String> carrosList = new JList<>(carrosDisponibles);

        // Agregar la lista al centro de la ventana
        carrosFrame.add(new JScrollPane(carrosList), BorderLayout.CENTER);

        // Mostrar la ventana de carros disponibles
        carrosFrame.setLocationRelativeTo(this); // Se posiciona en relación a la ventana actual
        carrosFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new consultaDisponibilidad();
            }
        });
    }
}

