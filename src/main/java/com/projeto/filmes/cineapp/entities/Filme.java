package com.projeto.filmes.cineapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String diretor;
	private Integer classificacao;
	private Integer duracao;
	private Integer ano_lancamento;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn()
	private Sinopse sinopse;
	
	@ManyToMany
	@JoinTable(name = "filme_genero", joinColumns = @JoinColumn(name = "filme_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private Set<Genero> genero = new HashSet<>();

	public Filme() {
	}

	public Filme(Long id, String titulo, String diretor, Integer classificacao, Integer duracao,
			Integer ano_lancamento, Sinopse sinopse) {
		this.id = id;
		this.titulo = titulo;
		this.diretor = diretor;
		this.classificacao = classificacao;
		this.duracao = duracao;
		this.ano_lancamento = ano_lancamento;
		this.sinopse = sinopse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Sinopse getSinopse() {
		return sinopse;
	}
	
	public void setSinopse(Sinopse sinopse) {
		this.sinopse = sinopse;
	}
	
	public Set<Genero> getGenero() {
		return genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}
}
