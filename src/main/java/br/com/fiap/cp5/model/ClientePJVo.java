package br.com.fiap.cp5.model;

public class ClientePJVo {

	private Integer pj_id;
	private String cnpj;
	private Integer id_cliente;

	public ClientePJVo() {  }
	
	public ClientePJVo(Integer pj_id, String cnpj, Integer id_cliente) {
		super();
		this.pj_id = pj_id;
		this.cnpj = cnpj;
		this.id_cliente = id_cliente;
	}

	public Integer getPj_id() {
		return pj_id;
	}

	public void setPj_id(Integer pj_id) {
		this.pj_id = pj_id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Override
	public String toString() {
		return "pj_id=" + pj_id + ", cnpj=" + cnpj + ", id_cliente=" + id_cliente + "]";
	}

}
