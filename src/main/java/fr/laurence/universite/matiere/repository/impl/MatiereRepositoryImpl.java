package fr.laurence.universite.matiere.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.laurence.universite.matiere.domain.Matieres;
import fr.laurence.universite.matiere.repository.IMatiereRepository;

@Repository
public class MatiereRepositoryImpl implements IMatiereRepository{

	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Matieres> findAll() {
		List<Matieres> liste = restTemplate.exchange
				("http://localhost:8080/matieres",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Matieres>>(){}
				).getBody();
		return liste;
	}

	@Override
	public Matieres getOne(Integer id) {
		Matieres m = restTemplate.getForObject("http://localhost:8080/matieres/"+ id, Matieres.class);
		return m;
	}

	@Override
	public Matieres save(Matieres validerMatiere) {
		Matieres m = restTemplate.postForObject("http://localhost:8080/matieres", validerMatiere, Matieres.class);
		return m;
	}

	@Override
	public void update(Matieres matiere, Integer id) {
		restTemplate.put("http://localhost:8080/matieres/" + id, matiere, Matieres.class);		
	}

	@Override
	public void deleteById(Integer id) {
		restTemplate.delete("http://localhost:8080/matieres/" + id);
		
	}

}
