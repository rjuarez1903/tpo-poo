package modelo;

public abstract class Usuario {
	protected String nombre, apellido, dni;

	protected Usuario(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
}
