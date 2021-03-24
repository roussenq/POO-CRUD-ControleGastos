package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import controller.ControladoraReceita;
import model.vo.ReceitaVO;
import java.util.ArrayList;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_RECEITA_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR = 3;

	public void apresentarMenuReceita() {
		int opcao = this.apresentarOpcoesReceita();

		while (opcao != OPCAO_MENU_RECEITA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_RECEITA: {
				this.cadastrarReceita();
				break;
			}
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				this.consultarReceita();
				break;
			}
			case OPCAO_MENU_ATUALIZAR_RECEITA: {
				this.atualizarReceita();
				break;
			}
			case OPCAO_MENU_EXCLUIR_RECEITA: {
				this.excluirReceita();
				break;
			}
			default:
				System.out.println("\nOpção Inválida!");
				break;
			}
			opcao = this.apresentarOpcoesReceita();
		}
	}
	
	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.println("\nInforme o codigo do usuario: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme a descrição da receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.println("\nInforme o valor da receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nInforme a data da receita: ");
		String dataReceita = teclado.nextLine();
		if (!dataReceita.equalsIgnoreCase("")) {
			receitaVO.setDataReceita(LocalDate.parse(dataReceita, dataFormatter));
		}
		
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);
	}
	
	private void excluirReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		
		System.out.println("\nInforme o codigo do usuario: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme o codigo do receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirReceitaController(receitaVO);
	}

	private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		
		System.out.println("\nInforme o codigo do usuario: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme o codigo da receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nInforme a descrição da receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.println("\nInforme o valor da receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nInforme a data da receita: ");
		String dataReceita = teclado.nextLine();
		if (!dataReceita.equalsIgnoreCase("")) {
			receitaVO.setDataReceita(LocalDate.parse(dataReceita, dataFormatter));
		}
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
	}
	
	private void consultarReceita() {
		int opcao = this.apresentarOpcoesConsultaReceita();
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		while(opcao != OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTAR_TODAS_RECEITAS: {
				opcao = OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR;
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.println("\nInforme o codigo do usuario: ");
				receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				ArrayList<ReceitaVO> listaReceitasVO = controladoraReceita.consultarTodasReceitasController(receitaVO);
				System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n%3s %-30s %-10s %-15s\n", "ID", "DESCRIÇÃO", "VALOR", "DATA RECEITA");
				for (int i = 0; i < listaReceitasVO.size(); i++) {
					listaReceitasVO.get(i).imprimir();	
				}
				break;
			}
			case OPCAO_MENU_CONSULTAR_UMA_RECEITA:{
				opcao = OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR;
				ReceitaVO receitaVO = new ReceitaVO();
				System.out.print("\nDigite o codigo da receita: ");
				receitaVO.setId(Integer.parseInt(teclado.nextLine()));
				ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
				if(receita != null) {
					System.out.print("\n---------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s %-30s %-10s %-15s\n", "ID", "DESCRIÇÃO", "VALOR", "DATA RECEITA");
					receita.imprimir();
				}
				break;
			}
			default:
				System.out.println("Opção invalida");
				opcao = this.apresentarOpcoesConsultaReceita();
			}
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
	
	private int apresentarOpcoesConsultaReceita() {
		System.out.println("\nInforme o tipo de consulta a ser realizada: ");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITAS + " - Consultar todas receitas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma receita especifica");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_VOLTAR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}
