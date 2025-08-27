package com.projeto.filmes.cineapp.entities.dto;

import com.projeto.filmes.cineapp.entities.Sinopse;

public class SinopseDTO {
	
	private String texto;
	
	public SinopseDTO() {
	}

	public SinopseDTO(Sinopse sinopse) {
		this.texto = sinopse.getTexto();
	}

	public String getSinopse() {
		return texto;
	}

	public void setSinopse(String texto) {
		this.texto = texto;
	}
}	
