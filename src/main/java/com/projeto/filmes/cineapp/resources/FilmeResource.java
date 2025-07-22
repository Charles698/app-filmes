package com.projeto.filmes.cineapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public ResponseEntity<List<Filme>> findAll() {
		List<Filme> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Filme> findById(@PathVariable Long id){
		Filme obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
