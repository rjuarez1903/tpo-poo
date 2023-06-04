package modelo;

import java.util.List;

public class TipoClase {
	private String nombre;
	private List<RelacionCantidadArticulo> materiales;
	private boolean isOnline;
	
	public TipoClase(String nombre, List<RelacionCantidadArticulo> materiales, boolean isOnline) {
		this.nombre = nombre;
		this.materiales = materiales;
		this.isOnline = isOnline;
	}

	public String getNombre() {
		return nombre;
	}

	public List<RelacionCantidadArticulo> getMateriales() {
		return materiales;
	}

	public boolean isOnline() {
		return isOnline;
	}
	
}
