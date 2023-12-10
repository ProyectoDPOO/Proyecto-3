package Modelo;

public class EstadoVehiculo {
	
	private String estado;
	private String sedeActual;
	private String fechaDisponibilidad;
	
	public EstadoVehiculo(String estado, String sedeActual, String fechadisponible)
	{
		this.estado = estado;
		this.sedeActual = sedeActual.toUpperCase();
		this.fechaDisponibilidad = fechadisponible;
	}
	
	
	public String getEstado() {
		return estado;
	}
	
	public String getsedeActual() {
		return sedeActual;
	}
	public void setSedeActual(String destino) {
		
		this.sedeActual = destino;
	}
	
	public String getfechaDisponibilidad() {
		return fechaDisponibilidad;
	}
	
	public void actualizarEstado(String estadoNuevo) 
	{
		if(estadoNuevo.equals("Disponible")|| estadoNuevo.equals("Ocupado")||
				estadoNuevo.equals("Limpieza")||estadoNuevo.equals("Mantenimiento")) 
		{
			estado = estadoNuevo;
		} 
		else
		{
			System.out.println("Este estado no extiste");
		}
	}
}

