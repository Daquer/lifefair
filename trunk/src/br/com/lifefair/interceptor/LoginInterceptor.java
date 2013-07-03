package br.com.lifefair.interceptor;

import br.com.lifefair.medicamento.domain.CarrinhoDTO;
import br.com.lifefair.usuario.domain.UsuarioDTO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor extends ActionSupport implements Interceptor  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		UsuarioDTO usuarioLogado = (UsuarioDTO) invocation.getInvocationContext().getSession().get("usuarioLogado");
		CarrinhoDTO carrinho = (CarrinhoDTO) invocation.getInvocationContext().getSession().get("carrinhoLogado");
		if (usuarioLogado == null) {
			addActionError("Faça Login para poder acessar esta área.");
			return "invalido";
		} else {
			return invocation.invoke();
		}
		
		
	}

	//init e destroy

	public void destroy() {
		System.out.println("Destruindo InterceptorAction...");

	}

	public void init() {
		System.out.println("Inicializando InterceptorAction...");

	}
}