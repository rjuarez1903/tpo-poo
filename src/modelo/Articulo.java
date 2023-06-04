package modelo;

import vista.ArticuloView;

import java.time.LocalDate;

public class Articulo {
	private static int contador = 0;
	private int idArticulo;
	private boolean isActive;
	private String nombre;
	private double precio;
	private int numeroUsos;
	private LocalDate fechaDeFabricacion;
	private TipoAmortizacion tipoAmortizacion;

	public Articulo(TipoArticulo tipoArticulo) {
		this.isActive = true;
		this.idArticulo = Articulo.contador;
		this.nombre = tipoArticulo.getDescripcion();
		this.precio = tipoArticulo.getPrecio();
		this.numeroUsos = tipoArticulo.getNumeroUsos();
		this.fechaDeFabricacion = tipoArticulo.getFechaDeFabricacion();
		this.tipoAmortizacion = tipoArticulo.getTipoAmortizacion();
		Articulo.contador++;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public boolean getIsActive() {
		return isActive;
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
	
	public void usarArticulo() {
		
	}
	
	public ArticuloView toView() {
		return new ArticuloView(idArticulo, nombre, numeroUsos);
	}


}
