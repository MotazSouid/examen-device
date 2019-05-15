package tn.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.entities.Personne;
import tn.entities.QuestionSondage;
import tn.entities.ReponseSondage;

@Remote
public interface SondageServiceRemote {
	
	public void ajouterQuestion(QuestionSondage question);
	
	public void ajouterReponse(ReponseSondage reponse);
	
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2,

			int idReponse3);
	
	public void ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Personne personne);
	
	public void affecterReponseAPersonne(int reponseId, int personneId);
	
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId);
	
	public Long nbPersonnes();
	

}
