
public class ComConsultarUsuario implements Comando{
	private Biblioteca biblioteca;
	public ComConsultarUsuario() {
		this.biblioteca = Biblioteca.getInstance();
	}
	
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.consultarUsuario(codigoUsuario);
	}
}
