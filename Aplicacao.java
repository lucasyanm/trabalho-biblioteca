import java.util.Scanner;

public class Aplicacao {
	public static void main(String[] args) {		
		//Inicio da aplicacao//		
		Scanner reader = new Scanner(System.in);
		int codigoUsuario, codigoLivro;
		System.out.println("UBFA 2018.2 MATA62 - Biblioteca\nDocente: Claudio Nogueira Sant Anna\nDicentes:\n-Lucas Yan Melo de Carvalho\n-Alisson Oliveira Souza\n\n");
		System.out.println("Sistema da Biblioteca aberto.");
		
		String cmd = reader.next();
		Sistema sistemaInstancia = Sistema.getInstance();
		while(cmd.compareTo("sai") != 0) {			
			if(cmd.compareTo("emp") == 0) {
				codigoUsuario = reader.nextInt();
				codigoLivro = reader.nextInt();
				sistemaInstancia.emprestimo(codigoLivro, codigoUsuario);
			}
			else if(cmd.compareTo("dev") == 0) {
				codigoUsuario = reader.nextInt();
				codigoLivro = reader.nextInt();
				sistemaInstancia.devolucao(codigoLivro, codigoUsuario);
			}
			else if(cmd.compareTo("rsv") == 0) {
				codigoUsuario = reader.nextInt();
				codigoLivro = reader.nextInt();
				sistemaInstancia.reserva(codigoLivro, codigoUsuario);
			}
			else if(cmd.compareTo("obs") == 0){
				codigoUsuario = reader.nextInt();
				codigoLivro = reader.nextInt();
				sistemaInstancia.observar(codigoLivro, codigoUsuario);
			}
			else if(cmd.compareTo("liv") == 0) {
				codigoLivro = reader.nextInt();
				sistemaInstancia.consultarLivro(codigoLivro);
			}
			else if(cmd.compareTo("usu") == 0) {
				codigoUsuario = reader.nextInt();
				sistemaInstancia.consultarUsuario(codigoUsuario);
			}
			else if(cmd.compareTo("ntf") == 0){
				codigoUsuario = reader.nextInt();
				sistemaInstancia.consultarNotificacoes(codigoUsuario);
			}
			else System.out.println("Entrada incorreta.");
			cmd = reader.next();		
		}
		System.out.println("Sistema da Biblioteca encerrado.");
		reader = null;
	}
}
