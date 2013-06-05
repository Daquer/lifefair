<%@ page language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
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
						<s:if test="%{true}">
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
						
						</s:if>
					</tbody>
				</table>
			</div>
	
	
	<decorator:body />
	</div>
</html>