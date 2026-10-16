package exercicios.ex11;

//Inicializa a classe ContaBancaria com construtor
public class ContaBancaria {
	//Atributos privados para garantir o encapsulamento, assim somente a classe ContaBancaria pode acessá-los diretamente
	private String titular;
	private String numero;
	private double saldo;
	private double saldoChequeEspecial;
	private double limiteChequeEspecial = 0.1;
	private double saldoInicialChequeEspecial;
	private double totalInvestimentos = 0;
	private static double totalGeralInvestimentos = 0;
	
	//Garante que os atributos não comecem com valores vazios, obrigando o fornecimento de dados antes da criação do objeto
	public ContaBancaria(String titular, String numero) {
		if(titular != null && titular.trim().length() != 0) {
			this.titular = titular;
		} else {
			throw new IllegalArgumentException("Erro: Nenhum campo pode estar vazio!");
		}
		if(numero != null && numero.trim().length() != 0) {
			this.numero = numero;					
		} else {
			throw new IllegalArgumentException("Erro: Nenhum campo pode estar vazio!");		
		}
		this.saldo = 0.0;
		this.saldoChequeEspecial = this.saldo * limiteChequeEspecial;
		this.saldoInicialChequeEspecial = saldoChequeEspecial;
	}
	//Método depositar, pode ser utilizado por outras classes
	public void depositar(double valor) {
		//Valida o valor do depósito e adiciona ao saldo da conta, se > 0
		if (valor > 0) {
			if(saldoChequeEspecial <= saldoInicialChequeEspecial) {
				double diferenca = saldoInicialChequeEspecial - saldoChequeEspecial;
				if(diferenca > 0) {
					if(valor >= diferenca) {
						saldoChequeEspecial = saldoInicialChequeEspecial;
						valor -= diferenca;
						System.out.println("\nParte do depósito foi debitada para o cheque especical");
						System.out.printf("\nO valor depositado foi de R$%.2f", valor);
					} else {
						saldoChequeEspecial += valor;
						valor = 0;
						System.out.println("\nO valor do depósito foi debitado para o cheque especical");
					}
					saldo += valor;
					saldoChequeEspecial = saldo * limiteChequeEspecial;	
					saldoInicialChequeEspecial = saldoChequeEspecial;
				} else {
					saldo += valor;
					saldoChequeEspecial = saldo * limiteChequeEspecial;	
					saldoInicialChequeEspecial = saldoChequeEspecial;
					System.out.printf("\nDepósito no valor de R$%.2f realizado com sucesso!", valor);
				}
			}
		} else {
			System.out.println("Valor de depósito inválido!");
		}
	}
	//Método sacar, pode ser utilizado por outras classes
	public boolean sacar(double valor) {
		//Valida o valor do saque
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.printf("\nSaque no valor de R$%.2f realizado com sucesso!", valor);
			return true;
		} else if (valor > saldo) {
			saldoChequeEspecial = saldo * limiteChequeEspecial;
			if(valor <= saldo + saldoChequeEspecial) {
				saldoChequeEspecial -= (valor - saldo);
				saldo = 0;
				System.out.printf("Saque no valor de R$%.2f realizado usando cheque especial!", valor);
				return true;
			} else {
				System.out.printf("Erro: Saque não realizado (Saldo atual: R$%.2f | Saldo Cheque Especial: R$%.2f)!", saldo, getSaldoChequeEspecial());
				return false;
			}
		} else {
			System.out.println("Valor de saque inválido.");
			return false;
		}
	}
	public void investir(double valor) {
		if(valor > 0 && valor <= saldo) {
			saldo -= valor;
			totalInvestimentos += valor;
			totalGeralInvestimentos += valor;
			System.out.printf("Investimento no valor de R$%.2f realizado com sucesso!", valor);
		} else {
			if(valor > saldo) {
				System.out.println("Erro: Saldo insuficiente para realizar o investimento!");
			} else {
				System.out.println("Erro: O valor do investimento não pode ser negativo.");
			}
		}
	}
	//Retorna o nome do titular, evitando acesso direto a esse atributo
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		if(titular != null && titular.trim().length() != 0) {
			this.titular = titular;
		} else {
			throw new IllegalArgumentException("Erro: Titular não pode estar vazio! Digite novamente:");
		}
	}
	//Retorna o numero da conta, evitando acesso direto a esse atributo
	public String getNumero() {
		return numero;
	}
	//Retorna o valor do saldo, evitando acesso direto a esse atributo
	public double getSaldo() {
		return saldo;
	}
	public double getSaldoChequeEspecial() {
		return saldoChequeEspecial;
	}
	public double getTotalInvestimentos() {
		return totalInvestimentos;
	}
	public static double getTotalGeralInvestimentos() {
		return totalGeralInvestimentos;
	}
}
