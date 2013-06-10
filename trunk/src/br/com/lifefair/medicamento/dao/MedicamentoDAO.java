package br.com.lifefair.medicamento.dao;

import java.util.List;

import br.com.lifefair.medicamento.domain.MedicamentoDTO;


public interface MedicamentoDAO {
	
	public List<MedicamentoDTO> getBuscaMedicamento(MedicamentoDTO medicamentoDTO);

}
