package modelo;

public class CantidadDetalle {
	private int cantidadPorAlummo;
	private int cantidadPorProfesor;
	private String detalle;

	public CantidadDetalle(int cantidadPorAlummo, int cantidadPorProfesor, String detalle) {
		this.cantidadPorAlummo = cantidadPorAlummo;
		this.cantidadPorProfesor = cantidadPorProfesor;
		this.detalle = detalle;
	}

	public int getCantidadPorAlummo() {
		return cantidadPorAlummo;
	}

	public int getCantidadPorProfesor() {
		return cantidadPorProfesor;
	}

	public String getDetalle() {
		return detalle;
	}
	
	
}
