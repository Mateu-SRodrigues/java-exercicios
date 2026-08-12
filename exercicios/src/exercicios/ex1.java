/*Faça um programa que receba dois números reais (double),
calcule e mostre a média entre eles.
	Caso a média seja maior que 7, mostrar a mensagem “Aprovado”,
senão mostrar “Reprovado”*/

package exercicios;

import java.util.Scanner;
public class ex1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		//Pede as entradas ao usuário
		System.out.println("Digite o primeiro numero: ");
		double n1 = teclado.nextDouble();
		System.out.println("Digite o segundo numero: ");
		double n2 = teclado.nextDouble();
		
		//Calcula a média
		double media = (n1 + n2)/2;
		
		//Retorna a média e se o aluno foi aprovado ou reprovado
		System.out.println("A media é " + media);
		if(media > 7)
			System.out.println("Aprovado");
		else
			System.out.println("Reprovado");
		
		teclado.close();
	}

}
