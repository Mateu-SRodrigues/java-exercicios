/*2. Henrique conseguiu um novo emprego como desenvolvedor, que paga muito bem, 
 * mas agora ele precisa pagar imposto de renda. 
 * Faça um algoritmo que leia o salário  dele e mostre o salário após 
 * a retirada do imposto de renda, com base na tabela  abaixo: 
        Até R$ 2.259,20: 0%
        De R$ 2.259,21 até R$ 2.826,65: 7%
        De R$2.826,66 até R$ 3.751,05: 15%
        De R$ 3.751,06 até R$ 4.664,68: 22%
        Acima de R$ 4.664,68: 27% */

package exercicios;
import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		//Pede e armazena o valor do salário
		System.out.println("Digite o salário: ");
		double salario = teclado.nextDouble();

		//Aplica o desconto com base na tabela do IR
		if (salario <= 2259.20) {
			salario = salario * 1;
		}
		else if (salario > 2259.20 && salario < 2826.66) {
			salario = salario * 0.93;
		}
		else if (salario > 2826.65 && salario < 3751.06) {
			salario = salario * 0.85;
		}
		else if (salario > 3751.05 && salario < 4664.69) {
			salario = salario * 0.78;
		}
		else if (salario > 4664.68) {
			salario = salario * 0.73;
		}
		
		//Exibi o salário após o seu devido desconto
		System.out.println("O salário é de R$" + salario + " com desconto.");
		
		teclado.close();
	}

}
