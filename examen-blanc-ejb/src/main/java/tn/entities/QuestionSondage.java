package tn.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: QuestionSondage
 *
 */
@Entity

public class QuestionSondage implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String question;
	@OneToMany(fetch=FetchType.EAGER)
	private List<ReponseSondage> reponses;
	private static final long serialVersionUID = 1L;

	public QuestionSondage() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	public List<ReponseSondage> getReponses() {
		return reponses;
	}
	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}
   
}
