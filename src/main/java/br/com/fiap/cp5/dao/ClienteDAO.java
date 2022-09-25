package br.com.fiap.cp5.dao;

import java.sql.SQLException;

import br.com.fiap.cp5.model.ClienteVo;

public interface ClienteDAO {

	public void inserirCliente(ClienteVo cliente) throws SQLException;
	public void alterarCliente(ClienteVo clienteVo) throws SQLException;
	public ClienteVo obterClientePorChave(Integer id_cli) throws SQLException;
	public void excluirCliente(ClienteVo clienteVo) throws SQLException;
	
}
