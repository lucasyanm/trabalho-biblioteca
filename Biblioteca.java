import java.util.*;

public class Biblioteca {
	private static Biblioteca instance;
	private List<Livro> livros = new ArrayList<Livro>(); 
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	private Biblioteca() {}
	
	public static Biblioteca getInstance() {
		if(instance == null) {
			instance = new Biblioteca();
			
			//Cadastro de usuarios//
			TipoDeUsuario graduando1 = new Graduando();
			instance.cadastrarUsuario(123, "João da Silva", graduando1);
			
			TipoDeUsuario posgraduando1 = new PosGraduando();
			instance.cadastrarUsuario(456, "Luiz Fernando Rodrigues", posgraduando1);
			
			TipoDeUsuario graduando2 = new Graduando();
			instance.cadastrarUsuario(789, "Pedro Paulo", graduando2);
			
			TipoDeUsuario professor1 = new Professor();
			instance.cadastrarUsuario(100, "Carlos Lucena", professor1);	
			
			//Cadastro de livros//
			List<Exemplar> exemplares = new ArrayList<Exemplar>();
			Exemplar exemplar1 = new Exemplar(1,"Disponivel");
			Exemplar exemplar2 = new Exemplar(2,"Disponivel");
			exemplares.add(exemplar1);
			exemplares.add(exemplar2);
			instance.cadastrarLivro(100,"Engenharia de Software", "AddisonWesley","Ian Sommervile",6,2000,(ArrayList<Exemplar>)exemplares);
			
			Exemplar exemplar3 = new Exemplar(3,"Disponivel");
			exemplares.clear();
			exemplares.add(exemplar3);
			instance.cadastrarLivro(101,"UML - Guia do Usuário", "Campus","Grady Booch, James Rumbaugh, Ivar Jacobson",7,2000,(ArrayList<Exemplar>)exemplares);
			
			Exemplar exemplar4 = new Exemplar(4,"Disponivel");
			exemplares.clear();
			exemplares.add(exemplar4);
			instance.cadastrarLivro(200,"Code Complete", "Microsoft Press","Steve McConnell",2,2014,(ArrayList<Exemplar>)exemplares);
			
			Exemplar exemplar5 = new Exemplar(5,"Disponivel");
			exemplares.clear();
			exemplares.add(exemplar5);
			instance.cadastrarLivro(201,"Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall","Robert Martin",1,2002,(ArrayList<Exemplar>)exemplares);
			
			Exemplar exemplar6 = new Exemplar(6,"Disponivel");
			Exemplar exemplar7 = new Exemplar(7,"Disponivel");
			exemplares.clear();
			exemplares.add(exemplar6);
			exemplares.add(exemplar7);
			instance.cadastrarLivro(300,"Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional","Martin Fowler",1,1999,(ArrayList<Exemplar>)exemplares);
			
			exemplares.clear();
			instance.cadastrarLivro(301,"Software Metrics: A Rigorous and Practical Approach", "CRC Press","Norman Fenton, James Bieman",3,2014,(ArrayList<Exemplar>)exemplares);
			
			Exemplar exemplar8 = new Exemplar(8,"Disponivel");
			Exemplar exemplar9 = new Exemplar(9,"Disponivel");
			exemplares.clear();
			exemplares.add(exemplar8);
			exemplares.add(exemplar9);
			instance.cadastrarLivro(400,"Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional","Martin Fowler",3,2003, (ArrayList<Exemplar>)exemplares);
			
			exemplares.clear();
			instance.cadastrarLivro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Adisson-Wesley Professional", "Martin Fowler", 3, 2003, (ArrayList<Exemplar>)exemplares);
		}
		return instance;
	}
	
	public Usuario getUsuarioPorCodigo(int codigo) {
		for (Usuario usuario : usuarios) {
			if(usuario.getCodigo() == codigo)
				return usuario;
		}
		return null;
	}
	
	public boolean verificarUsuario(int codigoUsuario) {
		if(this.getUsuarioPorCodigo(codigoUsuario) == null) {
			System.out.println("Usuario nao encontrado.");
			return false;
		}
		return true;
	}
	
	public boolean verificarLivro(int codigoLivro) {
		if(this.getLivroPorCodigo(codigoLivro) == null) {
			System.out.println("Livro nao encontrado.");
			return false;
		}
		return true;
	}
	
	public void cadastrarUsuario(int codigo, String nome, TipoDeUsuario tipoDeUsuario) {
		Usuario user = new Usuario(codigo, nome, tipoDeUsuario);
		usuarios.add(user);
	}
	
	public void cadastrarLivro(int codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao, ArrayList<Exemplar> exemplares) {
		Livro livro = new Livro(codigo, titulo, editora, autores, edicao, anoPublicacao);
		livros.add(livro);
		
		for(Exemplar exemplar : exemplares) {
			livro.insertExemplar(exemplar);
		}
	}
	
	public Livro getLivroPorCodigo(int codigo) {
		for (Livro livro : livros) {
			if(livro.getCodigo() == codigo)
				return livro;
		}
		return null;
	}
	
	public void setEmprestimo(int codigoLivro, int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		if(!this.verificarLivro(codigoLivro))
			return;
		
		boolean disponivel = false;
		Exemplar exemplarDisponivel = null;
		Livro livroCur = null;
		
		livroCur = getLivroPorCodigo(codigoLivro);
		
		for (Exemplar exemplar : livroCur.getExemplares()) {
			if(exemplar.getStatus().compareTo("Disponivel") == 0) {
				disponivel = true;
				exemplarDisponivel = exemplar;
				break;
			}
		}
		Usuario user = getUsuarioPorCodigo(codigoUsuario);
		
		if(!disponivel){
			System.out.println("Não há exemplares disponíveis.");
			System.out.println("Usuario: "+user.getNome()+"\nLivro: "+livroCur.getTitulo());	
			return;
		}		
		
		if(user.setEmprestimo(livroCur, exemplarDisponivel)) {
			System.out.println("Emprestimo realizado.");
			livroCur.removeReserva(user);
		}
		else System.out.println("Emprestimo nao realizado.");
		System.out.println("Usuario: "+user.getNome()+"\nLivro: "+livroCur.getTitulo());		
		
	}
	
	public void devolucao(int codigoLivro, int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		if(!this.verificarLivro(codigoLivro))
			return;
		
		Usuario user = getUsuarioPorCodigo(codigoUsuario);
		Livro livroCur = getLivroPorCodigo(codigoLivro);
		if(user.devolucao(codigoLivro))
			System.out.println("Devolucao Realizada.");
		else System.out.println("Devolucao nao realizada. Nao havia emprestimo do livro.");
		System.out.println("Usuario: "+user.getNome()+"\nLivro: "+livroCur.getTitulo());
	}
	
	public void setReserva(int codigoLivro, int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		if(!this.verificarLivro(codigoLivro))
			return;
		
		Reserva reserva = new Reserva(getLivroPorCodigo(codigoLivro).getTitulo(), Calendar.getInstance().getTime());
		Livro livro = getLivroPorCodigo(codigoLivro);
		Usuario user = getUsuarioPorCodigo(codigoUsuario);
		
		if(user.setReserva(reserva)) {
			livro.setReserva(user);
			if(livro.getQuantidadeReservas() == 2 ) {
				livro.notificarObservadores();
			}
			System.out.println("Reserva Realizada.");
		}
		else System.out.println("Reserva nao realizada.");
		System.out.println("Usuario: "+user.getNome()+"\nLivro: "+livro.getTitulo());				
	}
	
	public void setObserver(int codigoLivro, int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		if(!this.verificarLivro(codigoLivro))
			return;
		
		Usuario user = getUsuarioPorCodigo(codigoUsuario);
		Livro livro = getLivroPorCodigo(codigoLivro);
		
		livro.setObservador(user);
		System.out.println("Usuario "+user.getNome()+" sera notificado sobre o livro "+'"'+livro.getTitulo()+'"'+'.');
		return;	
	}
	
	public void consultarLivro(int codigoLivro) {
		if(!this.verificarLivro(codigoLivro))
			return;
		
		Livro livro = getLivroPorCodigo(codigoLivro);
		if(livro == null) {
			System.out.println("Livro nao encontrado.");
			return;
		}
		System.out.println("Título: "+ livro.getTitulo());
		System.out.println("Quantidade de reservas: "+livro.getQuantidadeReservas());
		if(livro.getQuantidadeReservas()!=0) {
			System.out.println("Usuarios com reserva deste livro: ");
			livro.PrintReservas();
		}
		System.out.println("Exemplares: ");
		for(Exemplar exemplar : livro.getExemplares()) {
			System.out.println("Código: "+exemplar.getCodigo()+" Estado: "+exemplar.getStatus());
			if(exemplar.getStatus().compareTo("Emprestado - Indisponível")==0) {
				System.out.println("Nome do usuario:"+exemplar.getEmprestimo().getNomeUsuario()+"\nData do emprestimo: "+ exemplar.getEmprestimo().getDataEmprestimo()+ "\nData de devolução prevista: "+exemplar.getEmprestimo().getDataDevolucaoPrevista());
			}
		}
	}
	
	public void consultarUsuario(int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		
		System.out.println("Emprestimos correntes: ");
		Usuario usuario = getUsuarioPorCodigo(codigoUsuario);
		for (Emprestimo emprestimo : usuario.getListaEmprestimos()) {
			System.out.println("Titulo: "+getLivroPorCodigo(emprestimo.getCodigoLivro()).getTitulo()+"\nData do emprestimo: "+emprestimo.getDataEmprestimo()+"\nData prevista para devolução: "+emprestimo.getDataDevolucaoPrevista());
		}
		System.out.println("Emprestimos passados: ");
		for (Emprestimo emprestimo : usuario.getListaEmprestimosPassados()) {
			System.out.println("Titulo: "+getLivroPorCodigo(emprestimo.getCodigoLivro()).getTitulo()+"\nData do emprestimo: "+emprestimo.getDataEmprestimo()+"\nData de devolução: "+emprestimo.getDevolucao());
		}
		
		System.out.println("Reservas: ");
		for (Reserva reserva : usuario.getListaReservas()) {
			System.out.println("Titulo: "+reserva.getTituloLivro()+"\nData da reserva: "+reserva.getDataReserva());
			
		}
	}
	
	
	public void consultarNotificacoes(int codigoUsuario) {
		if(!this.verificarUsuario(codigoUsuario))
			return;
		
		System.out.println("Quantidade de notificações: "+getUsuarioPorCodigo(codigoUsuario).getQuantidadeNotificacoes());
	}
	
	
}
