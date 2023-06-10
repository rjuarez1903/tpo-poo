package vista;

public class ArticuloView {
	private int idArticulo;
	private String nombre;
	private double precio;
	private int numeroUsos;

	public ArticuloView(int idArticulo, String nombre, double precio, int numeroUsos) {
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.numeroUsos = numeroUsos;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumeroUsos() {
		return numeroUsos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public void setNombre(String nombre) {
	}

	public void setNumeroUsos(int numeroUsos) {
		this.numeroUsos = numeroUsos;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ArticuloView [idArticulo=" + idArticulo + ", nombre=" + nombre + ", precio=" + precio + ", numeroUsos="
				+ numeroUsos + "]";
	}

}
