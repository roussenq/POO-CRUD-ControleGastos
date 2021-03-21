package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.vo.ReceitaVO;

public class ReceitaDAO {
	
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
			System.out.println("\nErro ao executar a query que verifica o codigo do usuario para cadastrar receita");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "insert into receita (idusuario, descricao, valor, datareceita) values ("
				+ receitaVO.getIdUsuario() + ",'"
				+ receitaVO.getDescricao() + "',"
				+ receitaVO.getValor() + ",'"
				+ receitaVO.getDataReceita() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de cadastro de receita!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public int excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "delete from receita where idusuario =" + receitaVO.getIdUsuario() + " and idreceita =" + receitaVO.getId();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de exclusão da receita");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorIdReceita(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT idreceita FROM receita WHERE idreceita =" + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica o codigo da receita para excluir receita");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "update receita set "
				+ "descricao = '" + receitaVO.getDescricao() + "', "
				+ "valor = " + receitaVO.getValor() + ", "
				+ "datareceita = '" + receitaVO.getDataReceita() + "' "
				+ "where idusuario = " + receitaVO.getIdUsuario() + " and idreceita =" + receitaVO.getId();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica o codigo da receita para atualizar receita");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	
	
	
	public ReceitaVO consultarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = null;
		
		String query = "SELECT idreceita, descricao, valor, datareceita FROM receita WHERE idreceita =" + receitaVO.getId();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				receita = new ReceitaVO();
				receita.setId(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
				receita.setValor(Double.parseDouble(resultado.getString(3)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(4), dataFormatter));
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consulta a uma receita!");
			System.out.println("\nErro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
	}

	public ArrayList<ReceitaVO> consultarTodasReceitasDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVO> listaReceitasVO = new ArrayList<ReceitaVO>();
		
		String query = "SELECT idreceita, descricao, valor, datareceita FROM receita WHERE idusuario =" + receitaVO.getIdUsuario();
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				ReceitaVO receita = new ReceitaVO();
				receita.setId(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
			    receita.setValor(Double.parseDouble(resultado.getString(3)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(4), dataFormatter));
				listaReceitasVO.add(receita);
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de consultar todas as receitas");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaReceitasVO;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
