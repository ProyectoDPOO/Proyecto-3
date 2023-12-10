package Modelo;

public class PaymentInfo {
	private double monto;
    private String numeroCuenta;
    private String numeroTransaccion;

    public PaymentInfo(double monto, String numeroCuenta, String numeroTransaccion) {
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
        this.numeroTransaccion = numeroTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }
}
