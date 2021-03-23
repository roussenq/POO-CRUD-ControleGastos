package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

	private static final int OPCAO_MENU_CONSULTAR_TODAS_DESPESAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_VOLTAR = 3;

	public void apresentarMenuDespesa() {
		int opcao = this.apresentarOpcoesDespesa();
		while (opcao != OPCAO_MENU_DESPESA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_DESPESA: {
				this.cadastrarDespesa();
				break;
			}
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				this.consultarDespesa();
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

	private void consultarDespesa() {
		int opcao = this.apresentarOpcoesConsultaDespesa();
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		while (opcao != OPCAO_MENU_CONSULTAR_DESPESA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODAS_DESPESAS: {
				opcao = OPCAO_MENU_CONSULTAR_DESPESA_VOLTAR;
				DespesaVO despesaVO = new DespesaVO();
				System.out.println("\nInforme o código do usuario: ");
				despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				
				ArrayList<DespesaVO> listaDespesasVO = controladoraDespesa.consultarTodasDespesasController(despesaVO);
				System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n%3s %-5s %-30s %-10s %-15s %-15s %-15s\n",
						"ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR","DATA VENCIMENTO", "DATA PAGAMENTO", "CATEGORIA");
				for (int i = 0; i < listaDespesasVO.size(); i++) {
					listaDespesasVO.get(i).imprimir();
				}
				break;
			}
			case OPCAO_MENU_CONSULTAR_UMA_DESPESA:{
				opcao = OPCAO_MENU_CONSULTAR_DESPESA_VOLTAR;
				DespesaVO despesaVO = new DespesaVO();
				System.out.println("\nInforme o código da despesa: ");
				despesaVO.setId(Integer.parseInt(teclado.nextLine()));
				
				DespesaVO despesa = controladoraDespesa.consultarDespesaController(despesaVO);
				System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n%3s %-5s %-30s %-10s %-15s %-15s %-15s\n",
						"ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR","DATA VENCIMENTO", "DATA PAGAMENTO", "CATEGORIA");
				despesa.imprimir();
				break;
			}
			default: {
				System.out.println("\nOpção invalida!");
				opcao = this.apresentarOpcoesConsultaDespesa();
			}
			}

		}

	}

	private int apresentarOpcoesConsultaDespesa() {
		System.out.println("\nInforme o tipo de consulta a ser realizada: ");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_DESPESAS + " - Consultar todas receitas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar uma receita especifica");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_VOLTAR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
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
		if (!dataPagamento.equalsIgnoreCase("")) {
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
		if (!dataPagamento.equalsIgnoreCase("")) {
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
