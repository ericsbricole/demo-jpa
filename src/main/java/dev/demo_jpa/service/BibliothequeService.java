package dev.demo_jpa.service;

import java.util.List;

import dev.demo_jpa.dao.DaoHibernate;
import dev.demo_jpa.dao.IDao;
import dev.demo_jpa.model.Emprunt;
import dev.demo_jpa.model.Livre;

public class BibliothequeService {
	
	private IDao dao;
	
	public BibliothequeService(){
		dao = new DaoHibernate();
	}
	
	public Livre findBook(int id){
		System.out.println("recherche de livre pour  l'ID: " + id);
		Livre livre = dao.findBook(id);
		System.out.println("Livre trouvé = " + livre.getTitre() + " de " + livre.getAuteur());
		return livre;
	}

	public Livre findBook(String name){
		System.out.println("recherche de livre pour  le nom: " + name);
		Livre livre = dao.findBook(name);
		System.out.println("Livre trouvé = " + livre.getTitre() + " de " + livre.getAuteur());
		return livre;
	}
	
	public Emprunt findEmprunt(int id){
        System.out.println("recherche d'un emprunt pour l'id = " + id );
		Emprunt emprunt = dao.findEmprunt(id);
		return emprunt;
	}
	
	public List<Emprunt> findEmprunts(String clientName){
		List<Emprunt> emprunts = dao.findEmprunts(clientName);
		return emprunts;
	}

}
