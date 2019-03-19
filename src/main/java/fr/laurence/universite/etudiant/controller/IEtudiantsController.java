package fr.laurence.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.laurence.universite.etudiant.domain.Etudiants;

public interface IEtudiantsController {
	
	public String findAll(Model model);

	public String infosEtudiant (Model model, Integer id);
	
	public String supprimerEtudiant (Model model, Integer id);
	
	public String ajouterEtudiant (Model model);	
	public String validerEtudiant (Model model, Etudiants validerEtudiant);
	
	public String ModifEtudiant (Model model, Integer id);	
	public String validerModifEtudiant (Model model, Etudiants modifEtudiant);
}
