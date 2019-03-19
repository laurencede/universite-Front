package fr.laurence.universite.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.laurence.universite.note.domain.Note;
import fr.laurence.universite.note.domain.NotePK;
import fr.laurence.universite.note.repository.INoteRepository;
import fr.laurence.universite.note.service.INoteService;

@Service
public class NoteServiceImpl implements INoteService{

	@Autowired
	INoteRepository inr;
	
	@Override
	public List<Note> findAll() {
		List<Note> listeNote = inr.findAll();
		return listeNote;
	}

	@Override
	public Note save(Note note) {
		Note n = inr.save(note);
		return n;
	}

	@Override
	public Note findOne(Integer idEtudiant, Integer idMatiere) {
			NotePK npk = new NotePK();
			npk.setEtudiant(idEtudiant);
			npk.setMatiere(idMatiere);
			Note n = inr.getOne(npk);
			return n;

		}

}
