package controlador;

import excepciones.InscripcionNoDisponibleException;
import modelo.Clase;
import modelo.Sede;
import modelo.SupertlonSingleton;

public class SocioControlador {

	public void inscribirseClase(Clase clase) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		try {
			supertlonSingleton.inscribirseClase(clase);
		} catch (InscripcionNoDisponibleException e) {

			e.printStackTrace();
		}
	}
}
