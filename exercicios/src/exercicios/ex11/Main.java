package exercicios.ex11;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//Cria o vetor conta, do tipo ContaBancaria, que armazena no máximo 3 contas
		ContaBancaria[] conta = new ContaBancaria[3];
		//Cria as variáveis opção e qtdContas, armazena o número de contas
		int opcao;
		int qtdContas = 0;
		
		//Exibi o Menu Principal enquanto a opção desejada for != 0
		do {
			System.out.println("\n=============== MENU PRINCIPAL ===============");
			System.out.println("1.Criar conta (" + qtdContas + "/3 cadastradas)");
			System.out.println("2.Selecionar uma conta existente");
			System.out.println("3.Consultar dados");
			System.out.println("0.Sair");
			System.out.println("Selecione uma opção: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();//Limpa o buffer
			
			//Compara a entrada do usuário com as opções disponíveis no Menu Principal
			switch (opcao) {
			//Caso 1:
			case 1:
				//Se a quantidade de contas for menor que o vetor conta, cria uma nova conta
				if(qtdContas < conta.length) {
					conta[qtdContas] = criarConta(teclado);
					qtdContas++;
				} else {
					System.out.println("Número máximo de contas atingido!");
					break;
				}
				break;
			//Caso 2: 
			case 2:
				//Se a quantidade de contas for > 0, contaSelecionada recebe a conta que o usuário selecionou
				if(qtdContas == 0) {
					System.out.println("Nenhuma conta cadastrada!");
				} else {
					ContaBancaria contaSelecionada = selecionarConta(conta, qtdContas, teclado);
					//Se a conta não estiver vazia, o Menu Operações é exibido
					if(contaSelecionada != null) {
						menuOperacoes(contaSelecionada, teclado);
					}
				}
				break;
			//Caso 3:
			case 3:
				//Percorre e exibe todos os dados das contas do vetor conta
				System.out.println("Dados das contas cadastradas:");
				for(int i = 0; i < qtdContas; i++) {
					System.out.println((i+1) + ". Titular:" + conta[i].getTitular() + " | Nº: " + conta[i].getNumero() + " | Saldo: " + conta[i].getSaldo());
				}
				break;
			//Caso 0: Encerra a execução do programa
			case 0:
				System.out.println("Encerrando...");
				break;
			//Caso o usuário digite uma opção inválida
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
		
		teclado.close();
	}
	//Cria, armazena e retorna a nova conta
	public static ContaBancaria criarConta(Scanner teclado) {
		System.out.println("\n=============== CRIAR CONTA ===============");
		
		System.out.println("Digite o nome do titular: ");
		String titular = teclado.nextLine();
		
		System.out.println("Digite o numero da conta: ");
		String numero = teclado.nextLine();
		//Armazena os dados em newConta de acordo com a assinatura de método do construtor ContaBancaria
		ContaBancaria newConta = new ContaBancaria(titular, numero);
		
		System.out.println("Conta em nome de " + newConta.getTitular() + " criada com sucesso!\n");
		return newConta;
	}
	//Exibi todas as contas cadastradas e retorna conta selecionada
	public static ContaBancaria selecionarConta(ContaBancaria[] conta, int qtdContas, Scanner teclado) {
		
		System.out.println("\n=============== SELECIONAR CONTA ===============");
		
		//Percorre e exibi todas as contas do vetor conta
		for(int i = 0; i < qtdContas; i++) {
			System.out.println((i+1) + ". Titular:" + conta[i].getTitular() + " | Nº: " + conta[i].getNumero());
		}
		
		//Armazena o índice da conta selecionada
		System.out.println("Selecione a conta: ");
		int indice = teclado.nextInt() - 1;
		
		if(indice < 0 || indice > qtdContas) {
			System.out.println("Opção de conta inválida!");
			return null;
		} else {
			//Exibi os dados da conta selecionada por meio dos métodos get e a retorna
			System.out.println("\nCONTA SELECIONADA:");
			System.out.println("Titular: " + conta[indice].getTitular() + " | Nº: " + conta[indice].getNumero() + " | Saldo: " + conta[indice].getSaldo() + ".");
			
			return conta[indice];
		}

	}
	//Exibi o Menu Operações enquanto a opção desejada for != 0
	private static void menuOperacoes(ContaBancaria conta, Scanner teclado) {
		int opcao;
		
		do {
			System.out.println("\n=============== MENU OPERAÇÕES ===============");
			System.out.println("1.Depositar");
			System.out.println("2.Sacar");
			System.out.println("0.Voltar");
			System.out.println("Digite a operação desejada: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();//Limpa o buffer
			
			//Compara a entrada do usuário com as opções disponíveis no Menu Operações
			switch (opcao) {
			//Caso 1: Depositar
			case 1:
				//Pede o valor do depósito e passa como parâmetro do método depositar
				System.out.println("Digite o valor do depósito: ");
				double valorDeposito = teclado.nextDouble();
				conta.depositar(valorDeposito);
				break;
			//Caso 2: Sacar
			case 2:
				//Pede o valor do saque e passa como parâmetro do método sacar
				System.out.println("Digite o valor do saque: ");
				double valorSaque = teclado.nextDouble();
				conta.sacar(valorSaque);
				break;
			//Caso 0: Volta ao Menu Principal
			case 0:
				System.out.println("Voltando para o Menu Principal...");
				break;
			//Caso o usuário digite uma opção inválida
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}
}
