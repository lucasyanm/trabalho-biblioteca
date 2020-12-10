
public class ComConsultarNotificacoes implements Comando {
	private Biblioteca biblioteca;
	public ComConsultarNotificacoes() {
		this.biblioteca = Biblioteca.getInstance();
	}
	
	public void execute(int codigoLivro, int codigoUsuario) {
		biblioteca.consultarNotificacoes(codigoUsuario);
	}
}
