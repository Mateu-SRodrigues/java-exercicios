package exercicios.ex11;

//Inicializa a classe ContaBancaria com construtor
public class ContaBancaria {
	//Atributos privados para garantir o encapsulamento, assim somente a classe ContaBancaria pode acessá-los diretamente
	private String titular;
	private String numero;
	private double saldo;
	
	//Garante que os atributos não comecem com valores vazios, obrigando o fornecimento de dados antes da criação do objeto
	public ContaBancaria(String titular, String numero) {
		this.titular = titular;
		this.numero = numero;
		this.saldo = 0.0;
	}
	//Método depositar, pode ser utilizado por outras classes
	public void depositar(double valor) {
		//Valida o valor do depósito e adiciona ao saldo da conta, se > 0
		if (valor > 0) {
			setSaldo(getSaldo() + valor); 
			System.out.println("Depósito no valor de R$" + valor + " realizado com sucesso!");
		} else {
			System.out.println("Valor de depósito inválido!");
		}
	}
	//Método sacar, pode ser utilizado por outras classes
	public void sacar(double valor) {
		//Valida o valor do saque
		if (valor > 0) {
			//Subtrai o valor do saque do saldo da conta, se >= saldo
			if (saldo >= valor) {
				setSaldo(getSaldo() - valor);
				System.out.println("Saque no valor de R$" + valor + " realizado com sucesso!");
				
			}
			else {
				System.out.println("Saldo insuficiente para o saque de R$" + valor + ".");
			}
		} else {
			System.out.println("Valor de saque inválido.");
		}
	}
	//Retorna o nome do titular, evitando acesso direto a esse atributo
	public String getTitular() {
		return titular;
	}
	//Recebe o nome do titular como parâmetro e atribue à variável titular de uma conta específica
	public void setTitular(String titular) {
		this.titular = titular;
	}
	//Retorna o numero da conta, evitando acesso direto a esse atributo
	public String getNumero() {
		return numero;
	}
	//Recebe o número da conta como parâmetro e atribue à variável numero de uma conta específica
	public void setNumero(String numero) {
		this.numero = numero;
	}
	//Retorna o valor do saldo, evitando acesso direto a esse atributo
	public double getSaldo() {
		return saldo;
	}
	//Recebe o valor do saldo como parâmetro e atribue à variável saldo de uma conta específica
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
