package exercicios.ex11;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ContaBancaria[] conta = new ContaBancaria[3];
		int opcao;
		int qtdContas = 0;
		
		do {
			System.out.println("\n=============== MENU PRINCIPAL ===============");
			System.out.println("1.Criar conta (" + qtdContas + "/3 cadastradas)");
			System.out.println("2.Selecionar uma conta existente");
			System.out.println("3.Consultar dados");
			System.out.println("0.Sair");
			System.out.println("Selecione uma opção: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			case 1:
				if(qtdContas < conta.length) {
					conta[qtdContas] = criarConta(teclado);
					qtdContas++;
				} else {
					System.out.println("Número máximo de contas atingido!");
					break;
				}
				break;
			case 2:
				if(qtdContas == 0) {
					System.out.println("Nenhuma conta cadastrada!");
				} else {
					ContaBancaria contaSelecionada = selecionarConta(conta, qtdContas, teclado);
					if(contaSelecionada != null) {
						menuOperacoes(contaSelecionada, teclado);
					}
				}
				break;
			case 3:
				System.out.println("Dados das contas cadastradas:");
				for(int i = 0; i < qtdContas; i++) {
					System.out.println((i+1) + ". Titular:" + conta[i].getTitular() + " | Nº: " + conta[i].getNumero() + " | Saldo: " + conta[i].getSaldo());
				}
				break;
			case 0:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
		
		teclado.close();
	}
	public static ContaBancaria criarConta(Scanner teclado) {
		System.out.println("\n=============== CRIAR CONTA ===============");
		
		System.out.println("Digite o nome do titular: ");
		String titular = teclado.nextLine();
		
		System.out.println("Digite o numero da conta: ");
		String numero = teclado.nextLine();
		
		ContaBancaria newConta = new ContaBancaria(titular, numero);
		
		System.out.println("Conta em nome de " + newConta.getTitular() + " criada com sucesso!\n");
		return newConta;
	}
	public static ContaBancaria selecionarConta(ContaBancaria[] conta, int qtdContas, Scanner teclado) {
		
		System.out.println("\n=============== SELECIONAR CONTA ===============");
		
		for(int i = 0; i < qtdContas; i++) {
			System.out.println((i+1) + ". Titular:" + conta[i].getTitular() + " | Nº: " + conta[i].getNumero());
		}
		System.out.println("Selecione a conta: ");
		int opcao = teclado.nextInt() - 1;
		
		if(opcao < 0 || opcao > qtdContas) {
			System.out.println("Opção de conta inválida!");
			return null;
		} else {
			System.out.println("\nCONTA SELECIONADA:");
			System.out.println("Titular: " + conta[opcao].getTitular() + " | Nº: " + conta[opcao].getNumero() + " | Saldo: " + conta[opcao].getSaldo() + ".");
			
			return conta[opcao];
		}

	}
	private static void menuOperacoes(ContaBancaria conta, Scanner teclado) {
		int opcao;
		
		do {
			System.out.println("\n=============== SELECIONAR OPERAÇÃO ===============");
			System.out.println("1.Depositar");
			System.out.println("2.Sacar");
			System.out.println("0.Voltar");
			System.out.println("Digite a operação desejada: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o valor do depósito: ");
				double valorDeposito = teclado.nextDouble();
				conta.depositar(valorDeposito);
				break;
			case 2:
				System.out.println("Digite o valor do saque: ");
				double valorSaque = teclado.nextDouble();
				conta.sacar(valorSaque);
				break;
			case 0:
				System.out.println("Voltando para o Menu Principal...");
				
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}
}
