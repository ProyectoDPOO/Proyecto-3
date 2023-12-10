package Modelo;
import java.util.ArrayList;



public class Cliente extends Usuario{
	private String fechaDeNacimiento;
	private String telefono;
	private String nacionalidad;
	private String imgDocidentidad;
	private String identificacion;
	private LicenciaConducir licencia;
	private String nombre;
	private MedioPago Medio;
	private ArrayList<String> resumen;
	
	public Cliente(String nombre, String nombreUsuario, String contraseña, String fechaDeNacimiento, String telefono,
			String nacionalidad, String imgDocidentidad, String identificacion,String numeroLicencia,
			String paisExpedicion, String fechaLicencia, String imgLicencia,String tipoPago, 
			String numeroMedioPago, String fechaVencimientoMedioPago) {
		super(nombreUsuario, contraseña, "Cliente");
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.nacionalidad = nacionalidad;
		this.imgDocidentidad = imgDocidentidad;
		this.identificacion = identificacion;
		this.licencia = new LicenciaConducir(numeroLicencia,paisExpedicion, fechaLicencia,imgLicencia);
		this.Medio = new MedioPago(tipoPago,numeroMedioPago,fechaVencimientoMedioPago);
		this.nombre = nombre;
		
		}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}


	public String getImgDocidentidad() {
		return imgDocidentidad;
	}


	public String getIdentificacion() {
		return identificacion;
	}
	public String getNumeroLicencia() {
		return licencia.getNumeroLicencia();
	}
	
	public String getPaisExpedicion() {
		return licencia.getPaisExpedicion();
	}
	public String getImgLicencia() {
		return licencia.getImgLicencia();
	}
	public String getTipo() {
        return Medio.getTipo();
    }

    public String getNumeroPago() {
        return Medio.getNumero();
    }

    public String getFechaVencimientoPago() {
        return Medio.getFechaVencimiento();
    }

	public ArrayList<String> resumenCliente() {
		resumen.add(this.getNombre());
		resumen.add(this.getNombreUsuario());
		resumen.add(this.getContraseña());
		resumen.add(fechaDeNacimiento);
		resumen.add(telefono);
		resumen.add( nacionalidad);
		resumen.add(imgDocidentidad);
		resumen.add(identificacion);
		resumen.add(licencia.getNumeroLicencia());
		resumen.add(licencia.getPaisExpedicion());
		resumen.add(licencia.getFechaLicencia());
		resumen.add(licencia.getImgLicencia());
		resumen.add(Medio.getTipo());
		resumen.add(Medio.getNumero()); 
		resumen.add(Medio.getFechaVencimiento());
		return resumen;
	}

}
