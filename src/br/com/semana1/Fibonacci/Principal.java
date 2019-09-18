package br.com.semana1.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.semana1.Caesar.Desafio;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*SEMANA 1 - FIBONACCI: EXIBINDO A LISTA*/
		List<Integer> fiboLista = new ArrayList<>();

		fiboLista = Fibonacci();      
		System.out.println(fiboLista);
		
		/*SEMANA 1 - FIBONACCI: VERIFICANDO SE UM NUMERO ESTÁ NA LISTA*/
		System.out.println("Digite um número: ");
		Integer numero = sc.nextInt();
		sc.close();
		
		boolean ehFibo = isFibonacci(numero);
		
		if(ehFibo) {
			System.out.println("O número digitado está na lista!");
		}else {
			System.out.println("O número digitado NÃO está na lista!");
		}
	}
	
@Desafio("Fibonacci")
	public static List<Integer> Fibonacci(){
		       
	 	List<Integer> fibo = new ArrayList<>();    
		Integer atual = 0;
		Integer anterior = 0;
		
        for (int i = 1; anterior <= 350; i++) {
      	  
            if (i == 1) {
            	atual = 1;
            	anterior = 0;
            	fibo.add(anterior);
            	fibo.add(atual);
            } else {
            	atual = anterior + atual;
                anterior = atual - anterior;
             /*Verifica se o numero é menor que 350 por que 
              * o ultimo elemento é adicionado a lista, mas nao é testado*/  
                if (atual <= 350) { 
                	fibo.add(atual);
				} 
            }
        }
        
		return fibo;	
		
	}

@Desafio("isFibonacci")
	public static boolean isFibonacci(Integer numero){
	
		//Recebe a lista do método @Desafio("Fibonacci")
		List<Integer> fiboLista = new ArrayList<>();
		fiboLista = Fibonacci();  
		return fiboLista.contains(numero);
		
	}
}
