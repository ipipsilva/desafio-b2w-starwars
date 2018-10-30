package br.com.desafiob2w.starwars.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafiob2w.starwars.model.Planeta;
import br.com.desafiob2w.starwars.repository.PlanetaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetaControllerTest {

	@Autowired
	PlanetaRepository planetaRepository;

	private List<Planeta> planetas;

	@Before
	public void init() {

		planetas = new ArrayList<Planeta>();

		planetas.add(new Planeta("Tooteine", "arido"));
		planetas.add(new Planeta("Naboo", "temperado"));
		planetas.add(new Planeta("Coruscant", "temperado"));
		planetas.add(new Planeta("Kamino", "arido"));
		planetas.add(new Planeta("Marte", "arido"));
	}

	private void salvarPlanetas() {
		planetas.forEach(item -> planetaRepository.save(item));
	}

	private void removerPlanetas() {
		planetaRepository.deleteAll();
	}

	@Test
	public void incluirPlanetaTest() {
		planetas.forEach(item -> planetaRepository.save(item));
		planetas.forEach(item -> assertNotNull(item.getId()));
		removerPlanetas();
	}

	@Test
	public void listarTodosTest() {
		List<Planeta> listaPlanetas = planetaRepository.findAll();
		listaPlanetas.forEach(item -> assertNotNull(item));
	}

	@Test
	public void obterPlanetaPorIdTest() {
		salvarPlanetas();
		Planeta planetaPorId = planetaRepository.findById(planetas.get(0).getId()).orElse(null);
		assertNotNull(planetaPorId);
		removerPlanetas();
	}

	@Test
	public void obterPlanetaPorNomeTest() {
		salvarPlanetas();
		Planeta planetaPorNome = planetaRepository.findByNome(planetas.get(0).getNome());
		assertNotNull(planetaPorNome);
		removerPlanetas();
	}

	@Test
	public void atualizarPlanetaTest() {
		salvarPlanetas();
		Planeta planetaPorId = planetaRepository.findById(planetas.get(0).getId()).orElse(null);
		planetaPorId.setClima("seco");
		Planeta planetaAlterado = planetaRepository.save(planetaPorId);
		assertEquals("seco", planetaAlterado.getClima());
		removerPlanetas();
	}

	@Test
	public void removerPlanetaTest() {
		salvarPlanetas();
		planetas.forEach(item -> planetaRepository.deleteById(item.getId()));
		List<Planeta> planetas = planetaRepository.findAll();
		assertEquals(0, planetas.size());
	}
}
