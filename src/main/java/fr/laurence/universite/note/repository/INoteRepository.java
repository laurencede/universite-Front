package fr.laurence.universite.note.repository;

import java.util.List;

import fr.laurence.universite.note.domain.Note;
import fr.laurence.universite.note.domain.NotePK;

public interface INoteRepository {

	public List<Note> findAll();

	public Note save(Note note);

	public Note getOne(NotePK npk);

}
