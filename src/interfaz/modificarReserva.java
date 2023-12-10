package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class modificarReserva {
	
		public static void main(String[] args) {
	        JFrame frame = new JFrame("Consultar y Modificar Reserva");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 350);

	        Color backgroundColor = new Color(176, 196, 222); // Color de fondo

	        JPanel panel = new JPanel();
	        panel.setBackground(backgroundColor); // Establecer el color de fondo del panel
	        frame.add(panel);
	        panel.setLayout(new BorderLayout());

	        JLabel tituloLabel = new JLabel("Consultar y Modificar Reserva");
	        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
	        tituloLabel.setFont(new Font("Arial", Font.BOLD, 14));
	        panel.add(tituloLabel, BorderLayout.NORTH);

	        JPanel consultarModificarReservaPanel = new JPanel(new GridLayout(9, 2));
	        panel.add(consultarModificarReservaPanel, BorderLayout.CENTER);

	        String[] parametrosReserva = {
	            "ID de Reserva:", "Cliente:", "Categoría del Vehículo:", "Sede de Recogida:",
	            "Sede de Entrega:", "Fecha de Recogida:", "Fecha de Entrega:",
	            "Rango de Horas de Recogida:", "Rango de Horas de Entrega:"
	        };
	        JTextField[] txtCamposReserva = new JTextField[parametrosReserva.length];

	        for (int i = 0; i < parametrosReserva.length; i++) {
	            agregarParametro(consultarModificarReservaPanel, parametrosReserva[i]);
	            JTextField txtCampo = new JTextField(20);
	            txtCamposReserva[i] = txtCampo;
	            consultarModificarReservaPanel.add(txtCampo);
	        }

	        JButton consultarReservaButton = new JButton("Consultar Reserva");
	        JButton modificarReservaButton = new JButton("Modificar Reserva");
	        JButton eliminarReservaButton = new JButton("Eliminar Reserva");
	        JButton regresarButton = new JButton("Regresar");

	        JPanel botonesPanel = new JPanel();
	        botonesPanel.add(consultarReservaButton);
	        botonesPanel.add(modificarReservaButton);
	        botonesPanel.add(eliminarReservaButton);
	        botonesPanel.add(regresarButton);
	        panel.add(botonesPanel, BorderLayout.SOUTH);

	        // Agregar un listener al botón de consultar reserva
	        consultarReservaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Aquí deberías agregar la lógica para consultar la reserva por el ID de reserva.
	                // Luego, llenar los campos de texto con los datos de la reserva consultada.
	                // Si la reserva no se encuentra, mostrar un mensaje de error.
	            }
	        });

	        // Agregar un listener al botón de modificar reserva
	        modificarReservaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Aquí deberías agregar la lógica para modificar la reserva con los datos ingresados en los campos.
	                // Puedes mostrar un mensaje de confirmación o realizar las acciones necesarias.
	            }
	        });

	        // Agregar un listener al botón de eliminar reserva
	        eliminarReservaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Aquí deberías agregar la lógica para eliminar la reserva.
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