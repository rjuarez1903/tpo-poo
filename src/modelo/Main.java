package modelo;

import vista.TablaArticuloInterfaz;

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

public class Main {

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub
		 * 
		 * // ENTORNO PRUEBAS CREACION TIPO DE CLASE, AGENDAR CLASES
		 * 
		 * // Se crea una instancia de la clase SupertlonSingleton utilizando el método
		 * estático getInstance() SupertlonSingleton supertlonSingleton =
		 * SupertlonSingleton.getInstance();
		 * 
		 * // Se crean dos objetos de la clase TipoArticulo: colchoneta1 y pesa
		 * TipoArticulo colchoneta1 = new TipoArticulo("Colchoneta Softech", 20,
		 * TipoAmortizacion.USO); TipoArticulo pesa = new TipoArticulo("Pesa Pampero",
		 * 10, TipoAmortizacion.USO);
		 * 
		 * // Se crean varios objetos de la clase Articulo utilizando el constructor de
		 * la clase. // Cada objeto de Articulo está asociado a un objeto de
		 * TipoArticulo y tiene sus propias características (dimensiones y precio). //
		 * Estos objetos representan colchonetas y pesas con diferentes dimensiones y
		 * precios. Articulo colchoneta = new Articulo(colchoneta1, "2,5 x 8", 300);
		 * Articulo colchoneta5 = new Articulo(colchoneta1, "2,5 x 8", 300); Articulo
		 * colchoneta6 = new Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta7
		 * = new Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta8 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta9 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta10 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta11 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta12 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta13 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta14 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta15 = new
		 * Articulo(colchoneta1, "2,5 x 8", 300); Articulo colchoneta2 = new
		 * Articulo(colchoneta1, "1 x 3", 500); Articulo colchoneta3 = new
		 * Articulo(colchoneta1, "4 x 2", 600); Articulo colchoneta4 = new
		 * Articulo(colchoneta1, "2 x 5", 700); Articulo pesa1 = new Articulo(pesa,
		 * "10kg", 5000); Articulo pesa5 = new Articulo(pesa, "10kg", 5000); Articulo
		 * pesa6 = new Articulo(pesa, "10kg", 5000); Articulo pesa7 = new Articulo(pesa,
		 * "10kg", 5000); Articulo pesa8 = new Articulo(pesa, "10kg", 5000); Articulo
		 * pesa2 = new Articulo(pesa, "8kg", 2500); Articulo pesa3 = new Articulo(pesa,
		 * "6kg", 2000); Articulo pesa9 = new Articulo(pesa, "6kg", 2000); Articulo
		 * pesa10 = new Articulo(pesa, "6kg", 2000); Articulo pesa4 = new Articulo(pesa,
		 * "15kg", 7000);
		 * 
		 * // Se crea un ArrayList llamado "articulos" para almacenar los objetos de la
		 * clase Articulo creados anteriormente. // Los objetos de Articulo se agregan
		 * al ArrayList mediante el método add(). ArrayList<Articulo> articulos = new
		 * ArrayList<Articulo>(); articulos.add(colchoneta); articulos.add(colchoneta2);
		 * articulos.add(colchoneta3); articulos.add(colchoneta4);
		 * articulos.add(colchoneta5); articulos.add(colchoneta6);
		 * articulos.add(colchoneta7); articulos.add(colchoneta8);
		 * articulos.add(colchoneta9); articulos.add(colchoneta10);
		 * articulos.add(colchoneta11); articulos.add(colchoneta12);
		 * articulos.add(pesa1); articulos.add(pesa2); articulos.add(pesa3);
		 * articulos.add(pesa4); articulos.add(pesa5); articulos.add(pesa6);
		 * articulos.add(pesa7); articulos.add(pesa8); articulos.add(pesa9);
		 * articulos.add(pesa10);
		 * 
		 * 
		 * // Se crea un objeto de la clase Sede con el nombre "sedeTest", un valor de
		 * cuota mensual y un nivel de membresía. // Luego, se establece el ArrayList
		 * "articulos" creado anteriormente como los artículos disponibles en la sede.
		 * Sede sedeTest = new Sede("Recoelta", 35000, Nivel.PLATINUM);
		 * sedeTest.setArticulos(articulos); //Seteo manual de articulos para la sede en
		 * contexto de prueba
		 * 
		 * // Se crea un objeto de la clase Emplazamiento con el tipo y capacidad
		 * especificados Emplazamiento emplazamientoTest = new
		 * Emplazamiento(TipoEmplazamiento.SALON, 150);
		 * 
		 * // Se crean dos objetos de la clase LocalDateTime para representar fechas y
		 * horas de inicio y fin de clase respectivamente. LocalDateTime dateTime1 =
		 * LocalDateTime.of(2023, 6, 11, 10, 0); LocalDateTime dateTime2 =
		 * LocalDateTime.of(2023, 6, 11, 8, 30);
		 * 
		 * 
		 * // Se crea un HashMap llamado "cantidadPorArticulo" para almacenar
		 * información sobre la cantidad de cada tipo de artículo requerida. // La clave
		 * del HashMap es el id del tipo de artículo y el valor asociado es una lista de
		 * objetos CantidadDetalle // Esta informacion se obtendría de la interfaz
		 * gráfica // Interfaz para crear un Tipo de Clase. De aquí se obtendría la
		 * información para el hashMap. Descomentar para visualizar
		 * 
		 * // TablaArticuloInterfaz frame = new TablaArticuloInterfaz(articulos);
		 * //frame.setVisible(true)
		 * 
		 * HashMap<Integer, List<CantidadDetalle>> cantidadPorArticulo = new
		 * HashMap<>(); cantidadPorArticulo.put(0, new ArrayList<>());
		 * cantidadPorArticulo.get(0).add(new CantidadDetalle(1, 1, "2,5 x 8"));
		 * cantidadPorArticulo.put(1, new ArrayList<>());
		 * cantidadPorArticulo.get(1).add(new CantidadDetalle(2, 1, "10kg"));
		 * cantidadPorArticulo.get(1).add(new CantidadDetalle(1, 1, "6kg"));
		 * 
		 * 
		 * System.out.println("CREANDO TIPO CLASE"); // Se crea un objeto de la clase
		 * TipoClase con el nombre "tipoClaseTest", // especificando el nombre, un
		 * indicador booleano (online o no) y el HashMap "cantidadPorArticulo".
		 * TipoClase tipoClaseTest = new TipoClase("Tipo Clase Prueba", false,
		 * cantidadPorArticulo); // Se agrega el objeto "tipoClaseTest" al
		 * SupertlonSingleton utilizando el método addTipoClase().
		 * supertlonSingleton.addTipoClase(tipoClaseTest); // A modo de prueba
		 * 
		 * System.out.println("CREANDO CLASE");
		 * 
		 * // Se agrega una clase a la sede utilizando el método agendarClase() del
		 * SupertlonSingleton, // pasando como argumentos el objeto "tipoClaseTest", la
		 * sede, el emplazamiento y las fechas/horas.
		 * supertlonSingleton.agendarClase(tipoClaseTest, sedeTest, emplazamientoTest,
		 * dateTime1, dateTime2);
		 * 
		 * // Se crean dos objetos de la clase Socio con diferentes nombres, apellidos,
		 * números de identificación y niveles de membresía // a modo de prueba Socio
		 * socioTest1 = new Socio("Socio Test1", "Sanza", "1234", Nivel.PLATINUM); Socio
		 * socioTest2 = new Socio("Socio Test2", "PEREZ", "12345", Nivel.PLATINUM);
		 * 
		 * // Se inscribe a los socios en la clase de la sede utilizando el método
		 * inscribirse() de la clase Clase. // claseTest es una var publica que almacena
		 * la clase creada a modo de prueba sedeTest.claseTest.inscribirse(socioTest1);
		 * sedeTest.claseTest.inscribirse(socioTest2);
		 * 
		 * ;
		 * 
		 */

		var clase1 = new Clase(null, null, null, LocalDateTime.of(2023, 6, 10, 16, 0),
				LocalDateTime.of(2023, 6, 10, 17, 0));
		var clase2 = new Clase(null, null, null, LocalDateTime.of(2023, 6, 10, 9, 0),
				LocalDateTime.of(2023, 6, 10, 10, 0));

		var clases = new ArrayList<Clase>();

		var hora1 = LocalDateTime.of(2023, 6, 10, 16, 0);
		var hora2 = LocalDateTime.of(2023, 6, 10, 10, 0);

		clases.add(clase1);
		clases.add(clase2);

		for (Clase clase : clases) {
			System.out.println(clase);
		}

		Clase[] claseDelDiaArray = clases.toArray(new Clase[clases.size()]);

		Arrays.sort(claseDelDiaArray, Comparator.comparing(Clase::getHoraInicio));
		
		for (Clase claseDelDia : claseDelDiaArray) {
			System.out.println(claseDelDia);
		}

	}

}
