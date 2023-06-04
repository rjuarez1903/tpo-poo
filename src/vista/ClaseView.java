package vista;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Emplazamiento;
import modelo.Profesor;
import modelo.TipoClase;

public class ClaseView {
	private TipoClase tipo;
	private Profesor profesor;
	private Emplazamiento lugar;
	private LocalDate dia;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	
	public ClaseView(TipoClase tipo, Profesor profesor, Emplazamiento lugar, LocalDate dia, LocalTime horaInicio,
			LocalTime horaFinal) {
		super();
		this.tipo = tipo;
		this.profesor = profesor;
		this.lugar = lugar;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
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

	public void setTipo(TipoClase tipo) {
		this.tipo = tipo;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public void setLugar(Emplazamiento lugar) {
		this.lugar = lugar;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Override
	public String toString() {
		return "ClaseView [tipo=" + tipo + ", profesor=" + profesor + ", lugar=" + lugar + ", dia=" + dia
				+ ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + "]";
	}

}
