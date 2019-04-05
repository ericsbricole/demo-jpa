package banque.entite;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Adresse {

	private Integer numero;
	private String rue;
	private Integer codePostale;
	private String ville;
	
	
	public Adresse() {
		super();
	}
	
	public Adresse(Integer numero, String rue, Integer codePostale, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Integer getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(Integer codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
