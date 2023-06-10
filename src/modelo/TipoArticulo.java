package modelo;

import java.time.LocalDate;

import vista.ArticuloView;

public class TipoArticulo {
	private static int contador = 0;
	private int idTipoArticulo;
	private String nombre;
	private double precio;
	private int numeroUsos;
	private LocalDate fechaDeFabricacion;
	private TipoAmortizacion tipoAmortizacion;

	public TipoArticulo(String descripcion, double precio, int numeroUsos, LocalDate fechaDeFabricacion,
			TipoAmortizacion tipoAmortizacion) {
		this.nombre = descripcion;
		this.precio = precio;
		this.numeroUsos = numeroUsos;
		this.fechaDeFabricacion = fechaDeFabricacion;
		this.tipoAmortizacion = tipoAmortizacion;
		this.idTipoArticulo = contador;
		contador++;
	}

	public ArticuloView toView() {
		return new ArticuloView(idTipoArticulo, nombre, precio, numeroUsos);
	}

	public String getDescripcion() {
		return nombre;
	}

	public int getIdTipoArticulo() {
		return idTipoArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getNumeroUsos() {
		return numeroUsos;
	}

	public LocalDate getFechaDeFabricacion() {
		return fechaDeFabricacion;
	}

	public TipoAmortizacion getTipoAmortizacion() {
		return tipoAmortizacion;
	}

}
