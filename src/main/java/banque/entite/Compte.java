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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name="NUMERO")
	protected String numero;
	@Column(name="SOLDE")
	protected Double solde;
	@ManyToMany
	@JoinTable(name="CLIENT_COMPTE",
	joinColumns=@JoinColumn(name="ID_COMPTE",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="ID_CLIENT",referencedColumnName="ID")
	)
	protected List<Client> clients;
	@OneToMany(mappedBy="compte")
	protected List<Operation> operations;
	
	public Compte() {
		super();
	}
	
	public Compte(String numero, Double solde, List<Client> clients, List<Operation> operations) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.clients = clients;
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
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
}
