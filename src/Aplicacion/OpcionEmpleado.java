package Aplicacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



@SuppressWarnings("serial")
public class OpcionEmpleado extends JFrame {
	
	public OpcionEmpleado() 
	{
		setTitle("Opciones de Empleado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,250);
		setLayout (new BorderLayout());
		
		
        JPanel centro = new JPanel(new GridLayout(2, 2));
        centro.setBackground(new Color(176, 196, 222));
        
        JButton alquiler = new JButton("Generar alquiler");
        
        alquiler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	alquiler alquiventana;
				try {
					alquiventana = new alquiler();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			    dispose();
            }
        });
        
        JButton conductor = new JButton("Registrar conductores adicionales");
        
        conductor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	try {
					registrarConductorAdicional ventana = new registrarConductorAdicional ();
					ventana.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        

JButton actualizar = new JButton("Gestión Vehículo");

        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame nuevaVentana = new JFrame("Gestión Vehículo");
                nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentana.setSize(400, 300);

                JPanel panelNuevaVentana = new JPanel();
                panelNuevaVentana.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
                
                JButton agregarVehiculo = new JButton("Agregar Vehículo");
                JButton trasladoVehiculo = new JButton("Traslado Vehículo");
                JButton eliminarVehiculo = new JButton("Eliminar Vehículo");

                Dimension buttonSize = new Dimension(300, 50);
                agregarVehiculo.setPreferredSize(buttonSize);
                trasladoVehiculo.setPreferredSize(buttonSize);
                eliminarVehiculo.setPreferredSize(buttonSize);
                
                panelNuevaVentana.add(agregarVehiculo);
                panelNuevaVentana.add(trasladoVehiculo);
                panelNuevaVentana.add(eliminarVehiculo);
                
                agregarVehiculo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Crear una nueva ventana de "Gestionar Vehículo"
                            JFrame nuevaVentana = new JFrame("Agregar Vehículo");
                            nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            nuevaVentana.setSize(400, 400);

                            // Crear un panel para organizar los elementos
                            JPanel panelGestionVehiculo = new JPanel();
                            panelGestionVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                            // Agregar etiquetas y campos de texto para los datos del vehículo
                            String[] etiquetas = {
                                "Placa:",
                                "Marca:",
                                "Modelo:",
                                "Color:",
                                "Transmisión:",
                                "Capacidad:",
                                "Categoría:",
                                "Estado:",
                                "Sede Actual:",
                                "Fecha Disponible:"
                            };

                            JTextField[] camposTexto = new JTextField[etiquetas.length];

                            for (int i = 0; i < etiquetas.length; i++) {
                                JLabel label = new JLabel(etiquetas[i]);
                                camposTexto[i] = new JTextField(20);
                                panelGestionVehiculo.add(label);
                                panelGestionVehiculo.add(camposTexto[i]);
                            }

                            nuevaVentana.add(panelGestionVehiculo);
                            nuevaVentana.setVisible(true);
                        }
                    });

                  trasladoVehiculo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Crear una nueva ventana de "Traslado Vehículo"
                            JFrame nuevaVentana = new JFrame("Traslado Vehículo");
                            nuevaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            nuevaVentana.setSize(400, 200);

                            // Crear un panel para organizar los elementos
                            JPanel panelTrasladoVehiculo = new JPanel();
                            panelTrasladoVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                            // Agregar etiquetas y campos de texto para "Sede Actual" y "Nueva Sede"
                            String[] etiquetasTraslado = {
                                "Sede Actual:",
                                "Nueva Sede:"
                            };

                            JTextField[] camposTextoTraslado = new JTextField[etiquetasTraslado.length];

                            for (int i = 0; i < etiquetasTraslado.length; i++) {
                                JLabel label = new JLabel(etiquetasTraslado[i]);
                                camposTextoTraslado[i] = new JTextField(20);
                                panelTrasladoVehiculo.add(label);
                                panelTrasladoVehiculo.add(camposTextoTraslado[i]);
                            }

                            nuevaVentana.add(panelTrasladoVehiculo);
                            nuevaVentana.setVisible(true);
                        }
                    });

                

                eliminarVehiculo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Crear una nueva ventana de "Eliminar Vehículo"
                        JFrame nuevaVentanaEliminar = new JFrame("Eliminar Vehículo");
                        nuevaVentanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        nuevaVentanaEliminar.setSize(400, 200);

                        // Crear un panel para organizar los elementos
                        JPanel panelEliminarVehiculo = new JPanel();
                        panelEliminarVehiculo.setLayout(new GridLayout(0, 2, 10, 10));

                        // Agregar etiquetas y campos de texto para "Placa," "Marca," y "Modelo"
                        String[] etiquetasEliminar = {
                            "Placa:",
                            "Marca:",
                            "Modelo:"
                        };

                        JTextField[] camposTextoEliminar = new JTextField[etiquetasEliminar.length];

                        for (int i = 0; i < etiquetasEliminar.length; i++) {
                            JLabel label = new JLabel(etiquetasEliminar[i]);
                            camposTextoEliminar[i] = new JTextField(20);
                            panelEliminarVehiculo.add(label);
                            panelEliminarVehiculo.add(camposTextoEliminar[i]);
                        }

                        nuevaVentanaEliminar.add(panelEliminarVehiculo);
                        nuevaVentanaEliminar.setVisible(true);
                    }
                });

                nuevaVentana.add(panelNuevaVentana);
                nuevaVentana.setVisible(true);
            }
        });



        
        JButton salir = new JButton("Salir del sistema");
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
        
		centro.add(alquiler);
        centro.add(conductor);
        centro.add(actualizar);
        centro.add(salir);
        
		add(centro, BorderLayout.CENTER);
		
        setVisible(true);
	}
	
	public static void main(String[] args)
	{

		new OpcionEmpleado();
			
	}
}
