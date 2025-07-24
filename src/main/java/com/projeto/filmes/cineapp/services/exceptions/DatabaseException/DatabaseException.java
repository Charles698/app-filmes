package com.projeto.filmes.cineapp.services.exceptions.DatabaseException;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}
}
