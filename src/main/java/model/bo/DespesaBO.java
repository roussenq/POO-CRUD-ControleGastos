package model.bo;

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

}
