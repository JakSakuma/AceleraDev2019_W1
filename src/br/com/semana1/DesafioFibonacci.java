package br.com.semana1;

import java.util.ArrayList;
import java.util.List;

/* Faça um método @Desafio("Fibonacci") que retorne uma lista java.util.List 
 * com os primeiros números Integer da série de Fibonacci até 350.
 * A série de Fibonacci é a seguinte: 0, 1, 1, 2, 3, 5, 8, 13, etc…
 * Faça um segundo método @Desafio("isFibonnaci") que recebe um Integer 
 * como parâmetro e retorne Boolean. Caso o número recebido por parâmetro 
 * esteja entre os números da sequência de Fibonnaci do @Desafio("Fibonnaci") 
 * retorne true, senão, false.*/

public class DesafioFibonacci {

	//parallelStreams - Assincrono -- thread
	//list tem o método sort de ordenação..forEach, clear, 
	
@Desafio("Fibonacci")
	public List<Integer> Fibonacci(){
		       
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
	public boolean isFibonacci(Integer numero){
	
		boolean ehFibo = false;
	
		//Recebe a lista do método @Desafio("Fibonacci")
		List<Integer> fiboLista = new ArrayList<>();
		fiboLista = Fibonacci();  
		
		//Verifica se o numero escolhido está na lista.
		for (int i = 0; i < fiboLista.size(); i++) {
			Integer numeroLista = fiboLista.get(i);
			
			if (numero == numeroLista) {				
				ehFibo = true;
				break;
			}	
		}
		
		return ehFibo;
		
	}
}