package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;

public class DespesaBO {

	public void cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if(despesaDAO.existeRegistroPorIdUsuario(despesaVO.getIdUsuario())) {
			int resultado = despesaDAO.cadastrarDespesaDAO(despesaVO);
			if(resultado == 1) {
				System.out.println("\nDespesa cadastrada com sucesso!");
			} else {
				System.out.println("\nDespesa não cadastrada");
			}
		} else {
			System.out.println("\nCodigo de usuario não cadastrado no BD!");
		}
	}

	public void atualizarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		
		if(despesaDAO.existeRegistroPorIdUsuario(despesaVO.getIdUsuario()) 
				&& despesaDAO.existeRegistroPorIdDespesa(despesaVO.getId()) ) {
				
				int resultado = despesaDAO.atualizarDespesaVO(despesaVO);
				if(resultado == 1) {
					System.out.println("\nDespesa atualizada com sucesso!");
				} else {
					System.out.println("\nDespesa não atualizada");
				}
			
		} else {
			System.out.println("\nDespesa não localizada no BD");
		}
		
	}

	public void excluirDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		
		if(despesaDAO.existeRegistroPorIdUsuario(despesaVO.getIdUsuario()) 
				&&	despesaDAO.existeRegistroPorIdDespesa(despesaVO.getId())) {
			
			int resultado = despesaDAO.excluirDespesa(despesaVO);
			if(resultado == 1) {
				System.out.println("\nExclusão realizada com sucesso!");
			} else {
				System.out.println("\nExclusão não realizada");
			}
		}else {
			System.out.println("\nDespesa não localizada no BD");
		}
	}

	public ArrayList<DespesaVO> consultarTodasDespesasBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> listaDespesasVO = despesaDAO.consultarTodasDespesasDAO(despesaVO);
		if(listaDespesasVO.isEmpty()) {
			System.out.println("\nLista de despesas está vazia!");
		}
		return listaDespesasVO;
	}

	public DespesaVO consultarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(despesaVO);
		if(despesa == null) {
			System.out.println("\nDespesa não localizada!");
		}
		return despesa;
	}


}
