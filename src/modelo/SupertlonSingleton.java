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

	// METODO SOPORTE TECNICO

	public void agregarUsuario(Usuario x) {
		usuarios.add(x);
	}

	public void agregarSede(Sede x) {
		for (Sede sede : sedes) {
			if (sede.getBarrio() == x.getBarrio()) {
				return;
				// Lanzar excepcion Sede ya existe
			}
		}
		sedes.add(x);
	}

	public void agregarTipoArticulo(TipoArticulo x) {
		tiposArticulos.add(x);
	}

	// READY
	public void agregarTipoClase(String nombreClase, boolean online,
			HashMap<Integer, List<CantidadDetalle>> cantidadArticulo) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soySoporteTecnico()) {
			TipoClase nuevoTipoClase = new TipoClase(nombreClase, online, cantidadArticulo);
			tiposClases.add(nuevoTipoClase);
		}
	}

	// METODO ADMINISTRATIVO

	public void agendarClase(TipoClase tipoClase, Sede sede, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		UsuarioSingleton usuarioSingleton = UsuarioSingleton.getInstance();
		Usuario usuarioActual = usuarioSingleton.getUsuarioActual();
		if (usuarioActual.soyAdministrativo()) {
		}
		sede.agendarClase(tipoClase, emplazamiento, dateInicio, dateFin);
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
