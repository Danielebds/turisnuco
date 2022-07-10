programa
{
	
	funcao inicio()
	{	
		inteiro op
		escreva("Menu Principal\n")
		escreva("1 - Cadastrar Cliente\n")
		escreva("2 - Buscar Cliente\n")
		escreva("3 - Cadastrar Destino\n")
		escreva("4 - Buscar Destino\n")
		leia(op)

		escolha(op){
			caso 1:
				cadastrarCliente()
			pare
			caso 2:
				buscarCliente()
			pare
			caso 3:
				cadastrarDestino()
			pare
			caso 4:
				buscarDestino()
			pare
			caso contrario:
				escreva("Digite a opção Valida")
		}
	}

	funcao cadastrarCliente(){
		cadeia nome , cpf, email, telefone
		escreva("---CADASTRAR CLIENTE---")
		escreva("\nDigite o Nome do cliente: ")
		leia(nome)
		escreva("Digite o CPF do cliente: ")
		leia(cpf)
		escreva("Digite o Email do cliente: ")
		leia(email)
		escreva("Digite o Telefone do cliente: ")
		leia(telefone)
		inteiro op 
		escreva("Aperte 1 Para o Menu ou 0 para Novo Cadastro: ")
		leia(op)
		escolha(op){
			caso 1: 
				inicio()
			pare 
			caso 0:
				cadastrarCliente()
			pare 
		}
	}

	funcao buscarCliente(){
		cadeia email
		escreva("---BUSCAR CLIENTE---")
		escreva("Digite o Email do cliente: ")
		leia(email)

		inteiro op 
		escreva("Aperte 1 Para o Menu ou 0 para Nova Buscar: ")
		leia(op)
		escolha(op){
			caso 1: 
				inicio()
			pare 
			caso 0:
				buscarCliente()
			pare 
		}
		
	}

	funcao cadastrarDestino(){
		cadeia nome
		cadeia ponto
		escreva("---CADASTRAR DESTINO---")
		escreva("digite o nome do destino: ")
		leia(nome)
		escreva("Digite seu ponto de partida: ")
		leia(ponto)

		inteiro op 
		escreva("Aperte 1 Para o Menu ou 0 para Cadastar Novo Destino: ")
		leia(op)
		escolha(op){
			caso 1: 
				inicio()
			pare 
			caso 0:
				cadastrarDestino()
			pare 
		}
	}

	funcao buscarDestino(){
		cadeia nome
		escreva("---BUSCAR DESTINO---")
		escreva("digite o nome do destino")
		leia(nome)

		inteiro op 
		escreva("Aperte 1 Para o Menu ou 0 para Buscar Novo Destino: ")
		leia(op)
		escolha(op){
			caso 1: 
				inicio()
			pare 
			caso 0:
				buscarDestino()
			pare 
		}
		
	}
	
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1894; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */