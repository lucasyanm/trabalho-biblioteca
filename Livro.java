import java.util.*;

public class Livro implements Notificador{
	private int codigo;
	private String titulo;
	private String editora;
	private String autores;
	private int edicao;
	private int anoPublicacao;
	private List<Usuario> reservas = new ArrayList<Usuario>();
	private List<Exemplar> exemplares = new ArrayList<Exemplar>();
	private List<Observador> observadores = new ArrayList<Observador>();
	
	public Livro(int codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	}
	
	public void insertExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);	
	}
	
	public int getQuantidadeReservas() {
		return reservas.size();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setReserva(Usuario usuario) {
		this.reservas.add(usuario);
	}
	
	public void notificarObservadores() {
		for (Observador observador : observadores) {
			observador.update();
		}
	}
	
	public void setObservador(Observador observador) {
		this.observadores.add(observador);
	}
	
	public void removeObservador(Observador observador) {
		observadores.remove(observador);
	}
	
	public ArrayList<Exemplar> getExemplares(){
		return (ArrayList<Exemplar>) this.exemplares;
	}
	
	public int getQuantidadeExeplares() {
		return exemplares.size();
	}
	
	public void PrintReservas() {
		for (Usuario usuario : reservas) {
			System.out.println(usuario.getNome());
		}
	}
	
	public void removeReserva(Usuario user) {
		this.reservas.remove(user);
	}
}
