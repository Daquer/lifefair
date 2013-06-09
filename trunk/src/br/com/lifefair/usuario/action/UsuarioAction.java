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
	
	
	@Autowired
	private UsuarioDao dao;
	
	//Acesso
	//Acesso à home.
	public String inicio() {
		return "inicio";
	}
	
	//Acesso à área fechada, somente possível entrar com um login
	public String login() {
		this.usuarioDTO = dao.logarUsuario(usuarioDTO);
		
		if (usuarioDTO.getId() != null) {
			ActionContext.getContext().getSession().put("usuarioLogado", usuarioDTO);			
			
			if (usuarioDTO.getTipo().equals("med")) {
				return "autenticado_med";
			} else if(usuarioDTO.getTipo().equals("pac")) {
				return "autenticado_pac";
			} else if (usuarioDTO.getTipo().equals("adm")){
				return "autenticado_adm";
			} else {
				return "autenticado_indef";
			}
		} else {
			addActionError("Login Inválido.");
			return "invalido";
		}
	}
	
	public String logoff() {
		ActionContext.getContext().getSession().clear();
		return "logoff";
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
