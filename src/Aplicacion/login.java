package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class login extends JFrame {

    public login() {
        setTitle("Bienvenid@s");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Elimina el tamaño fijo de la ventana
        // setSize(300, 150);

        setLayout(new BorderLayout());

        JPanel centro = new JPanel(new GridLayout(2, 1, 10, 10));

        centro.setBackground(new Color(176, 196, 222));
        JButton nuevo = new JButton("Iniciar sesion");
        JButton top = new JButton("Salir del sistema");

        nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InicioSesion(null).setVisible(true);
            }
        });

        top.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Establecer tamaños preferidos para los botones
        nuevo.setPreferredSize(new Dimension(150, 50));
        top.setPreferredSize(new Dimension(150, 50));

        centro.add(nuevo);
        centro.add(top);
        add(centro, BorderLayout.CENTER);

        pack(); // Ajusta automáticamente el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}
