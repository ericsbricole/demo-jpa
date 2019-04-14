package banque.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	private String beneficiaire;

	public Virement() {	}
	
	public Virement(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	public Virement(LocalDateTime date, Double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
