package modelo;

import vista.SocioView;

public class Socio extends Usuario {
	
	private Nivel nivel;
	private boolean isActive;

	public Socio(String nombre, String apellido, String dni, Nivel nivel) {
		super(nombre, apellido, dni);
		this.nivel = nivel;
		this.isActive = true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public boolean getIsActive() {
		return isActive;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public SocioView toView() {
		return new SocioView(nombre, apellido, dni);
	}
	
}
