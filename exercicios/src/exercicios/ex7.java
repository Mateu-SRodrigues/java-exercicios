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
		int[] A = new int[3];
		int[] B = new int[3];
		int prod = 0;

		for (int i = 0; i < 3; i++) {
			System.out.println("Digite a coordena a" + (i+1) + " do vetor A: ");
			A[i] = teclado.nextInt();
		}
		for (int j = 0; j < 3; j++) {
			System.out.println("Digite a coordena b" + (j+1) + " do vetor B: ");
			B[j] = teclado.nextInt();
		}
		for (int k = 0; k < 3; k++) {
			prod += A[k] * B[k];
		}
		
		System.out.println("A*B = " + prod);
		
		teclado.close();
	}

}
