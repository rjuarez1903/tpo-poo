package vista;

public class TipoArticuloView {
	private int idTipoArticulo;
	private String nombre;
	private double precio;
	private int numeroUsos;

	public TipoArticuloView(int idTipoArticulo, String nombre, double precio, int numeroUsos) {
		this.idTipoArticulo = idTipoArticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.numeroUsos = numeroUsos;
	}

	@Override
	public String toString() {
		return "TipoArticuloView [idTipoArticulo=" + idTipoArticulo + ", nombre=" + nombre + ", precio=" + precio
				+ ", numeroUsos=" + numeroUsos + "]";
	}

	public void setIdTipoArticulo(int idTipoArticulo) {
		this.idTipoArticulo = idTipoArticulo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setNumeroUsos(int numeroUsos) {
		this.numeroUsos = numeroUsos;
	}

	public int getIdTipoArticulo() {
		return idTipoArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumeroUsos() {
		return numeroUsos;
	}

}
