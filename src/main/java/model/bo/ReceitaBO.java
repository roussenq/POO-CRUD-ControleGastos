package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;

public class ReceitaBO {

	public void cadastrarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		
		if (receitaDAO.existeRegistroPorIdUsuario(receitaVO.getIdUsuario())) {
			int resultado = receitaDAO.cadastrarReceitaDAO(receitaVO);
			if (resultado == 1) {
				System.out.println("\nReceita cadastrada com sucesso!");
			} else {
				System.out.println("\nReceita não cadastrada!");
			}
		} else {
			System.out.println("\nCodigo do usuario não cadastrado no BD");
		}
	}

	public void atualizarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();

		if (receitaDAO.existeRegistroPorIdUsuario(receitaVO.getIdUsuario())
				&& receitaDAO.existeRegistroPorIdReceita(receitaVO.getId())) {

			int resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
			if (resultado == 1) {
				System.out.println("\nReceita atualizada com sucesso!");
			} else {
				System.out.println("\nReceita não atualizada");
			}

		} else {
			System.out.println("\nReceita não localizada no BD");
		}

	}

	public void excluirReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();

		if (receitaDAO.existeRegistroPorIdUsuario(receitaVO.getIdUsuario())
				&& receitaDAO.existeRegistroPorIdReceita(receitaVO.getId())) {

			int resultado = receitaDAO.excluirReceitaDAO(receitaVO);
			if (resultado == 1) {
				System.out.println("\nReceita excluida com sucesso!");
			} else {
				System.out.println("\nReceita não excluida");
			}

		} else {
			System.out.println("\nReceita não localizada no BD");
		}
	}

	public ArrayList<ReceitaVO> consultarTodasReceitasBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ArrayList<ReceitaVO> listaReceitaVO = receitaDAO.consultarTodasReceitasDAO(receitaVO);
		if (listaReceitaVO.isEmpty()) {
			System.out.println("\nLista de receita vazia!");
		}

		return listaReceitaVO;
	}

	public ReceitaVO consultarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();

		ReceitaVO receita = receitaDAO.consultarReceitaDAO(receitaVO);
		if (receita == null) {
			System.out.println("\nReceita não localizada!");
		}
		return receita;
	}

}
