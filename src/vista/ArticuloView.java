package vista;

public class ArticuloView {
	private int idArticulo;
	private String nombre;
	private int numeroUsos;
	
	public ArticuloView(int idArticulo, String nombre, int numeroUsos) {
		this.idArticulo = idArticulo;
		this.nombre = nombre;
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

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroUsos(int numeroUsos) {
		this.numeroUsos = numeroUsos;
	}

	@Override
	public String toString() {
		return "ArticuloView [idArticulo=" + idArticulo + ", nombre=" + nombre + ", numeroUsos=" + numeroUsos + "]";
	}


}
