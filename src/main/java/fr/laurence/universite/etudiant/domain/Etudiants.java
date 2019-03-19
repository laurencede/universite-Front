package fr.laurence.universite.etudiant.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import fr.laurence.universite.note.domain.Note;


public class Etudiants {
	
	private Integer id;
	private Integer numero_etudiant;
	private String nom;
	private String prenom;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	private Character sexe;
	private String photo;
	private List<Note> notes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero_etudiant() {
		return numero_etudiant;
	}
	public void setNumero_etudiant(Integer numero_etudiant) {
		this.numero_etudiant = numero_etudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public Character getSexe() {
		return sexe;
	}
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	
	
	
	
	
	
}
