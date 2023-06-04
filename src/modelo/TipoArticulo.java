package modelo;

import java.time.LocalDate;

public class TipoArticulo {
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
	}

	public String getDescripcion() {
		return nombre;
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
