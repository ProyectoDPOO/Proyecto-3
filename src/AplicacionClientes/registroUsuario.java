package AplicacionClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class registroUsuario extends JFrame {

    public registroUsuario() {
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para los campos del formulario
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(11, 2, 10, 10)); // Ajustado para 11 filas y 2 columnas

        // Campos del formulario
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblNombreUsuario = new JLabel("Nombre de Usuario:");
        JTextField txtNombreUsuario = new JTextField();

        JLabel lblContrasena = new JLabel("Contraseña:");
        JPasswordField txtContrasena = new JPasswordField();

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento (dd/mm/yyyy):");
        JTextField txtFechaNacimiento = new JTextField();

        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        JLabel lblNacionalidad = new JLabel("Nacionalidad:");
        JTextField txtNacionalidad = new JTextField();

        JLabel lblNumIdentificacion = new JLabel("Número de Identificación:");
        JTextField txtNumIdentificacion = new JTextField();

        JLabel lblNumLicencia = new JLabel("Número de Licencia:");
        JTextField txtNumLicencia = new JTextField();

        JLabel lblPaisExpedicion = new JLabel("País de Expedición:");
        JTextField txtPaisExpedicion = new JTextField();

        JLabel lblFechaLicencia = new JLabel("Fecha de Expedición de la Licencia (dd/mm/yyyy):");
        JTextField txtFechaLicencia = new JTextField();

        // Agregar los campos al panel
        panelCampos.add(lblNombre);
        panelCampos.add(txtNombre);
        panelCampos.add(lblNombreUsuario);
        panelCampos.add(txtNombreUsuario);
        panelCampos.add(lblContrasena);
        panelCampos.add(txtContrasena);
        panelCampos.add(lblFechaNacimiento);
        panelCampos.add(txtFechaNacimiento);
        panelCampos.add(lblTelefono);
        panelCampos.add(txtTelefono);
        panelCampos.add(lblNacionalidad);
        panelCampos.add(txtNacionalidad);
        panelCampos.add(lblNumIdentificacion);
        panelCampos.add(txtNumIdentificacion);
        panelCampos.add(lblNumLicencia);
        panelCampos.add(txtNumLicencia);
        panelCampos.add(lblPaisExpedicion);
        panelCampos.add(txtPaisExpedicion);
        panelCampos.add(lblFechaLicencia);
        panelCampos.add(txtFechaLicencia);

        // Crear el botón "Registrar"
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para procesar el registro de usuario
                String nombre = txtNombre.getText();
                String nombreUsuario = txtNombreUsuario.getText();
                char[] contrasena = txtContrasena.getPassword();
                String fechaNacimientoStr = txtFechaNacimiento.getText();
                String telefono = txtTelefono.getText();
                String nacionalidad = txtNacionalidad.getText();
                String numIdentificacion = txtNumIdentificacion.getText();
                String numLicencia = txtNumLicencia.getText();
                String paisExpedicion = txtPaisExpedicion.getText();
                String fechaLicenciaStr = txtFechaLicencia.getText();

                // Validar y convertir fechas
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaNacimiento = null;
                Date fechaLicencia = null;
                try {
                    fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
                    fechaLicencia = dateFormat.parse(fechaLicenciaStr);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Formato de fecha inválido", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si hay un error de formato
                }

                // Puedes agregar aquí la lógica para almacenar los datos del nuevo usuario.
                // Por ejemplo, puedes llamar a un método de la capa de lógica de negocios.

                // Mostrar un mensaje de éxito o realizar alguna acción adicional
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");

                // Guardar la información en un archivo de texto
                guardarInformacionEnArchivo(nombre, nombreUsuario, new String(contrasena),
                        fechaNacimiento, telefono, nacionalidad, numIdentificacion, numLicencia,
                        paisExpedicion, fechaLicencia);

                // Cerrar la ventana de registro después de completar el registro
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

        // Panel para los dos últimos botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnRegistrar);
        panelBotones.add(regresarButton);

        // Agregar paneles al contenedor principal
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private void guardarInformacionEnArchivo(String nombre, String nombreUsuario, String contrasena,
                                            Date fechaNacimiento, String telefono, String nacionalidad,
                                            String numIdentificacion, String numLicencia,
                                            String paisExpedicion, Date fechaLicencia) {
        try {
            // Especifica la ruta y el nombre del archivo
            String rutaArchivo = "usuarios_registrados.txt";

            // Crea o abre el archivo en modo de escritura
            FileWriter fileWriter = new FileWriter(rutaArchivo, true); // true indica que se añadirán datos al archivo existente
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribe la información del usuario en el archivo
            bufferedWriter.write("Nombre: " + nombre);
            bufferedWriter.newLine();
            bufferedWriter.write("Nombre de Usuario: " + nombreUsuario);
            bufferedWriter.newLine();
            bufferedWriter.write("Contraseña: " + contrasena);
            bufferedWriter.newLine();
            bufferedWriter.write("Fecha de Nacimiento: " + fechaNacimiento);
            bufferedWriter.newLine();
            bufferedWriter.write("Teléfono: " + telefono);
            bufferedWriter.newLine();
            bufferedWriter.write("Nacionalidad: " + nacionalidad);
            bufferedWriter.newLine();
            bufferedWriter.write("Número de Identificación: " + numIdentificacion);
            bufferedWriter.newLine();
            bufferedWriter.write("Número de Licencia: " + numLicencia);
            bufferedWriter.newLine();
            bufferedWriter.write("País de Expedición: " + paisExpedicion);
            bufferedWriter.newLine();
            bufferedWriter.write("Fecha de Expedición de la Licencia: " + fechaLicencia);
            bufferedWriter.newLine();
            bufferedWriter.write("----------"); // Separador entre usuarios
            bufferedWriter.newLine();

            // Cierra el flujo de escritura
            bufferedWriter.close();

            JOptionPane.showMessageDialog(null, "Información guardada en el archivo", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar la información en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new registroUsuario();
            }
        });
    }
}

