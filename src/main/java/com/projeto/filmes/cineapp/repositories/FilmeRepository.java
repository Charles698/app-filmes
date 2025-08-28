package com.projeto.filmes.cineapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.filmes.cineapp.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	 @Query("SELECT f FROM Filme f JOIN FETCH f.sinopse JOIN FETCH f.genero")
	 List<Filme> findAll();
	
	 List<Filme> findByTituloContainingIgnoreCase(String titulo);
}
