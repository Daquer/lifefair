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

	
	private static final long serialVersionUID = -4049607468860054923L;
	
	private UsuarioDTO usuarioDTO;
	
	@Autowired
	private UsuarioDao dao;
	
	public String inicio() {
		return "inicio";
	}
	
	public String login() {
		this.usuarioDTO = dao.logarUsuario(usuarioDTO);
		
		if (usuarioDTO.getId() != null) {

			ActionContext.getContext().getSession().put("usuarioLogado", usuarioDTO);

			return "logado";
		} else {
			return "invalido";
		}
	}
}
