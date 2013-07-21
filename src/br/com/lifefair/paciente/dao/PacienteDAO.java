package br.com.lifefair.paciente.dao;

import java.util.List;

import br.com.lifefair.paciente.domain.PacienteDTO;
import br.com.lifefair.usuario.domain.UsuarioDTO;

public interface PacienteDAO {
	
	
	public PacienteDTO incluirPaciente(PacienteDTO pacienteDTO);
	
	public PacienteDTO getPacienteByUsuario(UsuarioDTO usuarioDTO);

	public PacienteDTO alterarPaciente(PacienteDTO pacienteDTO);

	public List<PacienteDTO> getLista(PacienteDTO pacienteDTO);

	public List<PacienteDTO> getBuscaResultado(PacienteDTO pacienteDTO);

	public PacienteDTO getPaciente(PacienteDTO pacienteDTO);

	public boolean excluirPaciente(Integer id);

	public PacienteDTO logarPaciente(PacienteDTO pacienteDTO);
}
