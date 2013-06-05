<%@ page language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta name="titulo" content="LifeFair" />
<meta name="subtitulo" content="Página Teste" />
</head>
<body>
<p class="destaque">Esta página é apenas uma
referência para o desenvolvimento da jsp, utilizando o css de referência.</p>
<br/>

<s:form action="">
	<table width="30%" class="tabela_interna">
		<tr>
			<th colspan="2">Saudação</th>
		</tr>
		<tr>
			<td width="120">Nome: <span class="obrigatorio">*</span></td>
			<td><s:textfield name="nome" maxlength="200" size="30" /></td>
		</tr>
	</table>
	<table id="tabela_botoes" cellspacing="0" cellpadding="0" border="0"
		width="30%">
		<tr align="center">
		<td>
			<s:submit value="Consultar" cssClass="margem_botoes button" />
			</td>
		</tr>
	</table>
</s:form>
</body>
</html>