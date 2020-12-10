import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PosGraduando implements TipoDeUsuario {
	final private int limite = 4;
	final private int tempoEmprestimo = 4;
	
	@Override
	public boolean verifyEmprestimo(Livro livro, Usuario usuario) {
		ArrayList<Emprestimo> emprestimos = usuario.getListaEmprestimos();
		
		if(emprestimos.size() >= limite) {
			System.out.println("Limite de emprestimos excedido");
			return false;
		}
	
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getCodigoLivro() == livro.getCodigo()) {
				System.out.println("Usuário já possui emprestimo deste livro");
				return false;
			}
		}
		
		Calendar cal = new GregorianCalendar();

		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getDataDevolucaoPrevista().before(cal.getTime())) {
				System.out.println("Usuário possui devoluções pendentes");
				return false;
			}
		}
		
		ArrayList<Reserva> reservas = usuario.getListaReservas();
		for (Reserva reserva : reservas) {
			if(reserva.getTituloLivro() == livro.getTitulo()) {
				return true;
			}
		}
		
		if(livro.getQuantidadeReservas() >= livro.getQuantidadeExeplares()) {
			System.out.println("Emprestimo não pode ser realizado: Todos os exemplares estão reservados");
			return false;
		}
		
		
		return true;
	}
	
	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

}
