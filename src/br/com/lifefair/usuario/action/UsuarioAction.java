package br.com.lifefair.usuario.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.lifefair.com.medico.dao.MedicoDAO;
import br.com.lifefair.medicamento.domain.CarrinhoDTO;
import br.com.lifefair.medicamento.domain.MedicamentoDTO;
import br.com.lifefair.medico.domain.MedicoDTO;
import br.com.lifefair.paciente.dao.PacienteDAO;
import br.com.lifefair.paciente.domain.PacienteDTO;
import br.com.lifefair.usuario.dao.UsuarioDao;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("request")
public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 5858043201266765171L;

	private UsuarioDTO usuarioDTO;
	private MedicoDTO medicoDTO;
	private PacienteDTO pacienteDTO;
	private CarrinhoDTO carrinho;
	private List<String> tipos;
	private String tipo;
	private String medicoDePac;
	private String confirmarSenha;
	
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private MedicoDAO medicoDao;
	@Autowired
	private PacienteDAO pacienteDao;
	
	//TODO Página de cadastro dinâmica para médico e paciente
	
	//Acesso
	//Acesso à home.
	public String inicio() {
		return "inicio";
	}
	
	//Acesso à área fechada, somente possível entrar com um login
	public String login() {
		this.usuarioDTO = usuarioDao.logarUsuario(usuarioDTO);
		this.carrinho = new CarrinhoDTO();
		this.carrinho.setItems(new ArrayList<MedicamentoDTO>());
		
		if (usuarioDTO.getId() != null && !usuarioDTO.getLogin().equals("") && !usuarioDTO.getSenha().equals("")) {
			ActionContext.getContext().getSession().put("usuarioLogado", usuarioDTO);
			ActionContext.getContext().getSession().put("carrinhoLogado", carrinho);
			
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
		tipos.add("Medico");
		tipos.add("Paciente");
		return "cadastrese";
	}
	
	public String cadastro() {
		if(confirmarSenha.equals(usuarioDTO.getSenha())) {
			usuarioDTO.setTipo(tipo.equals("Paciente") ? "pac" : "med");
			this.usuarioDTO = usuarioDao.incluirUsuario(usuarioDTO);
			if(tipo.equals("Medico")) {
				medicoDTO.setFk_usuario(usuarioDao.getUsuarioByLogin(usuarioDTO).getId());
				medicoDao.incluirMedico(medicoDTO);
			} else {
				pacienteDTO.setFk_medico(medicoDao.getMedicoByCrm(medicoDePac).getPk_medico());
				pacienteDTO.setFk_usuario(usuarioDao.getUsuarioByLogin(usuarioDTO).getId());
				pacienteDao.incluirPaciente(pacienteDTO);
			}
		
			return "cadastrado";
		} else {
			addActionError("A senha e a confirmação não batem.");					
			tipos = new ArrayList<String>();
			tipos.add("Medico");
			tipos.add("Paciente");
			return "erroSenha";
		}
	}
	
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public UsuarioDao getDao() {
		return usuarioDao;
	}

	public void setDao(UsuarioDao dao) {
		this.usuarioDao = dao;
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

	public MedicoDTO getMedicoDTO() {
		return medicoDTO;
	}

	public void setMedicoDTO(MedicoDTO medicoDTO) {
		this.medicoDTO = medicoDTO;
	}

	public PacienteDTO getPacienteDTO() {
		return pacienteDTO;
	}

	public void setPacienteDTO(PacienteDTO pacienteDTO) {
		this.pacienteDTO = pacienteDTO;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public MedicoDAO getMedicoDao() {
		return medicoDao;
	}

	public void setMedicoDao(MedicoDAO medicoDao) {
		this.medicoDao = medicoDao;
	}

	public String getMedicoDePac() {
		return medicoDePac;
	}

	public void setMedicoDePac(String medicoDePac) {
		this.medicoDePac = medicoDePac;
	}

	public PacienteDAO getPacienteDao() {
		return pacienteDao;
	}

	public void setPacienteDao(PacienteDAO pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public CarrinhoDTO getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDTO carrinho) {
		this.carrinho = carrinho;
	}

}
