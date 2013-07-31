<%@page import="org.apache.wicket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@page import="br.com.lifefair.usuario.action.UsuarioAction"%>
<%@page import="br.com.lifefair.usuario.domain.UsuarioDTO"%>
<%@page import="br.com.lifefair.medicamento.domain.CarrinhoDTO"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><decorator:title default="LifeFair" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="includes/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value='/includes/js/jquery-1.7.2.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/includes/js/jquery.maskedinput-1.2.2.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/includes/js/jquery.validate.min.js' />"></script>
<script type="text/javascript"
	src="<s:url value='/includes/js/default.js'/>"></script>

<script type="text/javascript">
	function search(e) {
		var tecla = (window.event) ? event.keyCode : e.which;
		if (tecla == 13) {
			window.location.assign('buscaMedicamento.do?medicamentoDTO.nome='
					+ e.value);
		} else {
			return false;
		}
	}
	
	function login(e) {
		var tecla = (window.event) ? event.keyCode : e.which;
		if (tecla == 13) {
			$("#login").submit();
		} else {
			return false;
		}
	}
</script>
<decorator:head />
</head>
<body>
	<div id="wrapper">
		<div id="topo">

				<div id="header-wrapper"><div id="logo"> <h1><a>LifeFair</a></h1></div>
					<!-- a class="" href=""> <strong> <img id="logo"
								src="includes/images/LifeFair.png" />
						</strong>
					</a -->
				</div>

		</div>
		<div id="menu">

			
					<%
						if (request.getSession().getAttribute("usuarioLogado") == null) {
					%>
					<s:form action="login" id="login" method="post" >
						<ul>
							<li><span>Login</span></li>
							<li><s:textfield name="usuarioDTO.login" id="meuLogin"
									maxlength="10" /></li>


							<li><span>Password</span></li>
							<li><s:password name="usuarioDTO.senha" id="senha"
									maxlength="8" /></li>
							<li><s:submit cssClass="botao_layout"
									value="Login" id="logar" /></li>
							<li><a class="" href="cadastrese.do"><sub>ou
										Cadastre-se</sub></a></li>
						</ul>

					</s:form>
				
					<%
						} else {
							UsuarioDTO usuario = (UsuarioDTO) request.getSession()
									.getAttribute("usuarioLogado");
					%>
					
					<ul>
								<li><a href="editarCadastro.do">Meu
											Cadastro</a><li>
		
								<%
									if (usuario.getTipo().equals("med")) {
								%>
								<li><a href="cadastroMedicamento.do">Cadastrar Medicamento</a></li>
								<%
									}
								%>
								<li><s:textfield id="search-text" onkeypress="search(this)"
										onclick='this.value = ""; this.style.opacity = 1.0; return false;'
										style="opacity: 0.4;" value="remédio?" />
								</li>
								<li><a href="editarCadastro.do">Olá ${usuarioLogado.nome}</a></li>
								<li><a href="logoff.do">Logout</a></li>
								<%
									if (usuario.getTipo().equals("pac")) {
								%>
								<li><a href="mostrarCarrinho.do"> <img src="includes/images/shopping_cart.png"
									width="30px" height="30px" />
									<%
										if (request.getSession().getAttribute("carrinhoLogado") !=null){
											CarrinhoDTO carrinho = (CarrinhoDTO) request.getSession()
													.getAttribute("carrinhoLogado");
											out.println(carrinho.getItems().size() + (carrinho.getItems().size() == 1 ? " item" :" items"));
										}
									%></a></li>
								<%
									}
								%>
						</ul>	
					<%
						}
					%>
		</div>
		<div id="page">
			<div id="page-bgtop">
				<div id="page-bgbtm">
				<decorator:body />
				</div>
				</div>
				</div>
	</div>
</html>