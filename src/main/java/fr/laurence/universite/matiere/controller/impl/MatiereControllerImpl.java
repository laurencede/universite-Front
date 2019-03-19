package fr.laurence.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.laurence.universite.enseignant.domain.Enseignant;
import fr.laurence.universite.enseignant.service.impl.EnseignantServiceImpl;
import fr.laurence.universite.matiere.controller.IMatiereController;
import fr.laurence.universite.matiere.domain.Matieres;
import fr.laurence.universite.matiere.service.impl.MatiereServiceImpl;

@Controller
public class MatiereControllerImpl implements IMatiereController{

	@Autowired
	MatiereServiceImpl msi;
	
	@Autowired
	EnseignantServiceImpl esi;
	
	@Override
	@GetMapping("/matieres")
	public String findAll(Model model) {
		List<Matieres> listeMatieres = msi.findAll();
		model.addAttribute("listeMatieres", listeMatieres);
		return ("matiere/matieres");
	}

	@Override
	@GetMapping("/infos-matiere")
	public String infosMatiere(Model model, @RequestParam("id") Integer id) {
		Matieres infosMatiere = msi.getOneMatiere(id);
		model.addAttribute("infosMatiere", infosMatiere);
		return "matiere/infos-matiere";
	}

	@Override
	@GetMapping("/ajouter-matiere-formulaire")
	public String ajouterMatiere(Model model) {
		
		Matieres ajouterMatiere = new Matieres();
		model.addAttribute("validerMatiere", ajouterMatiere);
		
		List<Enseignant> liste = esi.findAll();
		model.addAttribute("listeEnseignant", liste);
		
		return "matiere/ajouter-matiere-formulaire";
	}


	@Override
	@PostMapping("/valider-matiere")
	public String validerMatiere(Model model, @ModelAttribute("validerMatiere") Matieres validerMatiere) {
		Matieres m = msi.save(validerMatiere);
		if(m == null) {
			return "redirect:/ajouter-matiere";
		}else {
			return "redirect:/matieres";

		}
	}

	@Override
	@GetMapping("/modifier-matiere-formulaire")
	public String modifierMatiere(Model model, @RequestParam("id") Integer id) {
		
		Matieres modifMatiere = msi.getOneMatiere(id);
		model.addAttribute("modifMatiere", modifMatiere);
		
		List<Enseignant> liste= esi.findAll();
		model.addAttribute("listeEnseignant", liste);
		
		return "matiere/modifier-matiere-formulaire";
	}

	@Override
	@PostMapping("/valider-modification-matiere")
	public String validerModifMatiere(Model model, @ModelAttribute Matieres modifMatiere) {
		msi.saveModif(modifMatiere);
		return "redirect:/matieres";
	}
	
	
	
	
	
	
	




}
