package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Sede {
	private String barrio;
	private double precioAlquiler;
	private Nivel nivel;
	private ArrayList<Articulo> articulos;
	private ArrayList<Clase> clases = new ArrayList<>();
	private ArrayList<Clase> clasesAlmacenadas = new ArrayList<>(); // DB Streaming - TODO
	private ArrayList<Emplazamiento> emplazamientos = new ArrayList<>();
	public Clase claseTest; // ELIMINAR

	public Sede(String barrio, double precioAlquiler, Nivel nivel) {
		this.barrio = barrio;
		this.precioAlquiler = precioAlquiler;
		this.nivel = nivel;
	}

	public void incorporarArticulo(TipoArticulo tipoArticulo, String descripcion, double precio) {
		articulos.add(new Articulo(tipoArticulo, descripcion, precio));
	}

	// READY
	public void agendarClase(TipoClase tipoClase, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		ArrayList<ArticuloCantidadDetalle> detalleCantidadesTotal = new ArrayList<>();
		HashMap<Integer, List<CantidadDetalle>> mapa = tipoClase.getCantidadArticulo();

		for (Entry<Integer, List<CantidadDetalle>> entry : mapa.entrySet()) {
			Integer idTipoArticulo = entry.getKey();
			List<CantidadDetalle> values = entry.getValue();
			for (CantidadDetalle estruct : values) {
				int cantTotal = estruct.getCantidadPorAlummo() * 2 + estruct.getCantidadPorProfesor(); // MODIFICAR PARA 30
				detalleCantidadesTotal
						.add(new ArticuloCantidadDetalle(idTipoArticulo, cantTotal, estruct.getDetalle()));
			}
		}

		System.out.println(detalleCantidadesTotal);

		if (verificarArticulosDisponibles(detalleCantidadesTotal)) {
			Clase nuevaClase = new Clase(this, tipoClase, emplazamiento, dateInicio, dateFin);
			claseTest = nuevaClase;
			clases.add(nuevaClase);
			System.out.println("CLASE CREADA CON EXITO");
			System.out.println(nuevaClase);
		} else {
			// LANZAR EXCEPCION
			System.out.println("NO ALCANZAN LOS ARTICULOS");
		}

	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	// READY
	private boolean verificarArticulosDisponibles(ArrayList<ArticuloCantidadDetalle> detalleCantidadesTotal) {
		for (ArticuloCantidadDetalle articuloCantidadDetalle : detalleCantidadesTotal) {
			int cantidadNecesaria = articuloCantidadDetalle.getCantidadTotal();
			for (Articulo item : articulos) {
				if (item.getIdTipoArticulo() == articuloCantidadDetalle.getIdTipoArticulo()
						&& item.getDescripcion() == articuloCantidadDetalle.getDetalle()) {
					cantidadNecesaria--;
				}
				if (cantidadNecesaria == 0) {
					break;
				}
			}
			if (cantidadNecesaria > 0) {
				return false;
			}
		}
		return true;
	}

	public String getBarrio() {
		return barrio;
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public ArrayList<Clase> getClasesAlmacenadas() {
		return clasesAlmacenadas;
	}

	public ArrayList<Emplazamiento> getEmplazamientos() {
		return emplazamientos;
	}

	@Override
	public String toString() {
		return "Sede [barrio=" + barrio + ", precioAlquiler=" + precioAlquiler + ", nivel=" + nivel + ", articulos="
				+ articulos + ", clases=" + clases + ", clasesAlmacenadas=" + clasesAlmacenadas + ", emplazamientos="
				+ emplazamientos + "]";
	}

}
