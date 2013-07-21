package br.com.lifefair.com.medico.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.lifefair.connection.AbstractDaoSql;
import br.com.lifefair.medico.domain.MedicoDTO;
import br.com.lifefair.medico.domain.MedicoDTORowMapper;
import br.com.lifefair.usuario.domain.UsuarioDTO;

@Repository
public class MedicoDAOImpl extends AbstractDaoSql implements MedicoDAO {

	@Resource
	private DataSource dataSource;
	
	@Override
	public MedicoDTO incluirMedico(MedicoDTO medicoDto) {
		String query = "INSERT INTO medicos (cpf,crm,local_trabalho,endereco,email,telefone,fk_usuario)values(:cpf ,:crm ,:local_trabalho, :endereco, :email, :telefone,:fk_usuario)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("cpf", medicoDto.getCpf());
		param.addValue("crm", medicoDto.getCrm());
		param.addValue("local_trabalho", medicoDto.getLocal_trabalho());
		param.addValue("endereco", medicoDto.getEndereco());
		param.addValue("email", medicoDto.getEmail());
		param.addValue("telefone", medicoDto.getTelefone());
		param.addValue("fk_usuario", medicoDto.getFk_usuario());

		KeyHolder key = new GeneratedKeyHolder();

		try {
			jdbcTemplate.update(query, param, key);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//medicoDto.setId(key.getKey().longValue()); //recebendo nulo

		return medicoDto;
	}

	@Override
	public MedicoDTO alterarMedico(MedicoDTO medicoDto) {

		String query = "UPDATE medicos SET cpf = :cpf,local_trabalho = :local_trabalho,endereco = :endereco," +
				"email = :email,telefone = :telefone WHERE pk_medico = :pk_medico";

		MedicoDTO temp;

		MapSqlParameterSource param = new MapSqlParameterSource();

		temp = getMedico(medicoDto);

		if (temp != null) {
			
		param.addValue("cpf", medicoDto.getCpf());
		param.addValue("crm", medicoDto.getCrm());
		param.addValue("local_trabalho", medicoDto.getLocal_trabalho());
		param.addValue("endereco", medicoDto.getEndereco());
		param.addValue("email", medicoDto.getEmail());
		param.addValue("telefone", medicoDto.getTelefone());
		param.addValue("fk_usuario", medicoDto.getFk_usuario());
		
		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(query, param, key);
		//usuarioDto.setId(key.getKey().longValue()); //Adicionado depois

		return medicoDto;
		} else {
	
			throw new RuntimeException();
		}
		
	}

	@Override
	public List<MedicoDTO> getLista(MedicoDTO medicoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicoDTO> getBuscaResultado(MedicoDTO medicoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicoDTO getMedicoByCrm(String crm) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from medicos where CRM=:crm");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("crm", crm);
		return jdbcTemplate.queryForObject(sql.toString(), param, new MedicoDTORowMapper());
	}
	
	@Override
	public MedicoDTO getMedicoByUsuario(UsuarioDTO usuarioDTO) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from medicos where fk_usuario=:idFk");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("idFk", usuarioDTO.getId());
		return jdbcTemplate.queryForObject(sql.toString(), param, new MedicoDTORowMapper());
	}
	
	@Override
	public MedicoDTO getMedico(MedicoDTO medicoDto) {
		StringBuilder sql = new StringBuilder();

		sql.append("select * from medicos where pk_medcio=:pk_medico");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("pk_medico", medicoDto.getPk_medico());
		return jdbcTemplate.queryForObject(sql.toString(), param, new MedicoDTORowMapper());
	}

	@Override
	public boolean excluirMedico(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MedicoDTO logarMedico(MedicoDTO medicoDto) {
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
