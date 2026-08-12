package exercicios;

import java.util.Scanner;
public class ex1 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Digite o primeiro numero: ");
		double n1 = teclado.nextDouble();
		System.out.println("Digite o segundo numero: ");
		double n2 = teclado.nextDouble();
		
		double media = (n1 + n2)/2;
		
		System.out.println("A media é " + media);
		if(media > 7)
			System.out.println("Aprovado");
		else
			System.out.println("Reprovado");
		
		teclado.close();
	}

}
