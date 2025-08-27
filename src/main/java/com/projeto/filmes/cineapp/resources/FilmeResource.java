package com.projeto.filmes.cineapp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.filmes.cineapp.entities.dto.FilmeDTO;
import com.projeto.filmes.cineapp.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public ResponseEntity<List<FilmeDTO>> findAll() {
		List<FilmeDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FilmeDTO> findById(@PathVariable Long id){
		FilmeDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Para buscar o título do filme que contenha espaços, use "%20"
	// Ex: filmes/nome?titulo=bastardos%20inglorios
	@GetMapping(value = "/buscar")
	public ResponseEntity<FilmeDTO> findByTitulo(@RequestParam("titulo") String nome){
		FilmeDTO obj = service.findByTitulo(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<FilmeDTO> insertById(@RequestBody FilmeDTO obj){
		FilmeDTO filmeSalvo = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(obj).toUri();
		return ResponseEntity.created(uri).body(filmeSalvo);	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FilmeDTO> update(@PathVariable Long id, @RequestBody FilmeDTO obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
