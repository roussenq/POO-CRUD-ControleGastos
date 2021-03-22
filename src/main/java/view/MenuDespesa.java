package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controller.ControladoraDespesa;
import model.vo.DespesaVO;

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
				this.cadastrarDespesa();
				break;
			}
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				System.out.println("Despesa consultada!");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_DESPESA: {
				this.atualizarDespesa();
				break;
			}
			case OPCAO_MENU_EXCLUIR_DESPESA: {
				this.excluirDespesa();
				break;
			}
			default:
				System.out.println("\nOpção Inválida!");
				break;
			}
			opcao = this.apresentarOpcoesDespesa();
		}
	}

	private void excluirDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		
		System.out.println("\nInforme o código do usuario: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme o codigo da despesa que deseja excluir: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.excluirDespesaController(despesaVO);
	}

	private void atualizarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		
		System.out.println("\nInforme o código do usuario: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme o código da despesa: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme a nova descrição da despesa: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.println("\nInforme o novo valor da despesa: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nInforme a nova data de vencimento: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.println("\nInforme a nova data de pagamento: ");
		String dataPagamento = teclado.nextLine();
		if(!dataPagamento.equalsIgnoreCase("")) {
			despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		}
		System.out.println("\nInforme a nova categoria: ");
		despesaVO.setCategoria(teclado.nextLine());
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.atualizarDespesaController(despesaVO);
	}

	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.println("\nInforme o codigo do usuario: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme a descrição da despesa: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.println("\nInforme o valor da despesa: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nInforme a data de vencimento da despesa: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.println("\nInforme a data de pagamento da despesa: ");
		String dataPagamento = teclado.nextLine();
		if(!dataPagamento.equalsIgnoreCase("")) {
			despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		}
		System.out.println("\nInforme a categoria da despesa: ");
		despesaVO.setCategoria(teclado.nextLine());
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);
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
