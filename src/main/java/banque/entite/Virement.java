package banque.entite;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	private String beneficiaire;
	
}
