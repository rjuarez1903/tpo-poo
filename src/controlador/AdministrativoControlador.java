package controlador;

import java.time.LocalDateTime;
import java.util.Date;

import modelo.Articulo;
import modelo.Clase;
import modelo.Emplazamiento;
import modelo.EstadoClase;
import modelo.Nivel;
import modelo.Profesor;
import modelo.Sede;
import modelo.Socio;
import modelo.SupertlonSingleton;
import modelo.TipoArticulo;
import modelo.TipoClase;

public class AdministrativoControlador {

	public void agendarClase(TipoClase tipoClase, Sede sede, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.agendarClase(tipoClase, sede, emplazamiento, dateInicio, dateFin);
	}

	public void asginarProfesor(Clase clase, Profesor profesor) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.asginarProfesor(clase, profesor);
	}

	public void cambiarEstadoClase(Clase clase, EstadoClase nuevoEstado) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.cambiarEstadoClase(clase, nuevoEstado);
	}

	public void incorporarArticulos(Sede sede, TipoArticulo tipoArticulo, String descripcion, double precio,
			int cantidad) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.incorporarArticulos(sede, tipoArticulo, descripcion, precio, cantidad);
	}

	public void modificarSocio(Socio socio, String nombre, String apellido, Nivel nivel, boolean isActive) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.modificarSocio(socio, nombre, apellido, nivel, isActive);
	}

	public void crearSocio(String nombre, String apellido, String dni, Nivel nivel) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.crearSocio(nombre, apellido, dni, nivel);
	}
}
