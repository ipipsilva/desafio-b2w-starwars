package br.com.desafiob2w.starwars.controller;

import java.util.List;

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
@RequestMapping("/api/planetas/")
public class PlanetaController {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private PlanetaServiceRest planetaServiceRest;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	Planeta incluirPlaneta(Planeta planeta) {
		planeta.setQuantidadeFilmes(planetaServiceRest.obterQuantidadeFilmes(planeta.getNome()));
		return planetaRepository.save(planeta);
	}

	@PutMapping("{id}")
	Planeta atualizarPlaneta(Planeta planetaAlterado, @PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		} else {
			planeta.setNome(planetaAlterado.getNome());
			planeta.setTerreno(planetaAlterado.getTerreno());
			planeta.setClima(planetaAlterado.getClima());
			planeta.setQuantidadeFilmes(planetaServiceRest.obterQuantidadeFilmes(planetaAlterado.getNome()));
			planetaRepository.save(planeta);
		}

		return null;
	}

	@GetMapping
	List<Planeta> listarTodos() {
		return planetaRepository.findAll();
	}

	@GetMapping("{id}")
	Planeta obterPlanetaPorId(@PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		}

		return planeta;
	}

	@GetMapping("/nome/{nome}")
	Planeta obterPlanetaPorNome(@PathVariable String nome) {

		Planeta planeta = planetaRepository.findByNome(nome);

		if (null == planeta) {
			throw new PlanetaNotFoundException(nome);
		}

		return planeta;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void removerPlaneta(@PathVariable String id) {

		Planeta planeta = planetaRepository.findById(id).orElse(null);

		if (null == planeta) {
			throw new PlanetaNotFoundException(id);
		}

		planetaRepository.deleteById(id);
	}

}