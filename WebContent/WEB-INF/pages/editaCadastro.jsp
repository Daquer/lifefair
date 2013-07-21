<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="br.com.lifefair.usuario.domain.UsuarioDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de cadastro</title>
</head>
<body>
<%
if (request.getSession().getAttribute("usuarioLogado") != null) {
UsuarioDTO usuario = (UsuarioDTO) request.getSession()
									.getAttribute("usuarioLogado");%>
	<table>
		<s:form action="atualizaCadastro" method="post" >
			<tr>
				<td>Nome <s:textfield name="usuarioDTO.nome" />
				</td>
			</tr>
			<tr>
				<td>Login <s:textfield name="usuarioDTO.login" />
				</td>
			</tr>
			<tr>
				<td>Senha <s:password name="usuarioDTO.senha" />
				</td>
			</tr>
			<tr>
				<td>Confirmar senha <s:password name="confirmarSenha"/>
				</td>
			</tr>
		<%
			if (usuario.getTipo().equals("pac")) {
		%>
			<tr>
				<td>Nome completo <s:textfield name="pacienteDTO.nome_completo" />
				</td>
			</tr>
			
			<tr>
				<td>Data de nascimento <s:textfield name="pacienteDTO.datanasc" />
				</td>
			</tr>
			<tr>
				<td>Telefone <s:textfield name="pacienteDTO.telefone" />
				</td>
			</tr>
			<tr>
				<td>Endereço <s:textfield name="pacienteDTO.endereco" />
				</td>
			</tr>
			<tr>
				<td>E-mail <s:textfield name="pacienteDTO.email" />
				</td>
			</tr>
			<tr>
				<td>Alergias <s:textfield name="pacienteDTO.alergias" />
				</td>
			</tr>
			<tr>
				<td>CRM do Medico <s:textfield name="medicoDePac" />
				</td>
			</tr>
			<tr>
				<td>Problemas de Saúde <s:textfield name="pacienteDTO.problemas" />
				</td>
			</tr>
		<%
			}else if (usuario.getTipo().equals("med")) {
		%>
			<tr>
				<td>CPF <s:textfield name="medicoDTO.cpf" />
				</td>
			</tr>
			<tr>
				<td>CRM <s:textfield name="medicoDTO.crm" />
				</td>
			</tr>
			<tr>
				<td>Local de Trabalho <s:textfield name="medicoDTO.local_trabalho" />
				</td>
			</tr>
			<tr>
				<td>Endereco <s:textfield name="medicoDTO.endereco" />
				</td>
			</tr>
			<tr>
				<td>E-mail <s:textfield name="medicoDTO.email" />
				</td>
			</tr>
			<tr>
				<td>Telefone <s:textfield name="medicoDTO.telefone" />
				</td>
			</tr>
		<% } 
		}%>
		</s:form>
	
	</table>
</body>
</html>