package br.com.desafiob2w.starwars.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetaAPI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5838380587125587911L;

	private String name;
	private String[] films;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getFilms() {
		return films;
	}

	public void setFilms(String[] films) {
		this.films = films;
	}

}
