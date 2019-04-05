package banque.entite;

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
@Table(name="COMPTE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {

	@Id
	@Column(name="NUMERO")
	protected String numero;
	@Column(name="SOLDE")
	protected Double solde;
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	protected Client client;
	@OneToMany(mappedBy="compte")
	protected List<Operation> operations;
	
	public Compte() {
		super();
	}
	
	public Compte(String numero, Double solde, Client client, List<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.client = client;
		this.operations = operations;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
