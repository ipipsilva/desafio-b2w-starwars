package br.com.desafiob2w.starwars.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.desafiob2w.starwars.exception.PlanetaNotFoundException;
import br.com.desafiob2w.starwars.model.Planeta;
import br.com.desafiob2w.starwars.model.PlanetaAPI;
import br.com.desafiob2w.starwars.repository.PlanetaRepository;

@RestController
@RequestMapping("/api")
public class PlanetaController {

	@Autowired
	private PlanetaRepository planetaRepository;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/planetas")
	Planeta incluirPlaneta(Planeta planeta) {
		planeta.setQuantidadeFilmes(obterQuantidadeFilmes(planeta.getNome()));
		return planetaRepository.save(planeta);
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

	@GetMapping("/planetas/{nome}")
	Planeta obterPlanetaPorNome(@PathVariable String nome) {

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

	private Integer obterQuantidadeFilmes(String nome) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String fooResourceUrl = "https://swapi.co/api/planets";
		ResponseEntity<PlanetaAPI> response = restTemplate.exchange(fooResourceUrl + "/1", HttpMethod.GET, entity,
				PlanetaAPI.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody().getFilms().length;
		} else {
			return 0;
		}
	}
}