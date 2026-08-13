/*3. Depois de um longo dia dando aulas, 
 * Ricardo precisa de sua ajuda para calcular as médias finais de seus alunos. 
 * Sabendo que a média final é calculada pela fórmula  abaixo, 
 * construa um algoritmo que, dadas as notas, calcule a nota final. 
 * NF (nota final),  Av1 (avaliação 1), Tb1 (trabalho 1) e Tb2 (trabalho 2). 
    						NF = Av1 + (Tb1 + Tb2)
*/

package exercicios;
import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Digite a nota da Av1: ");
		float av1 = teclado.nextFloat();
		System.out.println("Digite a nota do Tb1: ");
		float tb1 = teclado.nextFloat();
		System.out.println("Digite a nota do Tb2: ");
		float tb2 = teclado.nextFloat();
		
		float nf = av1 + ((tb1 + tb2) / 2);
		System.out.println("A nota final é " + nf + ".");
		
		teclado.close();
	}

}
