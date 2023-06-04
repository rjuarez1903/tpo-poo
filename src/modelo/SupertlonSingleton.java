package modelo;

import java.util.ArrayList;

public class SupertlonSingleton {
	private static SupertlonSingleton instancia;
	private ArrayList<Usuario> usuarios;
	private ArrayList<TipoClase> tiposClase;
	private ArrayList<TipoArticulo> tiposArticulos;
	private ArrayList<Sede> sedes;

	private SupertlonSingleton() {
		this.usuarios = new ArrayList<Usuario>();
		this.tiposClase = new ArrayList<TipoClase>();
		this.tiposArticulos = new ArrayList<TipoArticulo>();
		this.sedes = new ArrayList<Sede>();
	};

	public static SupertlonSingleton getInstance() {
		if (instancia == null) {
			instancia = new SupertlonSingleton();
		}
		return instancia;
	}

	public void agregarUsuario(Usuario x) {
		usuarios.add(x);
	}

	public void agregarSede(Sede x) {
		if (sedes.size() < 49) {
			for (Sede sede : sedes) {
				if (sede.getBarrio() == x.getBarrio()) {
					return;
				}
			}
		}
		sedes.add(x);
	}

	public void agregarTipoArticulo(TipoArticulo x) {
		tiposArticulos.add(x);
	}

	public void agregarTipoClase(TipoClase x) {
		tiposClase.add(x);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public ArrayList<TipoClase> getTiposClase() {
		return tiposClase;
	}

	public ArrayList<TipoArticulo> getTiposArticulos() {
		return tiposArticulos;
	}

	public ArrayList<Sede> getSedes() {
		return sedes;
	}

}
