<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="br.com.lifefair.usuario.domain.UsuarioDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="medicamentoDTO.nome" /></title>
</head>
<body>
	<table>
		<tr>
			<th>Imagem</th>
			<th>Nome</th>
			<th>Tarja</th>
			<th>Princípios Ativos</th>
			<th>mg/g</th>
			<th>Data de fabricação</th>
			<th>Vencimento</th>
			<th>Peso</th>
			<th>Descricao de uso</th>
			<th>Preço</th>
		</tr>
		<tr>
			<td><img src="<s:property 
					value="medicamentoDTO.imagem" />" /></td> <!-- usar ajax caso implemento um dia como blob -->
			<td><s:property 
					value="medicamentoDTO.nome" /></td>
			<td><s:property 
					value="medicamentoDTO.tarja" /></td>
			<td><s:property 
					value="medicamentoDTO.principios_ativos" /></td>
			<td><s:property 
					value="medicamentoDTO.mg_por_g" /></td>
			<td><s:property 
					value="medicamentoDTO.dtfabric" /></td>
			<td><s:property 
					value="medicamentoDTO.vencimento" /></td>
			<td><s:property 
					value="medicamentoDTO.peso" /></td>
			<td><s:property 
					value="medicamentoDTO.descricao_de_uso" /></td>
			<td><s:property 
					value="medicamentoDTO.preco" /></td>
		<%
			UsuarioDTO usuario = (UsuarioDTO) request.getSession()
			.getAttribute("usuarioLogado");
			if (usuario.getTipo().equals("pac")) {
		%>
			<td><input type="button" value="Adicionar ao carrinho" onclick='window.location="adicionarCarrinho.do?medicamentoDTO.id=<s:property value="medicamentoDTO.id" />"'/></td>
		<%
			}
		%>
		</tr>
	</table>
</body>
</html>