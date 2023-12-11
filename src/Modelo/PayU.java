package Modelo;

public class PayU implements Pago{
	
	 public boolean processPayment(CreditCardInfo cardInfo, PaymentInfo paymentInfo) {
	    	
	        System.out.println("Pago procesado correctamente");
	        
	        return true;
	    }

	    public boolean blockCreditLimit(CreditCardInfo cardInfo, double amount) {
	    	System.out.println("Límite de crédito bloqueado");
	        return true;
	    }
	    public String toString() {
	        return "PayU"; 
	    }

}
