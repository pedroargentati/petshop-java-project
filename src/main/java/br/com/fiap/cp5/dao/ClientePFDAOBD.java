package br.com.fiap.cp5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.cp5.jdbc.adapter.DataAccessObjectAdapter;
import br.com.fiap.cp5.model.ClientePfVo;

public class ClientePFDAOBD extends DataAccessObjectAdapter implements ClientePFDAO {

	public void cadastrarClientePf(ClientePfVo clientePFVo) throws SQLException {
		try {
			System.out.println("iniciando método: cadastrarClientePF(clientePfVo).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" INSERT INTO ");
				sql.append("		PF");
				sql.append(" ( 	ID_CLIENTE, ");
				sql.append("	CPF, ");
				sql.append("	DT_NASCIMENTO )");
				sql.append(" VALUES (?, ?, ?)");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt   	  ( 1, clientePFVo.getId_cliente() );
				preparedStatement.setString	  ( 2, clientePFVo.getCpf() );
				preparedStatement.setDate	  ( 3, clientePFVo.getDt_nascimento() );
				preparedStatement.execute();
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);

			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}

		} finally {
			System.out.println("finalizando método: cadastrarClientePF(clientePF).");
		}
	}
	
	public void excluirClientePF(Integer id_cliente) throws SQLException {
		try {
		System.out.println("iniciando método: excluirClientePF(id_cliente)");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		try {
			
			connection = conectar();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" DELETE FROM ");
			sql.append("		PF ");
			sql.append(" WHERE ");
			sql.append("	ID_CLIENTE = ? ");
			
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt( 1, id_cliente );
			
			preparedStatement.execute();
			
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		
		} finally {
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
			
			
		} finally {
			System.out.println("finalizando método: excluirClientePF(id_cliente).");
		}
		
	}

	public void alterarClientePF(ClientePfVo clientePFVo) throws SQLException {

		try {
			System.out.println("iniciando método: alterarClientePF(clientePFVo).");
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" UPDATE ");
				sql.append(		"PF");
				sql.append(" SET ");
				sql.append("	CPF = ?, ");
				sql.append("	DT_NASCIMENTO = ?");
				sql.append(" WHERE ");
				sql.append("	ID_CLIENTE = ? ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setString	  ( 1, clientePFVo.getCpf() );
				preparedStatement.setDate	  ( 2, clientePFVo.getDt_nascimento() );
				preparedStatement.setInt   	  ( 3, clientePFVo.getId_cliente() );
				preparedStatement.execute();
				
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			
			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			
			
		} finally {
			System.out.println("finalizando método: alterarClientePF(clientePFVo).");
		}
		
	}

	public ClientePfVo obterClientePFPorChave(Integer id_cliente) throws SQLException {
		try {
			System.out.println("iniciando método: obterClientePFPorChave(id_cli).");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ClientePfVo result = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT ");
				sql.append("  	ID_CLIENTE, ");
				sql.append("	CPF, ");
				sql.append("	DT_NASCIMENTO ");
				sql.append(" FROM ");
				sql.append(" 	PF ");
				sql.append(" WHERE ");
				sql.append("    ID_CLIENTE = ? ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt(1, id_cliente);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					result = new ClientePfVo();
					result.setId_cliente	( resultSet.getInt	  ("ID_CLIENTE") );
					result.setCpf			( resultSet.getString ("CPF") );
					result.setDt_nascimento	( resultSet.getDate   ("DT_NASCIMENTO") );
				}
				
				return result;
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			} finally {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
		} finally {
			System.out.println("finalizando metodo: obterClientePFPorChave(id_cliente).");
		}
	}

	@Override
	public List<ClientePfVo> obterListaClientePF() throws SQLException {
		try {
			System.out.println("iniciando método: obterListaClientePF().");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List<ClientePfVo> result = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT ");
				sql.append("  	ID_CLIENTE, ");
				sql.append("	CPF, ");
				sql.append("	DT_NASCIMENTO ");
				sql.append(" FROM ");
				sql.append(" 	PF ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				resultSet = preparedStatement.executeQuery();
				result = new ArrayList<>();
				
				while(resultSet.next()) {
					ClientePfVo vo = new ClientePfVo();
					vo.setId_cliente	( resultSet.getInt	  ("ID_CLIENTE") );
					vo.setCpf			( resultSet.getString ("CPF") );
					vo.setDt_nascimento	( resultSet.getDate   ("DT_NASCIMENTO") );

					result.add(vo);
				}
				return result;
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			} finally {
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			
		} finally {
			System.out.println("finalizando método: obterListaClientePF().");
		}
	}
	
}
