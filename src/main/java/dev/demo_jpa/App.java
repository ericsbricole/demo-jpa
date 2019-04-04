package dev.demo_jpa;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;

import dev.demo_jpa.model.Emprunt;
import dev.demo_jpa.model.Livre;
import dev.demo_jpa.service.BibliothequeService;

public class App 
{
    public static void main( String[] args )
    {
    	
        BibliothequeService service = new BibliothequeService();
        
        service.findBook(1);
        
        
        service.findBook("Germinal");
        
        Emprunt e0 = service.findEmprunt(1);
        e0.getLivres().forEach( l -> System.out.println(l.getTitre()));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh/mm/ss");
        System.out.println("cet emprunt a commencé le " + e0.getDateDebut().format(formatter));
        System.out.println("cet emprunt finit le " + e0.getDateFin().format(formatter));
        
        System.out.println("recherche de tous les emprunts du client Brigand:");
        List<Emprunt> emprunts = service.findEmprunts("Brigand");
        emprunts.forEach( e -> {
        	System.out.println("id de l'emprunt " + e.getId());
        	System.out.println("cet emprunt comporte les livres suivants");
        	e.getLivres().forEach( l -> System.out.println(l.getTitre() + " par " + l.getAuteur()));
        });
        
    }
}
