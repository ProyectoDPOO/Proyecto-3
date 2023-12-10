package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reserva {
	
	private Map<String, CategoriaVehiculo> categoriasVehiculos;
	private String cliente;
	private String sedeRecogida;
	private String sedeEntrega;
	private String fechaRecogida;
	private String fechaEntrega;
	private String rangoHorasRecogida;
	private String rangoHorasEntrega;
	private int costoReserva;
	private int precioPagoAnticipado;
	private ArrayList<String> resumenReserva;

	
	public Reserva(String cliente, String categoriaVehiculo, String sedeRecogida, 
			String sedeEntrega, String fechaRecogida, String fechaEntrega, String rangoHorasRecogida, String rangoHorasEntrega){
		
		categoriasVehiculos = new HashMap<>();

		this.cliente = cliente;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.fechaRecogida = fechaRecogida;
		this.fechaEntrega = fechaEntrega;
		this.setRangoHorasRecogida(rangoHorasRecogida);
		this.setRangoHorasEntrega(rangoHorasEntrega);
		
		
	}
	
	public String setFechaRecogida(){
		return this.fechaRecogida;
	}
			
	public String setSedeRecogida(){	
		return this.sedeRecogida;
	}
	
	public String setFechaEntrega(){
		return this.fechaEntrega;
	}
			
	public String setSedeEntrega(){
		return this.sedeEntrega;
	}
	
	public int getCostoReserva() {		
		return costoReserva;
	}
	
	public CategoriaVehiculo asignarVehiculo(String categoriaVehiculo) {
		
		if (categoriasVehiculos.containsKey(categoriaVehiculo)) {
	        return categoriasVehiculos.get(categoriaVehiculo);
	    } 
		else 
		{
	    	return null;
	    }
	}
	public int getprecioPagoAnticipado(String categoriaVehiculo) {
		precioPagoAnticipado = 0;

		CategoriaVehiculo categoria = asignarVehiculo(categoriaVehiculo);
		if (categoria != null) 
		{
		
			int preciototal = categoria.getTarifaActual();
			precioPagoAnticipado = (int) (preciototal *0.3);
		}
		
		return precioPagoAnticipado;
	}
	
	private static int numeroReserva = 1;
	public int generarNumeroReserva() {
		int reservaActual = numeroReserva;
	    numeroReserva++; 
	    return reservaActual;
	  }
	
	public ArrayList<String> resumenReserva()
	{
		resumenReserva.add(cliente);
		resumenReserva.add(fechaEntrega);
		resumenReserva.add(sedeRecogida);
		resumenReserva.add(sedeEntrega);
		resumenReserva.add(String.valueOf(costoReserva));
		resumenReserva.add(String.valueOf(precioPagoAnticipado));
		
		return resumenReserva;
	}

	public String getRangoHorasRecogida() {
		return rangoHorasRecogida;
	}

	public void setRangoHorasRecogida(String rangoHorasRecogida) {
		this.rangoHorasRecogida = rangoHorasRecogida;
	}

	public String getRangoHorasEntrega() {
		return rangoHorasEntrega;
	}

	public void setRangoHorasEntrega(String rangoHorasEntrega) {
		this.rangoHorasEntrega = rangoHorasEntrega;
	}
}
