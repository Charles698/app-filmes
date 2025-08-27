package com.projeto.filmes.cineapp.entities.dto;

import java.util.HashSet;
import java.util.Set;

import com.projeto.filmes.cineapp.entities.Filme;

public class FilmeDTO {
	
	private String titulo;
	private String diretor;
	private Integer classificacao;
	private Integer duracao;
	private Integer ano_lancamento;
	
	private String sinopse;
	
	private Set<GeneroDTO> generos = new HashSet<>();
	
	public FilmeDTO() {
	}

	public FilmeDTO(Filme filme) {
		this.titulo = filme.getTitulo();
		this.diretor = filme.getDiretor();
		this.classificacao = filme.getClassificacao();
		this.duracao = filme.getDuracao();
		this.ano_lancamento = filme.getAno_lancamento();
		this.sinopse = filme.getSinopse().getTexto();
		
		filme.getGenero().forEach(genero -> this.generos.add(new GeneroDTO(genero)));	
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(Integer ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public Set<GeneroDTO> getGenero() {
		return generos;
	}	
}
