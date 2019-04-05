package banque.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIVRETA")
public class LivretA extends Compte {

	@Column(name="TAUX")
	private Double taux;
	
	public LivretA(){
	}

	public LivretA(String numero, Double solde, Client client, List<Operation> operations, Double taux) {
		super(numero, solde, client, operations);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
}
