package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
		 			+ despesaVO.getValor() + ",";
		if (despesaVO.getDataVencimento() != null) {
			query = query + " '" + despesaVO.getDataVencimento() +  "',";  					 			
		}else {
 			query = query + " " + null + ",";
 		}
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

	public ArrayList<DespesaVO> consultarTodasDespesasDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> listaDespesasVO = new ArrayList<DespesaVO>();
		
		String query = "SELECT "
							+ "iddespesa,"
							+ "idusuario,"
							+ "descricao,"
							+ "valor,"
							+ "datavencimento,"
							+ "datapagamento,"
							+ "categoria "
					+ "FROM despesa "
					+ "WHERE idusuario = " + despesaVO.getIdUsuario();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				DespesaVO despesa = new DespesaVO();
				despesa.setId(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				if(resultado.getString(5) != null) {
					despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dataFormatter));
				}
				if(resultado.getString(6) != null) {
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dataFormatter));	
				}
				
				
				despesa.setCategoria(resultado.getString(7));
				listaDespesasVO.add(despesa);
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta à lista de despesas! ");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return listaDespesasVO;
	}

	public DespesaVO consultarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = null;
		
		String query = "SELECT "
				+ "iddespesa,"
				+ "idusuario,"
				+ "descricao,"
				+ "valor,"
				+ "datavencimento,"
				+ "datapagamento,"
				+ "categoria "
		+ "FROM despesa "
		+ "WHERE iddespesa = " + despesaVO.getId() ;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				despesa = new DespesaVO();
				despesa.setId(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
			//	if(resultado.getString(5) != null) {
					despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dataFormatter));
	//			}
				if(resultado.getString(6) != null) {
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dataFormatter));	
				}
				despesa.setCategoria(resultado.getString(7));
				
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta de uma despesa!");
			System.out.println("\nErro :" + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return despesa;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
