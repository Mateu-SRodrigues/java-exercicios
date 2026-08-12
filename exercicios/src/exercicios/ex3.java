package exercicios;
import java.util.Scanner;
import java.util.Arrays;

public class ex3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		int[] inteiros = new int[7];//Cria um vetor de inteiros, de tamanho 7, e armazena na variável inteiros
		int num;//Armazena a entrada do usuário
		int cont = 0;//Cria um contador
		int posicao = 0;//Armazena a posição do inteiro
		
		//Armazena todas as 7 entradas do usuário no vetor
		for (int i = 0; i < 7; i++) {
			System.out.println("Digite o " + (i+1) + "º numero: ");
			inteiros[i] = teclado.nextInt();
		}
		
		//Pede o inteiro ao usuário
		System.out.println("Digite um inteiro: ");
		num = teclado.nextInt();
		
		//Verifica se o inteiro do usuário está no vetor
		for (int j = 0; j < 7; j++) {
			//Se sim, o contador recebe +1 e a posição recebe o índice do inteiro dentro do vetor
			if(num == inteiros[j]) {
				cont++;
				posicao = j;
			}
		}
		//Organiza o vetor em ordem crescente
		Arrays.sort(inteiros);
		
		//Imprime o inteiro e a posição dele no vetor
		if(cont > 0)
			System.out.println(num + " está na posição " + posicao + " do vetor.");
		else
			System.out.println(num + " não está no vetor.");
		
		//Imprime o vetor em ordem crescente
		System.out.println("Números em ordem crescente: " + Arrays.toString(inteiros));
		
		teclado.close();
	}
}
