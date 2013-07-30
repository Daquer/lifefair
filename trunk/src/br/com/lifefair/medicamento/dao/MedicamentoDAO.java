package br.com.lifefair.medicamento.dao;

import java.util.List;

import br.com.lifefair.medicamento.domain.MedicamentoDTO;


public interface MedicamentoDAO {
	
	public List<MedicamentoDTO> getBuscaMedicamento(MedicamentoDTO medicamentoDTO);
	
	public MedicamentoDTO getMedicamento(MedicamentoDTO medicamentoDto);
	
	public MedicamentoDTO incluirMedicamento(MedicamentoDTO medicamentoDto);
	//public byte[] getImageFromBlob(Blob blob);//TODO metodo Teste, talvez seja usado o ajax (conceito parece errado, pois ainda assim deve vir da action)

}
