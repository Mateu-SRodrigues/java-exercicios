package exercicios;
import java.util.Scanner;
import java.util.Arrays;

public class ex3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		
		int[] inteiros = new int[7];
		int num;
		int cont = 0;
		int posicao = 0;
		
		for (int i = 0; i < 7; i++) {
			
			System.out.println("Digite o " + (i+1) + "º numero: ");
			inteiros[i] = teclado.nextInt();
		}
		
		System.out.println("Digite um inteiro: ");
		num = teclado.nextInt();
		
		for (int j = 0; j < 7; j++) {
			if(num == inteiros[j]) {
				cont++;
				posicao = j;
			}
		}
		
		Arrays.sort(inteiros);
		
		if(cont > 0)
			System.out.println(num + " está na posição " + posicao + " do vetor.");
		else
			System.out.println(num + " não está no vetor.");
		
		System.out.println("Números em ordem crescente: " + Arrays.toString(inteiros));
		
		teclado.close();
	}
}
