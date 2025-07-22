package com.projeto.filmes.cineapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.filmes.cineapp.entities.Genero;
import com.projeto.filmes.cineapp.services.GeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {
	
	@Autowired
	private GeneroService service;
	
	@GetMapping
	public ResponseEntity<List<Genero>> findAll() {
		List<Genero> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Genero> findById(@PathVariable Long id){
		Genero obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
