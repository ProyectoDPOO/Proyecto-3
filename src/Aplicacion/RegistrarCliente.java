package Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

import Procesamiento.EmpresaAlquilerVehiculo;
import Modelo.Usuario;

public class RegistrarCliente extends JFrame {

    private EmpresaAlquilerVehiculo empresa;
    private JTextField imgDocidentidadTextField;
    private JTextField imgLicenciaTextField;

    public RegistrarCliente(EmpresaAlquilerVehiculo empresa) {
        this.empresa = empresa;
        setTitle("Registrar Cliente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.setBackground(new Color(176, 196, 222));

        panel.add(new JLabel("Nombre del Usuario:"));
        JTextField nombreTextField = new JTextField();
        panel.add(nombreTextField);
        
        panel.add(new JLabel("Nombre de Usuario:"));
        JTextField nombreUsuarioTextField = new JTextField();
        panel.add(nombreUsuarioTextField);

        panel.add(new JLabel("Nombre dentro del Sistema:"));
        JTextField nombreSistemaTextField = new JTextField();
        panel.add(nombreSistemaTextField);

        panel.add(new JLabel("Contraseña:"));
        JPasswordField contrasenaField = new JPasswordField();
        panel.add(contrasenaField);

        panel.add(new JLabel("Fecha de Nacimiento:"));
        JTextField fechaNacimientoTextField = new JTextField();
        panel.add(fechaNacimientoTextField);

        panel.add(new JLabel("Teléfono:"));
        JTextField telefonoTextField = new JTextField();
        panel.add(telefonoTextField);

        panel.add(new JLabel("Nacionalidad:"));
        JTextField nacionalidadTextField = new JTextField();
        panel.add(nacionalidadTextField);

        panel.add(new JLabel("Número Identificación:"));
        JTextField numIdentificacionTextField = new JTextField();
        panel.add(numIdentificacionTextField);

        panel.add(new JLabel("Número de Licencia:"));
        JTextField numLicenciaTextField = new JTextField();
        panel.add(numLicenciaTextField);

        panel.add(new JLabel("País Expedición:"));
        JTextField paisExpedicionTextField = new JTextField();
        panel.add(paisExpedicionTextField);

        panel.add(new JLabel("Fecha de Licencia:"));
        JTextField fechaLicenciaTextField = new JTextField();
        panel.add(fechaLicenciaTextField);

        panel.add(new JLabel("Tipo de Pago:"));
        JTextField tipoPagoTextField = new JTextField();
        panel.add(tipoPagoTextField);

        panel.add(new JLabel("Número de Medio de Pago:"));
        JTextField numMedioPagoTextField = new JTextField();
        panel.add(numMedioPagoTextField);

        panel.add(new JLabel("Fecha de Vencimiento de Medio de Pago:"));
        JTextField fechaVencimientoTextField = new JTextField();
        panel.add(fechaVencimientoTextField);
        
        panel.add(new JLabel("Imagen Doc. Identidad:"));
        imgDocidentidadTextField = new JTextField();
        JButton imgDocidentidadButton = new JButton("Seleccionar");
        imgDocidentidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen(imgDocidentidadTextField);
            }
        });
        panel.add(imgDocidentidadButton);
        
        panel.add(new JLabel("Imagen Licencia:"));
        imgLicenciaTextField = new JTextField();
        JButton imgLicenciaButton = new JButton("Seleccionar");
        imgLicenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen(imgLicenciaTextField);
            }
        });
        panel.add(imgLicenciaButton);
       

        JPanel inferior = new JPanel();
        JButton registro = new JButton("Registrar Cliente");

        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados y registrar el cliente
            	String nombre = nombreTextField.getText();
                String nombreUsuario = nombreUsuarioTextField.getText();
                String contrasena = new String(contrasenaField.getPassword());
                String fechaNacimiento = fechaNacimientoTextField.getText();
                String telefono = telefonoTextField.getText();
                String nacionalidad = nacionalidadTextField.getText();
                String numIdentificacion = numIdentificacionTextField.getText();
                String numLicencia = numLicenciaTextField.getText();
                String paisExpedicion = paisExpedicionTextField.getText();
                String fechaLicencia = fechaLicenciaTextField.getText();
                String tipoPago = tipoPagoTextField.getText();
                String numeroMedioPago = numMedioPagoTextField.getText();
                String fechaVencimientoPago = fechaVencimientoTextField.getText();
                String imgDocidentidad = imgDocidentidadTextField.getText();
                String imgLicencia = imgLicenciaTextField.getText();

                empresa.registrarCliente(nombre, nombreUsuario, contrasena, fechaNacimiento, telefono,
                        nacionalidad, imgDocidentidad, numIdentificacion, numLicencia,
                        paisExpedicion, fechaLicencia, imgLicencia, tipoPago,
                        numeroMedioPago, fechaVencimientoPago);

                // Guardar la información en un archivo
                guardarInformacionEnArchivo(nombre, nombreUsuario, contrasena, fechaNacimiento, telefono,
                        nacionalidad, imgDocidentidad, numIdentificacion, numLicencia,
                        paisExpedicion, fechaLicencia, imgLicencia, tipoPago,
                        numeroMedioPago, fechaVencimientoPago);
                	
                // Cerrar la ventana después de registrar el cliente
                dispose();
            }
        });


        inferior.add(registro);
        inferior.setBackground(new Color(70, 130, 180));
        
     // Agregar el botón "Regresar"
        JButton regresar = new JButton("Regresar");
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
                new menuInicial().setVisible(true); // Abre la ventana MenuInicial
            }
        });
        
        inferior.add(regresar);

        add(inferior, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
    
    private void seleccionarImagen(JTextField textField) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            textField.setText(selectedFile.getAbsolutePath());
        }
    }
    
        private void guardarInformacionEnArchivo(String nombre, String nombreUsuario, String contrasena,
            String fechaNacimiento, String telefono, String nacionalidad,
            String imgDocidentidad, String numIdentificacion, String numLicencia,
            String paisExpedicion, String fechaLicencia, String imgLicencia,
            String tipoPago, String numeroMedioPago, String fechaVencimientoPago) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacion_clientes.txt", true))) {
            // Escribe la información del cliente en el archivo
            writer.write("Nombre: " + nombre + "\n");
            writer.write("Nombre de Usuario: " + nombreUsuario + "\n");
            writer.write("Contraseña: " + contrasena + "\n");
            writer.write("Fecha de Nacimiento: " + fechaNacimiento + "\n");
            writer.write("Teléfono: " + telefono + "\n");
            writer.write("Nacionalidad: " + nacionalidad + "\n");
            writer.write("Número de Identificación: " + numIdentificacion + "\n");
            writer.write("Número de Licencia: " + numLicencia + "\n");
            writer.write("País de Expedición: " + paisExpedicion + "\n");
            writer.write("Fecha de Licencia: " + fechaLicencia + "\n");
            writer.write("Imagen Doc. Identidad: " + imgDocidentidad + "\n");
            writer.write("Imagen Licencia: " + imgLicencia + "\n");
            writer.write("Tipo de Pago: " + tipoPago + "\n");
            writer.write("Número de Medio de Pago: " + numeroMedioPago + "\n");
            writer.write("Fecha de Vencimiento de Medio de Pago: " + fechaVencimientoPago + "\n");
            writer.write("----------------------------------------\n");  // Separador entre registros
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
        new RegistrarCliente(empresa);
    }
}
