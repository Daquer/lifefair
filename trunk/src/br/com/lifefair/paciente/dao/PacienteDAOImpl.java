package br.com.lifefair.paciente.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.lifefair.connection.AbstractDaoSql;
import br.com.lifefair.paciente.domain.PacienteDTO;
import br.com.lifefair.paciente.domain.PacienteDTORowMapper;
import br.com.lifefair.usuario.domain.UsuarioDTO;

@Repository
public class PacienteDAOImpl extends AbstractDaoSql implements PacienteDAO {

	@Resource
	private DataSource dataSource;
	
	@Override
	public PacienteDTO incluirPaciente(PacienteDTO pacienteDTO) {
		String query = "INSERT INTO pacientes (nome_completo,datanasc,telefone,endereco,email,alergias, fk_medico,saudeprobs, fk_usuario)" +
				"values(:nome_completo ,:datanasc ,:telefone, :endereco, :email, :alergias, :fk_medico, :saudeprobs, :fk_usuario)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome_completo", pacienteDTO.getNome_completo());
		param.addValue("datanasc", pacienteDTO.getDatanasc());
		param.addValue("telefone", pacienteDTO.getTelefone());
		param.addValue("endereco", pacienteDTO.getEndereco());
		param.addValue("alergias", pacienteDTO.getAlergias());
		param.addValue("fk_medico", pacienteDTO.getFk_medico());
		param.addValue("email", pacienteDTO.getEmail());
		param.addValue("saudeprobs", pacienteDTO.getSaudeprobs());
		param.addValue("fk_usuario", pacienteDTO.getFk_usuario());

		KeyHolder key = new GeneratedKeyHolder();

		try {
			jdbcTemplate.update(query, param, key);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pacienteDTO.setId(key.getKey().longValue()); //recebendo nulo

		return pacienteDTO;
	}

	@Override
	public PacienteDTO getPacienteByUsuario(UsuarioDTO usuarioDTO) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from pacientes where fk_usuario=:idFk");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idFk", usuarioDTO.getId());
		return jdbcTemplate.queryForObject(sql.toString(), param, new PacienteDTORowMapper());
	}
	
	@Override
	public PacienteDTO alterarPaciente(PacienteDTO pacienteDTO) {
			
			String query = "UPDATE pacientes SET nome_completo = :nome_completo,datanasc = :datanasc,telefone = :telefone," +
					"endereco = :endereco,email = :email,alergias = :alergias,fk_medico = :fk_medico,saudeprobs = :saudeprobs WHERE pk_paciente = :pk_paciente";

			PacienteDTO temp;

			MapSqlParameterSource param = new MapSqlParameterSource();

			temp = getPaciente(pacienteDTO);

			if (temp != null) {
				param.addValue("nome_completo", pacienteDTO.getNome_completo());
				param.addValue("datanasc", pacienteDTO.getDatanasc());
				param.addValue("telefone", pacienteDTO.getTelefone());
				param.addValue("endereco", pacienteDTO.getEndereco());
				param.addValue("email", pacienteDTO.getEmail());
				param.addValue("alergias", pacienteDTO.getAlergias());
				param.addValue("fk_medico", pacienteDTO.getFk_medico());
				param.addValue("saudeprobs", pacienteDTO.getSaudeprobs());
				param.addValue("pk_paciente", pacienteDTO.getPk_paciente());

				KeyHolder key = new GeneratedKeyHolder();
				jdbcTemplate.update(query, param, key);
				//usuarioDto.setId(key.getKey().longValue()); //Adicionado depois

				return pacienteDTO;

			} else {

				throw new RuntimeException();
			}
	}
	
	@Override
	public PacienteDTO getPaciente(PacienteDTO pacienteDTO) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from pacientes where fk_usuario=:idFk");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idFk", pacienteDTO.getFk_usuario());
		return jdbcTemplate.queryForObject(sql.toString(), param, new PacienteDTORowMapper());
	}

	@Override
	public List<PacienteDTO> getLista(PacienteDTO pacienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteDTO> getBuscaResultado(PacienteDTO pacienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean excluirPaciente(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PacienteDTO logarPaciente(PacienteDTO pacienteDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

}
