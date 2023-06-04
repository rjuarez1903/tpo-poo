package modelo;

import java.util.ArrayList;

public class SupertlonSingleton {
	private static SupertlonSingleton instancia;
	private Usuario usuarioActual;
	private ArrayList<Usuario> usuarios;
	private ArrayList<TipoClase> tiposClases;
	private ArrayList<TipoArticulo> tiposArticulos;
	private ArrayList<Sede> sedes;

	private SupertlonSingleton() {
		this.usuarios = new ArrayList<Usuario>();
		this.tiposClases = new ArrayList<TipoClase>();
		this.tiposArticulos = new ArrayList<TipoArticulo>();
		this.sedes = new ArrayList<Sede>();
		this.usuarioActual = new SoporteTecnico("Admin", "Admin", "1234");
	};

	public static SupertlonSingleton getInstance() {
		if (instancia == null) {
			instancia = new SupertlonSingleton();
		}
		return instancia;
	}

	// Acceso
	public void ingresar(String dni) {
		for (Usuario usuario : usuarios) {
			if (usuario.dni == dni) {
				usuarioActual = usuario;
			}
		}
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	// Metodos Soporte Tecnico

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

	public void agregarTipoClase(TipoClase x) {
		tiposClases.add(x);
	}

	// Metodos Administrativo

	public void agregarArticulo(int idTipoArticulo, int cantidad, String barrio) {
		Sede sede = buscarSede(barrio);
		TipoArticulo tipoArticulo = buscarTipoArticulo(idTipoArticulo);
		if (sede != null && tipoArticulo != null) {
			for (int i = cantidad; i > 0; i--) {
				sede.incorporarArticulo(tipoArticulo);
			}
		}
	}

	// Metodos de busqueda

	private Sede buscarSede(String barrio) {
		for (Sede sede : sedes) {
			if (sede.getBarrio() == barrio) {
				return sede;
			}
		}
		return null;
	}

	private TipoArticulo buscarTipoArticulo(int idTipoArticulo) {
		for (TipoArticulo tipoArticulo : tiposArticulos) {
			if (tipoArticulo.getIdTipoArticulo() == idTipoArticulo) {
				return tipoArticulo;
			}
		}
		return null;
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

}
