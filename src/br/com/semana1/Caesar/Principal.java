package br.com.semana1.Caesar;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*SEMANA 1 - CAESAR*/
		String opc = "";
		String textoCifrado = "";
		String textoDecifrado = "";
			
		System.out.println("---------  MENU  ---------");
		System.out.println("1 - CRIPTOGRAFAR");
		System.out.println("2 - DESCRIPTOGRAFAR");
		System.out.println("DIGITE O NUMERO DA OPÇÃO:");
		opc = sc.nextLine();
		
		switch(opc) {
			case "1":
				System.out.println("---------  CRIPTOGRAFAR  ---------");
				System.out.println("Entre com o Texto para ser Cifrado: ");
				String textoPlano = sc.nextLine();
				sc.close();
				
				textoCifrado = encriptaCaesar(textoPlano);
				
				System.out.println("Texto Cifrado: " + textoCifrado);
				break;
			case "2":
				System.out.println("---------  DESCRIPTOGRAFAR  ---------");			
				System.out.println("Entre com o Texto para ser Decifrado: ");
				textoCifrado = sc.nextLine();
				sc.close();				
				
				textoDecifrado = decriptaCaesar(textoCifrado);
				
				System.out.println("Texto Decifrado: " + textoDecifrado);
				break;
			default:
				break;
		}
	}


	public static String encriptaCaesar(String texto) {
		
		char[] plainAlfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		if (texto.isEmpty()) {
			throw new IllegalArgumentException ("Nao ha texto para encriptar.");		
		} 
		 
		texto = texto.toLowerCase();
		char[] textoChar = texto.toCharArray();
		String ch;
	    String cif = "";   
	    
		for (int i = 0; i < textoChar.length; i++){
			if(textoChar[i] == (' ') || textoChar[i] == ('.') || textoChar[i] == (',')){
				cif += textoChar[i];
			}
			else if(textoChar[i] == ('0') || textoChar[i] == ('1') || textoChar[i] == ('2') || 
					textoChar[i] == ('3') || textoChar[i] == ('4') || textoChar[i] == ('5') || 
					textoChar[i] == ('6') || textoChar[i] == ('7') || textoChar[i] == ('8') || 
					textoChar[i] == ('9')){

				cif += textoChar[i];

			}else{
				//Procura letra no alfabeto
				for(int j = 0; j < plainAlfabeto.length; j++){
					if(String.valueOf(textoChar[i]).equals(String.valueOf(plainAlfabeto[j]))){

						int posicao = j + 3;
						if(posicao > 26){
							posicao = 26 + (posicao * (-1));
							posicao = posicao * (-1);
						}

						ch = String.valueOf(plainAlfabeto[posicao]);	
						cif += ch;
					}
				}
			}
		}
		
		return cif;	
  }
	
	public static String decriptaCaesar(String texto) {
		
		char[] plainAlfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	      
		if (texto.isEmpty()) {
			throw new IllegalArgumentException ("Nao ha texto para decriptar.");		
		} 
		texto = texto.toLowerCase();
		char[] textoChar = texto.toCharArray();
		String ch;
	    String dec = "";

		for (int i = 0; i < textoChar.length; i++){
			if(textoChar[i] == (' ') || textoChar[i] == ('.') || textoChar[i] == (',')){
				dec += textoChar[i];
			}
			else if(textoChar[i] == ('0') || textoChar[i] == ('1') || textoChar[i] == ('2') || 
					textoChar[i] == ('3') || textoChar[i] == ('4') || textoChar[i] == ('5') || 
					textoChar[i] == ('6') || textoChar[i] == ('7') || textoChar[i] == ('8') || 
					textoChar[i] == ('9')){

				dec += textoChar[i];

			}else{
				//Procura letra no alfabeto
				for(int j = 0; j < plainAlfabeto.length; j++){
					if(String.valueOf(textoChar[i]).equals(String.valueOf(plainAlfabeto[j]))){

						int posicao = j - 3;
						if(posicao < 0){
							posicao = 26 - (posicao * (-1));
						}

						ch = String.valueOf(plainAlfabeto[posicao]);	
						dec += ch;
					}
				}
			}
		}
		
		return dec;		
	}
}
