
public class ComObservar implements Comando{
	private Biblioteca biblioteca;
	public ComObservar() {
		this.biblioteca = Biblioteca.getInstance();
	}
	
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.setObserver(codigoLivro, codigoUsuario);
	}
}
