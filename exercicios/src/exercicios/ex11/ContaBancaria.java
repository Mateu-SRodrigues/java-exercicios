package exercicios.ex11;

public class ContaBancaria {
	private String titular;
	private String numero;
	private double saldo;
	
	public ContaBancaria(String titular, String numero) {
		this.titular = titular;
		this.numero = numero;
		this.saldo = 0.0;
	}
	public void depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor); 
			System.out.println("Depósito no valor de R$" + valor + " realizado com sucesso!");
		} else {
			System.out.println("Valor de depósito inválido!");
		}
	}
	public void sacar(double valor) {
		if (valor > 0) {
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
	public String getTitular() {
		return titular;
	}
	public String setTitular(String titular) {
		this.titular = titular;
		return titular;
	}
	public String getNumero() {
		return numero;
	}
	public String setNumero(String numero) {
		this.numero = numero;
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public double setSaldo(double saldo) {
		this.saldo = saldo;
		return saldo;
	}
}
