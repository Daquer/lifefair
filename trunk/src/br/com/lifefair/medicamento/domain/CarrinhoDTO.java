package br.com.lifefair.medicamento.domain;

import java.util.List;

public class CarrinhoDTO {
	public List<MedicamentoDTO> items;

	public List<MedicamentoDTO> getItems() {
		return items;
	}

	public void setItems(List<MedicamentoDTO> items) {
		this.items = items;
	}
}
