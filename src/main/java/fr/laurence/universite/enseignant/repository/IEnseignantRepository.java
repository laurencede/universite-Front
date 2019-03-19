package fr.laurence.universite.enseignant.repository;

import java.util.List;

import fr.laurence.universite.enseignant.domain.Enseignant;

public interface IEnseignantRepository {

	public List<Enseignant> findAll();

	public Enseignant getOne(Integer id);

	public void deleteById(Integer id);

	public Enseignant save(Enseignant newEnseignant);

	public void update(Enseignant enseignant, Integer id);


}
