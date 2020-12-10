
public class ComEmprestimo implements Comando{
	private Biblioteca biblioteca;
	public ComEmprestimo() {
		this.biblioteca = Biblioteca.getInstance();
	}

	@Override
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.setEmprestimo(codigoLivro, codigoUsuario);
		
	}

}
