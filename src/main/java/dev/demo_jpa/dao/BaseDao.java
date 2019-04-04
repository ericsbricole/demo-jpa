package dev.demo_jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDao {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	protected void prepareConnection(){
		emf = Persistence.createEntityManagerFactory("demo-jpa");
		em = emf.createEntityManager();
	}
	
}
