package br.com.fiap.cp5.model;

import java.sql.Date;

public class ClientePfVo {

	private Integer id_cliente;
	private String cpf;
	private Date dt_nascimento;
	
	public ClientePfVo() { }

	public ClientePfVo(Integer id_cliente, String cpf, Date dt_nascimento) {
		super();
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.dt_nascimento = dt_nascimento;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	@Override
	public String toString() {
		return "id_cliente=" + id_cliente + ", cpf=" + cpf + ", dt_nascimento=" + dt_nascimento + "]";
	}

}
