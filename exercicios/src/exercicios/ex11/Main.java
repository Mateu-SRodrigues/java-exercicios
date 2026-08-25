package exercicios.ex11;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Cria o ArrayList contas, do tipo ContaBancaria, que armazena as contas
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		
		//Armazena a opção do usuário
		int opcao;
		
		//Exibi o Menu Principal enquanto a opção desejada for != 0
		do {
			System.out.println("\n=============== MENU PRINCIPAL ===============");
			System.out.println("1.Criar conta (" + contas.size() + " cadastrada(s))");
			System.out.println("2.Selecionar uma conta existente");
			System.out.println("3.Consultar conta");
			System.out.println("0.Sair");
			System.out.println("Selecione uma opção: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();//Limpa o buffer
			
			//Compara a entrada do usuário com as opções disponíveis no Menu Principal
			switch (opcao) {
			//Caso 1:
			case 1:
				//Adiciona uma nova conta no final da lista contas
				contas.add(Main.criarConta(teclado));
				break;
			//Caso 2: 
			case 2:
				//Se o tamanho da lista de contas for > 0, contaSelecionada recebe o valor de retorno do método selecionarConta
				if(contas.size() > 0) {
					ContaBancaria contaSelecionada = selecionarConta(contas, teclado);
					//Se a conta não estiver vazia, o Menu Operações é exibido
					if(contaSelecionada != null)
						menuOperacoes(contaSelecionada, teclado);
				} else {
					System.out.println("Nenhuma conta cadastrada!");
				}
				break;
			//Caso 3:
			case 3:
				//Percorre e exibe os dados de todas as contas da lista contas
				System.out.println("Dados das contas cadastradas:");
				for(int i = 0; i < contas.size(); i++) {
					//contaAtual armazena uma conta de acordo com sua posição na lista contas
					ContaBancaria contaAtual = contas.get(i);
					System.out.println((i+1) + ". Titular:" + contaAtual.getTitular() + " | Nº: " + contaAtual.getNumero() + " | Saldo: " + contaAtual.getSaldo());
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
	//Exibi todas as contas cadastradas e retorna a conta selecionada
	public static ContaBancaria selecionarConta(ArrayList<ContaBancaria> contas, Scanner teclado) {
		
		System.out.println("\n=============== SELECIONAR CONTA ===============");
		
		//Armazena o número da conta desejada
		System.out.println("\n---- BUSCAR NÚMERO ----");
		System.out.println("Digite o número da conta: ");
		String numero = teclado.nextLine();
		
		//Percorre a lista contas
		for(int i = 0; i < contas.size(); i++) {
			
			//contaAtual armazena uma conta de acordo com seu índice na lista contas
			ContaBancaria contaAtual = contas.get(i);
			
			//Se o número da contaAtual = número dado pelo usuário, retorna a conAtual
			if(contaAtual.getNumero().equals(numero)) { //Compara o conteúdo de duas strings
				System.out.println("Conta encontrada!");
				System.out.println("Titular: " + contaAtual.getTitular() + " | Nº: " + contaAtual.getNumero() + " | Saldo: " + contaAtual.getSaldo() + ".");
				return contaAtual;
				}
		}
		//Se não, exibe uma mensagem e retorna nada
		System.out.println("Conta não encontrada!");
		return null;
	}
	//Exibe e raliza as operações de deposito e/ou saque na conta selecionada
	private static void menuOperacoes(ContaBancaria conta, Scanner teclado) {
		
		//Armazena a opção do usuário
		int opcao;
		
		//Exibi o Menu Operações enquanto a opção desejada for != 0
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
				//Pede o valor do saque e passa como parâmetro do método sacar()
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
