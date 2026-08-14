/*8. Em uma partida de RPG, o mestre está determinando o resultado 
 * de uma batalha para um jogador usando um dado. Escreva um algoritmo 
 * que receba um número  inteiro como entrada e, com base nesse número, 
 * determine se o jogador ganhou ou  perdeu a batalha. Se o número for par, 
 * o jogador vence; se for ímpar, o jogador perde.*/

package exercicios;
import java.util.Scanner;

public class ex8 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		//Armazena o nome e o número do jogador
		System.out.println("Digite o nome do jogador: ");
		String nome = teclado.next();
		System.out.println("Digite o número do jogador: ");
		int n = teclado.nextInt();
		
		//Verifica se o número é par (divisível por dois) ou ímpar
		if (n % 2 == 0) {
			System.out.println("O jogador " + nome + " VENCEU!");
		}
		else {
			System.out.println("O jogador " + nome + " PERDEU!");
		}
		
		teclado.close();
	}

}
