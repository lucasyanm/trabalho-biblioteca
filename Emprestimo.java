import java.util.Calendar;
import java.util.Date;
public class Emprestimo {
	private int codigoLivro;
	private int codigoUsuario;
	private String nomeUsuario;
	private Exemplar exemplar;
	private Date devolucaoPrevista;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	public Emprestimo(int codigoLivro, int codigoUsuario, Exemplar exemplar, Date devolucaoPrevista, Date dataEmprestimo, String nomeUsuario) {
		this.codigoLivro = codigoLivro;
		this.codigoUsuario = codigoUsuario;
		this.exemplar = exemplar;
		this.devolucaoPrevista = devolucaoPrevista;
		this.dataEmprestimo = dataEmprestimo;
		this.nomeUsuario = nomeUsuario;
	}

	public int getCodigoLivro() {
		return this.codigoLivro;
	}

	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}
	
	public Date getDataDevolucaoPrevista() {
		return devolucaoPrevista;
	}
	
	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public void devolucao() {
		exemplar.setEmprestimo(null);
		dataDevolucao = Calendar.getInstance().getTime();
	}
	
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}
	
	public Date getDevolucao() {
		return this.dataDevolucao;
	}
	
}	
