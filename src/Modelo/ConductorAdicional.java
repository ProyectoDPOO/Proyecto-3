package Modelo;

import java.util.ArrayList;

public class ConductorAdicional {


	private String nombre;
	private String identificacion;
	private String telefono;
	private String correo;
	private LicenciaConducir licencia;
	private ArrayList<String> resumen;
	
	public ConductorAdicional(String nombre,String identificacion, String telefono, String correo, String numeroLicencia,
			String paisExpedicion, String fechaLicencia, String imgLicencia){
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.licencia = new LicenciaConducir(numeroLicencia,paisExpedicion, fechaLicencia,imgLicencia);
	}

	public String getNombre() {
	
		return this.nombre;	
	
	}
	
	public String getTelefono() {
		
		return this.telefono;	
	
	}
	
	public String getCorreo() {
		
		return this.correo;	
	
	}
	
	public String getLicencia(String identificacion) {
		
		return this.identificacion;	
	
	}

	public ArrayList<String> resumenConductorAdicional() {
	resumen.add(this.getNombre());
	resumen.add(telefono);
	resumen.add(identificacion);
	resumen.add(licencia.getNumeroLicencia());
	resumen.add(licencia.getPaisExpedicion());
	resumen.add(licencia.getFechaLicencia());
	resumen.add(licencia.getImgLicencia());
	return resumen;
}

	
}
