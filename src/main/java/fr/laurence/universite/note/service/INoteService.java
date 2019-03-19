package fr.laurence.universite.note.service;

import java.util.List;

import fr.laurence.universite.note.domain.Note;

public interface INoteService {

	public List<Note> findAll();
	
	public Note save(Note note);
	
	public Note findOne(Integer idEtudiant, Integer idMatiere);
}
