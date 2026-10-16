package exercicios.ex11;

import java.util.ArrayList;

public class Banco {
	private String nome;
	private ArrayList<ContaBancaria> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<ContaBancaria>();
	}
	public void criarConta(ContaBancaria newConta) {
		if(consultarConta(newConta.getNumero()) != null) {
			System.out.println("Erro: Já existe uma conta cadastrada com esse número!");
		} else {
			contas.add(newConta);
			System.out.println("Conta em nome de " + newConta.getTitular() + " criada com sucesso!\n");
		}
	}
	public ContaBancaria consultarConta(String numero) {
		for(ContaBancaria contaIndice : contas) {
			if(contaIndice.getNumero().equals(numero)) {
				return contaIndice;
			}
		}
		return null;
	}
	public void listarContas() {
		if(contas.size() == 0) {
			System.out.println("Erro: Nenhuma conta foi cadastrada ainda!");
		} else {
			System.out.println("Contas cadastradas:");
			for(ContaBancaria contaIndice : contas) {
				System.out.printf("\nTitular: %s | Nº: %s", contaIndice.getTitular(), contaIndice.getNumero());
			}
		}
	}
	public void depositar(ContaBancaria contaDep, double valor) {
		if(contaDep != null) {
			contaDep.depositar(valor);
		} else {
			System.out.println("Erro: Nenhuma conta foi encontrada!");
		}
	}
	public void sacar(ContaBancaria contaSaq, double valor) {
		if(contaSaq != null) {
			contaSaq.sacar(valor);
		} else {
			System.out.println("Erro: Nenhuma conta foi encontrada!");
		}
	}
	public void transferir(ContaBancaria contaOrigem, ContaBancaria contaDestino, double valor) {
		
		if(contaOrigem == null) {
			System.out.println("Erro: Conta de origem não encontrada!");
		} else if(contaDestino == null) {
			System.out.println("Erro: Conta de destino não encontrada!");
		} else if(contaOrigem.equals(contaDestino)) {
			System.out.println("Erro: Os números das contas não podem ser iguais!");
		} else {
			if(contaOrigem.sacar(valor)) {
				contaDestino.depositar(valor);
			} else {
				System.out.println("\nErro: Transferência cancelada!");
			}
		}
	}
	public double totalGeralInvestimentos () {
		if(contas.size() == 0) {
			System.out.println("Erro: Nenhuma conta foi criada ainda!");
			return 0;
		} else if(ContaBancaria.getTotalGeralInvestimentos() == 0) {
			System.out.println("Erro: Nenhum investimento foi realizado ainda!");
			return 0;
		}
		return ContaBancaria.getTotalGeralInvestimentos();
	}
	public int getQuantidadeTotalContas() {
		return contas.size();
	}
}
