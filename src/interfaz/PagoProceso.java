package interfaz;

import javax.swing.*;

import Modelo.CreditCardInfo;
import Modelo.Pago;
import Modelo.PaymentInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PagoProceso {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        // Leer el archivo de configuración de pasarelas de pago

    	
    	List<Pago> pago = loadPaymentGatewaysFromFile("Pasarelas.txt");

        // Crear una ventana JFrame para la interfaz visual
        JFrame frame = new JFrame("Realizar Pago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(new BorderLayout());

        // Agregar un JComboBox para que el usuario seleccione una pasarela de pago
        JComboBox<Pago> gatewayComboBox = new JComboBox<>(pago.toArray(new Pago[0]));
        frame.add(gatewayComboBox, BorderLayout.NORTH);

        // Agregar un JButton para realizar el pago
        JButton paymentButton = new JButton("Realizar Pago");
        frame.add(paymentButton, BorderLayout.CENTER);

        
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pago selectedGateway = (Pago) gatewayComboBox.getSelectedItem();

                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);

                // Campos de entrada para la información de la tarjeta
                organizarLabel(panel, gbc, "Número de tarjeta de crédito:");
                organizarLabel(panel, gbc, "Nombre del titular de la tarjeta:");
                organizarLabel(panel, gbc, "Fecha de vencimiento de la tarjeta:");
                organizarLabel(panel, gbc, "CVV de la tarjeta:");

                // Campos de entrada para la información del pago
                organizarLabel(panel, gbc, "Monto del pago:");
                organizarLabel(panel, gbc, "Número de cuenta:");
                organizarLabel(panel, gbc, "Número de transacción:");
                
                for (Component component : panel.getComponents()) {
                    if (component instanceof JTextField) {
                        JTextField textField = (JTextField) component;
                        Dimension preferredSize = textField.getPreferredSize();
                        preferredSize.width = 200; // Ajusta el ancho según tus necesidades
                        textField.setPreferredSize(preferredSize);
                    }
                }

                // Agregar el panel a un JScrollPane
                JScrollPane scrollPane = new JScrollPane(panel);

                
                // Mostrar el panel de entrada y obtener la respuesta del usuario
                int result = JOptionPane.showConfirmDialog(
                        null, scrollPane, "Ingrese la información del pago", JOptionPane.OK_CANCEL_OPTION);

                // Procesar la información solo si el usuario hizo clic en "OK"
                if (result == JOptionPane.OK_OPTION) {
                    // Obtener la información ingresada por el usuario
                    String cardNumber = getFieldText(panel, 0);
                    String cardHolderName = getFieldText(panel, 1);
                    String expirationDate = getFieldText(panel, 2);
                    String cvv = getFieldText(panel, 3);

                    CreditCardInfo cardInfo = new CreditCardInfo(cardNumber, cardHolderName, expirationDate, cvv);

                    double amount = Double.parseDouble(getFieldText(panel, 4));
                    String accountNumber = getFieldText(panel, 5);
                    String transactionNumber = getFieldText(panel, 6);

                    PaymentInfo paymentInfo = new PaymentInfo(amount, accountNumber, transactionNumber);

                    // Realizar el pago
                    boolean paymentResult = selectedGateway.processPayment(cardInfo, paymentInfo);

                    if (paymentResult) {
                        // Bloquear el límite de crédito
                        boolean blockResult = selectedGateway.blockCreditLimit(cardInfo, paymentInfo.getMonto());

                        if (blockResult) {
                            // Registrar el pago en el archivo correspondiente
                            String logMessage = String.format("Fecha: %s, Monto: %s, Tarjeta: %s, Resultado: Éxito",
                                    java.time.LocalDateTime.now(), amount, cardNumber);

                            if (selectedGateway.getClass().getSimpleName().equals("PayPal")) {
                                writeToLogFile(logMessage, "PayPal.log");
                            } else if (selectedGateway.getClass().getSimpleName().equals("PayU")) {
                                writeToLogFile(logMessage, "PayU.txt");
                            } else if (selectedGateway.getClass().getSimpleName().equals("Sire")) {
                                writeToLogFile(logMessage, "Sire.json");
                            }

                            JOptionPane.showMessageDialog(null, "Pago procesado correctamente\nLímite de crédito bloqueado");
                            frame.setVisible(false);

                        } else {
                            JOptionPane.showMessageDialog(null, "Error en el bloqueo del límite de crédito");
                            frame.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en el pago");
                        frame.setVisible(false);
                    }
                }
                
            }
            
        });
        frame.setVisible(true);
        

    }



    private static void writeToLogFile(String logMessage, String fileName) {
        try {
            // Asegúrate de que el nombre del archivo sea sensible a mayúsculas y minúsculas
            if (fileName.endsWith(".txt")) {
                Files.write(Paths.get(fileName), (logMessage + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            } else if (fileName.endsWith(".json")) {
                Files.write(Paths.get(fileName), (logMessage + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            } else {
                System.out.println("Extensión de archivo no compatible: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Pago> loadPaymentGatewaysFromFile(String configFile) {
        List<Pago> pago = new ArrayList<>();
        

        try (InputStream inputStream = new FileInputStream(configFile)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			    String line;
			    while ((line = reader.readLine()) != null) {
			        try {
			            Class<?> gatewayClass = Class.forName(line);
			            Pago paymentGateway = (Pago) gatewayClass.getDeclaredConstructor().newInstance();
			            pago.add(paymentGateway);
			   
			        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			            e.printStackTrace();
			        }
			    }
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pago;
    }
    private static void organizarLabel(JPanel panel, GridBagConstraints gbc, String labelText) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(label, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private static String getFieldText(JPanel panel, int fieldIndex) {
        Component[] components = panel.getComponents();
        if (fieldIndex * 2 + 1 < components.length && components[fieldIndex * 2 + 1] instanceof JTextField) {
            JTextField textField = (JTextField) components[fieldIndex * 2 + 1];
            return textField.getText();
        }
        return "";
    }
}