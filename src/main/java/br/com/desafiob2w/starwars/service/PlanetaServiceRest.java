package br.com.desafiob2w.starwars.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.desafiob2w.starwars.model.ResultadoBusca;

@Component
public class PlanetaServiceRest {

	@Value("${url.servico}")
	private String urlServico;

	public Integer obterQuantidadeFilmes(String nome) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResultadoBusca> response = restTemplate.exchange(urlServico.concat(nome), HttpMethod.GET,
				obterEntity(), ResultadoBusca.class);

		if ((response.getStatusCode() == HttpStatus.OK) && (response.getBody().getResults().size() > 0)) {
			return response.getBody().getResults().get(0).getFilms().length;
		} else {
			return 0;
		}
	}

	private HttpEntity<String> obterEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		return entity;
	}
}
