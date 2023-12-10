package Aplicacion;

import javax.swing.*;

import Modelo.Cliente;
import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


@SuppressWarnings("serial")
public class MostrarInfoCliente extends JDialog {
 
	private JTextField nombreClienteField;
    private JTextField nombreUsuarioLabel;
    private JTextField fechaNacimientoLabel;
    private JTextField telefonoLabel;
    private JTextField nacionalidadLabel;
    private JTextField identificacionLabel;
    private JTextField numeroLicenciaLabel;
    private JTextField paisExpedicionLabel;
    private JTextField fechaExpedicionLabel;
    private JTextField tipoMedioPagoLabel;
    private JTextField numeroMedioPagoLabel;
    private JTextField fechaVencimientoMedioLabel;
    private EmpresaAlquilerVehiculo empresa;
    
    public MostrarInfoCliente(EmpresaAlquilerVehiculo empresa) {
    	
    	this.empresa=empresa;
        setTitle("Información del Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(176, 196, 222));
        
     
        nombreClienteField = new JTextField();
        agregarCampo(panel, "Nombre del Cliente: ", nombreClienteField);
        
        nombreUsuarioLabel = new JTextField();
        fechaNacimientoLabel = new JTextField();
        telefonoLabel = new JTextField();
        nacionalidadLabel = new JTextField();
        identificacionLabel = new JTextField();
        numeroLicenciaLabel = new JTextField();
        paisExpedicionLabel = new JTextField();
        fechaExpedicionLabel = new JTextField();
        tipoMedioPagoLabel = new JTextField();
        numeroMedioPagoLabel = new JTextField();
        fechaVencimientoMedioLabel = new JTextField();
        
        
        JButton buscar = new JButton("Buscar");
        panel.add(buscar);

        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreCliente = nombreClienteField.getText();
                Cliente cliente = empresa.mostrarCliente(nombreCliente);

                if (cliente != null) {
         
                    nombreUsuarioLabel.setText("Nombre de Usuario: " + cliente.getNombreUsuario());
                    fechaNacimientoLabel.setText("Fecha de Nacimiento: " + cliente.getFechaDeNacimiento());
                    telefonoLabel.setText("Teléfono: " + cliente.getTelefono());
                    nacionalidadLabel.setText("Nacionalidad: " + cliente.getNacionalidad());
                    identificacionLabel.setText("Identificación: " + cliente.getIdentificacion());
                    numeroLicenciaLabel.setText("Número de Licencia: " + cliente.getNumeroLicencia());
                    paisExpedicionLabel.setText("País de Expedición de la Licencia: " + cliente.getPaisExpedicion());
                    fechaExpedicionLabel.setText("Fecha de Expedición de la Licencia: " + cliente.getImgLicencia());
                    tipoMedioPagoLabel.setText("Tipo de medio pago: " + cliente.getTipo());
                    numeroMedioPagoLabel.setText("Número de medio pago: " + cliente.getNumeroPago());
                    fechaVencimientoMedioLabel.setText("Fecha de Vencimiento del Medio: " + cliente.getFechaVencimientoPago());
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
  
        nombreUsuarioLabel.setEditable(false);
        fechaNacimientoLabel.setEditable(false);
        telefonoLabel.setEditable(false);
        nacionalidadLabel.setEditable(false);
        identificacionLabel.setEditable(false);
        numeroLicenciaLabel.setEditable(false);
        paisExpedicionLabel.setEditable(false);
        fechaExpedicionLabel.setEditable(false);
        tipoMedioPagoLabel.setEditable(false);
        numeroMedioPagoLabel.setEditable(false);
        fechaVencimientoMedioLabel.setEditable(false);
        
        agregarCampo(panel, "Nombre de Usuario: ", nombreUsuarioLabel);
        agregarCampo(panel, "Fecha de Nacimiento: ", fechaNacimientoLabel);
        agregarCampo(panel, "Teléfono: ", telefonoLabel);
        agregarCampo(panel, "Nacionalidad: ", nacionalidadLabel);
        agregarCampo(panel, "Identificación: ", identificacionLabel);
        agregarCampo(panel, "Número de Licencia: ", numeroLicenciaLabel);
        agregarCampo(panel, "País de Expedición de la Licencia: ", paisExpedicionLabel);
        agregarCampo(panel, "Fecha de Expedición de la Licencia: ", fechaExpedicionLabel);
        agregarCampo(panel, "Tipo de medio pago: ", tipoMedioPagoLabel);
        agregarCampo(panel, "Número de medio pago: ", numeroMedioPagoLabel);
        agregarCampo(panel, "Fecha de Vencimiento del Medio: ", fechaVencimientoMedioLabel);

        
        JButton salirSistema = new JButton("Salir del sistema");

        salirSistema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
   
                dispose();
            }
        });

        JPanel inferior = new JPanel();
        inferior.add(salirSistema);
        add(inferior,BorderLayout.SOUTH);
        
        add(panel);
        
        setVisible(true);
    }
    
    private void agregarCampo(JPanel panel, String etiqueta, JComponent componente) {
        JPanel campoPanel = new JPanel();
        campoPanel.setLayout(new BoxLayout(campoPanel, BoxLayout.X_AXIS));
        campoPanel.add(new JLabel(etiqueta));
        campoPanel.add(componente);
        panel.add(campoPanel);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException
	{
		EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
		new MostrarInfoCliente(empresa);
			
	}

}


