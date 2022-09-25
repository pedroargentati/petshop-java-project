package br.com.fiap.cp5.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.cp5.model.ClientePfVo;

public interface ClientePFDAO {

	public void cadastrarClientePf(ClientePfVo clientePfVo) throws SQLException;
	public void excluirClientePF(Integer id_cliente) throws SQLException;
	public void alterarClientePF(ClientePfVo clientePFVo) throws SQLException;
	public ClientePfVo obterClientePFPorChave(Integer id_cliente) throws SQLException;
	public List<ClientePfVo> obterListaClientePF() throws SQLException;
	
}
