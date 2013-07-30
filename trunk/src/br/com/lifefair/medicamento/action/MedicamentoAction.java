package br.com.lifefair.medicamento.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;


@Controller
@Scope("request")
public class MedicamentoAction extends ActionSupport {

	private static final long serialVersionUID = 1373037758460270379L;
	
	private UsuarioDTO usuarioDTO;
	private MedicamentoDTO medicamentoDTO;
	private List<MedicamentoDTO> medicamentos;
	private CarrinhoDTO carrinho;
	private List<ItemMedicamento> itemsCarrinho;
	private File imagem;
	private String extensao;
	private List<FileItem> formItems;
	
	 // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

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
	
	public String cadastroMedicamento() {
		return "sucesso";
	}
	
	public String cadastrarMedicamento() {
		// configures upload settings
		/*DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk 
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);*/
		String caminhoDestino = "C:/workspace - Siscomat/LifeFair/WebContent/includes/images/"+medicamentoDTO.getNome() + "." + getExtensao();
        try {
        	//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        	//URL url = classLoader.getResource("123.jpg");

        	//Procurar usar o path relativo ao projeto
        	//Mudar para server-side e não algo que faz cópia na mesma máquina
        	//Observar que a imagem do medicamento não é carregada de imediato por ser necessário um refresh no projeto
			copy(this.imagem, new File(caminhoDestino));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		/*} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
		}
        int tamanhoCaminho = caminhoDestino.split("WebContent/").length;
        caminhoDestino = caminhoDestino.split("WebContent/")[tamanhoCaminho - 1];
        
        this.medicamentoDTO.setImagem(caminhoDestino);
        
        dao.incluirMedicamento(this.medicamentoDTO);
		return "sucesso";
	}
	
	private void copy(File src, File dst) throws IOException {  
	    InputStream in = new FileInputStream(src);  
	    OutputStream out = new FileOutputStream(dst);  
	  
	    // Transfer bytes from in to out  
	    byte[] buf = new byte[1024];  
	    int len;  
	    while ((len = in.read(buf)) > 0) {  
	        out.write(buf, 0, len);  
	    }  
	    in.close();  
	    out.close();  
	}  
	
	//carrega imagem de um inputStream. Proprio para uso dentro de action web  
	/*	private static BufferedImage loadImageFromInputStream(InputStream in) throws IOException {
			JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
			BufferedImage result = decoder.decodeAsBufferedImage();
			return result;
		}
	*/
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

	public File getImagem() {
		return imagem;
	}

	public void setImagem(File imagem) {
		this.imagem = imagem;
	}

	public List<FileItem> getFormItems() {
		return formItems;
	}

	public void setFormItems(List<FileItem> formItems) {
		this.formItems = formItems;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
}
