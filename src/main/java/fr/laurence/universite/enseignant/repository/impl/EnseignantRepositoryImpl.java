package fr.laurence.universite.enseignant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.laurence.universite.enseignant.domain.Enseignant;
import fr.laurence.universite.enseignant.repository.IEnseignantRepository;

@Repository
public class EnseignantRepositoryImpl implements IEnseignantRepository{

	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Enseignant> findAll() {
		List<Enseignant> liste = restTemplate.exchange
				("http://localhost:8080/enseignants",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Enseignant>>(){}
				).getBody();
		return liste;
	}

	@Override
	public Enseignant getOne(Integer id) {	
		Enseignant e = restTemplate.getForObject("http://localhost:8080/enseignants/"+ id, Enseignant.class);
		return e;
	}

	@Override
	public void deleteById(Integer id) {
		restTemplate.delete("http://localhost:8080/enseignants/" + id);		
	}

	@Override
	public Enseignant save(Enseignant newEnseignant) {
		Enseignant e = restTemplate.postForObject
				("http://localhost:8080/enseignants", 
				newEnseignant, 
				Enseignant.class);
		return e;
	}

	@Override
	public void update(Enseignant enseignant, Integer id) {
		restTemplate.put("http://localhost:8080/enseignants/" + id, enseignant, Enseignant.class);
	}



	

}
