package banque.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BANQUE")
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BANQ_ID")
	private Integer id;
	@Column(name="NOM")
	private String nom;
	@OneToMany(mappedBy="banque")
	private List<Client> clients;
	
	public Banque() {
		super();
	}
	public Banque(String nom, List<Client> clients) {
		this.nom = nom;
		this.clients = clients;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
