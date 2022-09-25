package br.com.fiap.cp5.model;

import java.io.Serializable;

public class ClienteVo implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id_cliente;
	String nome_cliente;
	String email;
	String logradouro;
	String complemento;
	String cep;
	Integer id_cidade;
	String uf;
	String tp_cliente;
	String comentario;

	public ClienteVo() {
		id_cliente = 1;
	}
	
	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getId_cidade() {
		return id_cidade == null ? 1 : id_cidade;
	}

	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTp_cliente() {
		return tp_cliente;
	}

	public void setTp_cliente(String tp_cliente) {
		this.tp_cliente = tp_cliente;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

	@Override
	public String toString() {
		return "ClienteVo [id_cliente=" + id_cliente + ", nome_cliente=" + nome_cliente + ", email=" + email
				+ ", logradouro=" + logradouro + ", complemento=" + complemento + ", cep=" + cep + ", id_cidade="
				+ id_cidade + ", uf=" + uf + ", tp_cliente=" + tp_cliente + ", comentario=" + comentario + "]";
	}


}
