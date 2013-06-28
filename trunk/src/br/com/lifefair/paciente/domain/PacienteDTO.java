package br.com.lifefair.paciente.domain;

public class PacienteDTO {
	private double pk_paciente;
	private double fk_usuario;
	private String nome_completo;
	private String datanasc;
	private String telefone;
	private String endereco;
	private String email;
	private String alergias;
	private double fk_medico;
	private String saudeprobs;
	
	public double getPk_paciente() {
		return pk_paciente;
	}
	public void setPk_paciente(double pk_paciente) {
		this.pk_paciente = pk_paciente;
	}
	public double getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(double fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
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
	public double getFk_medico() {
		return fk_medico;
	}
	public void setFk_medico(double fk_medico) {
		this.fk_medico = fk_medico;
	}
}
