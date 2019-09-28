package br.com.semana2.Futebol;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	private HashMap<Long, Jogador> jogadores = new HashMap<Long, Jogador>();
	private HashMap<Long, Time> times = new HashMap<Long, Time>();
	

	@Override
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		
			if (times.get(id) != null) {
				throw new IdentificadorUtilizadoException("ID do time ja existe.");
			}
	
		times.put(id, new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
				
	}

	@Override
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		
			if (jogadores.get(id) != null) {		
				throw new IdentificadorUtilizadoException("ID do jogador ja existe.");
			}
			if (times.get(idTime) == null) {
				throw new TimeNaoEncontradoException("Este time nao existe.");
			}
			
		jogadores.put(id, new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));

	}

	@Override
	public void definirCapitao(Long idJogador) {

		if (jogadores.get(idJogador) == null) {
			throw new JogadorNaoEncontradoException("Jogador nao foi encontrado.");
		}
		
		Jogador capitao = jogadores.get(idJogador);
		Time time = times.get(capitao.getIdTime());
		time.setCapitao(capitao);
		
	}

	@Override
	public Long buscarCapitaoDoTime(Long idTime) {

			if (times.get(idTime) == null) {
				throw new TimeNaoEncontradoException("Este time nao existe.");
			} 
			
			if(times.get(idTime).getCapitao() == null) {
				throw new CapitaoNaoInformadoException("Este time nao possui um capitao");
			}
			
		return times.get(idTime).getCapitao().getId();
	}

	@Override
	public String buscarNomeJogador(Long idJogador) {
		if (jogadores.get(idJogador) == null) {
			throw new JogadorNaoEncontradoException("Jogador nao foi encontrado.");
		}

		return jogadores.get(idJogador).getNome();
	}

	@Override
	public String buscarNomeTime(Long idTime) {
		
		if (times.get(idTime) == null) {
			throw new TimeNaoEncontradoException("Este time nao existe.");
		} 
		
		return times.get(idTime).getNome();
	}

	@Override
	public Long buscarJogadorMaiorSalario(Long idTime) {
		
		if (times.get(idTime) == null) {
			throw new TimeNaoEncontradoException("Este time nao existe.");
		} 
		if (times.get(idTime).getJogadores().size() == 0) {
			throw new JogadorNaoEncontradoException("Nao exite jogadores neste time.");
		}
		
		
		Jogador jogadorMaiorSalario = times.get(idTime).getJogadores().get(0);

		for(Jogador jogador : times.get(idTime).getJogadores()){

			if (jogador.getSalario().compareTo(jogadorMaiorSalario.getSalario()) > 0) { 
				jogadorMaiorSalario = jogador;

			}
			else if(jogador.getSalario().compareTo(jogadorMaiorSalario.getSalario()) == 0 && Long.compare(jogador.getId(), jogadorMaiorSalario.getId()) < 0) {
				jogadorMaiorSalario = jogador;

			}
		}
		
		return jogadorMaiorSalario.getId();
	}

	@Override
	public BigDecimal buscarSalarioDoJogaodor(Long idJogador) {
		
		if (jogadores.get(idJogador) == null) {
			throw new JogadorNaoEncontradoException("Jogador nao foi encontrado.");
		}
		
		return jogadores.get(idJogador).getSalario();
	}

	@Override
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		
		if (times.get(idTime) == null) {
			throw new TimeNaoEncontradoException("Este time nao existe.");
		} 
		
		List<Long> jogadoresTime = new ArrayList<Long>();
				
		for(Jogador jogador : times.get(idTime).getJogadores()){
			jogadoresTime.add(jogador.getId());
		}
		
		Collections.sort(jogadoresTime); /*Ordena Lista*/
		
		System.out.println(jogadoresTime);
		return jogadoresTime;
	}

	@Override
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		
		if (times.get(idTime) == null) {
			throw new TimeNaoEncontradoException("Este time nao existe.");
		}
		
		Jogador melhorJogador = times.get(idTime).getJogadores().get(0);

		for(Jogador jogador : times.get(idTime).getJogadores()){
			if (jogador.getNivelHabilidade().compareTo(melhorJogador.getNivelHabilidade()) > 0) { 
				melhorJogador = jogador;
			}
		}

		return melhorJogador.getId();

	}

	@Override
	public Long buscarJogadorMaisVelho(Long idTime) {	
		
		if (times.get(idTime) == null) {
			throw new TimeNaoEncontradoException("Este time nao existe.");
		}
		
		Jogador jogadorMaisVelho = times.get(idTime).getJogadores().get(0);

		for(Jogador jogador : times.get(idTime).getJogadores()){

			if (jogador.getDataNascimento().compareTo(jogadorMaisVelho.getDataNascimento()) < 0) { 
				jogadorMaisVelho = jogador;

			}
			else if(jogador.getDataNascimento().compareTo(jogadorMaisVelho.getDataNascimento()) == 0 && Long.compare(jogador.getId(), jogadorMaisVelho.getId()) < 0) {
				jogadorMaisVelho = jogador;

			}
		}

		return jogadorMaisVelho.getId();
	}

	@Override
	public List<Long> buscarTimes() {
		List<Long> listaTimes = new ArrayList<Long>();
	
		if (times.size() > 0) {
			for (Long i = 0L; i < times.size(); i++) {
				listaTimes.add(times.get(i).getId());
			}
			
			Collections.sort(listaTimes);
		} 
		
		
	/*	for (Map.Entry entry : times.entrySet()) {
			Time time = (Time) entry.getValue();
			listaTimes.add(time.getId());
		}
*/
		return listaTimes;

	}

	@Override
	public List<Long> buscarTopJogadores(Integer top) {
				
		if(top > jogadores.size()) {
			throw new JogadorNaoEncontradoException("A quantidade de jogadores informada é maior que a quantidade total de jogadores no sistema.");
		}
		
			List<Jogador> topJogadores = new ArrayList<Jogador>();
			List<Long> idJogadores = new ArrayList<Long>();

			if(jogadores.size() == 0) {
				return idJogadores;
			}
			
			for (Long key : jogadores.keySet()) {
				topJogadores.add(jogadores.get(key));

			}

			topJogadores.sort((j1, j2) -> {

				if (j1.getNivelHabilidade().compareTo(j2.getNivelHabilidade()) > 0) {
					return 1;
				}
				else if (j1.getNivelHabilidade().compareTo(j2.getNivelHabilidade()) < 0) {
					return -1;
				}
				else if(Long.compare(j1.getId(), j2.getId()) < 0) {
					return 1;
				} else {
					return -1;
				}

			});

			for (int i = topJogadores.size() - 1 ; i > topJogadores.size() - (top + 1); i--) {
				idJogadores.add(topJogadores.get(i).getId());
			}

			return idJogadores;
				
	}

	@Override
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		
		if (times.get(timeDaCasa) == null || times.get(timeDeFora) == null) {
			throw new TimeNaoEncontradoException("Time da casa ou time adversario inexistente");
		}

		if(times.get(timeDaCasa).getCorUniformePrincipal().equals(times.get(timeDeFora).getCorUniformePrincipal())) {
			return times.get(timeDeFora).getCorUniformeSecundario();
		}

		return times.get(timeDeFora).getCorUniformePrincipal();

	}

}