package br.com.lifefair.usuario.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.lifefair.usuario.dao.UsuarioDao;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("request")
public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 5858043201266765171L;

	private UsuarioDTO usuarioDTO;
	public boolean autenticado;
	
	
	@Autowired
	private UsuarioDao dao;
	
	public String inicio() {
		return "inicio";
	}
	
	public String login() {
		this.usuarioDTO = dao.logarUsuario(usuarioDTO);
		
		if (usuarioDTO.getId() != null) {

			ActionContext.getContext().getSession().put("usuarioLogado", usuarioDTO);			
			
			setAutenticado(true);
			return "autenticado";
		} else {
			setAutenticado(false);
			return "invalido";
		}
	}
	
	public String logoff() {
		ActionContext.getContext().getSession().clear();
		return "logoff";
	}
	
	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
}
