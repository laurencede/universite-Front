package fr.laurence.universite.matiere.service;

import java.util.List;

import fr.laurence.universite.matiere.domain.Matieres;

public interface IMatiereService {
	
	public List<Matieres> findAll();
	
	public Matieres getOneMatiere (Integer id);
	
	public Matieres save(Matieres validerMatiere);
	
	public Matieres saveModif(Matieres modifMatiere);
	
	public void supprimer (Integer id);
}
