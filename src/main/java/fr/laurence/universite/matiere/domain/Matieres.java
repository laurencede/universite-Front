package fr.laurence.universite.matiere.domain;

import java.util.List;

import fr.laurence.universite.enseignant.domain.Enseignant;
import fr.laurence.universite.note.domain.Note;

public class Matieres {
	
	private Integer id;
	private Integer numero_matiere;
	private String nom;
	private Integer coef;
	private Enseignant enseignant; 
	private List<Note> notes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_matiere() {
		return numero_matiere;
	}
	public void setNumero_matiere(Integer numero_matiere) {
		this.numero_matiere = numero_matiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getCoef() {
		return coef;
	}
	public void setCoef(Integer coef) {
		this.coef = coef;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	

	
	
	
}
