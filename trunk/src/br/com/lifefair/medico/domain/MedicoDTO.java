package br.com.lifefair.medico.domain;

public class MedicoDTO {
	private double pk_medico;
	private String cpf;
	private String crm;
	private String local_trabalho;
	private String endereco;
	private String email;
	private String telefone;
	
	public double getPk_medico() {
		return pk_medico;
	}
	public void setPk_medico(double pk_medico) {
		this.pk_medico = pk_medico;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getLocal_trabalho() {
		return local_trabalho;
	}
	public void setLocal_trabalho(String local_trabalho) {
		this.local_trabalho = local_trabalho;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
