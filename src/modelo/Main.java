package modelo;

import vista.Login;
import vista.TablaArticuloInterfaz;

import java.awt.GraphicsEnvironment;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import controlador.WindowManagerSingleton;
import excepciones.UsuarioDuplicadoException;

public class Main {

	public static void main(String[] args) {

		SupertlonSingleton supertlonSingleton = SupertlonSingleton.getInstance();

		ArrayList<Sede> sedes = new ArrayList<Sede>();
		sedes.add(new Sede("Palermo", 100, Nivel.BLACK));
		sedes.add(new Sede("Flores", 50, Nivel.ORO));
		sedes.add(new Sede("Recoleta", 1000, Nivel.PLATINUM));
		sedes.add(new Sede("Caballito", 1000, Nivel.BLACK));
		sedes.add(new Sede("Abasto", 1100, Nivel.ORO));
		sedes.add(new Sede("Villa Urquiza", 200, Nivel.BLACK));
		sedes.add(new Sede("Chacarita", 5000, Nivel.PLATINUM));
		sedes.add(new Sede("Microcentro", 800, Nivel.PLATINUM));
		sedes.add(new Sede("San Nicolas", 1000, Nivel.ORO));

		supertlonSingleton.setSedes(sedes);

		var usuario5 = new SoporteTecnico("Simon", "Gonzalez", "1");

		try {
			supertlonSingleton.agregarUsuario(usuario5);
		} catch (UsuarioDuplicadoException e) {
			e.printStackTrace();
		}

		WindowManagerSingleton windowManager = WindowManagerSingleton.getInstance();
		windowManager.switchWindow(new Login());

	}

}
