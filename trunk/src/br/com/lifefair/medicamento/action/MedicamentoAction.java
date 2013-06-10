package br.com.lifefair.medicamento.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.lifefair.medicamento.dao.MedicamentoDAO;
import br.com.lifefair.medicamento.domain.MedicamentoDTO;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("request")
public class MedicamentoAction extends ActionSupport {

	private static final long serialVersionUID = 1373037758460270379L;
	
	
	private UsuarioDTO usuarioDTO;
	private MedicamentoDTO medicamentoDTO;
	private List<MedicamentoDTO> medicamentos;

	//nome do medicamento para busca
	private String nome;
	
	@Autowired
	private MedicamentoDAO dao;
	
	//busca de Medicamentos
	public String buscaMedicamento() {
		medicamentos = dao.getBuscaMedicamento(medicamentoDTO);
		return "sucesso";
	}

	public MedicamentoDAO getDao() {
		return dao;
	}

	public void setDao(MedicamentoDAO dao) {
		this.dao = dao;
	}

	public MedicamentoDTO getMedicamentoDTO() {
		return medicamentoDTO;
	}

	public void setMedicamentoDTO(MedicamentoDTO medicamentoDTO) {
		this.medicamentoDTO = medicamentoDTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MedicamentoDTO> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<MedicamentoDTO> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
