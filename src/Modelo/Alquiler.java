package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Alquiler {
	
	private Map<String, CategoriaVehiculo> categoriasVehiculos;
	private String vehiculo;
	private String cliente;
	private String fechaRecogida;
	private String rangoHorasRecogida;
	private String sedeRecogida;
	private String fechaEntrega;
	private String rangoHorasEntrega;
	private String sedeEntrega;
	private ArrayList<ConductorAdicional> conductorAdicional;
	private ArrayList<Seguro> seguros;
	private ArrayList<Object> resumenAlquiler;

	
	public Alquiler(String cliente, String vehiculo, String fechaRecogida, String rangoHorasRecogida, String sedeRecogida, String fechaEntrega, String rangoHorasEntrega, String sedeEntrega, String seguros2, String conductores){
		
		categoriasVehiculos = new HashMap<>();
		this.vehiculo = cliente;
		this.cliente = vehiculo;
		this.setFechaRecogida(fechaRecogida);
		this.setRangoHorasRecogida(rangoHorasRecogida);
		this.sedeRecogida = sedeRecogida;
		this.setFechaEntrega(fechaEntrega);
		this.setRangoHorasEntrega(rangoHorasEntrega);
		this.sedeEntrega = sedeEntrega;

	}
	
	public void registroConductoresAdicionales(ArrayList<ConductorAdicional> conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	public void agregarSeguros(Seguro seguro) {
		seguros.add(seguro);
	}

	public CategoriaVehiculo asignarVehiculo(String vehiculo) {
		
		if (categoriasVehiculos.containsKey(vehiculo)) {
	        return categoriasVehiculos.get(vehiculo);
	    } 
		else 
		{
	    	return null;
	    }
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public String getVehiculo() {
		return vehiculo;
	}
	
	private static int numeroReserva = 1;
	public int generarNumeroAlquiler() {
		int reservaActual = numeroReserva;
	    numeroReserva++; 
	    return reservaActual;
	  }
	
	public int generarPrecioFinal(String placaVehiculo) {
		

		CategoriaVehiculo categoria = asignarVehiculo(placaVehiculo);
		
		int precioVehiculo =0;
		int precioConductorAdicional = 0;
		int otraSede = 0;	
		int valorSeguro = 0;
		
		
		precioVehiculo = categoria.getTarifaActual();
		
	    if (conductorAdicional != null && !conductorAdicional.isEmpty()) {
	        precioConductorAdicional = categoria.getTarifaConductorAdicional();
	    }

	    if (!sedeRecogida.equals(sedeEntrega)) {
	        otraSede = categoria.getTarifaOtraSede();
	    }

	    if (seguros != null) {
	        for (Seguro seguro : seguros) {
	            valorSeguro += seguro.getCosto();
	        }
	    }
		int totalFinal = precioVehiculo + precioConductorAdicional + otraSede + valorSeguro;
		return totalFinal;
	}
	
	public ArrayList<Object>resumen(){
		resumenAlquiler.add(conductorAdicional);
		resumenAlquiler.add(seguros);
		resumenAlquiler.add(getCliente());
		resumenAlquiler.add(getVehiculo());
		resumenAlquiler.add(this.generarNumeroAlquiler());
		return resumenAlquiler;
	}

	public String getFechaRecogida() {
		return fechaRecogida;
	}

	public void setFechaRecogida(String fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}

	public String getRangoHorasRecogida() {
		return rangoHorasRecogida;
	}

	public void setRangoHorasRecogida(String rangoHorasRecogida) {
		this.rangoHorasRecogida = rangoHorasRecogida;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getRangoHorasEntrega() {
		return rangoHorasEntrega;
	}

	public void setRangoHorasEntrega(String rangoHorasEntrega) {
		this.rangoHorasEntrega = rangoHorasEntrega;
	}
	public String getSedeEntrega() {
		return sedeEntrega;
	}
	
	public String getSedeRecoger() {
		return sedeRecogida;
	}

}