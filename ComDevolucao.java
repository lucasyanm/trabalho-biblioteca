
public class ComDevolucao implements Comando{
	private Biblioteca biblioteca;
	public ComDevolucao() {
		this.biblioteca = Biblioteca.getInstance();
	}

	@Override
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.devolucao(codigoLivro, codigoUsuario);
		
	}

}
