package br.com.lifefair.usuario.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("request")
public class InicioAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4049607468860054923L;

	
	public String inicio() {
		return "inicio";
	}

}
