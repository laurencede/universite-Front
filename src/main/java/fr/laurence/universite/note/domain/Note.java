package fr.laurence.universite.note.domain;

import fr.laurence.universite.etudiant.domain.Etudiants;
import fr.laurence.universite.matiere.domain.Matieres;

public class Note {
	
	private NotePK notePK;
	private Double note;
	private Etudiants etudiant; 
	private Matieres matiere;
	
	public NotePK getNotePK() {
		return notePK;
	}
	public void setNotePK(NotePK notePK) {
		this.notePK = notePK;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	public Etudiants getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiants etudiant) {
		this.etudiant = etudiant;
	}
	public Matieres getMatiere() {
		return matiere;
	}
	public void setMatiere(Matieres matiere) {
		this.matiere = matiere;
	}
	
}
