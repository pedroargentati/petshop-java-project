package br.com.fiap.cp5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.cp5.jdbc.adapter.DataAccessObjectAdapter;
import br.com.fiap.cp5.model.ProdutoVo;

public class ProdutoDAOBD extends DataAccessObjectAdapter implements ProdutoDAO {

	public void inserirProduto(ProdutoVo produtoVo) throws SQLException {
		try {
			System.out.println("iniciando metodo: inserirProduto(produtoVo).");

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append("INSERT INTO ");
				sql.append(			"PRODUTO ");
				sql.append(	"( ID_PRODUTO , ");
				sql.append(		"NM_PRODUTO, ");
				sql.append(		"VL_UNITARIO, ");
				sql.append(		"ID_UNIDADE, ");
				sql.append(		"ID_STATUS ) ");
				sql.append(	"VALUES (?, ?, ?, ?, ?) ");

				preparedStatement = connection.prepareStatement(sql.toString());
				preparedStatement.setInt	(	1, produtoVo.getId_produto() );
				preparedStatement.setString	(	2, produtoVo.getNm_produto() );
				preparedStatement.setDouble	(	3, produtoVo.getVl_unitario() );
				preparedStatement.setInt	(	4, produtoVo.getId_unidade() );
				preparedStatement.setInt	(	5, produtoVo.getId_status() );
				preparedStatement.execute();

			} catch (SQLException sqle) {
				throw new SQLException(sqle);

			} finally {
				closeStatement(preparedStatement);
				closeConnection(connection);
			}

		} finally {
			System.out.println("finalizando metodo: inserirProduto(produtoVo).");
		}
	}


	public Integer obterMaxSeqProduto() throws SQLException {
		try {
			System.out.println("iniciando metodo: obterMaxSeqProduto().");

			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			Integer result = null;

			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();

				sql.append("SELECT ");
				sql.append(		"MAX(ID_UNIDADE) AS MAXSEQ ");
				sql.append(	"FROM ");
				sql.append(		"PRODUTO ");

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
			System.out.println("finalizando metodo: obterMaxSeqProduto().");
		}
	}
	
	@Override
	public List<ProdutoVo> obterListaProduto() throws SQLException {
		try {
			System.out.println("iniciando método: obterListaProduto().");
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			List<ProdutoVo> result = null;
			
			try {
				
				connection = conectar();
				StringBuffer sql = new StringBuffer();
				
				sql.append(" SELECT ");
				sql.append("    ID_PRODUTO, ");
				sql.append("    NM_PRODUTO, ");
				sql.append("	VL_UNITARIO ");
				sql.append(" FROM ");
				sql.append(" 	PRODUTO ");
				
				preparedStatement = connection.prepareStatement(sql.toString());
				resultSet = preparedStatement.executeQuery();
				result = new ArrayList<>();
				
				while(resultSet.next()) {
					ProdutoVo vo = new ProdutoVo();
					vo.setId_produto	( resultSet.getInt 	  ("ID_PRODUTO") );
					vo.setNm_produto	( resultSet.getString ("NM_PRODUTO") );
					vo.setVl_unitario	( resultSet.getDouble ("VL_UNITARIO") );
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
			System.out.println("finalizando método: obterListaProduto().");
		}
	}
	
}
