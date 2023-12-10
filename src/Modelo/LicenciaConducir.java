package Modelo;

public class LicenciaConducir {
	private String numeroLicencia;
	private String paisExpedicion;
	private String FechaLicencia;
	private String imgLicencia;
	
	
	public LicenciaConducir(String numeroLicencia, String paisExpedicion, String fechaLicencia, String imgLicencia) {
		super();
		this.numeroLicencia = numeroLicencia;
		this.paisExpedicion = paisExpedicion;
		FechaLicencia = fechaLicencia;
		this.imgLicencia = imgLicencia;
	}

	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public String getPaisExpedicion() {
		return paisExpedicion;
	}

	public String getFechaLicencia() {
		return FechaLicencia;
	}

	public String getImgLicencia() {
		return imgLicencia;
	}

}
