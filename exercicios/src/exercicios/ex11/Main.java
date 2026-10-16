package exercicios.ex11;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Banco meuBanco = new Banco("Banco UECE");
		
		//Armazena a opção do usuário
		int opcao = -1;
		
		//Exibi o Menu Principal enquanto a opção desejada for != 0
		do {
			System.out.println("\n=============== SISTEMA " + meuBanco.getClass().getSimpleName() + " ===============");
			System.out.println("1.Criar Conta");
			System.out.println("2.Consultar informações de uma conta específica");
			System.out.println("3.Depositar");
			System.out.println("4.Sacar");
			System.out.println("5.Transferir");
			System.out.println("6.Realizar Investimento");
			System.out.println("7.Consultar o investimento total do banco");
			System.out.println("8.Consultar contas cadastradas");
			System.out.println("9.Alterar Dados");
			System.out.println("0.Sair");
			System.out.println("Selecione uma opção: ");
			
			try {
				opcao = teclado.nextInt();
				teclado.nextLine();//Limpa o buffer
				
				//Compara a entrada do usuário com as opções disponíveis no Menu Principal
				switch (opcao) {
				//Caso 1:
				case 1:
					System.out.println("\n=============== CRIAR CONTA ===============");
					
					System.out.println("Digite o nome do titular: ");
					String titular = teclado.nextLine().trim();
					
					System.out.println("Digite o numero da conta: ");
					String numero = teclado.nextLine().trim();
					
					try {
						ContaBancaria newConta = new ContaBancaria(titular, numero);
						meuBanco.criarConta(newConta);						
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;
				//Caso 2: 
				case 2:
					if(meuBanco.getQuantidadeTotalContas() > 0) {
						
						System.out.println("\n=============== CONSULTAR CONTA ===============");
						System.out.println("Digite o numero da conta: ");
						String numCons = teclado.nextLine().trim();
						ContaBancaria contaCons = meuBanco.consultarConta(numCons);
						
						if(contaCons != null) {
								System.out.printf("Titular: %s", contaCons.getTitular());
								System.out.printf("\nNumero: %s", contaCons.getNumero());
								System.out.printf("\nSaldo: R$%.2f", contaCons.getSaldo());
								System.out.printf("\nSaldo Cheque Especial: R$%.2f", contaCons.getSaldoChequeEspecial());
								System.out.printf("\nInvestimentos Totais: R$%.2f", contaCons.getTotalInvestimentos());
						} else {
							System.out.println("Erro: Conta não encontrada!");
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
					}
					break;
					
				case 3:
					if(meuBanco.getQuantidadeTotalContas() > 0) {
						System.out.println("\n=============== DEPOSITAR ===============");
						boolean validadorDep = false;
						
						System.out.println("Digite o numero da conta: ");
						String numDep = teclado.nextLine().trim();
						ContaBancaria contaDep = meuBanco.consultarConta(numDep);
						
						if(contaDep != null) {
							while (!validadorDep) {
								try {
									System.out.println("Digite o valor do depósito: ");
									double valorDep = teclado.nextDouble();
									teclado.nextLine();
									
									meuBanco.depositar(contaDep, valorDep);
									validadorDep = true;
								} catch (InputMismatchException e) {
									System.out.println("Valor de depósito inválido!");
									teclado.nextLine();
								}
							}
						} else {
							System.out.println("Erro: Conta não encontrada!");
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
					}
					break;
				case 4:
					if(meuBanco.getQuantidadeTotalContas() > 0) {						
						System.out.println("\n=============== SACAR ===============");
						boolean validadorSaq = false;
						
						System.out.println("Digite o numero da conta: ");
						String numSaq = teclado.nextLine().trim();
						ContaBancaria contaSaq = meuBanco.consultarConta(numSaq);
						
						if(contaSaq != null) {
							while (!validadorSaq) {
								try {
									System.out.println("Digite o valor do saque: ");
									double valorSaq = teclado.nextDouble();
									teclado.nextLine();
									
									meuBanco.sacar(contaSaq, valorSaq);
									validadorSaq = true;
								} catch (InputMismatchException e) {
									System.out.println("Valor de saque inválido!");
									teclado.nextLine();
								}
							}
						} else {
							System.out.println("Erro: Conta não encontrada!");
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
					}
					break;
				case 5:
					if(meuBanco.getQuantidadeTotalContas() > 0) {						
						System.out.println("\n=============== TRANSFERIR ===============");
						boolean validadorTransferir = false;
						
						System.out.println("Digite o numero da conta de origem: ");
						String numOrigem = teclado.nextLine().trim();
						System.out.println("Digite o numero da conta de destino: ");
						String numDestino = teclado.nextLine().trim();
						
						ContaBancaria contaOrigem = meuBanco.consultarConta(numOrigem);
						ContaBancaria contaDestino = meuBanco.consultarConta(numDestino);
						
						if(contaOrigem == null) {
							System.out.println("Erro: Conta de origem não encontrada!");
						} else if(contaDestino == null) {							
							System.out.println("Erro: Conta de destino não encontrada!");
						} else if(contaOrigem.equals(contaDestino)) {
							System.out.println("Erro: Os números das contas não podem ser iguais!");
						} else {
							while (!validadorTransferir) {
								try {
									System.out.println("Digite o valor da transferência: ");
									double valorTransferencia = teclado.nextDouble();
									teclado.nextLine();
									
									meuBanco.transferir(contaOrigem, contaDestino, valorTransferencia);
									validadorTransferir = true;
								} catch (InputMismatchException e) {
									System.out.println("Erro: Valor de transferência inválido!");
									teclado.nextLine();
								}
							}
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
					}
					break;
				case 6:
					if(meuBanco.getQuantidadeTotalContas() > 0) {						
						System.out.println("\n=============== INVESTIR ===============");
						boolean validadorInvestir = false;
						
						System.out.println("Digite o numero da conta que deseja investir: ");
						String numInvestir = teclado.nextLine().trim();
						
						ContaBancaria contaInvestir = meuBanco.consultarConta(numInvestir);
						
						if(contaInvestir == null) {
							System.out.println("Erro: Conta não encontrada!");
						} else {
							while (!validadorInvestir) {
								try {
									System.out.println("Digite o valor do investimento: ");
									double valorInvestir = teclado.nextDouble();
									teclado.nextLine();
									
									contaInvestir.investir(valorInvestir);
									validadorInvestir = true;
								} catch (InputMismatchException e) {
									System.out.println("Erro: Valor do investimento inválido!");
									teclado.nextLine();
								}
							}
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
					}
					break;
				case 7:
					double totalInvestimentos = meuBanco.totalGeralInvestimentos();
					System.out.printf("Total de investimentos do banco: R$%.2f", totalInvestimentos);
					break;
				case 8:
					meuBanco.listarContas();
					break;
				//Caso 9:
				case 9:
					if(meuBanco.getQuantidadeTotalContas() > 0) {
						boolean validadorAlterar = false;
						System.out.println("Digite o número da conta que deseja alterar:");
						String numAlt = teclado.nextLine().trim();
						ContaBancaria contaAlt = meuBanco.consultarConta(numAlt);
						
						if(contaAlt == null) {
							System.out.println("Erro: Conta não encontrada!");
						} else {
							System.out.printf("Titular atual: %s", contaAlt.getTitular());
							System.out.println("\nNovo titular: ");
							while (!validadorAlterar) {
								try {						
									String novoTitular = teclado.nextLine().trim();
									contaAlt.setTitular(novoTitular);
									validadorAlterar = true;
								} catch (IllegalArgumentException erro) {
									System.out.println(erro.getMessage());
								}
							}
						}
					} else {
						System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
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
			} catch (InputMismatchException e) {
				System.out.println("Digite apenas números!");
				teclado.nextLine();
				opcao = -1;
			}
		} while (opcao != 0);
		
		teclado.close();
	}
}
