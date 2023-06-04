package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import vista.ClaseView;

public class Clase {

	private Sede sede;
	private Socio[] socios = new Socio[30];
	private EstadoClase estado;
	private TipoClase tipo;
	private Profesor profesor;
	private Emplazamiento lugar;
	private LocalDate dia;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	
	/* TODO
	 * Hay que definir qué parámetros va a recibir el constructor de la clase.
	 */
	
	public void utilizarArticulos() {
		// TODO
	}
	
	private double calcularCostos() {
		// TODO
		return 0;
	}
	
	private double calcularIngresos() {
		// TODO
		return 0;
	}
	
	public double calcularRentabilidad() {
		// TODO
		return 0;
	}

	public Sede getSede() {
		return sede;
	}

	public Socio[] getSocios() {
		return socios;
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

	public LocalDate getDia() {
		return dia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}
	
	public ClaseView toView() {
		return new ClaseView(tipo, profesor, lugar, dia, horaInicio, horaFinal);
	}
	
}
