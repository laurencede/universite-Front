package fr.laurence.universite.etudiant.repository;

import java.util.List;

import fr.laurence.universite.etudiant.domain.Etudiants;

public interface IEtudiantsRepository {

	public List<Etudiants> findAll();

	public Etudiants getOne(Integer id);

	public void deleteById(Integer id);

	public Etudiants save(Etudiants newEtudiant);

	public void update(Etudiants etudiant, Integer id);
}
