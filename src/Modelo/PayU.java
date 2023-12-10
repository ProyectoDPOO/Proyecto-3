package Modelo;

import java.io.FileWriter;
import java.io.IOException;

public class PayU implements Pago{
	
    public boolean processPayment(CreditCardInfo cardInfo, PaymentInfo paymentInfo) {
    	
    	// Registrar el pago en el archivo 
        try {
            FileWriter writer = new FileWriter("PayU.txt", true);
            writer.write("Registro de pago de PayU: " + paymentInfo.getMonto() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Pago procesado correctamente");
        
        return true;
    }

    public boolean blockCreditLimit(CreditCardInfo cardInfo, double amount) {
    	System.out.println("Límite de crédito bloqueado");
        return true;
    }


}
