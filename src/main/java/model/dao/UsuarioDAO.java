package model.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT cpf FROM USUARIO WHERE cpf = '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica se existe usuario por CPF");
			System.out.println("ERRO: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO USUARIO (nome, cpf, telefone, login, senha) VALUES ('" 
		+ usuarioVO.getNome() + "','"
		+ usuarioVO.getCpf() + "','"
		+ usuarioVO.getTelefone() + "','"
		+ usuarioVO.getLogin() + "','"
		+ usuarioVO.getSenha() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro o usuario");
			System.out.println("ERRO: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idusuario FROM usuario WHERE idusuario = " + idUsuario;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query que verifica se existe usuario por id");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "UPDATE usuario SET nome = '' WHERE idusuario = " + usuarioVO.getIdUsuario() ;
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização do usuario");
			System.out.println("ERRO: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioVO consultarUsuariosDAO(UsuarioVO usuarioVO) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
