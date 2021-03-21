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

	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		//int idUsuario, String descricao, double valor, LocalDate dataVencimento,
		//LocalDate dataPagamento, String categoria
		System.out.println("\nInforme o codigo do usuario: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme a descrição da despesa: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.println("\nInforme o valor da despesa: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nInforme a data de vencimento: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.println("\nInforme a data de pagamento: ");
		despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), dataFormatter));
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
