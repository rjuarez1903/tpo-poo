package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SupertlonSingleton {
	private static SupertlonSingleton instancia;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Profesor> profesores;
	private ArrayList<TipoClase> tiposClases;
	private ArrayList<TipoArticulo> tiposArticulos;
	private ArrayList<Sede> sedes;

	private SupertlonSingleton() {
		this.usuarios = new ArrayList<Usuario>();
		this.tiposClases = new ArrayList<TipoClase>();
		this.tiposArticulos = new ArrayList<TipoArticulo>();
		this.sedes = new ArrayList<Sede>();
	};

	public static SupertlonSingleton getInstance() {
		if (instancia == null) {
			instancia = new SupertlonSingleton();
		}
		return instancia;
	}

	// Acceso - READY
	public void ingresar(String dni) {
		for (Usuario usuario : usuarios) {
			if (usuario.dni == dni) {
				UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
				usuarioSingleton.setUsuarioActual(usuario);
			}
		}
	}

	// METODOS SOPORTE TECNICO

	private void agregarUsuario(Usuario nuevoUsuario) {
		for (Usuario usuario : usuarios) {
			if (usuario.dni == nuevoUsuario.getDni()) {
				return;
				// Lanzar excepcion
			}
		}
		usuarios.add(nuevoUsuario);
	}

	// ready
	public void crearAdministrativo(String nombre, String apellido, String dni, ArrayList<Sede> sedes) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			Administrativo nuevoUsuarioAdministrativo = new Administrativo(nombre, apellido, dni, sedes);
			agregarUsuario(nuevoUsuarioAdministrativo);
		}
	}

	// ready
	public void crearSoporteTecnico(String nombre, String apellido, String dni) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			SoporteTecnico nuevoUsuarioSoporteTecnico = new SoporteTecnico(nombre, apellido, dni);
			agregarUsuario(nuevoUsuarioSoporteTecnico);
		}
	}

	// ready
	public void crearSocio(String nombre, String apellido, String dni, Nivel nivel) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico() || usuarioActual.soyAdministrativo()) {
			Socio nuevoSocio = new Socio(nombre, apellido, dni, nivel);
			agregarUsuario(nuevoSocio);
		}
	}

	// ready
	public void agregarSede(String barrio, Nivel nivel, double precioAlquiler) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			Sede nuevaSede = new Sede(barrio, precioAlquiler, nivel);
			for (Sede sede : sedes) {
				if (sede.getBarrio() == nuevaSede.getBarrio()) {
					return;
					// Lanzar excepcion Sede ya existe
				}
			}
			sedes.add(nuevaSede);
		}
	}

	// ready
	public void agregarTipoArticulo(String nombre, int numeroUsos, TipoAmortizacion tipoAmortizacion) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			TipoArticulo nuevoTipoArticulo = new TipoArticulo(nombre, numeroUsos, tipoAmortizacion);
			tiposArticulos.add(nuevoTipoArticulo);
		}
	}

	// ready
	public void agregarTipoClase(String nombreClase, boolean online,
			HashMap<Integer, List<CantidadDetalle>> cantidadArticulo) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			TipoClase nuevoTipoClase = new TipoClase(nombreClase, online, cantidadArticulo);
			tiposClases.add(nuevoTipoClase);
		}
	}

	// METODOS ADMINISTRATIVO

	// ready
	public void agendarClase(TipoClase tipoClase, Sede sede, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soyAdministrativo()) {
			sede.agendarClase(tipoClase, emplazamiento, dateInicio, dateFin);
		}
	}

	// ready
	public void asginarProfesor(Clase clase, Profesor profesor) {
		clase.asignarProfesor(profesor);
	}

	
	// ready
	public void cambiarEstadoClase(Clase clase, EstadoClase nuevoEstado) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soyAdministrativo()) {
			clase.cambiarEstado(nuevoEstado);
		}
	}

	// ready
	public void incorporarArticulos(Sede sede, TipoArticulo tipoArticulo, String descripcion, double precio,
			int cantidad) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soyAdministrativo()) {
			sede.incorporarArticulo(tipoArticulo, descripcion, precio, cantidad);
		}
	}

	public void modificarSocio(Socio socio, String nombre, String apellido, Nivel nivel, boolean isActive) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soyAdministrativo()) {
			socio.setNombre(nombre);
			socio.setApellido(apellido);
			socio.setIsActive(isActive);
			socio.setNivel(nivel);
		}
	}

	// METODOS DE USUARIO

	public void inscribirseClase(Clase clase) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySocio()) { // Verifica que el usuario es un socio
			clase.inscribirse(usuarioActual);
		}
	}

	// Getters and Setter

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<TipoClase> getTiposClase() {
		return tiposClases;
	}

	public ArrayList<TipoArticulo> getTiposArticulos() {
		return tiposArticulos;
	}

	public ArrayList<Sede> getSedes() {
		return sedes;
	}

	public void addTipoClase(TipoClase x) { // BORRAR
		tiposClases.add(x);
	}

}
