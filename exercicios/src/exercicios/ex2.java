/*Faça um programa que receba o nome e a idade de 5 pessoas e
mostre o nome e a idade da pessoa mais nova e da pessoas mais
velha*/

package exercicios;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Pessoa[] pessoa = new Pessoa[5];//Cria um vetor do tipo Pessoa, com tamanho 5, e armazena na variável pessoa
		Scanner teclado = new Scanner (System.in);
		
		//Armazena as entradas do usuário no vetor índice por índice
		for(int i = 0; i < 5; i++) {
			System.out.println("----------PESSOA " + (i+1) + "----------");
			
			//Instancia a classe: aloca memória, cria um objeto real do tipo Pessoa na memória
			pessoa[i] = new Pessoa();
			
			System.out.println("Digite o nome da pessoa: ");
			pessoa[i].nome = teclado.next();
			
			System.out.println("Digite a idade da pessoa: ");
			pessoa[i].idade = teclado.nextInt();
		}
		
		//Armazenam a idade e o nome da pessoa mais velha
		int maisVelha = 0;
		String velha = "";
		
		//Verifica a maior dentre as idades até encontrar a maior
		for(int j = 0; j < 5; j++) {
			//Pessoa mais velha			
			if (maisVelha < pessoa[j].idade) {
				maisVelha = pessoa[j].idade;
				velha = pessoa[j].nome;
			}
		}
		
		//Armazenam a idade e o nome da pessoa mais nova
		int maisNova = maisVelha;
		String nova = "";
		
		//Verifica a menor dentre as idades, a partir da maior
		for(int k = 0; k < 5; k++) {
			//Pessoa mais nova
			if (pessoa[k].idade < maisNova) {
				maisNova = pessoa[k].idade;
				nova = pessoa[k].nome;
			}
		}
		
		//Exibe nome e a idades da pessoa mais velha e mais nova
		System.out.println("*****PESSOA MAIS VELHA*****");
		System.out.println("Nome: " + velha);
		System.out.println("Idade: " + maisVelha);
		
		System.out.println("*****PESSOA MAIS NOVA*****");
		System.out.println("Nome: " + nova);
		System.out.println("Idade: " + maisNova);
		
		teclado.close();
	}

}
