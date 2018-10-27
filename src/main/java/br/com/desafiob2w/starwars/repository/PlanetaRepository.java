package br.com.desafiob2w.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.desafiob2w.starwars.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{
	
	public Planeta findByNome(String nome);
}