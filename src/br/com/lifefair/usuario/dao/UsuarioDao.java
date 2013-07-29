package br.com.lifefair.usuario.dao;

import java.util.List;

import br.com.lifefair.usuario.domain.UsuarioDTO;

public interface UsuarioDao {

	//Usuario
	public UsuarioDTO incluirUsuario(UsuarioDTO usuarioDto);

	public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDto);

	public List<UsuarioDTO> getLista(UsuarioDTO usuarioDto);

	public List<UsuarioDTO> getBuscaResultado(UsuarioDTO usuarioDto);

	public UsuarioDTO getUsuario(UsuarioDTO usuarioDto);
	
	public UsuarioDTO getUsuarioByLogin(UsuarioDTO usuarioDto);

	public boolean excluirUsuario(Integer id);

	public UsuarioDTO logarUsuario(UsuarioDTO usuarioDto);

	public UsuarioDTO getUsuarioById(double id);

}
