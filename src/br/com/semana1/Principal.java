package br.com.semana1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.semana1.Caesar;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*SEMANA 1 - FIBONACCI: EXIBINDO A LISTA*/
		List<Integer> fiboLista = new ArrayList<>();
		DesafioFibonacci fibonacci = new DesafioFibonacci();

		fiboLista = fibonacci.Fibonacci();      
		System.out.println(fiboLista);
		
		/*SEMANA 1 - FIBONACCI: VERIFICANDO SE UM NUMERO ESTÁ NA LISTA*/
		System.out.println("Digite um número: ");
		Integer numero = sc.nextInt();
		
		boolean ehFibo = fibonacci.isFibonacci(numero);
		System.out.println("Valor ehFibo: " + ehFibo);
		
		if(ehFibo) {
			System.out.println("O número digitado está na lista!");
		}else {
			System.out.println("O número digitado NÃO está na lista!");
		}
		
		/*SEMANA 1 - CAESAR*/
		Caesar caesar = new Caesar();
		String opc = "";
		String textoCifrado = "";
		String textoDecifrado = "";
		Integer numeroCasas = 0;
		
		System.out.println("---------  MENU  ---------");
		System.out.println("1 - CRIPTOGRAFAR");
		System.out.println("2 - DESCRIPTOGRAFAR");
		System.out.println("DIGITE O NUMERO DA OPÇÃO:");
		opc = sc.next();
		
		switch(opc) {
			case "1":
				System.out.println("---------  CRIPTOGRAFAR  ---------");
				System.out.println("Digite o número de casas: ");
				numeroCasas = sc.nextInt();
				
				System.out.println("Entre com o Texto para ser Cifrado: ");
				String textoPlano = sc.next();
				sc.close();
				
				textoCifrado = caesar.encriptaCaesar(numeroCasas, textoPlano);
				
				System.out.println("Texto Cifrado: " + textoCifrado);
				break;
			case "2":
				System.out.println("---------  DESCRIPTOGRAFAR  ---------");
				System.out.println("Digite o número de casas: ");
				numeroCasas = sc.nextInt();
				
				System.out.println("Entre com o Texto para ser Decifrado: ");
				textoCifrado = sc.next();
				sc.close();
				
				textoDecifrado = caesar.decriptaCaesar(numeroCasas, textoCifrado);
				
				System.out.println("Texto Decifrado: " + textoDecifrado);
				break;
			default:
				break;
		}
	}
}
