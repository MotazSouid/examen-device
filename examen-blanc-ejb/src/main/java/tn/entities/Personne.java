package tn.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personne
 *
 */
@Entity

public class Personne implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String personne;
	private int age;
	@ManyToMany(mappedBy="personnes", fetch=FetchType.EAGER)
	private List<ReponseSondage> reponses;
	private static final long serialVersionUID = 1L;

	public Personne() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPersonne() {
		return this.personne;
	}

	public void setPersonne(String personne) {
		this.personne = personne;
	}   
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public List<ReponseSondage> getReponses() {
		return reponses;
	}
	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}
   
}
