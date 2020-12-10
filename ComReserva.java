
public class ComReserva implements Comando{
	private Biblioteca biblioteca;
	public ComReserva() {
		this.biblioteca = Biblioteca.getInstance();
	}

	@Override
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.setReserva(codigoLivro, codigoUsuario);
		
	}

}
