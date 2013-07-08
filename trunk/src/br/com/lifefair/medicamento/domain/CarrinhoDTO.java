package br.com.lifefair.medicamento.domain;

import java.util.List;

public class CarrinhoDTO {
	private List<ItemMedicamento> items;
	private double total = 0.0;

	public List<ItemMedicamento> getItems() {
		return items;
	}

	public void setItems(List<ItemMedicamento> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
