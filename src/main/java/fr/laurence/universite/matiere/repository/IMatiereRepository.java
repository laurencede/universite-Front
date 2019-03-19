package fr.laurence.universite.matiere.repository;

import java.util.List;

import fr.laurence.universite.matiere.domain.Matieres;

public interface IMatiereRepository {

	public List<Matieres> findAll();

	public Matieres getOne(Integer id);

	public Matieres save(Matieres validerMatiere);
	
	public void update(Matieres matiere, Integer id);
	
	public void deleteById(Integer id);

}
