
public class Controle {
	public void startCommand(Comando cmd, int codigoLivro, int codigoUsuario) {
		cmd.execute(codigoLivro, codigoUsuario);
	}
	
	public Controle() {}
}
