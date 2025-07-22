package com.projeto.filmes.cineapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.filmes.cineapp.entities.Genero;
import com.projeto.filmes.cineapp.repositories.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository repository;
	
	public List<Genero> findAll(){
		return repository.findAll();
	}
	
	public Genero findById(Long id) {
		Optional<Genero> obj = repository.findById(id);
		return obj.get();
	}
}
