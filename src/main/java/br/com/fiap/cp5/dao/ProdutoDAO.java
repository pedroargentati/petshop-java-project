package br.com.fiap.cp5.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.cp5.model.ProdutoVo;

public interface ProdutoDAO {

	public void inserirProduto(ProdutoVo produtoVo) throws SQLException;
	public Integer obterMaxSeqProduto() throws SQLException;
	public List<ProdutoVo> obterListaProduto() throws SQLException;
	
}
