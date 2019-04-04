package dev.demo_jpa.dao;

import java.util.List;

import dev.demo_jpa.model.Emprunt;
import dev.demo_jpa.model.Livre;

public interface IDao {

	public Livre findBook(int id);
	public Livre findBook(String name);
	public Emprunt findEmprunt(Integer id);
	public List<Emprunt> findEmprunts(String clientName);
	
}
