package fr.laurence.universite.note.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.laurence.universite.etudiant.domain.Etudiants;
import fr.laurence.universite.etudiant.service.impl.EtudiantsServiceImpl;
import fr.laurence.universite.matiere.domain.Matieres;
import fr.laurence.universite.matiere.service.impl.MatiereServiceImpl;
import fr.laurence.universite.note.controller.INoteController;
import fr.laurence.universite.note.domain.Note;
import fr.laurence.universite.note.domain.NotePK;
import fr.laurence.universite.note.service.impl.NoteServiceImpl;

@Controller
public class NoteControllerImpl implements INoteController{

	Logger log = LoggerFactory.getLogger(NoteControllerImpl.class);
	
	@Autowired
	NoteServiceImpl nsi;
	
	@Autowired
	EtudiantsServiceImpl esi;
	
	@Autowired
	MatiereServiceImpl msi;

	@Override
	@GetMapping("/notes")
	public String findAll(Model model) {
		List<Note> listeNotes = nsi.findAll();
		model.addAttribute("notes", listeNotes);
		return "note/notes";
	}

	@Override
	@GetMapping("/note-formulaire-ajout")
	public String ajoutNote(Model model) {
		List<Etudiants> listeEtudiant = esi.findAll();
		model.addAttribute("etudiants", listeEtudiant);
		
		List<Matieres> listeMatieres = msi.findAll();
		model.addAttribute("matieres", listeMatieres);
		
		Note note = new Note();
		model.addAttribute("note", note);
		return "note/ajout-note-formulaire";
	}

	@Override
	@PostMapping("/valider-note-ajout")
	public String validerAjoutNote(Model model, Note note) {
//		log.info("Note: {}", note.getNote());
//		log.info("ID Etudiant: {}", note.getEtudiant().getId());
//		log.info("Matiere: {}", note.getMatiere().getId());
//		log.info("NotePK: {}", note.getNotePK());
		
		// Construire un objet NotePK
		NotePK npk = new NotePK();
		
		// lui affecter l'ID de l'etudiant
		Integer idEtudiant = note.getEtudiant().getId();
		npk.setEtudiant(idEtudiant); 
		
		//lui affecter l'ID de la matièere
		Integer iDMatiere = note.getMatiere().getId();
		npk.setMatiere(iDMatiere); 

		
		// AFfecter une valeur à la variable notePK
		// de l'objet note
		note.setNotePK(npk);
		nsi.save(note);
		return "redirect:/notes";
				
	}

	@Override
	@GetMapping("/modifier-note")
	public String modifierNoteFormulaire(Model model, @RequestParam("idMatiere") Integer idMatiere, @RequestParam("idEtudiant") Integer idEtudiant) {
		Note n = nsi.findOne(idEtudiant, idMatiere);
		model.addAttribute("note", n);
		return "note/modifier-note";
	}
	
}
