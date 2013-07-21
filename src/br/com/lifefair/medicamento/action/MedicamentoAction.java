package br.com.lifefair.medicamento.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.lifefair.medicamento.dao.MedicamentoDAO;
import br.com.lifefair.medicamento.domain.CarrinhoDTO;
import br.com.lifefair.medicamento.domain.ItemMedicamento;
import br.com.lifefair.medicamento.domain.MedicamentoDTO;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("request")
public class MedicamentoAction extends ActionSupport {

	private static final long serialVersionUID = 1373037758460270379L;
	
	private UsuarioDTO usuarioDTO;
	private MedicamentoDTO medicamentoDTO;
	private List<MedicamentoDTO> medicamentos;
	private CarrinhoDTO carrinho;
	private List<ItemMedicamento> itemsCarrinho;

	//nome do medicamento para busca
	private String nome;
	
	@Autowired
	private MedicamentoDAO dao;
	
	public String mostrarMedicamento() {
		medicamentoDTO = dao.getMedicamento(medicamentoDTO);
		return "sucesso";
	}
	
	public String adicionarCarrinho() {
		carrinho = (CarrinhoDTO) ActionContext.getContext().getSession().get("carrinhoLogado");
		
		MedicamentoDTO medicamento = dao.getMedicamento(medicamentoDTO);
		
		ItemMedicamento item = new ItemMedicamento();
		item.setMedicamento(medicamento);
		
		itemsCarrinho = carrinho.getItems();
		
		
		boolean jaExiste = false;
		if(itemsCarrinho.size() > 0) {
			for(int i = 0; i < itemsCarrinho.size(); i++) { //Verificacao se a quantidade vira de um novo item ou um pre-existente
				if(itemsCarrinho.get(i).getMedicamento().getId().equals(item.getMedicamento().getId())) {//Se já existe id igual
					item = itemsCarrinho.get(i);
					item.setQuantidade(item.getQuantidade() + 1);
					jaExiste = true;
				}
			}
		}
		
		if(jaExiste == false) {
			item.setQuantidade(1);
			itemsCarrinho.add(item);
		}
		
		//somar o total do carrinho
		double total = 0.00;
		
		for(int i=0; i < itemsCarrinho.size(); i++) {
			total += (itemsCarrinho.get(i).getMedicamento().getPreco() * itemsCarrinho.get(i).getQuantidade());
		}
		carrinho.setTotal(total);
		carrinho.setItems(itemsCarrinho); //atualiza a lista de itens do carrinho
		return "sucesso";
	}
	
	public String subtrairCarrinho() {
		carrinho = (CarrinhoDTO) ActionContext.getContext().getSession().get("carrinhoLogado");
		
		MedicamentoDTO medicamento = dao.getMedicamento(medicamentoDTO);
		
		ItemMedicamento item = new ItemMedicamento();
		item.setMedicamento(medicamento);
		
		itemsCarrinho = carrinho.getItems();
		
		if(itemsCarrinho.size() > 0 ) {
			for(int i = 0; i < itemsCarrinho.size(); i++) { //Verificacao se a quantidade vira de um novo item ou um pre-existente
				if(itemsCarrinho.get(i).getMedicamento().getId().equals(item.getMedicamento().getId())) {//Se já existe id igual
					item = itemsCarrinho.get(i);
					item.setQuantidade(item.getQuantidade() - 1);
					if(item.getQuantidade() == 0) {
						itemsCarrinho.remove(i);
					}
				}
			}
		}
		
		//somar o total do carrinho
		double total = 0.00;
		
		for(int i=0; i < itemsCarrinho.size(); i++) {
			total += (itemsCarrinho.get(i).getMedicamento().getPreco() * itemsCarrinho.get(i).getQuantidade());
		}
		
		carrinho.setTotal(total);
		carrinho.setItems(itemsCarrinho); //atualiza a lista de itens do carrinho
		return "sucesso";
	}
	
	public String mostrarCarrinho() {
		carrinho = (CarrinhoDTO) ActionContext.getContext().getSession().get("carrinhoLogado");
		itemsCarrinho = carrinho.getItems();
		return "sucesso";
	}
	
	public String compraPagamento() {
		//TODO criar compraPagamento.jsp com bandeiras, usar a netshoes como padrão para o carrinho.
		carrinho = (CarrinhoDTO) ActionContext.getContext().getSession().get("carrinhoLogado");
		usuarioDTO = (UsuarioDTO) ActionContext.getContext().getSession().get("usuarioLogado");
		return "sucesso";
	}
	
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

	public CarrinhoDTO getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDTO carrinho) {
		this.carrinho = carrinho;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ItemMedicamento> getItemsCarrinho() {
		return itemsCarrinho;
	}

	public void setItemsCarrinho(List<ItemMedicamento> itemsCarrinho) {
		this.itemsCarrinho = itemsCarrinho;
	}
}
