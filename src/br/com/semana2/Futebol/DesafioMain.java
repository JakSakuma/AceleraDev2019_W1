package br.com.semana2.Futebol;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMain {

	public static void main(String[] args) {
		DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

		LocalDate data1 = LocalDate.of(2000, 10, 01);
		LocalDate data2 = LocalDate.of(2010, 10, 01);
		LocalDate data3 = LocalDate.of(1980, 10, 01);
		BigDecimal d1 = new BigDecimal("10.0");
		BigDecimal d2 = new BigDecimal("20.0");
		BigDecimal d3 = new BigDecimal("100.0");

		System.out.println("[TESTE] buscarTimes - vazio");
		try{
			System.out.println(desafio.buscarTimes());
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] incluirTime - novo");
		try{
			desafio.incluirTime(1L, "Sao Jose", data1, "branco", "amarelo");
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] incluirTime - ID já existe");
		try{
			desafio.incluirTime(1L, "time 1", data1, "branco", "amarelo");
			System.out.println("[Falhou]");
		}catch (IdentificadorUtilizadoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();

		System.out.println("[TESTE] buscarJogadoresDoTime - Time existe, sem jogadores");
		try{
			desafio.buscarJogadoresDoTime(1L);
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

		System.out.println("[TESTE] buscarJogadorMaisVelho - Time existe, sem jogadores");
		try{
			desafio.buscarJogadorMaisVelho(1L);
			System.out.println("[Falhou] - Precisa retornar NullPointerException");
		} catch (NullPointerException e) {
			System.out.println("[Passou]");
		}
		System.out.println();
		
		System.out.println("[TESTE] incluirTime - Mais um time");
		try{
			desafio.incluirTime(2L, "time 1", data1, "branco", "amarelo");
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarTimes - Deve exibir [1,2]");
		try{
			System.out.println(desafio.buscarTimes());
			List<Long> lista = desafio.buscarTimes();
			if (lista.get(0).equals(1L) && lista.get(1).equals(2L)) {
				System.out.println("[Passou]");
			}else {
				System.out.println("[Falhou] - valores fora da ordem");
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] incluirJogador - Joao");
		try{
			desafio.incluirJogador(1L, 1L, "Joao", data2, 10, d1);
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarJogadorMaisVelho - 1 jogador cadastrado, mas Time escolhido sem jogadores");
		try{
			desafio.buscarJogadorMaisVelho(2L);
			System.out.println("[Falhou] - deveria retornar NullPointerException");
		} catch (NullPointerException e) {
			System.out.println("[Passou]");
		}
		System.out.println();		

		desafio.incluirJogador(3L, 1L, "Mario", data2, 11, d3);
		desafio.incluirJogador(2L, 1L, "Carlos", data3, 9, d2);
		System.out.println("[TESTE] incluirJogador - Time não existe");
		try{
			desafio.incluirJogador(5L, 10L, "alala", data1, 10, d1);
			System.out.println("[Falhou] - deveria retornar TimeNaoEncontradoException");
		} catch (TimeNaoEncontradoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();
		
		System.out.println("[TESTE] incluirJogador - jogador duplicado");
		try{
			desafio.incluirJogador(1L, 1L, "alala", data1, 10, d1);
			System.out.println("[Falhou] - deveria retornar IdentificadorUtilizadoException");
		} catch (IdentificadorUtilizadoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();

		System.out.println("[TESTE] definirCapitao - existe jogador");
		try{
			desafio.definirCapitao(3L);
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

		System.out.println("[TESTE] definirCapitao - jogador não existe");
		try{
			desafio.definirCapitao(5L);
			System.out.println("[Falhou] - deveria retornar JogadorNaoEncontradoException");
		} catch (JogadorNaoEncontradoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();

		System.out.println("[TESTE] buscarCapitaoDoTime - time existe e com capiptao definido");
		try{
			System.out.println(desafio.buscarCapitaoDoTime(1L));
			System.out.println("[Passou]");
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarCapitaoDoTime - time não existe ");
		try{
			System.out.println(desafio.buscarCapitaoDoTime(11L));
			System.out.println("[Falhou] - deveria retornar TimeNaoEncontradoException");
		} catch (TimeNaoEncontradoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();

		System.out.println("[TESTE] buscarCapitaoDoTime - sem capitão ");
		try{
			System.out.println(desafio.buscarCapitaoDoTime(2L));
			System.out.println("[Falhou] - deveria retornar CapitaoNaoInformadoException");
		} catch (CapitaoNaoInformadoException e) {
			System.out.println("[Passou]");
		}
		System.out.println();

		System.out.println("[TESTE] buscarNomeJogador - (deve retornar Joao)");
		try{
			if (desafio.buscarNomeJogador(1L).equals("Joao")) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - nome = "+desafio.buscarNomeJogador(1L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarNomeJogador - (deve retornar Sao Jose)");
		try{
			if (desafio.buscarNomeTime(1L).equals("Sao Jose")) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - nome = "+desafio.buscarNomeTime(1L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

		System.out.println("[TESTE] buscarJogadoresDoTime - (deve retornar [1,2,3])");
		try{
			List<Long> lista2 = desafio.buscarJogadoresDoTime(1L);
			if (lista2.get(0).equals(1L) && lista2.get(1).equals(2L) && lista2.get(2).equals(3L)) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - "+desafio.buscarJogadoresDoTime(1L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

		System.out.println("[TESTE] buscarMelhorJogadorDoTime - (deve retornar 3)");
		try{			
			if (desafio.buscarMelhorJogadorDoTime(1L).equals(3L)) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - "+desafio.buscarMelhorJogadorDoTime(1L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

		System.out.println("[TESTE] buscarTopJogadores - (deve retornar [3,1,2])");
		try{
			List<Long> lista2 = desafio.buscarTopJogadores(10);
			if (lista2.get(0).equals(3L) && lista2.get(1).equals(1L) && lista2.get(2).equals(2L)) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - "+desafio.buscarTopJogadores(10));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarJogadorMaisVelho - (deve retornar 2)");
		try{			
			if (desafio.buscarJogadorMaisVelho(1L).equals(2L)) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - "+desafio.buscarJogadorMaisVelho(1L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("[TESTE] buscarJogadorMaiorSalario - (deve retornar 3)");
		try{			
			if (desafio.buscarJogadorMaiorSalario(1L).equals(3L)) {
				System.out.println("[Passou]");
			} else {
				System.out.println("[Falhou] - "+desafio.buscarJogadorMaiorSalario(3L));
			}
		} catch (Exception e) {
			System.out.println("[Falhou]"+e.getMessage());
		}
		System.out.println();

	}
}