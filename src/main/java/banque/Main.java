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
import banque.entite.Virement;

public class Main {

		public static void main(String[] args) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			Banque banque = new Banque("Banque Postale", null);
			em.persist(banque);
			Adresse adresse = new Adresse(42, "rue Foo", 42000, "Cardiff");
			Client alexandre = new Client("Astier", "Alexandre", LocalDate.of(1980, 12, 31), adresse, banque, null);
			em.persist(alexandre);
			
			List<Client> clients = new ArrayList<>();
			clients.add(alexandre);
			Compte compte = new Compte("0000001",10000d, clients, null);
			//opération et virement sur compte
			Operation o0 = new Operation(LocalDateTime.of(2017, 01, 20, 01, 20), 10d, "anniversaire neveu", compte);
			Operation o1 = new Virement(LocalDateTime.of(2010, 03, 01, 10, 02), 50d, "tickets de train", compte, "Tantine");
			List<Operation> operations = new ArrayList<>(Arrays.asList(o0,o1));
			compte.setOperations(operations);
			em.persist(o0);
			em.persist(o1);
			em.persist(compte);
			
			banque.setClients(clients);
			
			//compte sera associé à 2 clients
			Client arthur = new Client("Pendragon", "Arthur", LocalDate.of(1980, 12, 2), adresse, banque, null);
			em.persist(arthur);
			clients.add(arthur);
			compte.setClients(clients);
			
			
			//alexandre aura 3 comptes de type différent
			Compte livretA = new LivretA("0000002", 230.21, new ArrayList<Client>(), null, 0.01);
			Compte assuranceVie = new AssuranceVie("0000003", 50_000d, new ArrayList<Client>(), operations, LocalDate.of(2022, 01, 25), 0.05);
			livretA.addClient(alexandre);
			assuranceVie.addClient(alexandre);
			em.persist(livretA);
			em.persist(assuranceVie);
			

			et.commit();
			em.close();
			
		}
		
}
