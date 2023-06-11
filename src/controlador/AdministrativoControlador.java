package controlador;

import java.time.LocalDateTime;
import java.util.Date;

import modelo.Emplazamiento;
import modelo.Sede;
import modelo.SupertlonSingleton;
import modelo.TipoClase;

public class AdministrativoControlador {

	public void agendarClase(TipoClase tipoClase, Sede sede, Emplazamiento emplazamiento, LocalDateTime dateInicio,
			LocalDateTime dateFin) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.agendarClase(tipoClase, sede, emplazamiento, dateInicio, dateFin);
	}
}
