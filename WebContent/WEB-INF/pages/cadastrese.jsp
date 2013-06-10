<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastre-se</title>
</head>
<body>
	<form action="cadastro.do" method="post">
		Nome<s:textfield name="usuarioDTO.nome" /><br />
		Login<s:textfield name="usuarioDTO.login" /><br />
		Senha<s:password name="usuarioDTO.senha"/><br />
		Confirmar senha<s:password /><br />
		Médico ou paciente? <s:radio label="tipo" name="tipo" list="tipos" /><br />
		
		<s:submit value="Cadastrar"/>
	</form>
</body>
</html>