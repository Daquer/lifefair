package br.com.lifefair.com.medico.dao;

import java.util.List;

import br.com.lifefair.medico.domain.MedicoDTO;

public interface MedicoDAO {
		
		//Medico
		public MedicoDTO incluirMedico(MedicoDTO medicoDto);

		public MedicoDTO alterarMedico(MedicoDTO medicoDto);

		public List<MedicoDTO> getLista(MedicoDTO medicoDto);

		public List<MedicoDTO> getBuscaResultado(MedicoDTO medicoDto);

		public MedicoDTO getMedicoByCrm(String crm);
			
		public MedicoDTO getMedico(MedicoDTO medicoDto);

		public boolean excluirMedico(Integer id);

		public MedicoDTO logarMedico(MedicoDTO medicoDto);
}
