package br.com.lifefair.medicamento.domain;

public class ItemMedicamento {
	
	private MedicamentoDTO medicamento;
	private int quantidade;
	
	public MedicamentoDTO getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(MedicamentoDTO medicamento) {
		this.medicamento = medicamento;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
