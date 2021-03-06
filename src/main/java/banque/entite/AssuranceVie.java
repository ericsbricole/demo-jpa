package banque.entite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {

	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	@Column(name="TAUX")
	private Double taux;
	
	
	
	public AssuranceVie() {
	}
	
	public AssuranceVie(String numero, Double solde, List<Client> clients, List<Operation> operations, LocalDate dateFin, Double taux) {
		super(numero, solde, clients, operations);
		this.dateFin = dateFin;
		this.taux = taux;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	
}
