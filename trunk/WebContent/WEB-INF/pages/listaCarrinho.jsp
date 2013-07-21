<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="br.com.lifefair.medicamento.action.MedicamentoAction"%>
<%@page import="br.com.lifefair.medicamento.domain.MedicamentoDTO"%>
<%@page import="br.com.lifefair.medicamento.domain.CarrinhoDTO"%>
<%@page import="java.util.List;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho</title>

<script type="text/javascript">
	function adicionaQuantidade(id) {
		var string = 'adicionarCarrinho.do?medicamentoDTO.id=' + id;
		window.location.href = string;
	}
	
	function subtrairQuantidade(id) {
		if($("#"+id).text() == '1') {
			var r=confirm("Tem certeza que deseja deletar o item?");
			if(r==true){
				var string = 'subtrairCarrinho.do?medicamentoDTO.id=' + id;
				window.location.href = string;		
			}else {
				return false;
			}
		} else {
			var string = 'subtrairCarrinho.do?medicamentoDTO.id=' + id;
			window.location.href = string;
		}
	}
	
	function compraPagamento() {
		window.location.assign('compraPagamento.do');
	}
</script>
</head>
<body>
	<h1>Carrinho</h1>
	<table>
		<tr>
			<th>Imagem</th>
			<th>Nome</th>
			<th>Preco</th>
			<th>Quantidade</th>
			<th>Comprar</th>
		</tr>
		<s:iterator value="itemsCarrinho" var="item">
		 <!-- possibilidade para usar imagem na iteração -->
				<tr>
					<td><img src="<s:property value="medicamento.imagem" />" /></td>
					<td><s:property value="medicamento.nome" /></td>
					<td><s:property value="medicamento.preco" /></td>
					<td><input type="button" value="-" onclick="subtrairQuantidade(<s:property value="medicamento.id" />)" /> <span id="<s:property value="medicamento.id" />"><s:property value="quantidade" /></span>
					<input type="button" value="+" onclick="adicionaQuantidade(<s:property value="medicamento.id" />)" /></td>
					
				</tr>
		</s:iterator>
		<tr><td>Total: <%CarrinhoDTO carrinho = (CarrinhoDTO) request.getSession().getAttribute("carrinhoLogado"); 
						out.print(String.format("%.2f",carrinho.getTotal()));%> <td><input type="button" value="Finalizar compra" onclick="compraPagamento()" /></td></td></tr>
	</table>
</body>
</html>