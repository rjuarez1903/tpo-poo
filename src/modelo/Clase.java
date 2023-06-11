package modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Clase {

	private Sede sede;
	private ArrayList<Socio> sociosInscriptos = new ArrayList<>();
	private ArrayList<Articulo> articulosDeClase = new ArrayList<>();
	private EstadoClase estado;
	private TipoClase tipo;
	private Profesor profesor;
	private Emplazamiento lugar;
	private LocalDateTime horaInicio;
	private LocalDateTime horaFinal;
	private double costoClase, ingresoClase;

	public Clase(Sede sede, TipoClase tipo, Emplazamiento lugar, LocalDateTime horaInicio, LocalDateTime horaFinal) {
		this.sede = sede;
		this.estado = EstadoClase.AGENDADA;
		this.tipo = tipo;
		this.lugar = lugar;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	public void utilizarArticulos() {
		// TODO
	}

	private void calcularCostos() {
		var duracion = Duration.between(horaInicio, horaFinal).toHours();

		double costoEmplazamiento;
		double costoAmortizacion;

		if (lugar.getTipoEmplazamiento() == TipoEmplazamiento.SALON) {
			costoEmplazamiento = sede.getPrecioAlquiler() / 300;
		} else if (lugar.getTipoEmplazamiento() == TipoEmplazamiento.PILETA) {
			costoEmplazamiento = sede.getPrecioAlquiler() / 150;
		} else {
			costoEmplazamiento = lugar.getSuperficie() * duracion * 500;
		}

	}

	private void calcularIngresos() {

	}

	public double calcularRentabilidad() {
		// TODO
		return 0;
	}

	public void inscribirse(Usuario socio) {
		if (sociosInscriptos.size() <= 30) {
			sociosInscriptos.add((Socio) socio);
			incorporarArticulos();
		} else {
			// LANZAR EXPCEPCION
		}
		System.out.println(this);
	}

	private void incorporarArticulos() {
		ArrayList<ArticuloCantidadDetalle> detalleCantidadesTotal = new ArrayList<>();
		HashMap<Integer, List<CantidadDetalle>> mapa = tipo.getCantidadArticulo();
		ArrayList<Articulo> articulosClaseAux = new ArrayList<>();

		for (Entry<Integer, List<CantidadDetalle>> entry : mapa.entrySet()) {
			Integer idTipoArticulo = entry.getKey();
			List<CantidadDetalle> values = entry.getValue();
			for (CantidadDetalle estruct : values) {
				int cantTotal = estruct.getCantidadPorAlummo() * sociosInscriptos.size()
						+ estruct.getCantidadPorProfesor();
				detalleCantidadesTotal
						.add(new ArticuloCantidadDetalle(idTipoArticulo, cantTotal, estruct.getDetalle()));
			}
		}

		for (ArticuloCantidadDetalle articuloCantidadDetalle : detalleCantidadesTotal) {
			int cantidadNecesaria = articuloCantidadDetalle.getCantidadTotal();
			for (Articulo item : sede.getArticulos()) {
				if (item.getIdTipoArticulo() == articuloCantidadDetalle.getIdTipoArticulo()
						&& item.getDescripcion() == articuloCantidadDetalle.getDetalle()) {
					articulosClaseAux.add(item);
					cantidadNecesaria--;
				}
				if (cantidadNecesaria == 0) {
					break;
				}
			}
		}
		articulosDeClase = articulosClaseAux;
	}

	public Sede getSede() {
		return sede;
	}

	public ArrayList<Socio> getSocios() {
		return sociosInscriptos;
	}

	@Override
	public String toString() {
		return "Clase [sociosInscriptos=" + sociosInscriptos + ", articulosDeClase="
				+ articulosDeClase + ", estado=" + estado + ", tipo=" + tipo + ", profesor=" + profesor + ", lugar="
				+ lugar + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", costoClase=" + costoClase
				+ ", ingresoClase=" + ingresoClase + "]";
	}

	public EstadoClase getEstado() {
		return estado;
	}

	public TipoClase getTipo() {
		return tipo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Emplazamiento getLugar() {
		return lugar;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public LocalDateTime getHoraFinal() {
		return horaFinal;
	}

}
