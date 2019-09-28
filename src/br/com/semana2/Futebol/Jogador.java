package br.com.semana2.Futebol;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {


	/*
	 * Long id* Identificador do Jogador 
	 * Long idTime* Identificador do time 
	 * String nome* Nome do Jogador 
	 * LocalDate dataNascimento* Data de nascimento do Jogador
	 * Integer nivelHabilidade* Nível de habilidade do jogador (0 a 100) 
	 * BigDecimal salario* Salário do jogador
	 * 
	 * Caso o identificador já exista, retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
	 * Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
	 */
	
	private Long id;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	
	public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		this.id = id;
		this.idTime = idTime;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdTime() {
		return idTime;
	}
	
	public void setIdTime(long idTime) {
		this.idTime = idTime;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}
	
	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
    
}
