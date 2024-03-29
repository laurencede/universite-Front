package fr.laurence.universite.etudiant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.laurence.universite.etudiant.controller.IEtudiantsController;
import fr.laurence.universite.etudiant.domain.Etudiants;
import fr.laurence.universite.etudiant.service.impl.EtudiantsServiceImpl;

@Controller
public class EtudiantsControllerImpl implements IEtudiantsController{
	Logger log = LoggerFactory.getLogger(EtudiantsControllerImpl.class);
	
	@Autowired
	EtudiantsServiceImpl esi;

	@Override
	@GetMapping("/etudiants")
	public String findAll(Model model) {
		List<Etudiants> liste = esi.findAll();
		model.addAttribute("listeEtudiants", liste);
		return "etudiant/etudiants";
	}

	@Override
	@GetMapping("/etudiant-infos")
	public String infosEtudiant(Model model, Integer id) {
		Etudiants infosEtudiant = esi.getOneEtudiants(id);
		model.addAttribute("etudiant", infosEtudiant);
		return "etudiant/etudiant-infos";
	}

	@Override
	@GetMapping("/supprimer-etudiant")
	public String supprimerEtudiant(Model model, Integer id) {
		esi.supprimer(id);
		return "redirect:/etudiants";
	}

	@Override
	@GetMapping("/ajouter-etudiant-formulaire")
	public String ajouterEtudiant(Model model) {
		Etudiants ajouterEtudiant = new Etudiants();
		model.addAttribute("newEtudiant", ajouterEtudiant);
		return "etudiant/ajouter-etudiant-formulaire";
	}

	@Override
	@PostMapping("/valider-etudiant")
	public String validerEtudiant(Model model, Etudiants validerEtudiant) {
		Etudiants et = esi.ajouterEtudiant(validerEtudiant);
		if(et == null) {
			return "redirect:/ajouter-etudiant-formulaire";
		}else {
			return "redirect:/etudiants";
		}
	}

	@Override
	@GetMapping("/modifier-etudiant")
	public String ModifEtudiant(Model model, @RequestParam("id") Integer id) {
		Etudiants modifEtudiant = esi.getOneEtudiants(id);
		model.addAttribute("modifEtudiant", modifEtudiant);
		return "etudiant/modifier-etudiant-formulaire";
	}

	@Override
	@PostMapping("/valider-correction-etudiant")
	public String validerModifEtudiant(Model model, @ModelAttribute Etudiants modifEtudiant) {
		esi.modifierEtudiant(modifEtudiant);
		return "redirect:/etudiants";
	}




	
	
}
