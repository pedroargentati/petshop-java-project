package br.com.fiap.cp5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.cp5.jdbc.adapter.DataAccessObjectAdapter;
import br.com.fiap.cp5.model.ClientePJVo;

public class ClientePJDAOBD extends DataAccessObjectAdapter implements ClientePJDAO {

	public void cadastrarClientePJ(ClientePJVo clientePJ) throws SQLException {
		try {
			System.out.println("iniciando método: cadastrarClientePJ(clientePJ).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" INSERT INTO ");
				sql.append("		PJ ");
				sql.append("	( PJ_ID, ");
				sql.append("	CNPJ, ");
				sql.append("	ID_CLIENTE ) ");
				sql.append(" VALUES (?, ?, ?)");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt   	  ( 1, clientePJ.getPj_id() );
				preparedStatement.setString	  ( 2, clientePJ.getCnpj() );
				preparedStatement.setInt	  ( 3, clientePJ.getId_cliente() );
				preparedStatement.execute();
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);

			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}

		} finally {
			System.out.println("finalizando método: cadastrarClientePJ(clientePJ).");
		}
	}
	
	public void excluirClientePJ(Integer id_cliente) throws SQLException {
		try {
		System.out.println("iniciando método: excluirClientePJ(id_cliente)");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	
		try {
			
			connection = conectar();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" DELETE FROM ");
			sql.append("		PJ ");
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
			System.out.println("finalizando método: excluirClientePJ(id_cliente).");
		}
		
	}

	public void alterarClientePJ(ClientePJVo clientePJ) throws SQLException {

		try {
			System.out.println("iniciando método: alterarClientePJ(clientePJ).");
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" UPDATE ");
				sql.append("		PJ");
				sql.append(" SET ");
				sql.append("	CNPJ = ? ");
				sql.append(" WHERE ");
				sql.append("	ID_CLIENTE = ? ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setString	  ( 1, clientePJ.getCnpj() );
				preparedStatement.setInt   	  ( 2, clientePJ.getId_cliente() );
				preparedStatement.execute();
				
				
			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			
			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			
			
		} finally {
			System.out.println("finalizando método: alterarClientePJ(clientePJ).");
		}
		
	}

	public ClientePJVo obterClientePJPorChave(Integer id_cliente) throws SQLException {
		try {
			System.out.println("iniciando método: obterClientePJPorChave(id_cliente).");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ClientePJVo result = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT ");
				sql.append(" 	PJ_ID, ");
				sql.append(" 	ID_CLIENTE, ");
				sql.append("	CNPJ ");
				sql.append(" FROM ");
				sql.append(" 	PJ ");
				sql.append(" WHERE ");
				sql.append("    ID_CLIENTE = ? ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt(1, id_cliente);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					result = new ClientePJVo();
					result.setPj_id			( resultSet.getInt	  ("PJ_ID") );
					result.setId_cliente	( resultSet.getInt	  ("ID_CLIENTE") );
					result.setCnpj			( resultSet.getString ("CNPJ") );
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
			System.out.println("finalizando método: obterClientePJPorChave(id_cliente).");
		}
	}

	@Override
	public List<ClientePJVo> obterListaClientePJ() throws SQLException {
		try {
			System.out.println("iniciando método: obterListaClientePJ().");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List<ClientePJVo> result = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT ");
				sql.append("    PJ_ID, ");
				sql.append("    ID_CLI, ");
				sql.append("	CNPJ ");
				sql.append(" FROM ");
				sql.append(" 	PJ ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				resultSet = preparedStatement.executeQuery();
				result = new ArrayList<>();
				
				while(resultSet.next()) {
					ClientePJVo vo = new ClientePJVo();
					vo.setPj_id			( resultSet.getInt	  ("PJ_ID") );
					vo.setId_cliente	( resultSet.getInt	  ("ID_CLIENTE") );
					vo.setCnpj			( resultSet.getString ("CNPJ") );
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
			System.out.println("finalizando método: obterListaClientePJ().");
		}
	}
	
}
