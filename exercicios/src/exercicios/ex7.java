/*4. Um aluno de Ciências da Computação da UECE está com dificuldade na cadeira de 
 * Geometria Analítica e cansado de calcular o produto interno de dois vetores. 
 * Faça um  algoritmo que receba as coordenadas de dois vetores e calcule o produto interno, 
 * de  acordo com as anotações do aluno:
    "Se A=(a1,a2,a3) e B=(b1,b2,b3) são vetores tridimensionais, 
    então o produto escalar entre a e b pode ser expresso como:
                A*B = a1*b1 + a2*b2 + a3*b3" */

package exercicios;
import java.util.Scanner;

public class ex7 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		//Cria os vetores e a variável do produto
		int[] A = new int[3];
		int[] B = new int[3];
		int prod = 0;

		//Pede e armazena as coordenadas do vetor A
		for (int i = 0; i < 3; i++) {
			System.out.println("Digite a coordena a" + (i+1) + " do vetor A: ");
			A[i] = teclado.nextInt();
		}
		//Pede e armazena as coordenadas do vetor B
		for (int j = 0; j < 3; j++) {
			System.out.println("Digite a coordena b" + (j+1) + " do vetor B: ");
			B[j] = teclado.nextInt();
		}
		//Calcula e armazena o produto escalalar entre A e B
		for (int k = 0; k < 3; k++) {
			//Incrementa em prod a multiplicação de duas coordenadas correspondentes
			prod += A[k] * B[k];
		}
		//Exibe o resultado
		System.out.println("A*B = " + prod);
		
		teclado.close();
	}

}
