<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da Busca</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Comprar</th>
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
		<s:iterator value="medicamentos">
			<tr>
				<td><a href='mostrarMedicamento.do?medicamentoDTO.id=<s:property value="id" />'>Exibir</a></td>
				<td><s:property 
						value="nome" /></td>
				<td><s:property 
						value="tarja" /></td>
				<td><s:property 
						value="principios_ativos" /></td>
				<td><s:property 
						value="mg_por_g" /></td>
				<td><s:property 
						value="dtfabric" /></td>
				<td><s:property 
						value="vencimento" /></td>
				<td><s:property 
						value="peso" /></td>
				<td><s:property 
						value="descricao_de_uso" /></td>
				<td><s:property 
						value="preco" /></td>						
			</tr>
		</s:iterator>
</table>

</body>
</html>