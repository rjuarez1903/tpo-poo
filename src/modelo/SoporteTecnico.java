package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class SoporteTecnico extends Usuario {

	public SoporteTecnico(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	// PERFILES DE USUARIO

	public void crearAdministrativo(String nombre, String apellido, String dni, ArrayList<String> sedes) {
		// TODO
	}

	public void crearSocio(String nombre, String apellido, String dni) {
		// TODO
	}

	public void crearSoporteTecnico(String nombre, String apellido, String dni) {
		// TODO
	}

	// ITEMS

	public void crearSede(String barrio, Nivel nivel, double precioAlquiler) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		Sede nuevaSede = new Sede(barrio, precioAlquiler, nivel);
		supertlonSingleton.agregarSede(nuevaSede);
	}

	public void crearTipoClase() {
		// TODO
	}

	public void crearTipoArticulo(String descripcion, double precio, int numeroUsos, LocalDate fechaDeFabricacion,
			TipoAmortizacion tipoAmortizacion) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		TipoArticulo nuevoTipoArticulo = new TipoArticulo(descripcion, precio, numeroUsos, fechaDeFabricacion,
				tipoAmortizacion);
		supertlonSingleton.agregarTipoArticulo(nuevoTipoArticulo);

	}

}
