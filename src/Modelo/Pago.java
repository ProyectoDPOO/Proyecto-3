package Modelo;

public interface Pago {

	    boolean processPayment(CreditCardInfo cardInfo, PaymentInfo paymentInfo);
	    boolean blockCreditLimit(CreditCardInfo cardInfo, double amount);

}
