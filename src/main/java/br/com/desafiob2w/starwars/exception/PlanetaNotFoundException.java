package br.com.desafiob2w.starwars.exception;

public class PlanetaNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4964176490405798846L;

	public PlanetaNotFoundException(String id){
		super("Planeta com o id " + id + " não encontrado.");
	}
}
