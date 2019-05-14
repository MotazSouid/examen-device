package tn.esprit.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.registry.infomodel.User;

import tn.entities.Utilisateur;
import tn.entities.Project;
import tn.interfaces.examenServiceRemote;
import tn.services.examenService;

@ManagedBean(name="examenBean")
@SessionScoped
public class ExamenBean implements Serializable {
	private String login;
	private String password;
	private Utilisateur user;
	
	@EJB
	examenServiceRemote examenService;
	
	public String Login()
	{
		user = examenService.login(login, password);
		if(user.getRole().equals("PRODUCT_OWNER") || user.getRole().equals("CLIENT"))
		return "/productOwner?faces-redirect=true";
		else
			return "/dev?faces-redirect=true";
	}
	
	public List<Project> getProjects()
	{
		return examenService.getAllProjects();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public examenServiceRemote getExamenService() {
		return examenService;
	}

	public void setExamenService(examenServiceRemote examenService) {
		this.examenService = examenService;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}
