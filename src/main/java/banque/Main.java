package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banque.entite.Adresse;
import banque.entite.AssuranceVie;
import banque.entite.Banque;
import banque.entite.Client;
import banque.entite.Compte;
import banque.entite.LivretA;
import banque.entite.Operation;

public class Main {

		public static void main(String[] args) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			Banque b = new Banque("SwissBank", null);
			em.persist(b);
			Adresse a = new Adresse(42, "rue Foo", 42000, "Cardiff");
			Client aa = new Client("Astier", "Alexandre", LocalDate.of(1980, 12, 31), a, b, null);
			
			Compte compte0 = new Compte("0000001",10000d, aa, null);
			Operation o0 = new Operation(LocalDateTime.of(2017, 01, 20, 01, 20), 10d, "anniversaire neveu", compte0);
			Operation o1 = new Operation(LocalDateTime.of(2010, 03, 01, 10, 02), 50d, "tickets de train", compte0);
			List<Operation> operations = new ArrayList<>(Arrays.asList(o0,o1));
			o0.setDate(LocalDateTime.of(2017, 12, 01, 11, 00));
			compte0.setOperations(operations);
			em.persist(o0);
			em.persist(compte0);
			Compte compte1 = new LivretA("2", 230.21, aa, null, 0.05);
//			Compte compte2 = new AssuranceVie("032156", 30000, aa, null, LocalDate.of(2018, 11, 02), 0.08);
			em.persist(compte1);
			List<Compte> comptes = new ArrayList<>(Arrays.asList(compte0));
			aa.setComptes(comptes);
			em.persist(aa);
			
			List<Client> clients = new ArrayList<>(Arrays.asList(aa));
			
			b.setClients(clients);
			
			
			et.commit();
			em.close();
		}
		
}
