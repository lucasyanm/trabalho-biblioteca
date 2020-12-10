import java.util.*;

public class Usuario implements Observador{
	private int codigo;
	private String nome;
	private List<Emprestimo> emprestimosAtuais = new ArrayList<Emprestimo>();
	private List<Emprestimo> emprestimosPassados = new ArrayList<Emprestimo>();
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private TipoDeUsuario tipoDeUsuario;
	private int quantidadeNotificacoes = 0;
	
	public Usuario(int codigo, String nome, TipoDeUsuario tipoDeUsuario) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipoDeUsuario = tipoDeUsuario;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean setEmprestimo(Livro livro, Exemplar exemplar) {
		if(this.tipoDeUsuario.verifyEmprestimo(livro, this)) {
			Calendar cal = Calendar.getInstance();
			Date atualDate = cal.getTime();
			
			cal.add(Calendar.DATE, tipoDeUsuario.getTempoEmprestimo());
			Emprestimo emprestimo = new Emprestimo(livro.getCodigo(), this.codigo, exemplar, cal.getTime(), atualDate, this.nome);
			cal.add(Calendar.DATE, -(tipoDeUsuario.getTempoEmprestimo()));
			
			emprestimosAtuais.add(emprestimo);
			exemplar.setEmprestimo(emprestimo);
			
			for(Reserva reserva : this.reservas) {
				if(reserva.getTituloLivro() == livro.getTitulo()) {
					this.reservas.remove(reserva);
					break;
				}
			}
			return true;
		}
		return false;
	}	
	
	public boolean devolucao(int codigoLivro) {
		for (Emprestimo emprestimo : emprestimosAtuais) {
			if(emprestimo.getCodigoLivro() == codigoLivro) {
				emprestimo.devolucao();
				emprestimosPassados.add(emprestimo);
				emprestimosAtuais.remove(emprestimo);
				return true;
			}
		}
		return false;
	}
	
	public boolean setReserva(Reserva reserva) {
		if(reservas.size()>=3) {
			System.out.println("Limite de reservas excedido.");
			return false;
		}
		reservas.add(reserva);
		return true;
	}
	
	public ArrayList<Reserva> getListaReservas(){
		return (ArrayList<Reserva>) this.reservas;
	}
	
	public ArrayList<Emprestimo> getListaEmprestimos(){
		return (ArrayList<Emprestimo>) this.emprestimosAtuais;
	}
	
	public ArrayList<Emprestimo> getListaEmprestimosPassados(){
		return (ArrayList<Emprestimo>) this.emprestimosPassados;
	}

	@Override
	public void update() {
		this.quantidadeNotificacoes++;		
	}

	@Override
	public int getQuantidadeNotificacoes() {
		return this.quantidadeNotificacoes;
	}
	
	
}
