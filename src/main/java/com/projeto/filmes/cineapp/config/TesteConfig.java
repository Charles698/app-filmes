package com.projeto.filmes.cineapp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.filmes.cineapp.entities.Filme;
import com.projeto.filmes.cineapp.entities.Genero;
import com.projeto.filmes.cineapp.entities.Sinopse;
import com.projeto.filmes.cineapp.repositories.FilmeRepository;
import com.projeto.filmes.cineapp.repositories.GeneroRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Genero g1 = new Genero(null, "Ação");
		Genero g2 = new Genero(null, "Ficção Cientifica");
		Genero g3 = new Genero(null, "Terror");
		Genero g4 = new Genero(null, "Guerra");
		
		Sinopse s1 = new Sinopse(null, "Em 1969, um ator em declínio e seu dublê buscam sucesso em Hollywood, mas acabam se envolvendo com a infame seita de Charles Manson.");
		Sinopse s2 = new Sinopse(null, "Com o fim dos recursos da Terra, um grupo de astronautas viaja pelo espaço através de um buraco de minhoca em busca de um novo planeta para a humanidade, liderados por um homem que pode nunca mais voltar para casa.");
		Sinopse s3 = new Sinopse(null, "Após uma missão falhar e armas nucleares caírem em mãos inimigas, o agente Ethan Hunt e sua equipe precisam se aliar a um agente da CIA para recuperar o plutônio e impedir um ataque global.");
		Sinopse s4 = new Sinopse(null, "Quinze anos depois de assassinar sua irmã, um paciente de sanatório chamado Michael Myers escapa na véspera de Halloween e volta para sua cidade natal para aterrorizar novas vítimas.");
		Sinopse s5 = new Sinopse(null, "Um aventureiro espacial se junta a um grupo de foras da lei para proteger um poderoso artefato de um vilão e, juntos, eles se tornam a última esperança da galáxia.");
		
		Filme fil1 = new Filme(null, "Era Uma Vez em... Hollywood", "Quentin Tarantino", 16, 160, 2019, s1);
		Filme fil2 = new Filme(null, "Interestelar", "Christopher Nolan", 10, 169, 2014, s2);
		Filme fil3 = new Filme(null, "Missao Impossivel - Efeito Fallout", "Christopher McQuarrie", 14, 148, 2018, s3);
		Filme fil4 = new Filme(null, "Halloween- A Noite do Terror", "John Carpenter", 16, 91, 1978, s4);
		Filme fil5 = new Filme(null, "Guardiões da Galáxia", "James Gunn", 12, 122, 2014, s5);
		
		generoRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
		filmeRepository.saveAll(Arrays.asList(fil1, fil2, fil3, fil4, fil5));
		
		fil1.getGenero().add(g1);
		fil1.getGenero().add(g4);
		fil2.getGenero().add(g2);
		fil3.getGenero().add(g1);
		fil4.getGenero().add(g3);
		fil5.getGenero().add(g2);
		fil5.getGenero().add(g1);
		
		filmeRepository.saveAll(Arrays.asList(fil1, fil2, fil3, fil4, fil5));
	}
}
