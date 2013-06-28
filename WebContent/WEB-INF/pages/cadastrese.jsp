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
				<td>Nome completo <s:textfield name="pacienteDTO.nome_completo" />
				</td>
			</tr>
			
			<tr class="paciente">
				<td>Data de nascimento <s:textfield name="pacienteDTO.datanasc" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>Telefone <s:textfield name="pacienteDTO.telefone" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>Endereço <s:textfield name="pacienteDTO.endereco" />
				</td>
			</tr>
			<tr class="paciente">
				<td>E-mail <s:textfield name="pacienteDTO.email" />
				</td>
			</tr>
			<tr class="paciente">
				<td>Alergias <s:textfield name="pacienteDTO.alergias" />
				</td>
			</tr>
			<tr class="paciente">
				<td>
			<tr class="paciente">
				<td>CRM do Medico <s:textfield name="medicoDePac" />
				</td>
			</tr>
			<tr class="paciente">
				<td>Problemas de Saúde <s:textfield name="pacienteDTO.problemas" />
				</td>
			</tr>

			<!-- Médico -->
			<tr class="medico">
				<td>CPF <s:textfield name="medicoDTO.cpf" />
				</td>
			</tr>
			<tr class="medico">
				<td>CRM <s:textfield name="medicoDTO.crm" />
				</td>
			</tr>
			<tr class="medico">
				<td>Local de Trabalho <s:textfield name="medicoDTO.local_trabalho" />
				</td>
			</tr>
			<tr class="medico">
				<td>Endereco <s:textfield name="medicoDTO.endereco" />
				</td>
			</tr>
			<tr class="medico">
				<td>E-mail <s:textfield name="medicoDTO.email" />
				</td>
			</tr>
			<tr class="medico">
				<td>Telefone <s:textfield name="medicoDTO.telefone" />
				</td>
			</tr>
		</table>
		Médico ou paciente?
		<s:radio label="tipo" name="tipo" list="tipos" /><br />
		<s:submit value="Cadastrar" id="cadastrar" />
		<br />
	</form>
</body>
</html>