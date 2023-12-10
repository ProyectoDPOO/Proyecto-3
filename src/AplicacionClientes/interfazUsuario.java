package AplicacionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfazUsuario extends JFrame {

    public interfazUsuario() {
        setTitle("Aplicación de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        
        // Color de fondo para el panel principal
        getContentPane().setBackground(new Color(30,142,240,255));

        // Agregar imagen del logo
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel, BorderLayout.NORTH);
        
        // Color de fondo para el panel de bienvenida
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(30, 142, 240, 255));
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel welcomeLabel = new JLabel("¡Bienvenido a Rent!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 45));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        welcomePanel.add(welcomeLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton btnRegistro = new JButton("Crear Nuevo Usuario");
        personalizarBoton(btnRegistro, new Color(40,60,133,255), Color.WHITE); // Código RGB para azul

        
        JButton btnConsulta = new JButton("Consultar Disponibilidad");
        personalizarBoton(btnConsulta, new Color(40,60,133,255), Color.WHITE); // Código RGB para verde

        
        JButton btnReserva = new JButton("Reservar Vehículo");
        personalizarBoton(btnReserva, new Color(40,60,133,255), Color.WHITE); // Código RGB para verde


        // Acción para el botón de registro
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistro();
            }
        });

        // Acción para el botón de consulta
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaConsulta();
            }
        });

        // Acción para el botón de reserva
        btnReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaReserva();
            }
        });

     // Agregar los botones al panel
        buttonPanel.add(btnRegistro);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
        buttonPanel.add(btnConsulta);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio de 10 píxeles
        buttonPanel.add(btnReserva);

        // Agregar componentes al contenedor principal
        add(logoLabel, BorderLayout.NORTH);
        add(welcomePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void mostrarOpciones() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    private void abrirVentanaRegistro() {
        // Lógica para abrir la ventana de registro de usuario
        // Puedes crear una instancia de la clase RegistroUsuario y mostrarla
        // Ejemplo: new RegistroUsuario().mostrarVentana();
        new registroUsuario();
    }

    private void abrirVentanaConsulta() {
        // Lógica para abrir la ventana de consulta de disponibilidad
        // Puedes crear una instancia de la clase ConsultaDisponibilidad y mostrarla
        // Ejemplo: new ConsultaDisponibilidad().mostrarVentana();
        new consultaDisponibilidad();
    }

    private void abrirVentanaReserva() {
        // Lógica para abrir la ventana de reserva de vehículo
        // Puedes crear una instancia de la clase ReservaVehiculo y mostrarla
        // Ejemplo: new ReservaVehiculo().mostrarVentana();
        new reservaVehiculo();
    }
    
    private void personalizarBoton(JButton boton, Color colorFondo, Color colorTexto) {
        boton.setFont(new Font("Arial", Font.PLAIN, 20));  // Ajusta el tamaño de la fuente
        boton.setMaximumSize(new Dimension(450, 50));  // Ajusta la altura del botón
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
    }

    public static void main(String[] args) {
        // Código para iniciar la interfaz de usuario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                interfazUsuario ventana = new interfazUsuario();
                ventana.mostrarOpciones();
            }
        });
    }
}

