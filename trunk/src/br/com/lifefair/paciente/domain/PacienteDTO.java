package br.com.lifefair.paciente.domain;

public class PacienteDTO {
	private Long pk_paciente;
	private Long fk_usuario;
	private String nome_completo;
	private String datanasc;
	private String telefone;
	private String endereco;
	private String email;
	private String alergias;
	private Long fk_medico;
	private String saudeprobs;

	
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	
	public String getSaudeprobs() {
		return saudeprobs;
	}
	public void setSaudeprobs(String saudeprobs) {
		this.saudeprobs = saudeprobs;
	}
	public Long getPk_paciente() {
		return pk_paciente;
	}
	public void setPk_paciente(Long pk_paciente) {
		this.pk_paciente = pk_paciente;
	}
	public Long getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(Long fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
	public Long getFk_medico() {
		return fk_medico;
	}
	public void setFk_medico(Long fk_medico) {
		this.fk_medico = fk_medico;
	}
}
