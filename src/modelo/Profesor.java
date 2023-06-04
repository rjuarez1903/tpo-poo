package modelo;

import java.util.List;

public class Profesor {
	private String nombre;
	private String apellido;
	private List<Clase> clases;
	private double sueldo;
	
	public Profesor(String nombre, String apellido, double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}
	
	public void addClase(Clase clase) {
		clases.add(clase);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
