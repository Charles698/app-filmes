package com.projeto.filmes.cineapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.filmes.cineapp.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
