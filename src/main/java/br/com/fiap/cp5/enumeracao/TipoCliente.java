package br.com.fiap.cp5.enumeracao;

public enum TipoCliente {
	
	PESSOAFISICA(1, "PF"), 
	PESSOAJURIDICA(2, "PJ");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
}