package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
	protected String nombre, apellido, dni;

	protected Usuario(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	// Metodos Soporte Tecnico
	public void crearSede(String barrio, Nivel nivel, double precioAlquiler) {
	};

	public void crearAdministrativo(String nombre, String apellido, String dni, ArrayList<String> sedes) {
	}

	public void crearSocio(String nombre, String apellido, String dni) {
	}

	public void crearSoporteTecnico(String nombre, String apellido, String dni) {
	}

	public void crearTipoClase() {
	}

	public void crearTipoArticulo(String descripcion, double precio, int numeroUsos, LocalDate fechaDeFabricacion,
			TipoAmortizacion tipoAmortizacion) {
	}

	// Metodos Administrativo

	public void incorporarArticulo() {
	}

	public void darDeBajaArticulo() {
	}

	public void cambiarEstadoClase() {
	}

	public void darAltaSocio() {
	}

	public void modificarSocio() {
	}

}
