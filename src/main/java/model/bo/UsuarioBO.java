package model.bo;

import java.util.ArrayList;
import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if (usuarioDAO.existeRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nCPF já cadastrado no BD!");
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
			System.out.println("\nUsuario não excluido!\nCódigo não encontrado\nUsuário não encontrado na base de dados!");

		}
		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if (listaUsuariosVO.isEmpty()) {
			System.out.println("\nLista de usuarios vazia!");
		} 
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuariosDAO(usuarioVO);
		if (usuario == null) {
			System.out.print("\nUsuario não localizado!");
		}
		return usuario;
	}
}
