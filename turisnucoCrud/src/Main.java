import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int op = 1;
		do {
			System.out.println("---------------------MENU-----------------------");
			System.out.println("1 - LOGIN / CADASTRO");
			System.out.println("2 - Buscar viagem");
			System.out.println("3 - Excluir cadastro");
			System.out.println("4 - Editar cadastro");
			op = scan.nextInt();
			
			switch(op) {
				case 1: 
					login();
					break;
				
				case 2:
					buscarViagem();
					break;
				
				case 3:
					excluirCadastro();
					break;
				
				case 4:
					editarCadastro();
					break;
					
				default:
					if(op != 0) {
						System.out.println("Digite uma opção válida!");
					}
			}
		}while(op != 0);
	}
	
	public static Usuario login() {
		Connection conn = null;
		PreparedStatement pstm = null;
	
		Scanner scan = new Scanner(System.in);
		Usuario usuario = new Usuario();
		System.out.println("----------LOGIN----------");
		System.out.println("Não possui uma conta? Digite 'criar conta' para criar uma conta.");
		System.out.print("Email: ");
		
		String email = scan.nextLine();
		String senha;
		if(verificarInput(email)) {
			System.out.print("Senha: ");
			senha = scan.nextLine();
			if(verificarInput(senha)) {
				System.out.println("Login efetuado com sucesso");
				String nome = "nome do usuario";
				
				usuario.setEmail(email);
				usuario.setNome(nome);
				usuario.setSenha(senha);
			}
		}
		
		return usuario;
	
	}
	
	public static boolean verificarInput(String input) {
		if(input.equals("criar conta")) {
			cadastro();	
			return false;
		}
		return true;
	}
	
	public static void cadastro() {
		Scanner scan = new Scanner(System.in);
		
		int erro;
		
		do {
		erro = 0;
		
		System.out.println("----------CADASTRO----------");
		
		System.out.print("EMAIL: ");
		String email = scan.nextLine();
		
		System.out.print("NOME: ");
		String nome = scan.nextLine();
		
		System.out.print("Senha: ");
		String senha = scan.nextLine();
		
		System.out.print("Confirmar senha: ");
		String confirmarSenha = scan.nextLine();
		
		if(email == "") {
			erro = 1;
		}else if(nome == "") {
			erro = 2;
		}else if(senha == "") {
			erro = 3;
		}else if(confirmarSenha == "") {
			erro = 4;
		}else if(!senha.equals(confirmarSenha)) {
			erro = 5;
		}else {
			System.out.println("está certo");
			Usuario usuario = new Usuario(nome, email, senha);
			usuario.criar();
			
				System.out.println("Cadastro efetuado com sucesso");
			
		}
		
		if(erro != 0) {
			switch(erro) {
				case 1:
					System.out.println("Email não pode ser vazio");
					break;
				case 2:
					System.out.println("Nome não pode ser vazio");
					break;
				case 3:
					System.out.println("Senha não pode ser vazio");
					break;
				case 4:
					System.out.println("Confirmar senha não pode ser vazio");
					break;
				case 5:
					System.out.println("As senhas não são iguais");
					break;
				default:
					if(erro != 0) {
						System.out.println("Erro ao se cadastrar!");
					}
			}
		}
		
		}while(erro != 0);
		
	}
	
	public static void buscarViagem() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----------BUSCAR VIAGEM---------");
		
		System.out.print("Digite o código da viagem: ");
		int codigo = scan.nextInt();
		
		if(codigo != 0) {
			String origem = "";
			String dataOrigem = "";
			
			String destino = "";
			String dataDestino = "";
			
			String nome = "";
			Double valor = 0.0;
			
			System.out.println("Origem: " + origem);
			System.out.println("Data de origem: " + dataOrigem);
			
			
			System.out.println("Destino: " + destino);
			System.out.println("Data de destino: " + dataDestino);
			
			System.out.println("Nome: " + nome);
			System.out.println("Valor: " + valor);
			
		}
	}
	
	public static void excluirCadastro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------EXCLUIR CADASTRO----------");
		
		Usuario usuario = login();
		
		if(!usuario.equals(new Usuario())) {
			System.out.println("Quer apagar sua conta? 1 - SIM / 0 - NÃO");
			int op = scan.nextInt();
			if(op == 1) {
				System.out.println("Conta do email '"+usuario.getEmail()+"' foi apagada com sucesso!");
			}
		}
	}
	
	public static void editarCadastro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------EDITAR CADASTRO----------");
		
		Usuario usuario = login();
		
		if(!usuario.equals(new Usuario())) {
			System.out.println("Digite 0 para manter o mesmo ou digite o novo valor.");
			
			System.out.print("Email: ");
			String email = scan.nextLine();
			
			if(email.equals("0")) {
				email = usuario.getEmail();
			}
			
			System.out.print("Nome: ");
			String nome = scan.nextLine();
			
			if(nome.equals("0")) {
				nome = usuario.getNome();
			}
			
			System.out.print("Senha: ");
			String senha = scan.nextLine();
			
			if(senha.equals("0")) {
				senha = usuario.getSenha();
			}
			
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.atualizar();
			
			System.out.println("Edição efetuada com sucesso!");
		}
	}
}
