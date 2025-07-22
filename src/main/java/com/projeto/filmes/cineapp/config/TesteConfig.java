package com.projeto.filmes.cineapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.repositories.FilmeRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Filme fil1 = new Filme(null, "Bastardos Inglórios", "Quentin Tarantino", 18, "2h33", 2009);
		Filme fil2 = new Filme(null, "Interestelar", "Christopher Nolan", 10, "2h49", 2014);
		Filme fil3 = new Filme(null, "Missão Impossível - Efeito Fallout", "Christopher McQuarrie", 14, "2h28", 2018);
		Filme fil4 = new Filme(null, "Halloween- A Noite do Terror", "John Carpenter", 16, "1h31", 1978);
		Filme fil5 = new Filme(null, "Guardiões da Galáxia", "James Gunn", 12, "2h2m", 2014);
		
		filmeRepository.saveAll(Arrays.asList(fil1, fil2, fil3, fil4, fil5));
	}
}
