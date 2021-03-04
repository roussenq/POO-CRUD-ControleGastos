package view;

import java.util.Scanner;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_RECEITA_VOLTAR = 5;

	public void apresentarMenuReceita() {
		int opcao = this.apresentarOpcoesReceita();

		while (opcao != OPCAO_MENU_RECEITA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_RECEITA: {
				System.out.println("Receita cadastrada!");
				break;
			}
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				System.out.println("Receita consultada!");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_RECEITA: {
				System.out.println("Receita atualizada!");
				break;
			}
			case OPCAO_MENU_EXCLUIR_RECEITA: {
				System.out.println("Receita excluida!");
				break;
			}
			default:
				System.out.println("\nOpção Inválida!");
				break;
			}
			opcao = this.apresentarOpcoesReceita();
		}
	}

	private int apresentarOpcoesReceita() {
		System.out.println("-----====Receitas====-----");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - CADASTRAR RECEITA");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - CONSULTAR RECEITA");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - ATUALIZAR RECEITA");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - EXCLUIR RECEITA");
		System.out.println(OPCAO_MENU_RECEITA_VOLTAR + " - VOLTAR");
		System.out.println("\nDigite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

}
