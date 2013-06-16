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
		<table>
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
				<td>Confirmar senha <s:password />
				</td>
			</tr>

			<!-- Paciente -->
			<tr class="paciente">
				<td>Data de Nacimento <s:textfield name="dt_nasc" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>Telefone <s:textfield name="tel_pac" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>Endereço <s:textfield name="endereco_pac" />
				</td>
			</tr>
			<tr class="paciente">
				<td>E-mail <s:textfield name="email_pac" />
				</td>
			</tr>
			<tr class="paciente">
				<td>Alergias <s:textfield name="alergias" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>Medico <s:textfield name="medico" />
				</td>
			</tr>
			<tr class="paciente">
				<td>Problemas de Saúde <s:textfield name="problemas" />
				</td>
			</tr>

			<!-- Médico -->
			<tr class="medico">
				<td>CPF <s:textfield name="cpf" />
				</td>
			</tr>
			<tr class="medico">
				<td>CRM <s:textfield name="crm" />
				</td>
			</tr>
			<tr class="medico">
				<td>Local de Trabalho <s:textfield name="local_trab" />
				</td>
			</tr>
			<tr class="medico">
				<td>Endereco <s:textfield name="endereco_med" />
				</td>
			</tr>
			<tr class="medico">
				<td>E-mail <s:textfield name="email_med" />
				</td>
			</tr>
			<tr class="medico">
				<td>Telefone <s:textfield name="tel_med" />
				</td>
			</tr>
			<s:submit value="Cadastrar" />
		</table>
		Médico ou paciente?
		<s:radio label="tipo" name="tipo" list="tipos" />
		<br />
	</form>
</body>
</html>