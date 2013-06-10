package br.com.lifefair.usuario.action;

import java.util.ArrayList;
import java.util.List;

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
	private List<String> tipos;
	
	String tipo;
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
		
		if (usuarioDTO.getId() != null && !usuarioDTO.getLogin().equals("") && !usuarioDTO.getSenha().equals("")) {
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
	
	//cadastro
	public String cadastrese() {
		tipos = new ArrayList<String>();
		tipos.add("M&eacute;dico");
		tipos.add("Paciente");
		return "cadastrese";
	}
	
	public String cadastro() {
		usuarioDTO.setTipo(tipo.equals("Paciente") ? "pac" : "med");
		this.usuarioDTO = dao.incluirUsuario(usuarioDTO);
		return "cadastrado";
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

	public List<String> getTipos() {
		return tipos;
	}

	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
