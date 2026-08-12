package exercicios;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Pessoa[] pessoa = new Pessoa[5];
		Scanner teclado = new Scanner (System.in);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("----------PESSOA " + (i+1) + "----------");
			
			//Instancia a classe: aloca memória, cria um objeto real do tipo Pessoa na memória
			pessoa[i] = new Pessoa();
			
			System.out.println("Digite o nome da pessoa: ");
			pessoa[i].nome = teclado.next();
			
			System.out.println("Digite a idade da pessoa: ");
			pessoa[i].idade = teclado.nextInt();
		}
		
		teclado.close();
		
		int maisVelha = 0;
		String velha = "";
		
		for(int j = 0; j < 5; j++) {
			//Pessoa mais velha			
			if (maisVelha < pessoa[j].idade) {
				maisVelha = pessoa[j].idade;
				velha = pessoa[j].nome;
			}
		}
		int maisNova = maisVelha;
		String nova = "";
		for(int k = 0; k < 5; k++) {
			//Pessoa mais nova
			if (pessoa[k].idade < maisNova) {
				maisNova = pessoa[k].idade;
				nova = pessoa[k].nome;
			}
		}
		System.out.println("*****PESSOA MAIS VELHA*****");
		System.out.println("Nome: " + velha);
		System.out.println("Idade: " + maisVelha);
		
		System.out.println("*****PESSOA MAIS NOVA*****");
		System.out.println("Nome: " + nova);
		System.out.println("Idade: " + maisNova);
	}

}
