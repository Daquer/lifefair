/**
 * 
 */


$(document).ready(function(){
	
	$("#datanascimento").mask("9999/99/99");

	
	
	//senhaAltera.jsp
	$("#alterarUsuario").click(function() {
		if ($("#senhaAtual").val() == "") {
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
	    }
		if ($("#novaSenha").val() == "") {
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
	    }
		if ($("#confirmarSenha").val() == "") {
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
	    }
		if ($("#novaSenha").val() != $("#confirmarSenha").val()) {
			alert("N�o foi Poss�vel realizar a altera��o da senha. " +
					"Por favor verificar os dados informados.");
    		return false;
		} else {
			var resposta = window.confirm("Tem certeza que deseja alterar a senha?");
            if(resposta) {
            	$("#alterarSenha").attr("action","alterarSenha.do");
            	$("#alterarSenha").submit();
            }
            else{
            return false; 
            }
	    }
    });
	
	//consultaTela.jsp
	$("#consultaUsuario").click(function() {
		if($("#nome").val() == ""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
		} else {
			$("#consultar").attr("action","consulta.do");
			$("#consultar").submit();
		}
	});
	
	//cadastroUsuario.jsp
	$("#cadastra").click(function() {
		if($("#nome").val() == ""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
		}
		if ($("#login").val() == "") {
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
	    }
		if ($("#senha").val() == "") {
			alert("Campo(s) obrigat�rio(s) n�o informado(s)");
    		return false;
	    }else {
	    	$("#cadastraForm").attr("action","cadastrar.do");
	    	$("#cadastraForm").submit();
	    }
	});
	
	//removerLista.jsp	
	//Confirma��o de exclus�o
	$("#removerUsuario").click(function() {
		var resposta = window.confirm("Tem certeza que deseja remover os registros " +
				"selecionados?");
        if(resposta) {
        	$("#removeForm").attr("action","excluir.do");
        	$("#removeForm").attr("method","get");
        	$("#removeForm").submit();
        } else {
        	return false; 
        }
	});
	
	$("#removerPessoa").click(function() {
		var resposta = window.confirm("Tem certeza que deseja remover os registros " +
				"selecionados?");
        if(resposta) {
        	$("#removeForm2").attr("action","excluirPessoa.do");
        	$("#removeForm2").attr("method","get");
        	$("#removeForm2").submit();
        } else {
        	return false; 
        }
	});
	
	
	
	//PESSOA =======================================================================
	//cadastroPessoa.jsp
	//s� numero para campo numero
	$("#numero").keypress(function SomenteNumero(e){
	    var tecla=(window.event)?event.keyCode:e.which;   
	    if((tecla>47 && tecla<58)) {
	        return true;
	    } else {
	        if (tecla==8 || tecla==0) {
	            return true;
	        } else {
	            return false;
	        }
	    }    
	});
	
	//s� numero para data
	
	$("#datanascimento").keypress(function SomenteNumero(e){
	    var tecla=(window.event)?event.keyCode:e.which;   
	    if((tecla>47 && tecla<58)) {
	        return true;
	    } else {
	        if (tecla==8 || tecla==0) {
	            return true;
	        } else {
	            return false;
	        }
	    }    
	});

	$("#cadastrarPessoa").click(function(){
		
		if($("#nome").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		if($("#datanascimento").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		
		
		//validar data
//		var hoje = new Date() ;
//		var data = $("#dt_nascimento").val();
//		data.getYear(data.charAt(0) + data.charAt(1) + data.charAt(2) + data.charAt(3));
//		data.getMonth(data.charAt(4) + data.charAt(5));
//		data.getDay(data.charAt(6) + data.charAt(7));
//		if(new Date(data).getTime() > hoje.getTime()){
//			alert("Data Invalida");
//			alert(Date(data).getTime());
//			alert(hoje.getTime());
//			return false;
//		}	
		
		if($("#logradouro").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		if($("#numero").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		
		if($("#email").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
			}
		
		var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			if(!filtro.test($("#email").val())){
				alert("email invalido");
				return false;
			}	
		
		if($("#uf").val()=="-1"){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		if($("#sexo").val()==("-1")){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}else{
			$("#cadastrarPessoaForm").attr("action","cadastrarPessoa.do");
			$("#cadastrarPessoaForm").submit();
		}
	});
	
	//consultaPessoa.jsp
	$("#consultarPessoa").click(function(){
		if($("#nome").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}
		if($("#datanascimento").val()==""){
			alert("Campo(s) obrigat�rio(s) n�o informado(s).");
				return false;
		}else{
			$("#consultarPessoaForm").attr("action","consultaPessoa.do");
			$("#consultarPessoaForm").submit();
		}
	});
});
	
//	$("#excluirChk").click(function(){
//		alert("oo");
//		if($("#chk").val()== ""){
//			alert("selecione para exluir");
//			return false;
//		}else{
//			
//			$("#sub").submit();
//			
//		}
//		
//	});
	
	
	// Bot�o alterar
//	$("#alterarPessoa").click(function(){
//		
//		if($("#nome").val()==""){
//			alert("campo nome Obrigatorio ");
//				return false;
//		}
//		if($("#dtn").val()==""){
//			alert("campo data de nacimento Obrigatorio ");
//				return false;
//		}
//		if($("#logradouro").val()==""){
//			alert("campo logradouro Obrigatorio ");
//				return false;
//		}
//		if($("#numero").val()==""){
//			alert("campo numero Obrigatorio ");
//				return false;
//		}
//		if($("#complemento").val()==""){
//			alert("campo complemento Obrigatorio ");
//				return false;
//		}
//		if($("#email").val()==""){
//			alert("campo email Obrigatorio ");
//				return false;
//			}
//		
//		var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
//			if(!filtro.test($("#email").val())){
//				alert("email invalido");
//					return false;
//			}	
//		
//		if($("#uf").val()=="pessoa.codUf"){
//			alert("campo uf Obrigatorio ");
//				return false;
//		}
//		if($("#sexo").val()=="pessoa.codSexo"){
//			alert("campo sexo Obrigatorio ");
//				return false;
//		}else{
//			$("#alterarPessoa").attr("action","alterarPessoa.do");
//			alert(" Alterado com Sucesso");
//			$("#alterarPessoa").submit();
//		}
//		
//	});
	





//function Verifica_Data(data, obrigatorio){  
//// Se o par�metro obrigat�rio for igual � zero, significa que elepode estar
//// vazio, caso contr�rio, n�o
//var data = document.getElementById(data);  
//    var strdata = data.value;  
//    if((obrigatorio == 1) || (obrigatorio == 0 && strdata != "")){  
//        // Verifica a quantidade de digitos informada esta correta.
//        if (strdata.length != 10){  
//            alert("Formato da data n�o � v�lido.  
//Formato correto:  
//- dd/mm/aaaa.");  
//            data.focus();  
//            return false  
//        }  
//        // Verifica m�scara da data
//        if ("/" != strdata.substr(2,1) || "/" != strdata.substr(5,1)){  
//            alert("Formato da data n�o � v�lido.  
//Formato correto:  
//- dd/mm/aaaa.");  
//            data.focus();  
//            return false  
//        }  
//        dia = strdata.substr(0,2)  
//        mes = strdata.substr(3,2);  
//        ano = strdata.substr(6,4);  
//        // Verifica o dia
//        if (isNaN(dia) || dia > 31 || dia < 1){  
//            alert("Formato do dia n�o � v�lido.");  
//            data.focus();  
//            return false  
//        }  
//        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){  
//            if (dia == "31"){  
//                alert("O m�s informado n�o possui 31 dias.");  
//                data.focus();  
//                return false  
//            }  
//        }  
//        if (mes == "02"){  
//            bissexto = ano % 4;  
//            if (bissexto == 0){  
//                if (dia > 29){  
//                    alert("O m�s informado possui somente 29 dias.");  
//                    data.focus();  
//                    return false  
//                }  
//            }else{  
//                if (dia > 28){  
//                    alert("O m�s informado possui somente 28 dias.");  
//                    data.focus();  
//                    return false  
//                }  
//            }  
//        }  
//    // Verifica o m�s
//        if (isNaN(mes) || mes > 12 || mes < 1){  
//            alert("Formato do m�s n�o � v�lido.");  
//            data.focus();  
//            return false  
//        }  
//        // Verifica o ano
//        if (isNaN(ano)){  
//            alert("Formato do ano n�o � v�lido.");  
//            data.focus();  
//            return false  
//        }  
//    }  
//}  
//
//
//
//function Verifica_Email(email, obrigatorio){  
//	// Se o par�metro obrigat�rio for igual � zero, significa que elepode estar
//	// vazio, caso contr�rio, n�o
//	    var email = document.getElementById(email);  
//	    if((obrigatorio == 1) || (obrigatorio == 0 && email.value != "")){  
//	        if(!email.value.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+.[a-zA-Z0-9._-]+)/gi)){  
//	            alert("Informe um e-mail v�lido");  
//	            email.focus();  
//	            return false  
//	        }  
//	    }  
//	}


