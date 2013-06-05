package br.com.lifefair.usuario.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class LoginAction {

	
	private static final long serialVersionUID = -4049607468860054923L;
	
	public String login() {
		return "sucesso";
	}
}
