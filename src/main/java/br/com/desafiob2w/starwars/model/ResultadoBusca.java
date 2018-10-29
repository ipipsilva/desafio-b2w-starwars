package br.com.desafiob2w.starwars.model;

import java.util.List;

public class ResultadoBusca {

	private List<PlanetaAPI> results;

	public List<PlanetaAPI> getResults() {
		return results;
	}

	public void setResults(List<PlanetaAPI> results) {
		this.results = results;
	}
}