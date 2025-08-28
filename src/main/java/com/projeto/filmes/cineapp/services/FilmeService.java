package com.projeto.filmes.cineapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.entities.dto.FilmeDTO;
import com.projeto.filmes.cineapp.repositories.FilmeRepository;
import com.projeto.filmes.cineapp.services.exceptions.ResourceNotFoundException;
import com.projeto.filmes.cineapp.services.exceptions.DatabaseException.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	
	// Método para pegar um lista de todos os filmes cadastrados
	public List<FilmeDTO> findAll(){
		List<Filme> filme = repository.findAll();
		return filme.stream()
				.map(FilmeDTO::new)
				.collect(Collectors.toList());
	}
	
	// Método para achar um filme pelo ID
	public FilmeDTO findById(Long id) {
		Filme obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new FilmeDTO(obj);
	}
	
	// Método para achar um filme pelo título do filme
	// ex: Bastardos Inglórios
	public List<FilmeDTO> findByTitulo(String nome) {
		List<Filme> obj = repository.findByTituloContainingIgnoreCase(nome);
		List<FilmeDTO> objDTO = obj.stream()
					.map(FilmeDTO::new)
					.collect(Collectors.toList());
		return objDTO;
	}
	
	// Método para inserir filmes 
	public FilmeDTO insert(FilmeDTO obj) {
		Filme entity = fromDTO(obj);
		Filme salvo = repository.save(entity);
		return new FilmeDTO(salvo);
	}
	
	// Método para deletar filmes
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) { // <- Caso o usuário tente deletar um filme não cadastrado
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	// Método para atualizar dados do filme
	public FilmeDTO update(Long id, FilmeDTO obj) {
		try {
			Filme entity = repository.getReferenceById(id);
			updateData(entity, fromDTO(obj));
			entity = repository.save(entity);
			return new FilmeDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	// Complemento do update para atualizar apenas alguns dados
	private void updateData(Filme entity, Filme obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setDiretor(obj.getDiretor());
		entity.setClassificacao(obj.getClassificacao());
		entity.setDuracao(obj.getDuracao());
		entity.setAno_lancamento(obj.getAno_lancamento());
	}
	
	private Filme fromDTO(FilmeDTO obj) {
		Filme entity = new Filme();
		entity.setTitulo(obj.getTitulo());
		entity.setDiretor(obj.getDiretor());
		entity.setClassificacao(obj.getClassificacao());
		entity.setDuracao(obj.getDuracao());
		entity.setAno_lancamento(obj.getAno_lancamento());
		return entity;
	}
}
