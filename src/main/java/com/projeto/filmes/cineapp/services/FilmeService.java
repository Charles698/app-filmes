package com.projeto.filmes.cineapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.repositories.FilmeRepository;
import com.projeto.filmes.cineapp.services.exceptions.ResourceNotFoundException;
import com.projeto.filmes.cineapp.services.exceptions.DatabaseException.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	public List<Filme> findAll(){
		return repository.findAll();
	}
	
	public Filme findById(Long id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Filme findByTitulo(String nome) {
		Optional<Filme> obj = repository.findByTitulo(nome);
		return obj.get();
	}
	
	public Filme insert(Filme obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Filme update(Long id, Filme obj) {
		try {
			Filme entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Filme entity, Filme obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setDiretor(obj.getDiretor());
		entity.setClassificacao(obj.getClassificacao());
		entity.setDuracao(obj.getDuracao());
		entity.setAno_lancamento(obj.getAno_lancamento());
	}
}
