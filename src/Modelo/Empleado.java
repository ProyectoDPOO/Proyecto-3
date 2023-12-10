package Modelo;

import java.util.ArrayList;

public class Empleado extends Usuario{

	private String sede;
	private String nombre;
	private ArrayList<String> resumen;
	public Empleado(String nombre,String nombreUsuario, String contrasena, String rol, String sede) {
		super(nombreUsuario, contrasena, rol);
		this.sede = sede;
		this.nombre = nombre;
	}


	public String getSede() {
		return sede;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<String> resumenEmpleado() {
		resumen.add(this.getNombre());
		resumen.add(this.getNombreUsuario());
		resumen.add(this.getContraseña());
		resumen.add(this.getRol());
		resumen.add(sede);
		return resumen;
	}
	
	
	
}
