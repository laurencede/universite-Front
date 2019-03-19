package fr.laurence.universite.matiere.controller;

import org.springframework.ui.Model;

import fr.laurence.universite.matiere.domain.Matieres;

public interface IMatiereController {

	public String findAll(Model model);
	
	public String infosMatiere (Model model, Integer id);
	
	public String ajouterMatiere (Model model);
	public String validerMatiere (Model model, Matieres validerMatiere);
	
	public String modifierMatiere(Model model, Integer id);
	public String validerModifMatiere (Model model, Matieres modifMatiere);
}
