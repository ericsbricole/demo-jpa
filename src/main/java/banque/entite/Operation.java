package banque.entite;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION")
@Inheritance(strategy=InheritanceType.JOINED)
public class Operation {

	@Id
	@Column(name="OP_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	@Column(name="DATE")
	protected LocalDateTime date;
	@Column(name="MONTANT")
	protected Double montant;
	@Column(name="MOTIF")
	protected String motif;
	@ManyToOne
	@JoinColumn(name="numero")
	protected Compte compte;
	
	
	public Operation() {
		super();
	}
	public Operation(LocalDateTime date, Double montant, String motif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
}
