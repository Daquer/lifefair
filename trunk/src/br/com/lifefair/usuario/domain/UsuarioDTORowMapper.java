package br.com.lifefair.usuario.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsuarioDTORowMapper implements RowMapper<UsuarioDTO>{
	
	public UsuarioDTO mapRow(ResultSet rs, int row) throws SQLException {

		UsuarioDTO usuario = new UsuarioDTO();

		usuario.setId(rs.getLong("id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setLogin(rs.getString("login"));
		usuario.setSenha(rs.getString("senha"));
		return usuario;
	}
}
