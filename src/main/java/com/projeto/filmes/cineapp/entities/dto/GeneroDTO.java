package com.projeto.filmes.cineapp.entities.dto;

import com.projeto.filmes.cineapp.entities.Genero;

public class GeneroDTO {
	
	private String tipo;
	
	public GeneroDTO(Genero genero) {
		this.tipo = genero.getTipo();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
