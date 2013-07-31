<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.lifefair.medicamento.domain.CarrinhoDTO"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>
</head>
<body>
	Compra no valor de
	<%
	CarrinhoDTO carrinho = (CarrinhoDTO) request.getSession()
			.getAttribute("carrinhoLogado");
	out.print(String.format("%.2f", carrinho.getTotal()));
	%>
	reais.
	<s:form action="compra.do" method="post">
		<table>
			<tr>
				<td><input type="radio" name="cartao" /></td>
				<td><input type="radio" name="cartao" /></td>
				<td><input type="radio" name="cartao" /></td>
			</tr>
			<tr>
				<td><img src="includes/images/visa.png" id="visa_img" /></td>
				<td><img src="includes/images/mastercard.png"
					id="mastercard_img" /></td>
				<td><img src="includes/images/aexpress.png" id="aexpress_img" />
				</td>
			</tr>
			<tr>
				<td colspan="3">Nome Como Consta no Cartão<br> <input
					type="text" name="NomeCartao" size="50" maxlength="80">
				</td>
			</tr>
			<tr>
				<td colspan="3">Número do cartão<br> <s:textfield
					name="compraDTO.numCartao " size="16" maxlength="16" />
				</td>
			</tr>
			<tr>
				<td width="50%" colspan="3">Código de Segurança:<br> <input
					type="text" name="CodigoAutorizacao" size="6" maxlength="4">
				</td>
			</tr>
			<tr>
				<td width="50%" class="normal"><br>Mês e Ano de Validade<br>
					<input type="text"  size="2" maxlength="2" />
					<input type="text" size="4" maxlength="4"/> (mm/aaaa)
				</td>
			</tr>
			<tr><td>
				<s:submit value="Comprar" />
			</td></tr>
		</table>
	</s:form>
</body>
</html>