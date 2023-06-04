package modelo;

import java.util.List;

public class Administrativo extends Usuario {
	// TODO

	/*
	 * Metodo incorporar articulo debe recibir como argumento una string para
	 * comparar con descripcion del tipo de articulo o recibir el tipo de articulo
	 * en sí (habría que ver de donde lo obtiene en ese caso) Analizar cual opcion
	 * es mas factible Si lo recibe como string, se debe hacer un get al supertlon
	 * para que devuelva los tipos de articulos para poder comparar, recuperar el
	 * objeto tipo articulo y pasarselo a la funcion
	 * 
	 * Considerar tambien parametro int cantidad como habiamos hablado
	 * 
	 * Tambien considear que el articulo se debe añadir a una sede, la cual debe
	 * estar dentro del array de sedes del administrativo
	 * 
	 * incorporar(String/TipoArticulo, int, String/Sede){ -- recupera el objeto --
	 * for (cantidad){ Articulo art = new Articulo (TipoArticulo)
	 * sede.agregarArticulo(art) }
	 * 
	 * }
	 * 
	 * 
	 */
	private List<Sede> sedes;

	public Administrativo(String nombre, String apellido, String numeroDeDocumento, List<Sede> sedes) {
		super(nombre, apellido, numeroDeDocumento);
		this.sedes = sedes;
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

	public List<Sede> getSedes() {
		return sedes;
	}

	public void incorporarArticulo(int idTipoArticulo, int cantidad, String barrio) {
		// TODO
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.agregarArticulo(idTipoArticulo, cantidad, barrio);
	}

	public void darDeBajaArticulo() {
		// TODO
	}

	public void cambiarEstadoClase() {
		// TODO
	}

	public void darAltaSocio() {
		// TODO
	}

	public void modificarSocio() {
		// TODO
	}

}
