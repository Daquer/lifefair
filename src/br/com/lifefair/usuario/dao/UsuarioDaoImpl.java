package br.com.lifefair.usuario.dao;

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
import br.com.lifefair.usuario.domain.UsuarioDTO;
import br.com.lifefair.usuario.domain.UsuarioDTORowMapper;


@Repository
public class UsuarioDaoImpl extends AbstractDaoSql implements UsuarioDao {

	@Resource
	private DataSource dataSource;

	//usuario
	@Override
	public UsuarioDTO incluirUsuario(UsuarioDTO usuarioDto) {
		String query = "INSERT INTO usuarios (NOME,LOGIN,SENHA,tipo)values(:nome ,:login ,:senha, :tipo)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome", usuarioDto.getNome());
		param.addValue("login", usuarioDto.getLogin());
		param.addValue("senha", usuarioDto.getSenha());
		param.addValue("tipo", usuarioDto.getTipo());

		KeyHolder key = new GeneratedKeyHolder();

		try {
			jdbcTemplate.update(query, param, key);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//usuarioDto.setId(key.getKey().longValue()); //recebendo nulo

		return usuarioDto;
	}

	@Override
	public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDto) {

		String query = "UPDATE usuarios SET NOME= :nome,LOGIN= :login, SENHA= :senha WHERE id= :id";

		UsuarioDTO temp;

		MapSqlParameterSource param = new MapSqlParameterSource();

		temp = getUsuario(usuarioDto);

		if (temp != null) {
			param.addValue("id", usuarioDto.getId());
			param.addValue("nome", usuarioDto.getNome());
			param.addValue("login", usuarioDto.getLogin());
			param.addValue("senha", usuarioDto.getSenha());

			KeyHolder key = new GeneratedKeyHolder();
			jdbcTemplate.update(query, param, key);
			//usuarioDto.setId(key.getKey().longValue()); //Adicionado depois

			return usuarioDto;

		} else {

			throw new RuntimeException();
		}

	}

	@Override
	public boolean excluirUsuario(Integer id) {

		String query = "DELETE FROM usuarios WHERE id= :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		int result = jdbcTemplate.update(query, param);

		if (result > 0) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public UsuarioDTO getUsuario(UsuarioDTO usuarioDto) {
		StringBuilder sql = new StringBuilder();

		sql.append("select id as id,NOME as nome, LOGIN as login, SENHA as senha from usuarios where id=:id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", usuarioDto.getId());
		return jdbcTemplate.queryForObject(sql.toString(), param, new UsuarioDTORowMapper());

	}

	@Override
	public UsuarioDTO getUsuarioByLogin(UsuarioDTO usuarioDto){
		StringBuilder sql = new StringBuilder();

		sql.append("select id as id,NOME as nome, LOGIN as login, SENHA as senha from usuarios where login=:login");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login", usuarioDto.getLogin());
		return jdbcTemplate.queryForObject(sql.toString(), param, new UsuarioDTORowMapper());
	}
	
	@Override
	public UsuarioDTO getUsuarioById(double id){
		StringBuilder sql = new StringBuilder();

		sql.append("select id as id,NOME as nome, LOGIN as login, SENHA as senha from usuarios where id=:id");
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbcTemplate.queryForObject(sql.toString(), param, new UsuarioDTORowMapper());
	}
	
	@Override
	public List<UsuarioDTO> getLista(UsuarioDTO usuarioDto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id as id,NOME as nome, LOGIN as login, SENHA as senha from usuario");
		MapSqlParameterSource param = new MapSqlParameterSource();
		//		verificacao para montagem da query
		if (!usuarioDto.getNome().isEmpty()) {
			sql.append(" where NOME like :nome ");
			String nome = usuarioDto.getNome();
			param.addValue("nome", "%" + nome + "%");
		} else {
			sql.append(" where 0 = 0 ");
		}
		return jdbcTemplate.query(sql.toString(), param, new RowMapper<UsuarioDTO>() {

			//return jdbcTemplate.query(sql, new MapSqlParameterSource(), new RowMapper<UsuarioDTO>() {

			public UsuarioDTO mapRow(ResultSet rs, int paramInt) throws SQLException {
				UsuarioDTO usuario = new UsuarioDTO();

				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}

		});

	}

	@Override
	public List<UsuarioDTO> getBuscaResultado(UsuarioDTO usuarioDto) {

		//StringBuilder sql = new StringBuilder();
		String sql = "select id as id, NOME as nome, LOGIN as login, SENHA as senha from usuarios where NOME like :nome";
		//sql.append("SELECT id AS id, NOME AS NOME, LOGIN AS LOGIN, SENHA AS SENHA FROM usuario");
		//pegando valores do formulario
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("nome", "%" + usuarioDto.getNome() + "%");
		//		verificacao para montagem da query

		//		if (!usuarioDto.getNome().isEmpty()) {
		//			sql.append(" WHERE NOME = :nome ");
		//			param.addValue("nome", usuarioDto.getNome());
		//		}
		return jdbcTemplate.query(sql, param, new RowMapper<UsuarioDTO>() {
			//return jdbcTemplate.query(sql.toString(), new MapSqlParameterSource(), new RowMapper<UsuarioDTO>() {
			public UsuarioDTO mapRow(ResultSet rs, int paramInt) throws SQLException {
				UsuarioDTO usuario = new UsuarioDTO();

				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("NOME"));
				usuario.setLogin(rs.getString("LOGIN"));
				usuario.setSenha(rs.getString("SENHA"));
				return usuario;
			}

		});

	}
	
	@Override
	public UsuarioDTO logarUsuario(UsuarioDTO usuarioDto) {
		String query = "select * from usuarios where LOGIN = :login and SENHA = :senha";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("login", usuarioDto.getLogin());
		param.addValue("senha", usuarioDto.getSenha());
		//caso a senha ou login esteja errada � tratado o erro

		try {
			return jdbcTemplate.queryForObject(query, param, new RowMapper<UsuarioDTO>() {

				public UsuarioDTO mapRow(ResultSet rs, int paramInt) throws SQLException {
					UsuarioDTO usuarioDto = new UsuarioDTO();
					usuarioDto.setId(rs.getLong("id"));
					usuarioDto.setNome(rs.getString("nome"));
					usuarioDto.setLogin(rs.getString("login"));
					usuarioDto.setSenha(rs.getString("senha"));
					usuarioDto.setTipo(rs.getString("tipo"));

					return usuarioDto;
				}
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioDto;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
