//TODO o item Bem vindo recebe hide na tela de login
$(document).ready( function() {
		
/*		if($("input:submit").val() == 'Login') {
			$("div#menu").hide();
			$("span#usuario").hide();
		}
		
		$("#data").mask("99/99/9999");*/
		
		//Tela de Login
		//Validação (somente números e letras)
		$("#meuLogin,#senha").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla>47 && tecla<58) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123)) { //só numero, e letras.
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		$("#tipoPaciente").click( function ChangeCadastro(){
			$(".medico").hide();
			$(".paciente").show();
		});
		
		$("label[for=tipoMedico]").html("M&eacute;dico");
		$("#tipoMedico").click( function ChangeCadastro(){
			$(".medico").show();
			$(".paciente").hide();
		});
});
		
		
		/*$("#logar").click(function() {
			if ($("#meuLogin").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
			if ($("#senha").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
		});
		
		//operacaoDeEmprestimo.jsp
		$("#submitEmprestimo").click( function() {
			var retornei = false;
			
			$(":text:enabled.naoTabela").each ( function(){
				if($(this).val() == "") {
					alert("Campo(s) obrigatório(s) não informado(s).");
					retornei = 1;
					return false;
				}
			});
			
			if(retornei) return false;
			
			$(":text:enabled.textfield").each( function() {
				if($(this).val() == "") {
					alert("Diga o número de peças para o empréstimo.");
					retornei = 1;
					return false;
				}
			});
			
			if(retornei) return false;
			
			if(!$(":checkbox").is(':checked')) {
				alert("Selecione ao menos uma peça.");
	    		return false;
			}

			if($("#selectRadio").val() == "-1") {
				alert("Selecione o radio.");
	    		return false;
			}
			
				
		});
		
		$("#missao").keypress(function SomenteLetras(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla==32) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123) || (tecla>47 && tecla<58)) { //só letras e espaço e numero
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		//checkbox que marca todas as outras.
		$("#chkMaster").click(function() {
			if($("#chkMaster").is(':checked')) {
	          $(":checkbox").attr('checked', true);
	          $(":checkbox").next(".textfield").removeAttr('disabled');
			} else {
	          $(":checkbox").attr('checked', false);
	          $(":checkbox").next(".textfield").attr('disabled','disabled');
			}
		});
		
		//clique na checkbox para habilitar o textfield ao lado.
		$(":checkbox").click(function() {
			if($(this).is(':checked')) {
				$(this).next(".textfield").removeAttr('disabled');
			} else {
				$(this).next(".textfield").attr('disabled','disabled');
			}
		});
		
		//CadastroBeneficiario.jsp
		$("#cadastroBeneficiario").click( function() {
			if($("#nome").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
			if($("#nip").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
			if($("#graduacao").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
		});
		
		//nome
		$("#nome,#graduacao").keypress(function SomenteLetras(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla==32) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123)) { //só letras e espaço
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		//nip
		$("#nip").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla>47 && tecla<58)) { //só numero
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		//CadastroMaterial.jsp
		$("#submitRadio").click( function() {
			if($("#codigoRadio").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
		});
		
		$("#codigoRadio").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla==32) || (tecla==45) || (tecla==47) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123) || (tecla>47 && tecla<58)) { //só numero, letras, espaço, hifen e barra
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		$("#submitPeca").click( function() {
			if($("#codigoPeca").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
			if($("#qtdPeca").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
		});
		
		
		$("#codigoPeca").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla==32) || (tecla==45) || (tecla==47) || (tecla>64 && tecla<91) || (tecla>96 && tecla<123) || (tecla>47 && tecla<58)) { //só numero, letras, espaço, hifen e barra
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		$("#qtdPeca").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla>47 && tecla<58)) { //só numero
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		
		//RecebimentoMaterial
		$("#submitRecebimento").click( function() {
			if($("#numeroEmissao").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
				return false;
			}
		});
		
		$("#numeroEmissao").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla>47 && tecla<58)) { //só numero
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		//======================================================================
		//senhaAltera.jsp
		$("#alterarUsuario").click(function() {
			if ($("#senhaAtual").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
			if ($("#novaSenha").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
			if ($("#confirmarSenha").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
			if ($("#novaSenha").val() != $("#confirmarSenha").val()) {
				alert("Não foi Possível realizar a alteração da senha. " +
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
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
			} else {
				$("#consultar").attr("action","consulta.do");
				$("#consultar").submit();
			}
		});
		
		//cadastroUsuario.jsp
		$("#cadastra").click(function() {
			if($("#nome").val() == ""){
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
			}
			if ($("#login").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }
			if ($("#senha").val() == "") {
				alert("Campo(s) obrigatório(s) não informado(s)");
	    		return false;
		    }else {
		    	$("#cadastraForm").attr("action","cadastrar.do");
		    	$("#cadastraForm").submit();
		    }
		});
		
		//removerLista.jsp	
		//Confirmação de exclusão
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
		//só numero para campo numero
		$("#numero").keypress(function SomenteNumero(e){
		    var tecla=(window.event)?event.keyCode:e.which;   
		    if((tecla>47 && tecla<58)) {
		        return true;
		    } else {
		        if (tecla==8 || tecla==0) { //8=backspace 0=nulo
		            return true;
		        } else {
		            return false;
		        }
		    }    
		});
		
		//só numero para data
		
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
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			if($("#datanascimento").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			
			
			//validar data
//				var hoje = new Date() ;
//				var data = $("#dt_nascimento").val();
//				data.getYear(data.charAt(0) + data.charAt(1) + data.charAt(2) + data.charAt(3));
//				data.getMonth(data.charAt(4) + data.charAt(5));
//				data.getDay(data.charAt(6) + data.charAt(7));
//				if(new Date(data).getTime() > hoje.getTime()){
//					alert("Data Invalida");
//					alert(Date(data).getTime());
//					alert(hoje.getTime());
//					return false;
//				}	
			
			if($("#logradouro").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			if($("#numero").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			
			if($("#email").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
				}
			
			var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
				if(!filtro.test($("#email").val())){
					alert("email invalido");
					return false;
				}	
			
			if($("#uf").val()=="-1"){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			if($("#sexo").val()==("-1")){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}else{
				$("#cadastrarPessoaForm").attr("action","cadastrarPessoa.do");
				$("#cadastrarPessoaForm").submit();
			}
		});
		
		//consultaPessoa.jsp
		$("#consultarPessoa").click(function(){
			if($("#nome").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}
			if($("#datanascimento").val()==""){
				alert("Campo(s) obrigatório(s) não informado(s).");
					return false;
			}else{
				$("#consultarPessoaForm").attr("action","consultaPessoa.do");
				$("#consultarPessoaForm").submit();
			}
		});
	});
			
//			$("#excluirChk").click(function(){
//				alert("oo");
//				if($("#chk").val()== ""){
//					alert("selecione para exluir");
//					return false;
//				}else{
//					
//					$("#sub").submit();
//					
//				}
//				
//			});
			
			
			// Botão alterar
//			$("#alterarPessoa").click(function(){
//				
//				if($("#nome").val()==""){
//					alert("campo nome Obrigatorio ");
//						return false;
//				}
//				if($("#dtn").val()==""){
//					alert("campo data de nacimento Obrigatorio ");
//						return false;
//				}
//				if($("#logradouro").val()==""){
//					alert("campo logradouro Obrigatorio ");
//						return false;
//				}
//				if($("#numero").val()==""){
//					alert("campo numero Obrigatorio ");
//						return false;
//				}
//				if($("#complemento").val()==""){
//					alert("campo complemento Obrigatorio ");
//						return false;
//				}
//				if($("#email").val()==""){
//					alert("campo email Obrigatorio ");
//						return false;
//					}
//				
//				var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
//					if(!filtro.test($("#email").val())){
//						alert("email invalido");
//							return false;
//					}	
//				
//				if($("#uf").val()=="pessoa.codUf"){
//					alert("campo uf Obrigatorio ");
//						return false;
//				}
//				if($("#sexo").val()=="pessoa.codSexo"){
//					alert("campo sexo Obrigatorio ");
//						return false;
//				}else{
//					$("#alterarPessoa").attr("action","alterarPessoa.do");
//					alert(" Alterado com Sucesso");
//					$("#alterarPessoa").submit();
//				}
//				
//			});
			





		//function Verifica_Data(data, obrigatorio){  
		//// Se o parâmetro obrigatório for igual à zero, significa que elepode estar
		//// vazio, caso contrário, não
		//var data = document.getElementById(data);  
//		    var strdata = data.value;  
//		    if((obrigatorio == 1) || (obrigatorio == 0 && strdata != "")){  
//		        // Verifica a quantidade de digitos informada esta correta.
//		        if (strdata.length != 10){  
//		            alert("Formato da data não é válido.  
		//Formato correto:  
		//- dd/mm/aaaa.");  
//		            data.focus();  
//		            return false  
//		        }  
//		        // Verifica máscara da data
//		        if ("/" != strdata.substr(2,1) || "/" != strdata.substr(5,1)){  
//		            alert("Formato da data não é válido.  
		//Formato correto:  
		//- dd/mm/aaaa.");  
//		            data.focus();  
//		            return false  
//		        }  
//		        dia = strdata.substr(0,2)  
//		        mes = strdata.substr(3,2);  
//		        ano = strdata.substr(6,4);  
//		        // Verifica o dia
//		        if (isNaN(dia) || dia > 31 || dia < 1){  
//		            alert("Formato do dia não é válido.");  
//		            data.focus();  
//		            return false  
//		        }  
//		        if (mes == 4 || mes == 6 || mes == 9 || mes == 11){  
//		            if (dia == "31"){  
//		                alert("O mês informado não possui 31 dias.");  
//		                data.focus();  
//		                return false  
//		            }  
//		        }  
//		        if (mes == "02"){  
//		            bissexto = ano % 4;  
//		            if (bissexto == 0){  
//		                if (dia > 29){  
//		                    alert("O mês informado possui somente 29 dias.");  
//		                    data.focus();  
//		                    return false  
//		                }  
//		            }else{  
//		                if (dia > 28){  
//		                    alert("O mês informado possui somente 28 dias.");  
//		                    data.focus();  
//		                    return false  
//		                }  
//		            }  
//		        }  
//		    // Verifica o mês
//		        if (isNaN(mes) || mes > 12 || mes < 1){  
//		            alert("Formato do mês não é válido.");  
//		            data.focus();  
//		            return false  
//		        }  
//		        // Verifica o ano
//		        if (isNaN(ano)){  
//		            alert("Formato do ano não é válido.");  
//		            data.focus();  
//		            return false  
//		        }  
//		    }  
		//}  
		//
		//
		//
		//function Verifica_Email(email, obrigatorio){  
//			// Se o parâmetro obrigatório for igual à zero, significa que elepode estar
//			// vazio, caso contrário, não
//			    var email = document.getElementById(email);  
//			    if((obrigatorio == 1) || (obrigatorio == 0 && email.value != "")){  
//			        if(!email.value.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+.[a-zA-Z0-9._-]+)/gi)){  
//			            alert("Informe um e-mail válido");  
//			            email.focus();  
//			            return false  
//			        }  
//			    }  
//			}*/


