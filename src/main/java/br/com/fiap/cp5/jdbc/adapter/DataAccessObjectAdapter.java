package br.com.fiap.cp5.jdbc.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataAccessObjectAdapter {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String login = "??";
	private String senha = "??";
	private Connection connection;

	public Connection conectar() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("[DRIVER] Erro ao carregar o driver\n" + e);
		} catch (SQLException e) {
			System.out.println("[CONEXÃO] Erro ao conectar com o banco de dados\n" + e);
		}

		return connection;
	}

	protected final void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			resultSet = null;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	protected final void closeStatement(PreparedStatement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
			statement = null;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	protected final void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
			connection = null;
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

}