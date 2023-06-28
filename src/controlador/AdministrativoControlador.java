package controlador;

import java.time.LocalDateTime;
import java.util.Date;

import excepciones.ArticulosInsuficientesException;
import excepciones.ProfesorNoDisponibleException;
import excepciones.UsuarioDuplicadoException;
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
import modelo.TipoEmplazamiento;

public class AdministrativoControlador {

	public void agregarEmplazamiento(Sede sede, TipoEmplazamiento tipoEmplazamiento, double superficie) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.agregarEmplazamiento(sede, tipoEmplazamiento, superficie);
	}

	public void agendarClase(TipoClase tipoClase, Sede sede, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		try {
			supertlonSingleton.agendarClase(tipoClase, sede, emplazamiento, dateInicio, dateFin);
		} catch (ArticulosInsuficientesException e) {

		}
	}

	public void asginarProfesor(Clase clase, Profesor profesor) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		try {
			supertlonSingleton.asginarProfesor(clase, profesor);
		} catch (ProfesorNoDisponibleException e) {
			e.getMessage();
		}
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
		try {
			supertlonSingleton.crearSocio(nombre, apellido, dni, nivel);
		} catch (UsuarioDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
