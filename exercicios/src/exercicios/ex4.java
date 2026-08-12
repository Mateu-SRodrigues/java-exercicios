/*Ex1. Laura está criando um programa para um projeto de pesquisa sobre o envelhecimento  humano e precisa de ajuda.

    a. Desenvolva um algoritmo que calcule a idade de uma pessoa de acordo com sua data de nascimento. Ex: Fulano nasceu 15 de agosto de 1999 Fulano tem 25 anos
    b. Na verdade, ela precisa de um algoritmo que converta a data de nascimento, fornecida em anos, meses e dias, para o formato de dias. Não se preocupe com ano bissextos e considere que todos os meses têm 30 dias. 
    Ex: Fulano nasceu 15 de agosto de 1999 
        Fulano tem 9380 dias de vida.*/

package exercicios;
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		int dias = 0;//Armazena os dias de vida
		
		//Pede o nome e a data de nascimenta
		System.out.println("Digite o nome da pesssoa: ");
		String nome = teclado.next();
		System.out.println("Digite o dia de nascimento: ");
		int diaNasc = teclado.nextInt();
		System.out.println("Digite o mês de nascimento: ");
		int mesNasc = teclado.nextInt();
		System.out.println("Digite o ano de nascimento: ");
		int anoNasc = teclado.nextInt();
		
		//Pede a data atual
		System.out.println("Digite o dia atual: ");
		int dia = teclado.nextInt();
		System.out.println("Digite o mês atual: ");
		int mes = teclado.nextInt();
		System.out.println("Digite o ano atual: ");
		int ano = teclado.nextInt();
		
		//Calcula e exibe a idade
		int idade = ano - anoNasc;
		System.out.println(nome + " tem " + idade + " anos.");
		
		//Calcula e exibe os dias de vida
		dias += (ano * 365) + (mes * 30) + dia;
		dias -= (anoNasc * 365) + (mesNasc * 30) + diaNasc;
		System.out.println(nome + " tem " + dias + " dias de vida.");

		teclado.close();
	}

}
