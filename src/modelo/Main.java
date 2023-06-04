package modelo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupertlonSingleton gym = SupertlonSingleton.getInstance();

		var art1 = new TipoArticulo("Colchoneta de alta densisdad marca Pampero", 200, 20, null, TipoAmortizacion.USO);
		var colchoneta = new Articulo(art1);
		var colchoneta2 = new Articulo(art1);
		
	}

}
