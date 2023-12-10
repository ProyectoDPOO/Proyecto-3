package Modelo;

public class CreditCardInfo {

	    private String numero;
	    private String nombreTarjeta;
	    private String fechaVencimiento;
	    private String cvv;

	    public CreditCardInfo(String numero, String nombreTarjeta, String fechaVencimiento, String cvv) {
	        this.numero = numero;
	        this.nombreTarjeta = nombreTarjeta;
	        this.fechaVencimiento = fechaVencimiento;
	        this.cvv = cvv;
	    }

	    public String getnumero() {
	        return numero;
	    }

	    public String getNombreTarjeta() {
	        return nombreTarjeta;
	    }

	    public String getFechaVencimiento() {
	        return fechaVencimiento;
	    }

	    public String getCvv() {
	        return cvv;
	    }
	
}
