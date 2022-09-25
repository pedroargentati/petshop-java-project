package br.com.fiap.cp5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.cp5.jdbc.adapter.DataAccessObjectAdapter;
import br.com.fiap.cp5.model.ClienteVo;

public class ClienteDAOBD extends DataAccessObjectAdapter implements ClienteDAO {

	public void inserirCliente(ClienteVo clienteVo) throws SQLException {
		try {
			System.out.println("iniciando metodo: inserirCliente(clienteVo).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append( "INSERT INTO ");
				sql.append(			"CLIENTE ");
				sql.append(	"( ID_CLIENTE , ");
				sql.append(		"NM_CLIENTE, ");
				sql.append(		"EMAIL, ");
				sql.append(		"LOGRADOURO, ");
				sql.append(		"COMPLEMENTO, ");
				sql.append(		"CEP, ");
				sql.append(		"ID_CIDADE, ");
				sql.append(		"UF, ");
				sql.append(		"TP_CLIENTE) ");
				sql.append(	"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt	(	1, clienteVo.getId_cliente() );
				preparedStatement.setString	(	2, clienteVo.getNome_cliente() );
				preparedStatement.setString	(	3, clienteVo.getEmail() );
				preparedStatement.setString	(	4, clienteVo.getLogradouro());
				preparedStatement.setString	(	5, clienteVo.getComplemento() );
				preparedStatement.setString	(	6, clienteVo.getCep() );
				preparedStatement.setInt	(	7, clienteVo.getId_cidade() );
				preparedStatement.setString	(	8, clienteVo.getUf() );
				preparedStatement.setString	(	9, clienteVo.getTp_cliente() );
				preparedStatement.execute();

			} catch (SQLException sqle) {
				throw new SQLException(sqle);

			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}

		} finally {
			System.out.println("finalizando metodo: inserirCliente(clienteVo).");
		}
	}
	
	public void alterarCliente(ClienteVo clienteVo) throws SQLException {
		try {
			System.out.println("iniciando metodo: alterarCliente(clienteVo= )" + clienteVo.getId_cliente()  + clienteVo.getNome_cliente() +".");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();

				sql.append( "UPDATE ");
				sql.append(			"CLIENTE ");
				sql.append(	"SET ");
				sql.append(		"NM_CLIENTE = ? ");
				sql.append(	"WHERE ");
				sql.append(		"ID_CLIENTE = ? ");

				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setString	(	1, clienteVo.getNome_cliente() );
				preparedStatement.setInt	(	2, clienteVo.getId_cliente() );
				preparedStatement.execute();

			} catch (SQLException sqle) {
				throw new SQLException(sqle);
			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
		} finally {
			System.out.println("finalizando m todo: alterarCliente(clienteVo).");
		}
		
	}
	
	public ClienteVo obterClientePorChave(Integer id_cliente) throws SQLException {
		try {
			System.out.println("iniciando metodo: obterClientePorChave(id_cliente).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ClienteVo result = null;

			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();

				sql.append( "SELECT ");
				sql.append(		"ID_CLIENTE, ");
				sql.append(		"NM_CLIENTE, ");
				sql.append(		"EMAIL, ");
				sql.append(		"LOGRADOURO, ");
				sql.append(		"COMPLEMENTO, ");
				sql.append(		"CEP, ");
				sql.append(		"ID_CIDADE, ");
				sql.append(		"UF, ");
				sql.append(		"TP_CLIENTE ");
				sql.append(	"FROM ");
				sql.append(		"CLIENTE ");
				sql.append(	"WHERE ");
				sql.append( 	"ID_CLIENTE = ? ");

				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt(1, id_cliente);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					result = new ClienteVo();
					result.setId_cliente	   ( resultSet.getInt	("ID_CLIENTE") );
					result.setNome_cliente	   ( resultSet.getString("NM_CLIENTE") );
					result.setEmail			   ( resultSet.getString("EMAIL") );
					result.setLogradouro	   ( resultSet.getString("LOGRADOURO") );
					result.setComplemento	   ( resultSet.getString("COMPLEMENTO") );
					result.setCep			   ( resultSet.getString("CEP") );
					result.setId_cidade   	   ( resultSet.getInt	("ID_CIDADE") );
					result.setUf			   ( resultSet.getString("UF") );
					result.setTp_cliente	   ( resultSet.getString("TP_CLIENTE") );
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
			System.out.println("finalizando metodo: obterClientePorChave(id_cliente).");
		}
	}
	
	public Integer obterMaxSeqCliente() throws SQLException {
		try {
			System.out.println("iniciando metodo: obterMaxSeqCliente().");

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			Integer result = null;

			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();

				sql.append("SELECT ");
				sql.append(		"MAX(ID_CLIENTE) AS MAXSEQ ");
				sql.append(	"FROM ");
				sql.append(		"CLIENTE ");

				preparedStatement = connection.prepareStatement(sql.toString());
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					result = resultSet.getInt("MAXSEQ");
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
			System.out.println("finalizando metodo: obterMaxSeqCliente().");
		}
	}
	
	public void excluirCliente(ClienteVo clienteVo) throws SQLException {
		try {
			System.out.println("iniciando metodo: excluirCliente(clienteVo).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();

				sql.append("DELETE FROM ");
				sql.append(		"CLIENTE ");
				sql.append(	"WHERE ");
				sql.append(		"ID_CLIENTE = ? ");

				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt( 1, clienteVo.getId_cliente() );

				preparedStatement.execute();

			} catch (SQLException sqle) {
				throw new SQLException(sqle);

			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}

		} finally {
			System.out.println("finalizando metodo: excluirCliente(clienteVo).");
		}
	}
	
}
