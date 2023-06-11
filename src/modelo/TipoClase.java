package modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TipoClase {
	private String nombre;
	private boolean online;
	private HashMap<Integer, List<CantidadDetalle>> cantidadArticulo;

	public HashMap<Integer, List<CantidadDetalle>> getCantidadArticulo() {
		return cantidadArticulo;
	}

	public TipoClase(String nombre, boolean online, HashMap<Integer, List<CantidadDetalle>> cantidadArticulo) {
		this.nombre = nombre;
		this.online = online;
		this.cantidadArticulo = cantidadArticulo;
	}
	

	@Override
	public String toString() {
		return "TipoClase [nombre=" + nombre + ", online=" + online + ", cantidadArticulo=" + cantidadArticulo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public boolean esOnline() {
		return online;
	}

}
