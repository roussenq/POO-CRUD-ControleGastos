package view;

import java.util.ArrayList;
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
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_VOLTAR = 3;

	public void apresentarMenuUsuario() {
		int opcao = this.apresentarOpcoesUsuario();

		while (opcao != OPCAO_MENU_USUARIO_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_USUARIO: {
				this.cadastrarUsuario();
				break;
			}
			case OPCAO_MENU_CONSULTAR_USUARIO: {
				this.consultarUsuario();
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

	private void consultarUsuario() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		while (opcao != OPCAO_MENU_CONSULTAR_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODOS_USUARIOS:
				opcao = OPCAO_MENU_CONSULTAR_VOLTAR;
				ArrayList<UsuarioVO> listaUsuariosVO = ControladorUsuario.consultarTodosUsuariosController();
				System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
				for (int i = 0; i < listaUsuariosVO.size(); i++) {
					System.out.println(listaUsuariosVO.get(i));
				}
				break;
			case OPCAO_MENU_CONSULTAR_UM_USUARIO:
				opcao = OPCAO_MENU_CONSULTAR_VOLTAR;
				UsuarioVO usuarioVO = new UsuarioVO();
				System.out.print("\nDigite o codigo do usuario: ");
				usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				UsuarioVO usuario = controladorUsuario.consultarUsuarioController(usuarioVO);
				System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
				System.out.println(usuario);
				break;
			default:
				break;
			}
		}
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada: ");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIOS + " - Consultar todos Usuarios");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar um Usuario especifico");
		System.out.println(OPCAO_MENU_CONSULTAR_VOLTAR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		
		System.out.print("\nDigite o código do usuario: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		controladorUsuario.excluirUsuarioController(usuarioVO);
		
	}

	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		
		System.out.print("\nDigite o código do usuario: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o nome do usuario: ");
		usuarioVO.setNome(teclado.nextLine());
		System.out.print("\nDigite o cpf do usuario: ");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.print("\nDigite o telefone do usuario: ");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.print("\nDigite o login do usuario: ");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.print("\nDigite a senha do usuario: ");
		usuarioVO.setSenha(teclado.nextLine());
		
		ControladorUsuario controladorUsuario = new ControladorUsuario();
		controladorUsuario.atualizarUsuarioController(usuarioVO);
		
	}

	private void cadastrarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();	
		System.out.print("\nDigite o nome do usuario: ");
		usuarioVO.setNome(teclado.nextLine());
		System.out.print("\nDigite o cpf do usuario: ");
		usuarioVO.setCpf(teclado.nextLine());
		System.out.print("\nDigite o telefone do usuario: ");
		usuarioVO.setTelefone(teclado.nextLine());
		System.out.print("\nDigite o login do usuario: ");
		usuarioVO.setLogin(teclado.nextLine());
		System.out.print("\nDigite a senha do usuario: ");
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
		System.out.print("\nDigite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

}
