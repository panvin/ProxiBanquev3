package com.konradvincent2software.proxibanquesi.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.service.AuthService;
import com.konradvincent2software.proxibanquesi.service.ConseillerService;


//@ManagedBean(name="conseillerManagedBean")
//@SessionScoped
public class ConseillerManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AuthService as = new AuthService();
	ConseillerService cs = new ConseillerService();
	
	// Propri�t�s
	@ManagedProperty(name = "nom", value = "Heinz")
	private String nom;
	//@ManagedProperty(name = "prenom")
	private String prenom;
	private String civilite;
	private String login;
	private String password;
	private List<Client> clients;
	
	// Constructeurs
	public ConseillerManagedBean() {
		super();
	}
	
	// Getters et Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
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
	public List<Client> getClients() {
		return this.clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	// Autres m�thodes
	public String authentifiaction() {
        if(as.authConseiller(login, password))
        {
        	//Conseiller conseiller = cs.lireConseiller(login);
        	//System.out.println(conseiller.getNom());
        	//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("conseiller", conseiller);
        	//setNom(conseiller.getNom());
            return "acceuil";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("username", new FacesMessage("Authetifiaction non r�ussi."));
            return "login";
        }
    }
	
	public String test() {
		return "login";
	}
	
}
