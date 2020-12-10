
public class ComConsultarLivro implements Comando{
	private Biblioteca biblioteca;
	
	public ComConsultarLivro() {
		this.biblioteca = Biblioteca.getInstance();
	}

	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.consultarLivro(codigoLivro);
	}
}
