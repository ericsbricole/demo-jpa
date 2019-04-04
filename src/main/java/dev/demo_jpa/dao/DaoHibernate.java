package dev.demo_jpa.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import dev.demo_jpa.model.Emprunt;
import dev.demo_jpa.model.Livre;

public class DaoHibernate extends BaseDao implements IDao{

	
	public DaoHibernate() {
		prepareConnection();
	}

	@Override
	public Livre findBook(int id) {
		Livre livre = em.find(Livre.class, 1);
		return livre;
	}
	
	@Override
	public Livre findBook(String name) {
		String query = "SELECT l FROM Livre l WHERE l.titre =:n";
		TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
		tq.setParameter("n", name);
		Livre livre = tq.getSingleResult();
		return livre;
	}

	@Override
	public Emprunt findEmprunt(Integer id) {
		Emprunt emprunt = em.find(Emprunt.class, 1);
		return emprunt;
	}

	@Override
	public List<Emprunt> findEmprunts(String clientName) {
		String query = "SELECT e FROM Emprunt e WHERE e.client.nom=:cn";
		TypedQuery<Emprunt> tq = em.createQuery(query, Emprunt.class);
		tq.setParameter("cn", clientName);
		List<Emprunt> emprunts = tq.getResultList();
		return emprunts;
	}


}
