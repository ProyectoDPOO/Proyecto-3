package Aplicacion;



import javax.swing.JFrame;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Procesamiento.EmpresaAlquilerVehiculo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;



@SuppressWarnings("serial")
public class RegistrarCategoria extends JFrame {
	
	private EmpresaAlquilerVehiculo empresa;
	
	public RegistrarCategoria(EmpresaAlquilerVehiculo empresa) 
	{
		this.empresa= empresa;
		setTitle("Registrar Categoría");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,350);
		setLayout (new BorderLayout());
		
		JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(0, 2));
        panel.setBackground(new Color(176, 196, 222));
        
        panel.add(new JLabel(" Nombre de Categoría:"));
        JTextField nombreCategoria = new JTextField();
        panel.add(nombreCategoria);
        
        panel.add(new JLabel(" Tarifa Temporada Alta:"));
        JTextField tarifaTemporadaAlta = new JTextField();
        panel.add(tarifaTemporadaAlta);
        
        panel.add(new JLabel(" Tarifa Temporada Baja:"));
        JTextField tarifaTemporadaBaja = new JTextField();
        panel.add(tarifaTemporadaBaja);
        
        panel.add(new JLabel(" Tarifa Conductor Adicional:"));
        JTextField tarifaConductorAdicional = new JTextField();
        panel.add(tarifaConductorAdicional);
        
        panel.add(new JLabel(" Tarifa Entregar en Otra Sede:"));
        JTextField tarifaEntregarOtraSede = new JTextField();
        panel.add(tarifaEntregarOtraSede);
        
        String[] opcionesTemporadaAlta = {"Sí", "No"};
        JComboBox<String> temporadaAltaComboBox = new JComboBox<>(opcionesTemporadaAlta);
        panel.add(new JLabel(" Temporada Alta:"));
        panel.add(temporadaAltaComboBox);
        
        JPanel inferior = new JPanel();
        
        JButton registro = new JButton("Registrar categoría");
        
        registro.addActionListener(e -> {
            
        	String nombre = nombreCategoria.getText(); 
            int tarifaAlta = Integer.parseInt(tarifaTemporadaAlta.getText());  
            int tarifaBaja = Integer.parseInt(tarifaTemporadaBaja.getText());  
            int tarifaAdicional = Integer.parseInt(tarifaConductorAdicional.getText());  
            int tarifaOtraSede = Integer.parseInt(tarifaEntregarOtraSede.getText());  
            boolean alta = temporadaAltaComboBox.getSelectedItem().equals("Sí");
            
           empresa.registrarCategoria(nombre, tarifaAlta, tarifaBaja, tarifaAdicional, tarifaOtraSede, alta);
           dispose();
        });
        
        
        inferior.add(registro);
        inferior.setBackground(new Color(70, 130, 180));
        add(inferior,BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		EmpresaAlquilerVehiculo empresa = new EmpresaAlquilerVehiculo();
		new RegistrarCategoria(empresa);
			
	}

}
