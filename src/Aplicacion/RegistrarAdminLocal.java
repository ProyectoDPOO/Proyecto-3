package Aplicacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrarAdminLocal extends JFrame {

    public RegistrarAdminLocal() {
        super("Registrar Administrador Local");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Crear un panel para organizar los elementos
        JPanel panelRegistroAdminLocal = new JPanel();
        panelRegistroAdminLocal.setLayout(new GridLayout(0, 2, 10, 10));

        // Agregar etiquetas y campos de texto para los datos del administrador local
        String[] etiquetasRegistroAdminLocal = {
                "Nombre:",
                "Nombre de Usuario:",
                "Contraseña:",
                "Rol:",
                "Sede:"
        };

        JTextField[] camposTextoRegistroAdminLocal = new JTextField[etiquetasRegistroAdminLocal.length];

        for (int i = 0; i < etiquetasRegistroAdminLocal.length; i++) {
            JLabel label = new JLabel(etiquetasRegistroAdminLocal[i]);
            camposTextoRegistroAdminLocal[i] = new JTextField(20);
            panelRegistroAdminLocal.add(label);
            panelRegistroAdminLocal.add(camposTextoRegistroAdminLocal[i]);
        }

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para manejar el evento del botón Registrar
                // Puedes agregar aquí la lógica para procesar los datos ingresados
                guardarInformacionAdminLocal(camposTextoRegistroAdminLocal);
            }
        });

        panelRegistroAdminLocal.add(registrarButton);
        add(panelRegistroAdminLocal);
        setVisible(true);
        
        JButton regresar = new JButton("Regresar");
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                new menuInicial().setVisible(true); // Abre la ventana MenuInicial
                
            }
            
        });
        
    
        panelRegistroAdminLocal.setBackground(new Color(70, 130, 180));
        panelRegistroAdminLocal.add(regresar);

        add(panelRegistroAdminLocal, BorderLayout.SOUTH);
    }
    
    private void guardarInformacionAdminLocal(JTextField[] camposTextoRegistroAdminLocal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacion_admin_local.txt", true))) {
            for (int i = 0; i < camposTextoRegistroAdminLocal.length; i++) {
                String etiqueta = camposTextoRegistroAdminLocal[i].getName();
                String valor = camposTextoRegistroAdminLocal[i].getText();
                writer.write(etiqueta + ": " + valor + "\n");
            }
            writer.write("----------------------------------------\n");  // Separador entre registros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Puedes probar la ventana creando una instancia de la clase
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrarAdminLocal();
            }
        });
    }
}
