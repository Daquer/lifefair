package br.com.lifefair.medicamento.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.lifefair.connection.AbstractDaoSql;
import br.com.lifefair.medicamento.domain.MedicamentoDTO;

@Repository
public class MedicamentoDAOImpl extends AbstractDaoSql implements MedicamentoDAO{
	
	@Resource
	private DataSource dataSource;
	
	public List<MedicamentoDTO> getBuscaMedicamento(MedicamentoDTO medicamentoDTO) {

		//StringBuilder sql = new StringBuilder();
		String sql = "select id as id, NOME as nome, TARJA as tarja, PRINCIPIOS_ATIVOS as principios_ativos, " +
				"MG_POR_G as mg_por_g, DTFABRIC as dtfabric, VENCIMENTO as vencimento, PESO as peso, DESCRICAO_DE_USO as descricao_de_uso from medicamentos where NOME like :nome";
		//sql.append("SELECT id AS id, NOME AS NOME, LOGIN AS LOGIN, SENHA AS SENHA FROM usuario");
		//pegando valores do formulario
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome", "%" + medicamentoDTO.getNome() + "%");
		//		verificacao para montagem da query

		//		if (!usuarioDto.getNome().isEmpty()) {
		//			sql.append(" WHERE NOME = :nome ");
		//			param.addValue("nome", usuarioDto.getNome());
		//		}
		return jdbcTemplate.query(sql, param, new RowMapper<MedicamentoDTO>() {
			//return jdbcTemplate.query(sql.toString(), new MapSqlParameterSource(), new RowMapper<UsuarioDTO>() {
			public MedicamentoDTO mapRow(ResultSet rs, int paramInt) throws SQLException {
				MedicamentoDTO medicamento = new MedicamentoDTO();

				medicamento.setId(rs.getLong("id"));
				medicamento.setNome(rs.getString("NOME"));
				medicamento.setTarja(rs.getString("tarja"));
				medicamento.setPrincipios_ativos(rs.getString("principios_ativos"));
				medicamento.setMg_por_g(rs.getInt("mg_por_g"));
				medicamento.setDtfabric(rs.getString("dtfabric"));
				medicamento.setVencimento(rs.getString("vencimento"));
				medicamento.setPeso(rs.getDouble("peso"));
				medicamento.setDescricao_de_uso(rs.getString("descricao_de_uso"));
				
				return medicamento;
			}

		});

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
