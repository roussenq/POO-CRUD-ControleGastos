package view;

import java.util.Scanner;

import controller.ControladorUsuario;
import model.vo.UsuarioVO;

public class MenuUsuario {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_USUARIO_VOLTAR = 5;

	public void apresentarMenuUsuario() {
		int opcao = this.apresentarOpcoesUsuario();

		while (opcao != OPCAO_MENU_USUARIO_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_USUARIO: {
				this.cadastrarUsuario();
				break;
			}
			case OPCAO_MENU_CONSULTAR_USUARIO: {
				System.out.println("Usuário consultado!");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_USUARIO: {
				this.atualizarUsuario();
				break;
			}
			case OPCAO_MENU_EXCLUIR_USUARIO: {
				this.excluirUsuario();
				break;
			}
			default:
				System.out.println("\nOpção Inválida!");
				break;
			}
			opcao = this.apresentarOpcoesUsuario();
		} 

	}

	private void excluirUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		
		System.out.println("\nDigite o código do usuario: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		controladorUsuario.excluirUsuarioController(usuarioVO);
		
	}

	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		
		System.out.println("\nDigite o código do usuario: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nDigite o nome do usuario: ");
		usuarioVO.setNome(teclado.nextLine());
		System.out.println("\nDigite o cpf do usuario: ");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.println("\nDigite o telefone do usuario: ");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.println("\nDigite o login do usuario: ");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.println("\nDigite a senha do usuario: ");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		controladorUsuario.atualizarUsuarioController(usuarioVO);
		
	}

	private void cadastrarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		System.out.println("\nDigite o nome do usuario: ");
		usuarioVO.setNome(teclado.nextLine());
		System.out.println("\nDigite o cpf do usuario: ");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.println("\nDigite o telefone do usuario: ");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.println("\nDigite o login do usuario: ");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.println("\nDigite a senha do usuario: ");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		controladorUsuario.cadastrarUsuarioController(usuarioVO);
	}

	private int apresentarOpcoesUsuario() {
		System.out.println("-----====Usuários====-----");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - CADASTRAR USUARIO");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - CONSULTAR USUARIO");
		System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - ATUALIZAR USUARIO");
		System.out.println(OPCAO_MENU_EXCLUIR_USUARIO + " - EXCLUIR USUARIO");
		System.out.println(OPCAO_MENU_USUARIO_VOLTAR + " - VOLTAR");
		System.out.println("\nDigite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

}
