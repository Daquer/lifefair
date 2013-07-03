package br.com.lifefair.medicamento.domain;

public class MedicamentoDTO {
	public Long id;
	public String nome;
	public String tarja;
	public String principios_ativos;
	public int mg_por_g;
	public String dtfabric;
	public String vencimento;
	public double peso;
	public String descricao_de_uso;
	public double preco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTarja() {
		return tarja;
	}
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
	public String getPrincipios_ativos() {
		return principios_ativos;
	}
	public void setPrincipios_ativos(String principios_ativos) {
		this.principios_ativos = principios_ativos;
	}
	public int getMg_por_g() {
		return mg_por_g;
	}
	public void setMg_por_g(int mg_por_g) {
		this.mg_por_g = mg_por_g;
	}
	public String getDtfabric() {
		return dtfabric;
	}
	public void setDtfabric(String dtfabric) {
		this.dtfabric = dtfabric;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getDescricao_de_uso() {
		return descricao_de_uso;
	}
	public void setDescricao_de_uso(String descricao_de_uso) {
		this.descricao_de_uso = descricao_de_uso;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
