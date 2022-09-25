package br.com.fiap.cp5.model;

import java.io.Serializable;

public class ProdutoVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_produto;
	private String nm_produto;
	private Double vl_unitario;
	private Integer id_unidade;
	private Integer id_status;

	public ProdutoVo() {
		id_produto = 1;
		id_unidade = 1;
	}

	public ProdutoVo(Integer id_produto, String nm_produto, Double vl_unitario, Integer id_unidade, Integer id_status) {
		this.id_produto = id_produto;
		this.nm_produto = nm_produto;
		this.vl_unitario = vl_unitario;
		this.id_unidade = id_unidade;
		this.id_status = id_status;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNm_produto() {
		return nm_produto;
	}

	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}

	public Double getVl_unitario() {
		return vl_unitario;
	}

	public void setVl_unitario(Double vl_unitario) {
		this.vl_unitario = vl_unitario;
	}

	public Integer getId_unidade() {
		return id_unidade;
	}

	public void setId_unidade(Integer id_unidade) {
		this.id_unidade = id_unidade;
	}

	public Integer getId_status() {
		return id_status;
	}

	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProdutoVo [id_produto=" + id_produto + ", nm_produto=" + nm_produto + ", vl_unitario=" + vl_unitario
				+ ", id_unidade=" + id_unidade + ", id_status=" + id_status + "]";
	}

}
