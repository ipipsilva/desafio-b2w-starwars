package br.com.desafiob2w.starwars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiob2w.starwars.model.Planeta;
import br.com.desafiob2w.starwars.repository.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private PlanetaServiceRest planetaServiceRest;

	public Planeta incluir(Planeta planeta) {
		Integer quantidadeFilmes = planetaServiceRest.obterQuantidadeFilmes(Optional.ofNullable(planeta));
		planetaRepository.save(planeta);
		return planeta;
	}
}
