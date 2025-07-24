package com.projeto.filmes.cineapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.filmes.cineapp.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	Optional<Filme> findByTitulo(String titulo);
}
