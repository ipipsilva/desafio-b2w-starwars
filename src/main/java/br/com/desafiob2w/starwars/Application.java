package br.com.desafiob2w.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Removendo os planetas da base");
		planetaRepository.deleteAll();
		
		System.out.println("Criando novos planetas para teste");
		Planeta planeta1 = new Planeta("Terra","Temperado");
		Planeta planeta2 = new Planeta("Marte", "Deserto");
		Planeta planeta3 = new Planeta("Venus", "Deserto");
		
		planetaRepository.save(planeta1);
		planetaRepository.save(planeta2);
		planetaRepository.save(planeta3);
		
		System.out.println("--------------------------------------------------------");
		List<Planeta> listaPlanetas = planetaRepository.findAll();
		
		for (Planeta planeta : listaPlanetas) {
			System.out.println(planeta.toString());
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.println("Buscando um unico planeta pelo ID: " + listaPlanetas.get(0).getId());
		
		Optional<Planeta> planetaRecuperado = planetaRepository.findById(listaPlanetas.get(0).getId());
		
		System.out.println("------------Retorno------------");
		System.out.println(planetaRecuperado.get().toString());
		
		System.out.println();
	}*/

}
