package modelo;

public class UsuarioSingleton {

	private Usuario usuarioActual;
	private static UsuarioSingleton instancia;

	private UsuarioSingleton() {
		this.usuarioActual = new SoporteTecnico("Admin", "Admin", "1234");
	};

	public static UsuarioSingleton getInstance() {
		if (instancia == null) {
			instancia = new UsuarioSingleton();
		}
		return instancia;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

}
