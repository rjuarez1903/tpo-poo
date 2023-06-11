package controlador;

import modelo.Clase;
import modelo.Sede;
import modelo.SupertlonSingleton;

public class SocioControlador {

	public void inscribirseClase(Clase clase) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.inscribirseClase(clase);
	}
}
