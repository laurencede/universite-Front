package fr.laurence.universite.matiere.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.laurence.universite.matiere.domain.Matieres;
import fr.laurence.universite.matiere.repository.IMatiereRepository;
import fr.laurence.universite.matiere.service.IMatiereService;

@Service
public class MatiereServiceImpl implements IMatiereService{

		@Autowired
		IMatiereRepository imr;

		@Override
		public List<Matieres> findAll() {
			List<Matieres> listeMatieres = imr.findAll();
			return listeMatieres;
		}

		@Override
		public Matieres getOneMatiere(Integer id) {
			Matieres infosMatiere = imr.getOne(id);
			return infosMatiere;
		}

		@Override
		public Matieres save(Matieres validerMatiere) {
			Matieres ajoutMatiere = imr.save(validerMatiere);
			return ajoutMatiere;
		}

		@Override
		public Matieres saveModif(Matieres modifMatiere) {
			Integer id = modifMatiere.getId();
			imr.update(modifMatiere, id);
			Matieres matModif = imr.getOne(id);
			return matModif;
		}

		@Override
		public void supprimer(Integer id) {
			imr.deleteById(id);
			
		}


		
		
}
