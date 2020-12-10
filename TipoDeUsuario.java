import java.util.ArrayList;

public interface TipoDeUsuario {
	public boolean verifyEmprestimo(Livro livro, Usuario usuario);
	public int getTempoEmprestimo();
}
