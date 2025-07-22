package com.projeto.filmes.cineapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.repositories.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	public List<Filme> findAll(){
		return repository.findAll();
	}
	
	public Filme findById(Long id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.get();
	}
}
