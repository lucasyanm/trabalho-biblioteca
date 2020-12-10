
public class Exemplar {
	private int codigo;
	private String status;
	private Emprestimo emprestimo;
	
	public Exemplar(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
		if(emprestimo != null)
			this.status = "Emprestado - Indisponível";
		else this.status = "Disponivel";
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getStatus() {
		return this.status;
	}
}
