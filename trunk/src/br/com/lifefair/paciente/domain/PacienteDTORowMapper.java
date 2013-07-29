package br.com.lifefair.paciente.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PacienteDTORowMapper implements RowMapper<PacienteDTO>{
	public PacienteDTO mapRow(ResultSet rs, int row) throws SQLException {

		PacienteDTO pacienteDTO = new PacienteDTO();

		pacienteDTO.setPk_paciente(rs.getLong("pk_paciente"));
		pacienteDTO.setFk_usuario(rs.getLong("fk_usuario"));
		pacienteDTO.setNome_completo(rs.getString("nome_completo"));
		pacienteDTO.setDatanasc(rs.getString("datanasc"));
		pacienteDTO.setTelefone(rs.getString("telefone"));
		pacienteDTO.setEndereco(rs.getString("endereco"));
		pacienteDTO.setEmail(rs.getString("email"));
		pacienteDTO.setAlergias(rs.getString("alergias"));
		pacienteDTO.setFk_medico(rs.getLong("fk_medico"));
		pacienteDTO.setSaudeprobs(rs.getString("saudeprobs"));

		return pacienteDTO;
	}
}
