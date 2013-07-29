<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Medicamento</title>
</head>
<body>
	<table>
		<s:form action="cadastrarMedicamento.do" method="post" enctype="multipart/form-data">
		<tr>
			<td>
				Nome <s:textfield name="medicamentoDTO.nome" />
			</td>
		</tr>
		<tr>
			<td>
				Tarja <s:textfield name="medicamentoDTO.tarja" />
			</td>
		</tr>
		<tr>
			<td>
				Principios ativos <s:textfield name="medicamentoDTO.principios_ativos" />
			</td>
		</tr>
		<tr>
			<td>
				Mg/g <s:textfield name="medicamentoDTO.mg_por_g" />
			</td>
		</tr>
		<tr>
			<td>
				Data de Fabricação <s:textfield name="medicamentoDTO.dtfabric" />
			</td>
		</tr>
		<tr>
			<td>
				Vencimento <s:textfield name="medicamentoDTO.vencimento" />
			</td>
		</tr>	
		<tr>
			<td>
				Peso (gramas)<s:textfield name="medicamentoDTO.peso" />
			</td>
		</tr>
		<tr>
			<td>
				Descrição de uso <s:textfield name="medicamentoDTO.descricao_de_uso" />
			</td>
		</tr>
		<tr>
			<td>
				Preço <s:textfield name="medicamentoDTO.preco" />
			</td>
		</tr>
		<tr>
			<td>
				Imagem <input type="file" name="imagem" />
			</td>
		</tr>
		<tr>
			<td>
				<s:submit value="Cadastrar" />
			</td>
		</tr>
		</s:form>
	</table>
</body>
</html>