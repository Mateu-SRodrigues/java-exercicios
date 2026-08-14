/*9. Elize é dona de um restaurante e está enfrentando um problema com o termostato de seu freezer, 
 * que possui apenas uma configuração em graus Celsius. No entanto, todo  o seu estoque de 
 * mantimentos está etiquetado com uma temperatura recomendada  em Fahrenheit, e fazer a conversão 
 * a cada vez que ela vai armazenar um novo item, é bastante trabalhoso. Portanto, ela precisa de 
 * um algoritmo que, dada uma  temperatura em Fahrenheit, diga seu equivalente em Celsius. 
 * Para checar os valores, ela também precisa que o mesmo algoritmo, dada uma temperatura em Celsius, 
 * diga seu equivalente em Fahrenheit. Observe que a conversão de graus Fahrenheit para Celsius é 
 * obtida por F = (5/9) * (C − 32). Deduza a fórmula de conversão de graus Celsius para Fahrenheit.*/

package exercicios;
import java.util.Scanner;

public class ex9 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		double c, f;
		
		//Armazena a temperatura em C e converte para F
		System.out.println("Digite a temperatura em Celsius: ");
		c = teclado.nextDouble();
		f = (9.0/5) * (c - 32);
		System.out.println(c + "°C = " + f + "°F.");
		
		//Armazena a temperatura em F e converte para C
		System.out.println("Digite a temperatura em Fahrenheit: ");
		f = teclado.nextDouble();
		c = (5.0/9) * (f - 32);
		System.out.println(f + "°F = " + c + "°C.");

		teclado.close();
	}

}
