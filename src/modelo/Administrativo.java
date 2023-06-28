package modelo;

import java.util.List;

public class Administrativo extends Usuario {
	@Override
	public String toString() {
		return "Administrativo [sedes=" + sedes + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}

	private List<Sede> sedes;

	public Administrativo(String nombre, String apellido, String numeroDeDocumento, List<Sede> sedes) {
		super(nombre, apellido, numeroDeDocumento);
		this.sedes = sedes;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public List<Sede> getSedes() {
		return sedes;
	}
	
	public boolean soyAdministrativo() {
		return true;
	}

}
