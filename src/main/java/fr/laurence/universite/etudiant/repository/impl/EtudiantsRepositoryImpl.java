package fr.laurence.universite.etudiant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.laurence.universite.etudiant.domain.Etudiants;
import fr.laurence.universite.etudiant.repository.IEtudiantsRepository;

@Repository
public class EtudiantsRepositoryImpl implements IEtudiantsRepository{

	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<Etudiants> findAll() {
		List<Etudiants> liste = restTemplate.exchange
				("http://localhost:8080/etudiants",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Etudiants>>(){}
				).getBody();
				return liste;
	}

	@Override
	public Etudiants getOne(Integer id) {
		Etudiants e = restTemplate.getForObject("http://localhost:8080/etudiants/"+ id, Etudiants.class);
		return e;
	}

	@Override
	public void deleteById(Integer id) {
		restTemplate.delete("http://localhost:8080/etudiants/"+ id);
		
	}

	@Override
	public Etudiants save(Etudiants newEtudiant) {
		Etudiants e = restTemplate.postForObject("http://localhost:8080/etudiants/", newEtudiant, Etudiants.class);
		return e;
	}

	@Override
	public void update(Etudiants etudiant, Integer id) {
		restTemplate.put("http://localhost:8080/etudiants/" + id, etudiant, Etudiants.class);
		
	}

}
