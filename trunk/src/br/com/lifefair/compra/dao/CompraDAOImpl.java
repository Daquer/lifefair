package br.com.lifefair.compra.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.lifefair.compra.domain.CompraDTO;
import br.com.lifefair.connection.AbstractDaoSql;

@Repository
public class CompraDAOImpl extends AbstractDaoSql implements CompraDAO{

	@Resource
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public CompraDTO inserirCompra(CompraDTO compraDTO) {
		String query = "INSERT INTO compra(idCompra,idProduto,quantidade,idUsuario,data, numCartao) value (:idCompra,:idProduto,:quantidade,:idUsuario,:data,:numCartao)";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		
		
		param.addValue("idCompra", compraDTO.getIdCompra());
		param.addValue("idProduto", compraDTO.getIdProduto());
		param.addValue("quantidade", compraDTO.getQuantidade());
		param.addValue("idUsuario", compraDTO.getIdUsuario());
		param.addValue("data", compraDTO.getData());
		param.addValue("numCartao", compraDTO.getNumCartao());
		
		KeyHolder key = new GeneratedKeyHolder();

		try {
			jdbcTemplate.update(query, param, key);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return compraDTO;
	}

	@Override
	public Long getLastIdCompra() {
			//StringBuilder sql = new StringBuilder();
			//sql.append("select MAX(idCompra) from compra");
			
			MapSqlParameterSource param = new MapSqlParameterSource();
			
			return this.jdbcTemplate.queryForLong("select MAX(idCompra) from compra", param);

	}
	
	
	
	
}
