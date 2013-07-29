package br.com.lifefair.medico.domain;

public class MedicoDTO {
	private Long pk_medico;
	private String cpf;
	private String crm;
	private String local_trabalho;
	private String endereco;
	private String email;
	private String telefone;
	private Long fk_usuario;
	
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
	public Long getPk_medico() {
		return pk_medico;
	}
	public void setPk_medico(Long pk_medico) {
		this.pk_medico = pk_medico;
	}
	public Long getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(Long fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	
}