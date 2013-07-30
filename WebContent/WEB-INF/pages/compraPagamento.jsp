<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.lifefair.medicamento.domain.CarrinhoDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>
</head>
<body>
	<form>
		<table>
		<tr>
		<td>Compra no valor de <%CarrinhoDTO carrinho = (CarrinhoDTO) request.getSession().getAttribute("carrinhoLogado"); 
						out.print(String.format("%.2f",carrinho.getTotal()));%> reais.</td></tr>
			<tr>
				<td>
					<img src="includes/images/visa.png" id="visa_img" />
				</td>
				<td>
					<img src="includes/images/mastercard.png" id="mastercard_img" />
				</td>
				<td>
					<img src="includes/images/aexpress.png" id="aexpress_img" />
				</td>
			</tr>
			<tr style="text-align:center;">
				<td>
					<input type="radio" name="cartao" />
				</td>
				<td>
					<input type="radio" name="cartao" />
				</td>
				<td>
					<input type="radio" name="cartao" />
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>