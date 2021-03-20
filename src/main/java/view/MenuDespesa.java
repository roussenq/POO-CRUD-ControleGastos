package view;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuDespesa {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_DESPESA_VOLTAR = 5;

	public void apresentarMenuDespesa() {
		int opcao = this.apresentarOpcoesDespesa();

		while (opcao != OPCAO_MENU_DESPESA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_DESPESA: {
				System.out.println("Despesa cadastrada!");
				break;
			}
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				System.out.println("Despesa consultada!");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_DESPESA: {
				System.out.println("Despesa atualizada!");
				break;
			}
			case OPCAO_MENU_EXCLUIR_DESPESA: {
				System.out.println("Despesa excluida!");
				break;
			}
			default:
				System.out.println("\nOpção Inválida!");
				break;
			}
			opcao = this.apresentarOpcoesDespesa();
		}

	}

	private int apresentarOpcoesDespesa() {
		System.out.println("-----====Despesas====-----");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - CADASTRAR DESPESA");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - CONSULTAR DESPESA");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - ATUALIZAR DESPESA");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - EXCLUIR DESPESA");
		System.out.println(OPCAO_MENU_DESPESA_VOLTAR + " - VOLTAR");
		System.out.println("\nDigite a opção:");
		return Integer.parseInt(teclado.nextLine());
	}

}
