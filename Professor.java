import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Professor implements TipoDeUsuario {
	private final int tempoEmprestimo = 7;
	
	@Override
	public boolean verifyEmprestimo(Livro livro, Usuario usuario) {
		ArrayList<Emprestimo> emprestimos = usuario.getListaEmprestimos();
		
		Calendar cal = new GregorianCalendar();

		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getDataDevolucaoPrevista().before(cal.getTime())) {
				System.out.println("Usuário possui devoluções pendentes");
				return false;
			}
		}
		
		
		return true;
	}
	
	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

}
