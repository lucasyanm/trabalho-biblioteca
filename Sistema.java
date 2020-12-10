
public class Sistema {
	private static Sistema sistema;
	private Controle controle = new Controle();

	
	private Sistema() {}
	
	public static Sistema getInstance() {
		if(sistema==null)
			sistema = new Sistema();
		return sistema;
	}
	
	public void emprestimo(int codigoLivro, int codigoUsuario) {
		Comando comando = new ComEmprestimo();
		controle.startCommand(comando, codigoLivro, codigoUsuario);
	}
	
	public void devolucao(int codigoLivro, int codigoUsuario) {
		Comando comando = new ComDevolucao();
		controle.startCommand(comando, codigoLivro, codigoUsuario);
	}
	
	public void reserva(int codigoLivro, int codigoUsuario) {
		Comando comando = new ComReserva();
		controle.startCommand(comando, codigoLivro, codigoUsuario);
	}
	
	public void observar(int codigoLivro, int codigoUsuario) {
		Comando comando = new ComObservar();
		controle.startCommand(comando, codigoLivro, codigoUsuario);
	}
	
	public void consultarLivro(int codigoLivro){
		Comando comando = new ComConsultarLivro();
		controle.startCommand(comando, codigoLivro, 0);
	}
	
	public void consultarUsuario(int codigoUsuario) {
		Comando comando = new ComConsultarUsuario();
		controle.startCommand(comando, 0, codigoUsuario);
	}
	
	public void consultarNotificacoes(int codigoUsuario) {
		Comando comando = new ComConsultarNotificacoes();
		controle.startCommand(comando, 0, codigoUsuario);
	}
}
