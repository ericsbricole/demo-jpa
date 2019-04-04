package dev.demo_jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	
	@Id
	private Integer id;
	@Column(name="TITRE")
	private String titre;
	@Column(name="AUTEUR")
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="COMPO",
	joinColumns= @JoinColumn(name="ID_LIV",referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_EMP",referencedColumnName="ID"))
	private Set<Emprunt> emprunts;
	
	


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}
	
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", emprunts=" + emprunts + "]";
	}
	
	
	
}
