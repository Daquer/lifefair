<%@page import="org.apache.wicket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@page import="br.com.lifefair.usuario.action.UsuarioAction"%>
<%@page import="br.com.lifefair.usuario.domain.UsuarioDTO"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><decorator:title default="LifeFair" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="includes/css/master.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value='/includes/js/jquery-1.7.2.min.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/includes/js/jquery.maskedinput-1.2.2.js'/>"></script>
<script type="text/javascript"
	src="<s:url value='/includes/js/default.js'/>"></script>

<decorator:head />
</head>
<body>
	<div id="total">
		<div id="topo">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr width="100%">
							<td class="">
									<a class="" href="">
										<strong>
											<img src="includes/LifeFair.png" />
										</strong>
									</a>
							</td>
					</tr>
			</table>
		</div>
		<div id="menu">
		
			<table >
				<tbody>
				<%if(request.getSession().getAttribute("usuarioLogado") == null) {%>
					<s:form action="login" method="post">
							<tr>
								<td class=""><a class=""
									href=""><strong>Login</strong></a></td>
			
								<td class=""><a class="" href=""><strong>Fale Conosco</strong></a></td>
			
								<td class=""><a class=""
									href=""><strong>Cadastre-se</strong></a></td>
			
								<td class="">
									<a class="" href="">
										<strong>
											O Site
										</strong>
									</a>
								</td>
								<td class="white_bold">
									Login
								</td>
								<td>
									<s:textfield name="usuarioDTO.login" id="meuLogin" maxlength="10" />
								</td>
				
				
								<td class="white_bold">Password</td>
								<td><s:password name="usuarioDTO.senha" id="senha" maxlength="8" /></td>
								<td class="botao">
									<s:submit cssClass="botao_layout" value="Login" id="logar"/>
								</td>
							</tr>
				
						</s:form>
					<%} else {
					UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuarioLogado");%>
					<tr>
								<td class=""><a class=""
									href=""><strong>Cadastro/Consultas</strong></a></td>
			
								<td class=""><a class="" href=""><strong>Compra/Pesquisa</strong></a></td>
								
								<%if(usuario.getTipo().equals("med")) { %>
									<td class=""><a class=""
										href=""><strong>�rea do M�dico</strong></a></td>
								<%} else if (usuario.getTipo().equals("pac")) { %>
								<td class="">
									<a class="" href="">
										<strong>
											�rea do Paciente
										</strong>
									</a>
								</td>
								<%} %>
								<td>
									Id:${usuarioLogado.id} |Login:${usuarioLogado.login}</a>
		
									<b class="white_bold">||</b><a href="logoff.do" class="bemvindo">
									Logout</a>
								</td>
						</tr>
					<%} %>
					
				</tbody>
			</table>
		</div>
	
	
		<table id="tabela_principal" width="100%" align="center">
				<tr>
	
					<span class="subtitulo"><decorator:getProperty
							property="meta.subtitulo" /></span>
					<br />
					<br />
					<s:if test="hasFieldErrors()">
						<table width="95%" border="0" cellpadding="5" cellspacing="0"
							class="tabela_verm" id="msgErros">
							<tbody>
								<tr>
									<td>
										<s:iterator value="fieldErrors">
											<li>
												<s:property value="value[0]" />
											</li>
										</s:iterator>
									</td>
								</tr>
							</tbody>
						</table>
					</s:if>
					<s:if test="hasActionErrors()">
						<table width="95%" border="0" cellpadding="5" cellspacing="0"
							class="tabela_verm" id="msgErros">
							<tbody>
								<tr>
									<td>
										<s:iterator value="actionErrors">
											<li>
												<s:property />
											</li>
										</s:iterator>
									</td>
								</tr>
							</tbody>
						</table>
					</s:if>
					<s:if test="hasActionMessages()">
						<table width="95%" border="0" cellpadding="5" cellspacing="0"
							class="tabela_sucesso" id="msgSucesso">
							<tbody>
								<tr>
									<td>
										<s:iterator value="actionMessages">
											<li>
												<s:property />
											</li>
										</s:iterator>
									</td>
								</tr>
							</tbody>
						</table>
					</s:if>
					<%-- Exibe uma caixa de mensagem oculta para exibi��o de valida��es javascript e ajax --%>
					<table id="id-box-msg" width="95%" border="0" cellpadding="5"
						cellspacing="0" class="tabela_verm" style="display: none;">
						<tbody>
							<tr>
								<td id="id-msg"></td>
							</tr>
						</tbody>
					</table>
					<br />
				<decorator:body />
			</tr>
		</table>
	</div>
</html>