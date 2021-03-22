package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import model.vo.DespesaVO;

public class DespesaDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public boolean existeRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
 		Statement stmt = Banco.getStatement(conn);
 		ResultSet resultado = null;
 		
 		String query = "SELECT idusuario FROM usuario WHERE idusuario =" + idUsuario;
 		
 		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica idusuario no cadastro da despesa");
			System.out.println("\nErro : " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
 		Statement stmt = Banco.getStatement(conn);
 		int resultado = 0;

 		String query = "INSERT INTO despesa(idusuario, descricao, valor, datavencimento, datapagamento, categoria) VALUES(" 
		 			+ despesaVO.getIdUsuario() + ",'" 
		 			+ despesaVO.getDescricao() + "',"
		 			+ despesaVO.getValor() + ",'"
		 			+ despesaVO.getDataVencimento() + "',";
 		
 		if (despesaVO.getDataPagamento() != null) {
 			query = query + " '" + despesaVO.getDataPagamento() +  "',"; 			
 		}else {
 			query = query + " " + null + ",";
 		} 
 		
 		query = query +  " '" + despesaVO.getCategoria() + "') ";
			
 		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar query de cadastro de despesa");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
 		return resultado;
	}

	public boolean existeRegistroPorIdDespesa(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT iddespesa FROM despesa WHERE iddespesa =" + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica se existe iddespesa");
			System.out.println("\nErro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarDespesaVO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "UPDATE despesa SET "
				+ " descricao ='" + despesaVO.getDescricao() + "',"
				+ " valor=" + despesaVO.getValor() + ","
				+ " datavencimento='"+ despesaVO.getDataVencimento() + "',"
				+ " datapagamento=" + despesaVO.getDataPagamento() + ","
				+ " categoria='" + despesaVO.getCategoria() + "'"
				+ "WHERE idusuario =" + despesaVO.getIdUsuario() + "  and iddespesa = " + despesaVO.getId();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de atualização da despesa!");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public int excluirDespesa(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "DELETE FROM despesa WHERE idusuario = " + despesaVO.getIdUsuario() + " AND iddespesa = " + despesaVO.getId();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de exclusão da despesa!");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
