package fr.laurence.universite.note.controller;

import org.springframework.ui.Model;

import fr.laurence.universite.note.domain.Note;

public interface INoteController {

	public String findAll(Model model);
	
	public String ajoutNote(Model model);
	public String validerAjoutNote(Model model, Note note);
	
	public String modifierNoteFormulaire (Model model, Integer idMatiere, Integer idEtudiant);

}
