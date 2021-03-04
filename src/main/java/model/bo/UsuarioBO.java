package model.bo;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if (usuarioDAO.existeRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nUsuario já cadastrado!");
		} else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuario cadastrado com Sucesso!");
			} else {
				System.out.println("\nUsuario não cadastrado!");
			}

		}

	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuario atualizado com Sucesso!");
			} else {
				System.out.println("\nUsuario não atualizado!");
			}
		} else {
			System.out.println("\nUsuario não atualizado!\nCódigo não encontrado!\nNão possui Cadastro");

		}
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if (usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuario excluido com Sucesso!");
			} else {
				System.out.println("\nUsuario não excluido!");
			}
		} else {
			System.out.println("\\nUsuario não excluido!\\nCódigo não encontrado\\nUsuário não encontrado na base de dados!");

		}
		
	}
}
