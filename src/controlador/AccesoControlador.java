package controlador;

import modelo.SupertlonSingleton;

public class AccesoControlador {

	public void ingresar(String dni) {
		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();
		supertlonSingleton.ingresar(dni);
	}
	
}
