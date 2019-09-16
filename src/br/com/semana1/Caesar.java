package br.com.semana1;

public class Caesar {
	
	private char[] plainAlfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public String encriptaCaesar(int numeroCasas, String textoPlano) {
		textoPlano = textoPlano.toLowerCase();
		char[] textoChar = textoPlano.toCharArray();
		String ch;
	    String cif = "";

		for (int i = 0; i < textoChar.length; i++){
			if(textoChar[i] == (' ') || textoChar[i] == ('.') || textoChar[i] == (',')){
				cif += textoChar[i];
			}
			else if(textoChar[i] == ('0') || textoChar[i] == ('1') || textoChar[i] == ('2') || textoChar[i] == ('3') || textoChar[i] == ('4') || 
					textoChar[i] == ('5') || textoChar[i] == ('6') || textoChar[i] == ('7') || textoChar[i] == ('8') || textoChar[i] == ('9')){

				cif += textoChar[i];

			}else{
				//Procura letra no alfabeto
				for(int j = 0; j < plainAlfabeto.length; j++){
					if(String.valueOf(textoChar[i]).equals(String.valueOf(plainAlfabeto[j]))){

						int posicao = j + numeroCasas;
						if(posicao >= 26){
							posicao = 26 - (posicao * (-1));
						}

						ch = String.valueOf(plainAlfabeto[posicao]);	
						cif += ch;
					}
				}
			}
		}
		
		return cif;
  }
	
	public String decriptaCaesar(int numeroCasas, String textoCifrado) {
		
		textoCifrado = textoCifrado.toLowerCase();
		char[] textoChar = textoCifrado.toCharArray();
		String ch;
	    String dec = "";

		for (int i = 0; i < textoChar.length; i++){
			if(textoChar[i] == (' ') || textoChar[i] == ('.') || textoChar[i] == (',')){
				dec += textoChar[i];
			}
			else if(textoChar[i] == ('0') || textoChar[i] == ('1') || textoChar[i] == ('2') || textoChar[i] == ('3') || textoChar[i] == ('4') || 
					textoChar[i] == ('5') || textoChar[i] == ('6') || textoChar[i] == ('7') || textoChar[i] == ('8') || textoChar[i] == ('9')){

				dec += textoChar[i];

			}else{
				//Procura letra no alfabeto
				for(int j = 0; j < plainAlfabeto.length; j++){
					if(String.valueOf(textoChar[i]).equals(String.valueOf(plainAlfabeto[j]))){

						int posicao = j - numeroCasas;
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
