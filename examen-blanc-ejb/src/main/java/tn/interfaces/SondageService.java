package tn.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.entities.Personne;
import tn.entities.QuestionSondage;
import tn.entities.ReponseSondage;

/**
 * Session Bean implementation class SondageService
 */
@Stateless
@LocalBean
public class SondageService implements SondageServiceRemote, SondageServiceLocal {

	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SondageService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterQuestion(QuestionSondage question) {
		em.persist(question);
		
	}

	@Override
	public void ajouterReponse(ReponseSondage reponse) {
		em.persist(reponse);
		
	}

	@Override
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3) {
		// TODO Auto-generated method stub
		QuestionSondage question = em.find(QuestionSondage.class, idQuestion);
		ReponseSondage rep1 = em.find(ReponseSondage.class, idReponse1);
		ReponseSondage rep2 = em.find(ReponseSondage.class, idReponse2);
		ReponseSondage rep3 = em.find(ReponseSondage.class, idReponse3);
		question.getReponses().add(rep1);
		question.getReponses().add(rep2);
		question.getReponses().add(rep3);
		
	}

	@Override
	public void ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Personne personne) {
		ReponseSondage rep = em.find(ReponseSondage.class, reponseSondageId);
		em.persist(personne);
		rep.getPersonnes().add(personne);
		personne.getReponses().add(rep);
		em.persist(personne);
	}

	@Override
	public void affecterReponseAPersonne(int reponseId, int personneId) {
		ReponseSondage rep = em.find(ReponseSondage.class, reponseId);
		Personne per = em.find(Personne.class, personneId);
		rep.getPersonnes().add(per);
		per.getReponses().add(rep);
		
	}

	@Override
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId) {
		List<ReponseSondage> reponses = new ArrayList<>();
		Personne per = em.find(Personne.class, personneId);
		reponses = per.getReponses();
		return reponses;
	}

	@Override
	public Long nbPersonnes() {
		Long nb = em.createQuery("select count(p) from Personne p",long.class).getSingleResult();
		return nb;
	}

}
