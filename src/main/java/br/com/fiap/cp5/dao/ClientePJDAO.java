package br.com.fiap.cp5.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.cp5.model.ClientePJVo;

public interface ClientePJDAO {

	public void cadastrarClientePJ(ClientePJVo clientePJVo) throws SQLException;
	public void excluirClientePJ(Integer id_cliente) throws SQLException;
	public void alterarClientePJ(ClientePJVo clientePJVo) throws SQLException;
	public ClientePJVo obterClientePJPorChave(Integer id_cliente) throws SQLException;
	public List<ClientePJVo> obterListaClientePJ() throws SQLException;
	
}
