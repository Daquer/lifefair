package br.com.lifefair.usuario.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.lifefair.compra.dao.CompraDAO;
import br.com.lifefair.compra.domain.CompraDTO;
import br.com.lifefair.medicamento.domain.CarrinhoDTO;
import br.com.lifefair.medicamento.domain.ItemMedicamento;
import br.com.lifefair.medico.dao.MedicoDAO;
import br.com.lifefair.medico.domain.MedicoDTO;
import br.com.lifefair.paciente.dao.PacienteDAO;
import br.com.lifefair.paciente.domain.PacienteDTO;
import br.com.lifefair.usuario.dao.UsuarioDao;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import org.springframework.mail.javamail.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("request")
public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 5858043201266765171L;

	private UsuarioDTO usuarioDTO;
	private MedicoDTO medicoDTO;
	private PacienteDTO pacienteDTO;
	private CompraDTO compraDTO;
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
	@Autowired
	private CompraDAO compraDao;
	
	//Acesso
	//Acesso � home.
	public String inicio() {
		return "inicio";
	}
	
	//Acesso � �rea fechada, somente poss�vel entrar com um login
	public String login() {
		this.usuarioDTO = usuarioDao.logarUsuario(usuarioDTO);
		this.carrinho = new CarrinhoDTO();
		this.carrinho.setItems(new ArrayList<ItemMedicamento>());
		
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
			addActionError("Login Inv�lido.");
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
			addActionError("A senha e a confirma��o n�o batem.");					
			tipos = new ArrayList<String>();
			tipos.add("Medico");
			tipos.add("Paciente");
			return "erroSenha";
		}
	}
	
	public String editarCadastro() {
		usuarioDTO = (UsuarioDTO) ActionContext.getContext().getSession().get("usuarioLogado");
		
		if(usuarioDTO.getTipo().equals("med")) {
			medicoDTO = medicoDao.getMedicoByUsuario(usuarioDTO);
		} else {
			pacienteDTO = pacienteDao.getPacienteByUsuario(usuarioDTO);
			this.medicoDePac = medicoDao.getMedicoByPaciente(pacienteDTO).getCrm();
		}
		
		return "sucesso";
	}
	
	public String atualizarCadastro() {
		usuarioDao.alterarUsuario(this.usuarioDTO);
		
		if(this.medicoDTO!=null){
			medicoDao.alterarMedico(this.medicoDTO);
		}
		
		if (this.pacienteDTO!=null){
			pacienteDao.alterarPaciente(this.pacienteDTO);
		}
		
		return "sucesso";
	}
	
	public String compra() {
		carrinho = (CarrinhoDTO) ActionContext.getContext().getSession().get("carrinhoLogado");
		usuarioDTO = (UsuarioDTO) ActionContext.getContext().getSession().get("usuarioLogado");
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");  
		String dataFormatada = formatador.format(new Date());  
		
		compraDTO.setData(dataFormatada);
		compraDTO.setIdUsuario(usuarioDTO.getId());
		
		Long lastIndex = compraDao.getLastIdCompra();
		
		Long indexSoma = Long.parseLong("1");
			compraDTO.setIdCompra(lastIndex + indexSoma);

		
		for(ItemMedicamento item : carrinho.getItems())
		{
			compraDTO.setIdProduto(item.getMedicamento().getId());
			compraDTO.setQuantidade(item.getQuantidade());
			
			compraDao.inserirCompra(compraDTO);
		}
		
		
		
		return "sucesso";
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

	public CompraDAO getCompraDao() {
		return compraDao;
	}

	public void setCompraDao(CompraDAO compraDao) {
		this.compraDao = compraDao;
	}

	public CompraDTO getCompraDTO() {
		return compraDTO;
	}

	public void setCompraDTO(CompraDTO compraDTO) {
		this.compraDTO = compraDTO;
	}

}
