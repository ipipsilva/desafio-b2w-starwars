package br.com.desafiob2w.starwars.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiob2w.starwars.exception.PlanetaNotFoundException;
import br.com.desafiob2w.starwars.model.Planeta;
import br.com.desafiob2w.starwars.repository.PlanetaRepository;
import br.com.desafiob2w.starwars.service.PlanetaServiceRest;

@RestController
@RequestMapping("/api")
public class PlanetaController {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private PlanetaServiceRest planetaServiceRest;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/planetas")
	Planeta incluirPlaneta(Planeta planeta) {
		planeta.setQuantidadeFilmes(planetaServiceRest.obterQuantidadeFilmes(planeta.getNome()));
		// return planetaRepository.save(planeta);
		return new Planeta();
	}

	@PutMapping("/planetas/{id}")
	Planeta atualizarPlaneta(Planeta planetaAlterado, @PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		} else {
			planeta.setNome(planetaAlterado.getNome());
			planeta.setTerreno(planetaAlterado.getTerreno());
			planeta.setClima(planetaAlterado.getClima());
			// TODO quantidade de filmes
			planetaRepository.save(planeta);
		}

		return null;
	}

	@GetMapping("/planetas")
	List<Planeta> listarTodos() {
		return planetaRepository.findAll();
	}

	@GetMapping("/planetas/{id}")
	Planeta obterPlanetaPorId(@PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		}

		return planeta;
	}

	@GetMapping("/planetas/?nome={nome}")
	Planeta obterPlanetaPorNome(@PathParam(value = "nome") String nome) {

		Planeta planeta = planetaRepository.findByNome(nome);

		if (null == planeta) {
			throw new PlanetaNotFoundException(nome);
		}

		return planeta;
	}

	@DeleteMapping("/planetas/{id}")
	void removerPlaneta(@PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		}

		planetaRepository.deleteById(id);
	}

}