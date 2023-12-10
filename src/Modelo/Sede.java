package Modelo;

public class Sede {

	private String nombreSede;
	private String ubicacion;
	private int horarioAtencion;
	private Empleado administradorLocal;

	public Sede(String nombreSede,String ubicacion, int horarioAtencion, Empleado administradorLocal){
		
		this.nombreSede = nombreSede;
		this.ubicacion = ubicacion;
		this.horarioAtencion = horarioAtencion;
		this.administradorLocal = administradorLocal;
	}

	public String getNombreSede() {
	
		return this.nombreSede;	
	
	}
	
	public String getUbicacion() {
		
		return this.ubicacion;	
	
	}
	
	public int getHorarioAtencion() {
		
		return this.horarioAtencion;	
	
	}
	
	public Empleado administradorLocal() {
		
		return administradorLocal;	
	
	}

}
