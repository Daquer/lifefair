package br.com.lifefair.medico.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MedicoDTORowMapper implements RowMapper<MedicoDTO> {

	public MedicoDTO mapRow(ResultSet rs, int row) throws SQLException {

		MedicoDTO medicoDto = new MedicoDTO();

		medicoDto.setPk_medico(rs.getLong("pk_medico"));
		medicoDto.setCpf(rs.getString("cpf"));
		medicoDto.setCrm(rs.getString("crm"));
		medicoDto.setLocal_trabalho(rs.getString("local_trabalho"));
		medicoDto.setEndereco(rs.getString("endereco"));
		medicoDto.setEmail(rs.getString("email"));
		medicoDto.setTelefone(rs.getString("telefone"));
		medicoDto.setFk_usuario(rs.getLong("fk_usuario"));
		
		
		return medicoDto;
	}

}
