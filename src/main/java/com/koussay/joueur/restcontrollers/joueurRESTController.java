package com.koussay.joueur.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koussay.joueur.entities.joueur;
import com.koussay.joueur.service.JoueurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class joueurRESTController {
	@Autowired
	JoueurService joueurService;
	
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<joueur> getAlljoueurs() {
		return joueurService.getAlljoueurs();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public joueur getjoueurById(@PathVariable("id") Long id) {
		return joueurService.getjoueur(id);
	 }
	
	@RequestMapping(value ="/addjo",method = RequestMethod.POST)
	public joueur createJoueur(@RequestBody joueur produit) {
		return joueurService.savejoueur(produit);
	}
	
	@RequestMapping(value ="/updatejo",method = RequestMethod.PUT)
	public joueur updateJoueur(@RequestBody joueur j) {
		return joueurService.updatejoueur(j);
	}
	
	@RequestMapping(value="/deljo/{id}",method = RequestMethod.DELETE)
	public void deleteJoueur(@PathVariable("id") Long id)
	{
		joueurService.deletejoueurById(id);
	}
	
	@RequestMapping(value="/jpos/{idPos}",method = RequestMethod.GET)
	public List<joueur> getJoueurByPosId(@PathVariable("idPos") Long idPos) {
	return joueurService.findByPositionIdPos(idPos);
	}
	
	@RequestMapping(value="/ByName/{nom}",method = RequestMethod.GET)
	public List<joueur> findByjoueurContains(@PathVariable("nom") String nom) {
		return joueurService.findByNomjoueurContains(nom);
	}



}
