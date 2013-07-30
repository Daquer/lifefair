package br.com.lifefair.medicamento.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.lifefair.connection.AbstractDaoSql;
import br.com.lifefair.medicamento.domain.MedicamentoDTO;

@Repository
public class MedicamentoDAOImpl extends AbstractDaoSql implements MedicamentoDAO{
	
	@Resource
	private DataSource dataSource;
	
	@Override
	public MedicamentoDTO incluirMedicamento(MedicamentoDTO medicamentoDto) {
		String query = "INSERT INTO medicamentos (nome,tarja,principios_ativos,mg_por_g,dtfabric,vencimento,peso,descricao_de_uso,preco,imagem)" +
				"values (:nome,:tarja,:principios_ativos,:mg_por_g,:dtfabric,:vencimento,:peso,:descricao_de_uso,:preco,:imagem)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("nome", medicamentoDto.getNome());
		param.addValue("tarja", medicamentoDto.getTarja());
		param.addValue("principios_ativos", medicamentoDto.getPrincipios_ativos());
		param.addValue("mg_por_g", medicamentoDto.getMg_por_g());
		param.addValue("dtfabric", medicamentoDto.getDtfabric());
		param.addValue("vencimento", medicamentoDto.getVencimento());
		param.addValue("peso", medicamentoDto.getPeso());
		param.addValue("descricao_de_uso", medicamentoDto.getDescricao_de_uso());
		param.addValue("preco", medicamentoDto.getPreco());
		param.addValue("imagem", medicamentoDto.getImagem());

		KeyHolder key = new GeneratedKeyHolder();

		try {
			jdbcTemplate.update(query, param, key);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//medicoDto.setId(key.getKey().longValue()); //recebendo nulo

		return medicamentoDto;
	}
	
	public List<MedicamentoDTO> getBuscaMedicamento(MedicamentoDTO medicamentoDTO) {


		String sql = "select id as id, NOME as nome, TARJA as tarja, PRINCIPIOS_ATIVOS as principios_ativos, " +
				"MG_POR_G as mg_por_g, DTFABRIC as dtfabric, VENCIMENTO as vencimento, PESO as peso, DESCRICAO_DE_USO as descricao_de_uso, preco as preco, imagem as imagem" +
				" from medicamentos where NOME like :nome";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome", "%" + medicamentoDTO.getNome() + "%");

		return jdbcTemplate.query(sql, param, new RowMapper<MedicamentoDTO>() {
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
				medicamento.setPreco(rs.getDouble("preco"));
				medicamento.setImagem(rs.getString("imagem"));
				
				return medicamento;
			}

		});

	}
	
	public MedicamentoDTO getMedicamento(MedicamentoDTO medicamentoDto) {
		StringBuilder sql = new StringBuilder();

		sql.append("select id as id, NOME as nome, TARJA as tarja, PRINCIPIOS_ATIVOS as principios_ativos, " +
				"MG_POR_G as mg_por_g, DTFABRIC as dtfabric, VENCIMENTO as vencimento, PESO as peso, DESCRICAO_DE_USO as descricao_de_uso, preco as preco, imagem as imagem from medicamentos where id=:id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", medicamentoDto.getId());
		return jdbcTemplate.queryForObject(sql.toString(), param, new RowMapper<MedicamentoDTO>() {
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
				medicamento.setPreco(rs.getDouble("preco"));
				medicamento.setImagem(rs.getString("imagem"));
				
				return medicamento;
			}

		});

	}
	
	/*public byte[] getImageFromBlob(Blob blob) { //TODO metodo Teste, talvez seja usado o ajax (conceito parece errado, pois ainda assim deve vir da action)
		byte[] imgData = null;
		try {
			imgData = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgData;
	}*/
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
